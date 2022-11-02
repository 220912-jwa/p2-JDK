package dev.jdk.controllers;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import dev.jdk.entities.bookslist;
import dev.jdk.entities.orders;
import dev.jdk.entities.tracking;
import dev.jdk.services.OrderService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class OrdersController {
private OrderService orderService;
public OrdersController(OrderService orderService){
    this.orderService=orderService;
}
    public void GetOrderDetailsById (Context ctx){
        ctx.status(200);
        int orderid = Integer.parseInt(ctx.pathParam("orderid"));
        ctx.json(orderService.GetOrderDetailsById(orderid));
    }
    public void GetOrderDetailsByIdWithPaymentDetails (Context ctx){
        ctx.status(200);
        int orderid = Integer.parseInt(ctx.pathParam("orderid"));
        ctx.json(orderService.GetOrderDetailsByIdWithPaymentDetails(orderid));
    }
    public void GetTrackingStatus (Context ctx){
        ctx.status(200);
        String trackingid = ctx.pathParam("trackingid");
        ctx.json(orderService.GetTrackingStatus(trackingid));
    }
    public Handler AddPaymentOrder = ctx -> {
        orders orderdetails = ctx.bodyAsClass(orders.class)   ;

        orders request=orderService.AddPaymentOrder(orderdetails);
        ctx.status(200);
    };
    public Handler SendConfirmationMail = ctx -> {
        orders maildetails = ctx.bodyAsClass(orders.class)   ;

        orderService.SendConfirmationMail(maildetails);
                Twilio.init("AC09235b579260ab1892dde3cf8fe1fe71", "ebc67d6f7a3f21bdd91dcba73a7afea5");
                Message message = Message.creator(
                                new com.twilio.type.PhoneNumber("+1"+maildetails.getUsers().getContactno()),
                                new com.twilio.type.PhoneNumber("+12059228864"),
                                "Thank you for placing order from draculas, view mail for more details")
                        .create();
        ctx.status(200);

    };
    public Handler UpdateTrackingStatus  = ctx -> {
        tracking tracking = ctx.bodyAsClass(tracking.class); // Jackson Library is mapping all fields from the JSON to our Author Class

        tracking request=orderService.Updatetracking(tracking);
        ctx.status(200);
    };
    public Handler createorder = ctx -> {
        bookslist bookidrecords = ctx.bodyAsClass(bookslist.class) ;
        Object[] books={6,9,8};
        bookslist request=orderService.createorders(bookidrecords.getBookid());
        ctx.json(request);
        ctx.status(200);
    };
    public Handler cancelorder = ctx -> {
        orders orderid = ctx.bodyAsClass(orders.class) ;
        orderService.cancelorder(orderid.getOrderid());
        ctx.status(200);
    };


}
