package dev.jdk.daos;

import dev.jdk.entities.*;
import dev.jdk.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements GenericDAO<orders> {
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
    @Override
    public orders getById(int orderid) {
        String sql="select distinct on(b.orderid) b.orderid,o.trackingno,u.emailid ,u.name,u.contactno,u.city,u.state,u.country,p.paymentstatus  from bookorderrecords b join users u on b.userid =u.userid join orders o on b.orderid =o.orderid\n" +
                "join payments p on p.paymentid =o.paymentid \n" +
                "where b.orderid=?";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,orderid);
            ResultSet rs=ps.executeQuery();

            if (rs.next()) {
                payments payment=new payments(
                    rs.getString("paymentstatus")
                );
                users user=new users(
                    rs.getString("emailid"),
                        rs.getString("name"),
                        rs.getString("contactno"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("country")
                );
                orders order=new orders(
                        rs.getInt("orderid"),
                        rs.getString("trackingno"),
                        user,
                        payment
                );
                return order;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<orders> getAll() {
        return null;
    }

    public List<orders> getAll(int orderid) {
        List<orders> orderitemlist = new ArrayList<>();
        String sql="select b.orderid,b2.bookid,b2.title,b2.description,b2.price,b2.imagepath from bookorderrecords b  join books b2  on b.bookid=b2.bookid where orderid=?";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,orderid);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                orderitemlist.add(new orders(
                        rs.getInt("orderid"),
                        new Book(
                                rs.getInt("bookid"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getDouble("price"),
                                rs.getString("imagepath")
                        )
                ));

            }
            return orderitemlist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public orders create(orders orders) {
        String sql="WITH usersdata(userid) as(\n" +
                "INSERT INTO users(userid,emailid,name,contactno,address,city,state,country,zipcode) values(DEFAULT,?,?,?,?,?,?,?,?) RETURNING userid\n" +
                "),paymentsdata(paymentid) as(\n" +
                "insert into payments(paymentid,paymentmethod,paymentstatus) values(default,?,'success') returning paymentid\n" +
                "),ordersdata(trackingno) as(\n" +
                "update orders set paymentid=paymentsdata1.paymentid,trackingno=MD5(random()::text) from (select paymentid from paymentsdata)as paymentsdata1 where orderid=? returning trackingno\n" +
                ")\n" +",trackingdetails(trackingid)as(\n" +
                "insert into trackingrecords(trackingid)select trackingno from ordersdata returning trackingid\n" +
                ")\n" +
                "update bookorderrecords set userid=usersdata1.userid from (select userid from usersdata) as usersdata1 where orderid=?;";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, orders.getUsers().getEmailid());
            ps.setString(2,orders.getUsers().getName());
            ps.setString(3,orders.getUsers().getContactno());
            ps.setString(4,orders.getUsers().getAddress());
            ps.setString(5,orders.getUsers().getCity());
            ps.setString(6,orders.getUsers().getState());
            ps.setString(7,orders.getUsers().getCountry());
            ps.setString(8,orders.getUsers().getZipcode());
            ps.setString(9,orders.getPayments().getPaymentmethod());
            ps.setInt(10,orders.getOrderid());
            ps.setInt(11,orders.getOrderid());

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void update(orders tUpdated) {

    }
    public void UpdateRequest(tracking tUpdated) {
        String sql="update trackingrecords set status=? where trackingid=?";
        try(Connection conn=cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tUpdated.getStatus());
            ps.setString(2,tUpdated.getTrackingno());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public tracking GetRequest(String trackingid){
        String sql="select trackingid,status from trackingrecords where trackingid=?";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,trackingid);
            ResultSet rs=ps.executeQuery();

            if (rs.next()) {
                tracking trackingrecords=new tracking(
                        rs.getString("trackingid"),
                        rs.getString("status")
                );
                return trackingrecords;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public bookslist createorders(Object[] books) {

        String sql="with ordersdata(orderid) as(\n" +
                "INSERT INTO orders(orderid,paymentid,trackingno) values(DEFAULT,null,null) RETURNING orderid\n" +
                "),booksdata(bookid)as(\n" +
                "select bookid from books where bookid = ANY (?)\n" +
                ")\n" +
                "INSERT INTO bookorderrecords (orderid,bookid)select distinct orderid,bookid from ordersdata,booksdata returning orderid;";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            Array array = ps.getConnection().createArrayOf("INT", books);
            ps.setArray(1, array);
            ResultSet rs=ps.executeQuery();

            if (rs.next()) {
                bookslist books1=new bookslist(
                        rs.getInt("orderid")
                );
                return books1;

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void delete(int id) {
        String sql="delete from orders where orderid=?";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
