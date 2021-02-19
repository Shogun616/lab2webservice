package se.iths.lab2webservice;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="böcker")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ISBN13;
    private String title;
    private String language;
    private float price;
    private Date releaseDate;
    private String category;

    public Book(long ISBN13, String title, String language, float price, Date releaseDate, String category) {
        this.ISBN13 = ISBN13;
        this.title = title;
        this.language = language;
        this.price = price;
        this.releaseDate = releaseDate;
        this.category = category;
    }

    public Book() {

    }

    public long getISBN13() {
        return ISBN13;
    }

    public void setISBN13(long ISBN13) {
        this.ISBN13 = ISBN13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
