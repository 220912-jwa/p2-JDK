package dev.jdk.daos;

import dev.jdk.entities.Book;
import dev.jdk.utils.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dev.jdk.utils.StringFormatter.formatKeywords;

public class BookDAO {
    private ConnectionUtility cu = ConnectionUtility.getConnectionUtility();
    public List<Book> getAllBooks()
    {
        List<Book> bookList = new ArrayList<>();
        String sql = "select * from books";
        try(Connection connection = cu.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book(rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getString("audience"),
                        rs.getString("genre"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getBoolean("bestseller"),
                        rs.getString("imagePath")
                );
                bookList.add(book);
            }
            return bookList;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public Book getBookById(int bookId)
    {
        String sql = "select * from books where bookid = ?";
        try(Connection connection = cu.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Book book = new Book(rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getString("audience"),
                        rs.getString("genre"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getBoolean("bestseller"),
                        rs.getString("imagePath")
                );
                return book;
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<Book> getAllBooksBySearchKeywords(String keywords)

    {
        String sql = "select * from books where";
        List<String> formattedKeywords = formatKeywords(keywords);

        for(int i = 0; i <= (formattedKeywords.size() - 1); i++)
        {
            sql += "\ntitle like '%" + formattedKeywords.get(i) + "%'";
            if(i != (formattedKeywords.size()-1))
            {
                sql+= "\nor";
            }
        }


        List<Book> bookList = new ArrayList<>();
        try(Connection connection = cu.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book(rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getString("audience"),
                        rs.getString("genre"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getBoolean("bestseller"),
                        rs.getString("imagePath")
                );
                bookList.add(book);
            }
            return bookList;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<Book> getAllBooksByAuthor(String author)
    {
        List<Book> bookList = new ArrayList<>();
        String sql = "select * from books where author = ?";
        try(Connection connection = cu.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, author);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book(rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getString("audience"),
                        rs.getString("genre"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getBoolean("bestseller"),
                        rs.getString("imagePath")
                );
                bookList.add(book);
            }
            return bookList;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAllBooksByAudience(String audience)
    {
        List<Book> bookList = new ArrayList<>();
        String sql = "select * from books where audience = ?";
        try(Connection connection = cu.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, audience);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book(rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getString("audience"),
                        rs.getString("genre"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getBoolean("bestseller"),
                        rs.getString("imagePath")
                );
                bookList.add(book);
            }
            return bookList;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAllBooksByGenre(String genre)
    {
        List<Book> bookList = new ArrayList<>();
        String sql = "select * from books where genre = ?";
        try(Connection connection = cu.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, genre);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book(rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getString("audience"),
                        rs.getString("genre"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getBoolean("bestseller"),
                        rs.getString("imagePath")
                );
                bookList.add(book);
            }
            return bookList;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<Book> getAllBooksByBestSeller()
    {
        List<Book> bookList = new ArrayList<>();
        String sql = "select * from books where bestseller = true";
        try(Connection connection = cu.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book(rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getString("audience"),
                        rs.getString("genre"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getBoolean("bestseller"),
                        rs.getString("imagePath")
                );
                bookList.add(book);
            }
            return bookList;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
