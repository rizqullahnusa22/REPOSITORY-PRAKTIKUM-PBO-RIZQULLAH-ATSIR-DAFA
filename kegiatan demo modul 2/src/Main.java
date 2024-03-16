import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Book[] bookList = new Book[10];
    private static ArrayList<Student> studentsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Mengisi stok buku
        bookList[0] = new Book("001", "Petani menyembelih Banteng", 5, "Jokowi");
        bookList[1] = new Book("002", "Banteng Merah", 10, "Megawati");
        bookList[2] = new Book("003", "Amin for Indonesia", 8, "Anies");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Library System Login");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih antara (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM : ");
                    String nimStudent = scanner.next();
                    if (nimStudent.length() != 15) {
                        System.out.println("NIM tidak valid! Harus 15 karakter.");
                        break;
                    }
                    Student student = new Student(nimStudent);
                    student.login();
                    break;
                case 2:
                    Admin admin = new Admin();
                    admin.login();
                    break;
                case 3:
                    System.out.println("Terima kasih semoga puas dengan pelayanan kami");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }



    // Class User
    public static abstract class User {
        private String nim;

        public User(String nim) {
            this.nim = nim;
        }

        public String getNim() {
            return nim;
        }
    }

    // Class Student
    public static class Student extends User {
        private String name;
        private String faculty;
        private String studyProgram;
        private ArrayList<Book> borrowedBooks = new ArrayList<>();

        public Student(String nim) {
            super(nim);
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

        private void menuStudent() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Dashboard Mahasiswa");
                System.out.println("1. Tampilkan Buku");
                System.out.println("2. Pinjam Buku");
                System.out.println("3. Logout");
                System.out.print("Pilih antara (1-3): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        displayBooks();
                        break;
                    case 2:
                        borrowBook();
                        break;
                    case 3:
                        logout();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }

        private void displayBooks() {
            System.out.println("Daftar Buku Tersedia:");
            for (Book book : bookList) {
                if (book != null) {
                    System.out.println("- " + book.getJudul() + " oleh " + book.getAuthor() + " (Stok: " + book.getStok() + ")");
                    for (Student student : studentsList) {
                        if (student.getBorrowedBooks().contains(book)) {
                            System.out.println("  Dipinjam oleh: " + student.getName());
                        }
                    }
                }
            }
        }

        private void borrowBook() {
            System.out.print("Masukkan ID Buku yang ingin dipinjam: ");
            String bookId = scanner.next();
            Book selectedBook = findBookById(bookId);
            if (selectedBook != null && selectedBook.getStok() > 0) {
                selectedBook.setStok(selectedBook.getStok() - 1);
                borrowedBooks.add(selectedBook);
                System.out.println("Berhasil meminjam buku: " + selectedBook.getJudul());
            } else {
                System.out.println("Buku tidak tersedia atau ID buku tidak valid.");
            }
        }


        private Book findBookById(String id) {
            for (Book book : bookList) {
                if (book != null && book.getIdBuku().equals(id)) {
                    return book;
                }
            }
            return null;
        }

        private void logout() {
            System.out.println("Logout berhasil.");
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
    }

    // Class Admin
    public static class Admin extends Main.User {
        public Admin() {
            super("admin");
        }

        public void login() {
            // Implementasi login admin
            System.out.print("Masukkan Username (admin): ");
            String username = scanner.next();
            System.out.print("Masukkan Password (admin): ");
            String password = scanner.next();
            if (checkAdmin(username, password)) {
                System.out.println("Login berhasil sebagai Admin Slot");
                menuAdmin();
            } else {
                System.out.println("User Admin tidak ditemukan");
            }
        }

        private boolean checkAdmin(String username, String password) {
            return true;
        }

        private void menuAdmin() {
            while (true) {
                System.out.println("Dashboard Admin");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Tampilkan Mahasiswa");
                System.out.println("3. Logout");
                System.out.print("Pilih antara (1-3): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudents();
                        break;
                    case 3:
                        System.out.println("Logout berhasil.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }

        private void addStudent() {

            System.out.println("Menambahkan mahasiswa...");
            System.out.print("Masukkan Nama: ");
            String nama = scanner.next();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.next();
            if (nim.length() != 15) {
                System.out.println("NIM tidak valid! Harus 15 karakter.");
                return;
            }
            System.out.print("Masukkan Fakultas: ");
            String fakultas = scanner.next();
            System.out.print("Masukkan Program Studi: ");
            String programStudi = scanner.next();
            // Tambahkan mahasiswa ke dalam daftar mahasiswa
            studentsList.add(new Main.Student(nim, nama, fakultas, programStudi));
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil ditambahkan.");
        }

        private void displayStudents() {
            // Implementasi penampilan daftar mahasiswa
            System.out.println("Daftar Mahasiswa yang terdaftar:");
            for (Main.Student student : studentsList) {
                System.out.println("- Nama: " + student.getName() + ", NIM: " + student.getNim() +
                        ", Fakultas: " + student.getFaculty() + ", Program Studi: " + student.getStudyProgram());
                if (!student.getBorrowedBooks().isEmpty()) {
                    System.out.println("  Meminjam Buku:");
                    for (Book book : student.getBorrowedBooks()) {
                        System.out.println("    - " + book.getJudul());
                    }
                }
            }
        }
    }
}