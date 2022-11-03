package dev.jdk.entities;

public class payments {
private int paymentid;
private String paymentmethod;
private String paymentstatus;
public payments(){

}
public payments(int paymentid,String paymentmethod,String paymentstatus){
    this.paymentid=paymentid;
    this.paymentmethod=paymentmethod;
    this.paymentstatus=paymentstatus;
}
public payments(String paymentstatus){
    this.paymentstatus=paymentstatus;
}
public int getPaymentid(){
    return paymentid;
}
    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    @Override
    public String toString() {
        return "payments{" +
                "paymentid=" + paymentid +
                ", paymentmethod='" + paymentmethod + '\'' +
                ", paymentstatus='" + paymentstatus + '\'' +
                '}';
    }
}
