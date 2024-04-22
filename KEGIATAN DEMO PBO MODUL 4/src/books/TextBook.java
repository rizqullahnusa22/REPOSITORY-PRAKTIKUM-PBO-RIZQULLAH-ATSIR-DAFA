package books;

public class TextBook extends Book{
    public TextBook(String idBuku, String judul, int stok, String author, String category, String duration) {
        super(idBuku, judul, stok, author, category, duration);
    }

    public TextBook(String idBuku, String judul, int stok, String author) {
    }


}