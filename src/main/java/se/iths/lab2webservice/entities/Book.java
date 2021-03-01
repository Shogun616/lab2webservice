package se.iths.lab2webservice.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="böcker")
public class Book {


    @Id
    private long isbn13;
    private String titel;
    private String språk;
    private float pris;
    private Date utgivningsdatum;
    private String kategori;

    public Book(long isbn13, String titel, String språk, float pris, Date utgivningsdatum, String kategori) {
        this.isbn13 = isbn13;
        this.titel = titel;
        this.språk = språk;
        this.pris = pris;
        this.utgivningsdatum = utgivningsdatum;
        this.kategori = kategori;
    }

    public Book() {

    }

    public long getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(long isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getSpråk() {
        return språk;
    }

    public void setSpråk(String språk) {
        this.språk = språk;
    }

    public float getPris() {
        return pris;
    }

    public void setPris(float pris) {
        this.pris = pris;
    }

    public Date getUtgivningsdatum() {
        return utgivningsdatum;
    }

    public void setUtgivningsdatum(Date utgivningsdatum) {
        this.utgivningsdatum = utgivningsdatum;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}