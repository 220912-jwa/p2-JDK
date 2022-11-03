package dev.jdk.entities;

import java.util.List;

public class orders {
    private int orderid;
    private String trackingno;
    private Book books;
    private payments payments;
    private users users;
    public orders(){

    }
    public orders(int orderid,Book books){
        this.orderid=orderid;
        this.books=books;
    }
    public orders(int orderid,String trackingno,users user,payments payment){
        this.orderid=orderid;
        this.trackingno=trackingno;
        this.users=user;
        this.payments=payment;
    }

    public int getOrderid() {
        return orderid;
    }

    public String getTrackingno() {
        return trackingno;
    }

    public void setTrackingno(String trackingno) {
        this.trackingno = trackingno;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public payments getPayments() {
        return payments;
    }

    public void setPayments(payments payments) {
        this.payments = payments;
    }

    public users getUsers() {
        return users;
    }

    public void setUsers(users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "orders{" +
                "orderid=" + orderid +
                ", trackingno='" + trackingno + '\'' +
                ", books=" + books +
                ", payments=" + payments +
                ", users=" + users +
                '}';
    }
}

