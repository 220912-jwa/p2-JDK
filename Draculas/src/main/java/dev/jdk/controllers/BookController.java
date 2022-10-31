package dev.jdk.controllers;

import dev.jdk.entities.Book;
import dev.jdk.services.BookService;
import io.javalin.http.Handler;

import java.util.List;


public class BookController
{
    private BookService bookService;

    public BookController(BookService bookService){this.bookService = bookService;}

    public Handler getAllBooksRequest = ctx ->
    {
      List<Book> bookList = bookService.getAllBooks();
      if(bookList != null)
      {
          ctx.json(bookList);
          ctx.status(200);
      }
      else
      {
          ctx.status(404);
      }
    };
    public Handler getBookByIdRequest = ctx ->
    {
        int bookId = Integer.parseInt(ctx.pathParam("bookId"));
        Book book = bookService.getBookById(bookId);
        if(book != null)
        {
            ctx.json(book);
            ctx.status(200);
        }
        else
        {
            ctx.status(404);
        }
    };
    public Handler getAllBooksByAuthorRequest = ctx ->
    {
        String author = ctx.pathParam("author");
        List<Book> bookList = bookService.getAllBooksByAuthor(author);
        if(bookList != null)
        {
            ctx.json(bookList);
            ctx.status(200);
        }
        else
        {
            ctx.status(404);
        }
    };
    public Handler getAllBooksByAudienceRequest = ctx ->
    {
        String audience = ctx.pathParam("audience");
        List<Book> bookList = bookService.getAllBooksByAudience(audience);
        if(bookList != null)
        {
            ctx.json(bookList);
            ctx.status(200);
        }
        else
        {
            ctx.status(404);
        }
    };
    public Handler getAllBooksByGenreRequest = ctx ->
    {
        String genre = ctx.pathParam("genre");
        List<Book> bookList = bookService.getAllBooksByGenre(genre);
        if(bookList != null)
        {
            ctx.json(bookList);
            ctx.status(200);
        }
        else
        {
            ctx.status(404);
        }
    };
    public Handler getAllBooksBySearchRequest = ctx ->
    {
        String keywords = ctx.pathParam("searchKeywords");
        List<Book> bookList = bookService.getAllBooksBySearchKeywords(keywords);
        if(bookList != null)
        {
            ctx.json(bookList);
            ctx.status(200);
        }
        else
        {
            ctx.status(404);
        }
    };
    public Handler getAllBooksByBestSellerRequest = ctx ->
    {
        List<Book> bookList = bookService.getAllBooksByBestSeller();
        if(bookList != null)
        {
            ctx.json(bookList);
            ctx.status(200);
        }
        else
        {
            ctx.status(404);
        }
    };
}
