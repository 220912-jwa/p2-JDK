package dev.jdk.services;

import dev.jdk.daos.OrderDAO;
import dev.jdk.entities.bookslist;
import dev.jdk.entities.orders;
import dev.jdk.entities.tracking;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

public class OrderService {
    private OrderDAO orderDAO;
    public OrderService(OrderDAO orderDAO){
        this.orderDAO=orderDAO;
    }
    public List<orders> GetOrderDetailsById(int orderid){
        return orderDAO.getAll(orderid);
    }
    public orders GetOrderDetailsByIdWithPaymentDetails(int orderid){
        return orderDAO.getById(orderid);
    }
    public orders AddPaymentOrder(orders orders){
        return orderDAO.create(orders);
    }
    public void SendConfirmationMail(orders orders){
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.host", "");
        prop.put("mail.smtp.port", "");
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("","");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(""));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(orders.getUsers().getEmailid()));
            message.setSubject("Order Confirmation");
            String result="";
            String estimatedtime="";
            if(orders.getUsers().getCountry().equals("US")){
                estimatedtime="Within 5-7 days";
            }else{
                estimatedtime="Within 10-15 days";
            }
            String values="                    <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">Order ID: "+orders.getOrderid()+"</p>\n" +
                    "                    <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">Tracking ID: "+orders.getTrackingno()+"</p>\n" +
                    "                    <p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">Estimated Delivery Time: "+estimatedtime+"</p>";
            StringBuilder html = new StringBuilder();

            FileReader fr = new FileReader(
                    "src/main/resources/html/mailtemplate.html");
            try {
                BufferedReader br = new BufferedReader(fr);
                String val;
                while ((val = br.readLine()) != null) {
                    html.append(val);
                }
                result = html.toString();
                br.close();
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(values+result, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);

        }catch (Exception mex) {
            mex.printStackTrace();
        }

    }
    public tracking Updatetracking(tracking tracking){
        orderDAO.UpdateRequest(tracking);
        return null;
    }
    public tracking GetTrackingStatus(String trackingid){
        return orderDAO.GetRequest(trackingid);
    }
    public bookslist createorders(Object[] books){
        return orderDAO.createorders(books);

    }
    public void cancelorder(int orderid){
        orderDAO.delete(orderid);

    }

}
