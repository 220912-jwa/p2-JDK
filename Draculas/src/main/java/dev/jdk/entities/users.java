package dev.jdk.entities;

public class users {
    private int userid;
    private String emailid;
    private String name;
    private String contactno;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public users(){

    }
    public users(String emailid,String name,String contactno,String address,String city,String state,String country, String zipcode){
        this.emailid=emailid;
        this.name=name;
        this.contactno=contactno;
        this.address=address;
        this.city=city;
        this.state=state;
        this.country=country;
        this.zipcode=zipcode;
    }
    public users(String emailid,String name,String contactno,String city,String state,String country){
        this.emailid=emailid;
        this.name=name;
        this.contactno=contactno;
        this.city=city;
        this.state=state;
        this.country=country;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "users{" +
                "userid=" + userid +
                ", emailid='" + emailid + '\'' +
                ", name='" + name + '\'' +
                ", contactno='" + contactno + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
