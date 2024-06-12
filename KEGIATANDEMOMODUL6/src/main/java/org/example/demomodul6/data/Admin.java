package org.example.demomodul6.data;

import org.example.demomodul6.books.Book;
import org.example.demomodul6.books.HistoryBook;
import org.example.demomodul6.books.StoryBook;
import org.example.demomodul6.books.TextBook;
import org.example.demomodul6.Main;
import org.example.demomodul6.exceptioncustom.IllegalAdminAcces;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.demomodul6.Utill.iMenu;

import java.util.ArrayList;

public class Admin extends Main implements iMenu {
    private ArrayList<Student> studentList = new ArrayList<>();

    public Admin() {
        super();
    }

    public void login(Stage primaryStage) {
        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20, 20, 20, 20));

        Label usernameLabel = new Label("Masukkan Username: ");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Masukkan Password: ");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            try {
                if (isAdmin(username, password)) {
                    showAlert(Alert.AlertType.INFORMATION, "Login berhasil sebagai Admin");
                    showAdminMenu(primaryStage);
                } else {
                    showAlert(Alert.AlertType.ERROR, "User Admin tidak ditemukan, karena anda penyusup");
                }
            } catch (IllegalAdminAcces ex) {
                showAlert(Alert.AlertType.ERROR, ex.getMessage());
            }
        });

        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        Scene loginScene = new Scene(loginLayout, 300, 200);
        primaryStage.setScene(loginScene);
    }

    public boolean isAdmin(String username, String password) throws IllegalAdminAcces {
        if (!username.equals("prabowogibran") || !password.equals("satuputaran")) {
            throw new IllegalAdminAcces("Invalid credentials");
        }
        return true;
    }

    public void showAdminMenu(Stage primaryStage) {
        VBox adminLayout = new VBox(10);
        adminLayout.setPadding(new Insets(20, 20, 20, 20));

        Label menuLabel = new Label("Dashboard Admin");
        Button addStudentButton = new Button("Tambah Mahasiswa");
        Button displayStudentsButton = new Button("Tampilkan Mahasiswa");
        Button inputBookButton = new Button("Input Buku");
        Button displayBooksButton = new Button("Tampilkan Daftar Buku");
        Button logoutButton = new Button("Logout");
        Button backButton = new Button("Kembali");

        addStudentButton.setOnAction(e -> showAddStudentForm(primaryStage));
        displayStudentsButton.setOnAction(e -> displayStudents(primaryStage));
        inputBookButton.setOnAction(e -> showInputBookForm(primaryStage));
        displayBooksButton.setOnAction(e -> displayBooks(primaryStage));
        logoutButton.setOnAction(e -> {
            Admin admin = new Admin();
            admin.login(primaryStage);
        });
        backButton.setOnAction(e -> start(primaryStage));

        adminLayout.getChildren().addAll(menuLabel, addStudentButton, displayStudentsButton, inputBookButton, displayBooksButton, logoutButton, backButton);

        Scene adminScene = new Scene(adminLayout, 300, 300);
        primaryStage.setScene(adminScene);
    }

    private void showAddStudentForm(Stage primaryStage) {
        VBox addStudentLayout = new VBox(10);
        addStudentLayout.setPadding(new Insets(20, 20, 20, 20));

        Label nameLabel = new Label("Masukkan Nama: ");
        TextField nameField = new TextField();
        Label nimLabel = new Label("Masukkan NIM: ");
        TextField nimField = new TextField();
        Label facultyLabel = new Label("Masukkan Fakultas: ");
        TextField facultyField = new TextField();
        Label studyProgramLabel = new Label("Masukkan Program Studi: ");
        TextField studyProgramField = new TextField();
        Button addButton = new Button("Tambah");
        Button backButton = new Button("Kembali");

        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String nim = nimField.getText();
            if (nim.length() != 15) {
                showAlert(Alert.AlertType.ERROR, "NIM tidak valid! Harus 15 karakter.");
                return;
            }
            String faculty = facultyField.getText();
            String studyProgram = studyProgramField.getText();
            studentList.add(new Student(nim, name, faculty, studyProgram));
            showAlert(Alert.AlertType.INFORMATION, "Mahasiswa dengan NIM " + nim + " berhasil ditambahkan.");
        });

        backButton.setOnAction(e -> showAdminMenu(primaryStage));

        addStudentLayout.getChildren().addAll(nameLabel, nameField, nimLabel, nimField, facultyLabel, facultyField, studyProgramLabel, studyProgramField, addButton, backButton);

        Scene addStudentScene = new Scene(addStudentLayout, 300, 300);
        primaryStage.setScene(addStudentScene);
    }

    private void showInputBookForm(Stage primaryStage) {
        VBox inputBookLayout = new VBox(10);
        inputBookLayout.setPadding(new Insets(20, 20, 20, 20));

        Label bookTypeLabel = new Label("Pilih jenis buku:");
        ToggleGroup bookTypeGroup = new ToggleGroup();
        RadioButton historyBookButton = new RadioButton("History Book");
        historyBookButton.setToggleGroup(bookTypeGroup);
        RadioButton storyBookButton = new RadioButton("Story Book");
        storyBookButton.setToggleGroup(bookTypeGroup);
        RadioButton textBookButton = new RadioButton("Text Book");
        textBookButton.setToggleGroup(bookTypeGroup);

        Label idLabel = new Label("Masukkan Id Buku: ");
        TextField idField = new TextField();
        Label titleLabel = new Label("Masukkan judul buku: ");
        TextField titleField = new TextField();
        Label authorLabel = new Label("Masukkan author buku: ");
        TextField authorField = new TextField();
        Label stockLabel = new Label("Masukkan stok buku: ");
        TextField stockField = new TextField();
        Label categoryLabel = new Label("Masukkan Category buku: ");
        TextField categoryField = new TextField();
        Label durationLabel = new Label("Masukkan Duration buku: ");
        TextField durationField = new TextField();
        Button addButton = new Button("Tambah");
        Button backButton = new Button("Kembali");

        addButton.setOnAction(e -> {
            String idBuku = idField.getText();
            String judul = titleField.getText();
            String author = authorField.getText();
            int stok = Integer.parseInt(stockField.getText());
            String category = categoryField.getText();
            String duration = durationField.getText();
            Book book = null;
            if (historyBookButton.isSelected()) {
                idBuku = generateId("HB");
                book = new HistoryBook(idBuku, judul, stok, author, category, duration);
            } else if (storyBookButton.isSelected()) {
                idBuku = generateId("SB");
                book = new StoryBook(idBuku, judul, stok, author, category, duration);
            } else if (textBookButton.isSelected()) {
                idBuku = generateId("TB");
                book = new TextBook(idBuku, judul, stok, author, category, duration);
            }

            if (book != null) {
                Main.bookList.add(book);
                showAlert(Alert.AlertType.INFORMATION, "Buku berhasil ditambahkan.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Pilih jenis buku terlebih dahulu.");
            }
        });

        backButton.setOnAction(e -> showAdminMenu(primaryStage));

        inputBookLayout.getChildren().addAll(bookTypeLabel, historyBookButton, storyBookButton, textBookButton, idLabel, idField, titleLabel, titleField, authorLabel, authorField, stockLabel, stockField, categoryLabel, categoryField, durationLabel, durationField, addButton, backButton);

        Scene inputBookScene = new Scene(inputBookLayout, 300, 400);
        primaryStage.setScene(inputBookScene);
    }

    private void displayBooks(Stage primaryStage) {
        VBox displayBooksLayout = new VBox(10);
        displayBooksLayout.setPadding(new Insets(20, 20, 20, 20));

        Label booksLabel = new Label("Daftar Buku Tersedia:");
        ListView<String> booksListView = new ListView<>();
        for (Book book : Main.bookList) {
            if (book != null) {
                booksListView.getItems().add("- " + book.getJudul() + " oleh " + book.getAuthor()
                        + " Stok: " + book.getStok()
                        + " category: " + book.getCategory()
                        + " duration: " + book.getDuration());
            }
        }
        Button backButton = new Button("Kembali");

        backButton.setOnAction(e -> showAdminMenu(primaryStage));

        displayBooksLayout.getChildren().addAll(booksLabel, booksListView, backButton);

        Scene displayBooksScene = new Scene(displayBooksLayout, 300, 400);
        primaryStage.setScene(displayBooksScene);
    }

    private void displayStudents(Stage primaryStage) {
        VBox displayStudentsLayout = new VBox(10);
        displayStudentsLayout.setPadding(new Insets(20, 20, 20, 20));

        Label studentsLabel = new Label("Daftar Mahasiswa yang terdaftar:");
        ListView<String> studentsListView = new ListView<>();
        for (Student student : studentList) {
            StringBuilder studentInfo = new StringBuilder("Nama: " + student.getName() + "\nNIM: " + student.getNim()
                    + "\nFakultas: " + student.getFaculty() + "\nProgram Studi: " + student.getStudyProgram());
            if (!student.getBorrowedBooks().isEmpty()) {
                studentInfo.append("\n  Meminjam Buku:");
                for (Book book : student.getBorrowedBooks()) {
                    studentInfo.append("\n    - " + book.getJudul());
                }
            }
            studentsListView.getItems().add(studentInfo.toString());
        }
        Button backButton = new Button("Kembali");

        backButton.setOnAction(e -> showAdminMenu(primaryStage));

        displayStudentsLayout.getChildren().addAll(studentsLabel, studentsListView, backButton);

        Scene displayStudentsScene = new Scene(displayStudentsLayout, 300, 400);
        primaryStage.setScene(displayStudentsScene);
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String generateId(String prefix) {
        int nextId = Main.bookList.size() + 1;
        return prefix + String.format("%03d", nextId);
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
