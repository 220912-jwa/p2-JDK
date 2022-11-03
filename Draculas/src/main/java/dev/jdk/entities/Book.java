package dev.jdk.entities;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String description;
    private String audience;
    private String genre;
    private double price;
    private int stock;
    private boolean bestSeller;
    private String imagePath;

    public Book(int bookId, String title, String author, String description, String audience, String genre, double price, int stock, boolean bestSeller, String imagePath)
    {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.description = description;
        this.audience = audience;
        this.genre = genre;
        this.price = price;
        this.stock = stock;
        this.bestSeller = bestSeller;
        this.imagePath = imagePath;
    }
    public Book(int bookid,String title,String description,Double price,String imagepath){
        this.bookId=bookid;
        this.title=title;
        this.description=description;
        this.price=price;
        this.imagePath=imagepath;
    }
    public Book(String author) {this.author = author;}

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return getTitle() + "{" +
                "\nbookId: " + getBookId() +
                "\ntitle: " + getTitle() +
                "\nauthor: " + getAuthor() +
                "\ndescription: " + getDescription() +
                "\naudience: " + getAudience() +
                "\ngenre:" + getGenre() +
                "\nprice: " + getPrice() +
                "\nstock: " + getStock() +
                "\nbestSeller: " + isBestSeller() +
                "\nimagePath: " + getImagePath() +
                "\n}";

    }
}
