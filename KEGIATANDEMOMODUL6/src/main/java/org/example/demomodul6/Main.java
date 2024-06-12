package org.example.demomodul6;

import org.example.demomodul6.books.Book;
import org.example.demomodul6.data.Admin;
import org.example.demomodul6.data.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Book> bookList = new ArrayList<>();
    public static ArrayList<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) {
        bookList.add(new Book("001", "Petani menyembelih Banteng", 5, "Jokowi", "Horror", "170"));
        bookList.add(new Book("002", "Banteng Merah", 10, "Megawati", "Action", "150"));
        bookList.add(new Book("003", "Amin for Indonesia", 8, "Anies", "Comedy", "200"));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library System Login");

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(20, 20, 20, 20));

        Label welcomeLabel = new Label("Library System Login");
        Button studentLoginButton = new Button("Login sebagai Mahasiswa");
        Button adminLoginButton = new Button("Login sebagai Admin");
        Button exitButton = new Button("Keluar");

        studentLoginButton.setOnAction(e -> showStudentLogin(primaryStage));
        adminLoginButton.setOnAction(e -> showAdminLogin(primaryStage));
        exitButton.setOnAction(e -> primaryStage.close());

        mainLayout.getChildren().addAll(welcomeLabel, studentLoginButton, adminLoginButton, exitButton);

        Scene scene = new Scene(mainLayout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showStudentLogin(Stage primaryStage) {
        VBox studentLayout = new VBox(10);
        studentLayout.setPadding(new Insets(20, 20, 20, 20));

        Label nimLabel = new Label("Masukkan NIM : ");
        TextField nimField = new TextField();
        Button loginButton = new Button("Login");
        Button backButton = new Button("Kembali");

        loginButton.setOnAction(e -> {
            String nimStudent = nimField.getText();
            if (nimStudent.length() != 15) {
                showAlert(Alert.AlertType.ERROR, "NIM tidak valid! Harus 15 karakter.");
            } else {
                Student student = new Student(nimStudent);
                if (student.login(primaryStage)) {
                    showAlert(Alert.AlertType.INFORMATION, "Login berhasil untuk NIM: " + nimStudent);

                } else {
                    showAlert(Alert.AlertType.ERROR, "Login gagal. NIM tidak valid.");
                }
            }
        });

        backButton.setOnAction(e -> start(primaryStage));

        studentLayout.getChildren().addAll(nimLabel, nimField, loginButton, backButton);

        Scene studentScene = new Scene(studentLayout, 300, 200);
        primaryStage.setScene(studentScene);
    }

    private void showAdminLogin(Stage primaryStage) {
        VBox adminLayout = new VBox(10);
        adminLayout.setPadding(new Insets(20, 20, 20, 20));

        Label adminLabel = new Label("Admin Login");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        Button backButton = new Button("Kembali");

        loginButton.setOnAction(e -> {
            Admin admin = new Admin();
            try {
                if (admin.isAdmin(usernameField.getText(), passwordField.getText())) {
                    showAlert(Alert.AlertType.INFORMATION, "Login berhasil sebagai Admin");
                    admin.showAdminMenu(primaryStage);
                } else {
                    showAlert(Alert.AlertType.ERROR, "Login gagal. Username atau password tidak valid.");
                }
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Login gagal. Terjadi kesalahan: " + ex.getMessage());
            }
        });

        backButton.setOnAction(e -> start(primaryStage));

        adminLayout.getChildren().addAll(adminLabel, usernameField, passwordField, loginButton, backButton);

        Scene adminScene = new Scene(adminLayout, 300, 200);
        primaryStage.setScene(adminScene);
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
