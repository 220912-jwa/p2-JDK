package dev.jdk;

import dev.jdk.controllers.BookController;
import dev.jdk.daos.BookDAO;
import dev.jdk.services.BookService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class AppDriver {
    public static void main(String[] args)
    {
        //DAOs
        BookDAO bookDAO = new BookDAO();

        //SERVICES
        BookService bookService = new BookService(bookDAO);

        //CONTROLLERS
        BookController bookController = new BookController(bookService);

        //CONFIG
        Javalin app = Javalin.create(config -> {
                    config.enableCorsForAllOrigins();
                    config.addStaticFiles("/html", Location.CLASSPATH);
                }
        ).start(8080);

//END POINTS

    //BOOKS
        //GET
        app.get("/get/book/all", bookController.getAllBooksRequest);
        app.get("/get/book/{bookId}", bookController.getBookByIdRequest);
        app.get("/get/book/all/author", bookController.getAllBooksByAuthorRequest);
        app.get("/get/book/all/{audience}", bookController.getAllBooksByAudienceRequest);
        app.get("/get/book/all/{genre}", bookController.getAllBooksByGenreRequest);
        app.get("/get/book/all/{searchKeywords}", bookController.getAllBooksBySearchRequest);
        app.get("/get/book/all/bestSeller", bookController.getAllBooksByBestSellerRequest);
    }

}
