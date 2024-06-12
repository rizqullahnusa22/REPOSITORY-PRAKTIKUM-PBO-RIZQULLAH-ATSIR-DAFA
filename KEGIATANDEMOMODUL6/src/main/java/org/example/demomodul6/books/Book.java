package org.example.demomodul6.books;


public class Book {
    private String idBuku;
    private String judul;
    private int stok;
    private String author;
    private String category;
    private String duration;

    // Constructor
    public Book(String idBuku, String judul, int stok, String author, String category, String duration) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.stok = stok;
        this.author = author;
        this.category = category;
        this.duration = duration;
    }

    // Default constructor
    public Book() {
    }

    // Getter and Setter methods
    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return idBuku + " - " + judul + " oleh " + author + " (Stok: " + stok + ", Kategori: " + category + ", Durasi: " + duration + ")";
    }
}
