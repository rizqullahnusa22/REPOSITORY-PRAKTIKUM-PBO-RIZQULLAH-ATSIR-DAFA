package org.example.demomodul6.data;

import org.example.demomodul6.Main;
import org.example.demomodul6.books.Book;
import org.example.demomodul6.Utill.iMenu;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Student implements iMenu {
    private String nim;
    private String name;
    private String faculty;
    private String studyProgram;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Student(String nim) {
        this.nim = nim;
    }

    public Student(String nim, String name, String faculty, String studyProgram) {
        this.nim = nim;
        this.name = name;
        this.faculty = faculty;
        this.studyProgram = studyProgram;
    }

    public boolean login(Stage primaryStage) {
        if (checkNim(this.nim)) {
            showAlert(Alert.AlertType.INFORMATION, "Login berhasil sebagai Mahasiswa");
            showStudentMenu(primaryStage);
            return true;
        } else {
            showAlert(Alert.AlertType.ERROR, "NIM Mahasiswa tidak valid atau tidak ditemukan");
            return false;
        }
    }

    private boolean checkNim(String nim) {
        return nim.length() == 15;
    }

    public void showStudentMenu(Stage primaryStage) {
        VBox studentLayout = new VBox(10);
        studentLayout.setPadding(new Insets(20, 20, 20, 20));

        Label menuLabel = new Label("Dashboard Mahasiswa");
        Button displayAndBorrowBooksButton = new Button("Tampilkan dan Pinjam Buku");
        Button returnBookButton = new Button("Kembalikan Buku");
        Button logoutButton = new Button("Logout");
        Button backButton = new Button("Kembali");

        displayAndBorrowBooksButton.setOnAction(e -> showAvailableBooks(primaryStage));
        returnBookButton.setOnAction(e -> showReturnBookForm(primaryStage));
        logoutButton.setOnAction(e -> primaryStage.close());
        backButton.setOnAction(e -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        studentLayout.getChildren().addAll(menuLabel, displayAndBorrowBooksButton, returnBookButton, logoutButton, backButton);

        Scene studentScene = new Scene(studentLayout, 300, 300);
        primaryStage.setScene(studentScene);
    }

    private void showAvailableBooks(Stage primaryStage) {
        VBox booksLayout = new VBox(10);
        booksLayout.setPadding(new Insets(20, 20, 20, 20));

        Label booksLabel = new Label("Daftar Buku Tersedia:");
        ListView<String> booksListView = new ListView<>();
        for (Book book : org.example.demomodul6.Main.bookList) {
            if (book != null) {
                booksListView.getItems().add("- " + book.getJudul() + " oleh " + book.getAuthor()
                        + " Stok: " + book.getStok()
                        + " category: " + book.getCategory()
                        + " duration: " + book.getDuration());
            }
        }

        TextField bookIdField = new TextField();
        bookIdField.setPromptText("Masukkan ID Buku");
        Button borrowButton = new Button("Pinjam");
        Button backButton = new Button("Kembali");

        borrowButton.setOnAction(e -> {
            String bookId = bookIdField.getText();
            Book selectedBook = findBookById(bookId);
            if (selectedBook != null && selectedBook.getStok() > 0) {
                selectedBook.setStok(selectedBook.getStok() - 1);
                borrowedBooks.add(selectedBook);
                showAlert(Alert.AlertType.INFORMATION, "Berhasil meminjam buku: " + selectedBook.getJudul());
            } else {
                showAlert(Alert.AlertType.ERROR, "Buku tidak tersedia atau ID buku tidak ditemukan");
            }
        });

        backButton.setOnAction(e -> showStudentMenu(primaryStage));

        booksLayout.getChildren().addAll(booksLabel, booksListView, bookIdField, borrowButton, backButton);

        Scene booksScene = new Scene(booksLayout, 400, 400);
        primaryStage.setScene(booksScene);
    }

    private void showReturnBookForm(Stage primaryStage) {
        VBox returnBookLayout = new VBox(10);
        returnBookLayout.setPadding(new Insets(20, 20, 20, 20));

        if (borrowedBooks.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "Anda belum meminjam buku.");
            showStudentMenu(primaryStage);
            return;
        }

        Label borrowedBooksLabel = new Label("Buku yang Anda pinjam:");
        ListView<String> borrowedBooksListView = new ListView<>();
        for (int i = 0; i < borrowedBooks.size(); i++) {
            borrowedBooksListView.getItems().add((i + 1) + ". " + borrowedBooks.get(i).getJudul());
        }

        TextField bookNumberField = new TextField();
        bookNumberField.setPromptText("Masukkan nomor buku yang akan dikembalikan");
        Button returnButton = new Button("Kembalikan");
        Button backButton = new Button("Kembali");

        returnButton.setOnAction(e -> {
            int choice = Integer.parseInt(bookNumberField.getText());
            if (choice > 0 && choice <= borrowedBooks.size()) {
                Book returnedBook = borrowedBooks.remove(choice - 1);
                returnedBook.setStok(returnedBook.getStok() + 1);
                showAlert(Alert.AlertType.INFORMATION, "Buku " + returnedBook.getJudul() + " berhasil dikembalikan.");
                showStudentMenu(primaryStage);
            } else {
                showAlert(Alert.AlertType.ERROR, "Pilihan tidak valid.");
            }
        });

        backButton.setOnAction(e -> showStudentMenu(primaryStage));

        returnBookLayout.getChildren().addAll(borrowedBooksLabel, borrowedBooksListView, bookNumberField, returnButton, backButton);

        Scene returnBookScene = new Scene(returnBookLayout, 400, 400);
        primaryStage.setScene(returnBookScene);
    }

    private Book findBookById(String id) {
        for (Book book : org.example.demomodul6.Main.bookList) {
            if (book != null && book.getIdBuku().equals(id)) {
                return book;
            }
        }
        return null;
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public String getNim() {
        return nim;
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
    public void menuAdmin() {
    }

    @Override
    public void menuStudent() {
    }

    @Override
    public void displayBooks() {
    }

    @Override
    public void menu() {
    }

    @Override
    public boolean login(String text, String text1) {
        return false;
    }

}
