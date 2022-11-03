package dev.jdk;

import dev.jdk.controllers.BookController;
import dev.jdk.controllers.OrdersController;
import dev.jdk.daos.BookDAO;
import dev.jdk.daos.OrderDAO;
import dev.jdk.services.BookService;
import dev.jdk.services.OrderService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;

public class AppDriver {
    public static void main(String[] args)
    {
        OrdersController ordersController=new OrdersController(new OrderService(new OrderDAO()));
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
        app.get("/get/book/author/{author}", bookController.getAllBooksByAuthorRequest);
        app.get("/get/book/audience/{audience}", bookController.getAllBooksByAudienceRequest);
        app.get("/get/book/genre/{genre}", bookController.getAllBooksByGenreRequest);
        app.get("/get/book/searchKeywords/{searchKeywords}", bookController.getAllBooksBySearchRequest);
        app.get("/get/book/all/bestSeller", bookController.getAllBooksByBestSellerRequest);

        //Orders
        app.routes(() -> {
            path("/order/{orderid}", () -> {
                get(ordersController::GetOrderDetailsById);
            });
            path("/orderpaymentconfirmation/{orderid}", () -> {
                get(ordersController::GetOrderDetailsByIdWithPaymentDetails);
            });
            path("/orderpaymentupdate", () -> {
                post(ordersController.AddPaymentOrder);
            });
            path("/sendconfirmationmail", () -> {
                post(ordersController.SendConfirmationMail);
            });
            path("/updatetrackingstatus",()->{
                put(ordersController.UpdateTrackingStatus);
            });
            path("/gettrackingstatus/{trackingid}",()->{
                get(ordersController::GetTrackingStatus);
            });
            path("/createorder",()->{
                post(ordersController.createorder);
            });
            path("/ordercancel",()->{
                post(ordersController.cancelorder);
            });
        });
    }

}
