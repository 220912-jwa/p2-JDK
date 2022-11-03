package dev.jdk.entities;

import java.util.Arrays;

public class bookslist {
    private Object[] bookid;
    private int orderid;
    public bookslist(){

    }
    public bookslist(Object[] bookid,int orderid){
        this.bookid=bookid;
        this.orderid=orderid;
    }
    public bookslist(int orderid){
        this.orderid=orderid;
    }

    public Object[] getBookid() {
        return bookid;
    }

    public void setBookid(Object[] bookid) {
        this.bookid = bookid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "bookslist{" +
                "bookid=" + Arrays.toString(bookid) +
                ", orderid=" + orderid +
                '}';
    }
}
