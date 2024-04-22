package data;

import books.Book;
import com.main.Main;
import util.iMenu;

import java.util.ArrayList;
import java.util.Scanner;

public  class Student extends Main.User implements iMenu {
    private String name;
    private String faculty;
    private String studyProgram;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Student(String nim) {
        super(nim);
    }


    @Override
    public void menuAdmin() {

    }

    public Student(String nim, String name, String faculty, String studyProgram) {
        super(nim);
        this.name = name;
        this.faculty = faculty;
        this.studyProgram = studyProgram;
    }

    public void login() {
        if (checkNim(getNim())) {
            System.out.println("Login berhasil sebagai Mahasiswa");
            menuStudent();
        } else {
            System.out.println("NIM Mahasiswa tidak valid atau tidak ditemukan");
        }
    }

    private boolean checkNim(String nim) {
        return nim.length() == 15;
    }

    @Override
    public void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Dashboard Mahasiswa");
            System.out.println("1. Tampilkan dan Pinjam Buku");
            System.out.println("2. Kembalikan Buku");
            System.out.println("3. Logout");
            System.out.print("Pilih antara (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    choiceBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    logout();
                    return;
                default:
                    System.out.println("Pilihan anda sudah milik orang lain");
            }
        }
    }

    @Override
    public void displayBooks() {

    }

    private void choiceBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Daftar Buku Tersedia:");
        for (Book book : Main.bookList) {
            if (book != null) {
                System.out.println("- " + book.getJudul() + " oleh "  + book.getAuthor()
                        +  " Stok : "  + book.getStok()
                        +  " category : "  + book.getCategory()
                        +  " duration : "  + book.getDuration());
            }
        }
        System.out.print("Masukkan ID Buku yang ingin dipinjam: ");
        String bookId = scanner.next();
        Book selectedBook = findBookById(bookId);
        if (selectedBook != null && selectedBook.getStok() > 0) {
            selectedBook.setStok(selectedBook.getStok() - 1);
            borrowedBooks.add(selectedBook);
            System.out.println("Berhasil meminjam buku: " + selectedBook.getJudul());
        } else {
            System.out.println("Buku tidak tersedia atau ID buku tidak ditemukan");
        }
    }
    private void returnBook() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Anda belum meminjam buku.");
            return;
        }
        System.out.println("Buku yang Anda pinjam:");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + borrowedBooks.get(i).getJudul());
        }
        System.out.print("Pilih buku yang akan dikembalikan (nomor): ");
        int choice = Main.scanner.nextInt();
        if (choice > 0 && choice <= borrowedBooks.size()) {
            Book returnedBook = borrowedBooks.remove(choice - 1);
            returnedBook.setStok(returnedBook.getStok() + 1);
            System.out.println("Buku " + returnedBook.getJudul() + " berhasil dikembalikan.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private Book findBookById(String id) {
        for (Book book : Main.bookList) {
            if (book != null && book.getIdBuku().equals(id)) {
                return book;
            }
        }
        return null;
    }

    private void logout() {
        System.out.println("Anda berhasil keluar dari zona nyaman");
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public void menu() {

    }
}
