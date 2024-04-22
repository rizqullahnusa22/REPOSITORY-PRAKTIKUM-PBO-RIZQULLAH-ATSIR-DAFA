package data;

import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import com.main.Main;
import util.iMenu;

import java.util.ArrayList;

public  class Admin extends Main.User implements iMenu {
    private ArrayList<Student> studentList = new ArrayList<>();

    public Admin() {
        super("admin");
    }

    public void login() {
        System.out.print("Masukkan Username (admin): ");
        String username = Main.scanner.next();
        System.out.print("Masukkan Password (adminslot99): ");
        String password = Main.scanner.next();
        if (isAdmin(username, password)) {
            System.out.println("Login berhasil sebagai Admin Slot");
            menuAdmin();
        } else {
            System.out.println("User Admin tidak ditemukan, karena sudah dimiliki orang lain");
        }
    }

    private boolean isAdmin(String username, String password) {

        return username.equals("admin") && password.equals("adminslot99");
    }
    @Override
    public void menuAdmin() {
        while (true) {
            System.out.println("Dashboard Admin");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Input Buku");
            System.out.println("4. Tampilkan Daftar Buku");
            System.out.println("5. Logout");
            System.out.print("Pilih antara (1-5): ");
            int choice = Main.scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    inputBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Selamat pagi Dunia tipu-tipu");
                    return;
                default:
                    System.out.println("Pilihan anda sudah bersama orang lain");
            }
        }
    }


    private void addStudent() {

        System.out.println("Menambahkan mahasiswa...");
        System.out.print("Masukkan Nama: ");
        String name = Main.scanner.next();
        System.out.print("Masukkan NIM: ");
        String nim = Main.scanner.next();
        if (nim.length() != 15) {
            System.out.println("NIM tidak valid! Harus 15 karakter.");
            return;
        }
        System.out.print("Masukkan Fakultas: ");
        String faculty = Main.scanner.next();
        System.out.print("Masukkan Program Studi: ");
        String studyProgram = Main.scanner.next();
        studentList.add(new Student(nim, name, faculty, studyProgram));
        System.out.println("Mahasiswa dengan NIM " + nim + " berhasil ditambahkan.");
    }

    private void inputBook() {

        System.out.println("Memasukkan buku...");
        System.out.println("Pilih jenis buku:");
        System.out.println("1. History Book");
        System.out.println("2. Story Book");
        System.out.println("3. Text Book");
        System.out.print("Pilih jenis buku (1-3): ");
        int bookType = Main.scanner.nextInt();
        Main.scanner.nextLine();

        String idBuku, judul, author, category, duration;
        int stok;
        System.out.print("Masukkan Id Buku: ");
        idBuku = Main.scanner.nextLine();
        System.out.print("Masukkan judul buku: ");
        judul = Main.scanner.nextLine();
        System.out.print("Masukkan author buku: ");
        author = Main.scanner.nextLine();
        System.out.print("Masukkan stok buku: ");
        stok = Main.scanner.nextInt();
        Main.scanner.nextLine();
        System.out.print("Masukkan Category buku: ");
        category = Main.scanner.nextLine();
        System.out.print("Masukkan Duration buku: ");
        duration = Main.scanner.nextLine();

        switch (bookType) {
            case 1:
                idBuku = generateId("HB");
                Main.bookList.add(new HistoryBook(idBuku, judul, stok, author, category, duration));
                break;
            case 2:
                idBuku = generateId("SB");
                Main.bookList.add(new StoryBook(idBuku, judul, stok, author, category, duration));
                break;
            case 3:
                idBuku = generateId("TB");
                Main.bookList.add(new TextBook(idBuku, judul, stok, author, category, duration));
                break;
            default:
                System.out.println("Pilihan anda tidak ditemukan, karena sudah bersama orang lain");
                return;
        }
        System.out.println("Buku berhasil ditambahkan.");
    }

    @Override
    public void menuStudent() {

    }

    @Override
    public void displayBooks() {

        System.out.println("Daftar Buku Tersedia:");
        for (Book book : Main.bookList) {
            if (book != null) {
                System.out.println("- " + book.getJudul() + " oleh "  + book.getAuthor()
                        +  " Stok : "  + book.getStok()
                        +  " category : "  + book.getCategory()
                        +  " duration : "  + book.getDuration());
            }
        }
    }

    private void displayStudents() {

        System.out.println("Daftar Mahasiswa yang terdaftar:");
        for (Student student : studentList) {
            System.out.println("Nama: " + student.getName());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Fakultas: " + student.getFaculty());
            System.out.println("Program Studi: " + student.getStudyProgram());
            if (!student.getBorrowedBooks().isEmpty()) {
                System.out.println("  Meminjam Buku:");
                for (Book book : student.getBorrowedBooks()) {
                    System.out.println("    - " + book.getJudul());
                }
            }
        }
    }

    private String generateId(String prefix) {
        // Implementasi pembuatan ID unik
        // Contoh: HB001, SB002, TB003, dst.
        int nextId = Main.bookList.size() + 1;
        return prefix + String.format("%03d", nextId);
    }
    @Override
    public void menu() {
    }
    public void getStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}



