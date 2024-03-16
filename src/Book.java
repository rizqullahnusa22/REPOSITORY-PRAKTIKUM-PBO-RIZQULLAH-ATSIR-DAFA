// Class Book
 class Book {
    private String idBuku;
    private String judul;
    private int stok;
    private String author;

    public Book(String idBuku, String judul, int stok, String author) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.stok = stok;
        this.author = author;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
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
}