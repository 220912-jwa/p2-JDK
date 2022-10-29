package dev.jdk.services;

import dev.jdk.daos.BookDAO;
import dev.jdk.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookDAO bookDAO;
    public BookService(BookDAO bookDAO){this.bookDAO = bookDAO;}

    public List<Book> getAllBooks()
    {

        List<Book> bookList = bookDAO.getAllBooks();
        return bookList;
    }

    public Book getBookById(int bookId)
    {

        Book book = bookDAO.getBookById(bookId);
        return book;
    }

    public List<Book> getAllBooksByAuthor(String author)
    {

        List<Book> bookList = bookDAO.getAllBooksByAuthor(author);
        return bookList;
    }

    public List<Book> getAllBooksByAudience(String audience)
    {

        List<Book> bookList = bookDAO.getAllBooksByAudience(audience);
        return bookList;
    }

    public List<Book> getAllBooksByGenre(String genre)
    {

        List<Book> bookList = bookDAO.getAllBooksByGenre(genre);
        return bookList;
    }
    public List<Book> getAllBooksBySearchKeywords(String keywords)
    {

        List<Book> bookList = bookDAO.getAllBooksBySearchKeywords(keywords);
        return bookList;
    }
    public List<Book> getAllBooksByBestSeller()
    {

        List<Book> bookList = bookDAO.getAllBooksByBestSeller();
        return bookList;
    }

}
