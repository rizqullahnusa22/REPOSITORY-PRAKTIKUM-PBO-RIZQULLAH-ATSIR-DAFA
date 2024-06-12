package org.example.demomodul6.data;


import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.example.demomodul6.books.Book;

import java.util.ArrayList;

public abstract class User {
    private String nim;

    public User(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }


    public abstract void login();
    public abstract void menuAdmin();
    public abstract void menuStudent();

    public void displayBooks(ArrayList<Book> bookList) {
        if (bookList == null || bookList.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "No books available");
            return;
        }

        ListView<String> listView = new ListView<>();
        for (Book book : bookList) {
            listView.getItems().add(book.getIdBuku() + " - " + book.getJudul() + " oleh " + book.getAuthor()
                    + " (Stok: " + book.getStok() + ", Kategori: " + book.getCategory() + ", Durasi: " + book.getDuration() + ")");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Daftar Buku");
        alert.setHeaderText("Buku yang tersedia");
        alert.getDialogPane().setContent(listView);
        alert.showAndWait();
    }

    // Helper method to show alerts
    protected void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
