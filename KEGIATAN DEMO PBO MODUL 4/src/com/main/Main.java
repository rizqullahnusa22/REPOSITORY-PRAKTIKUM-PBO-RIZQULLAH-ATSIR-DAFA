package com.main;

import books.Book;
import data.Admin;
import data.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Book> bookList = new ArrayList<>();
    public static ArrayList<Student> studentsList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        bookList.add(0, new Book("001", "Petani menyembelih Banteng", 5, "Jokowi", "Horror", "170"));
        bookList.add(1, new Book("002", "Banteng Merah", 10, "Megawati", "Action", "150"));
        bookList.add(2, new Book("003", "Amin for Indonesia", 8, "Anies", "Comedy", "200"));


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
                    System.out.println("Terima kasih telah mengisi hari-hariku");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan anda sudah milik orang lain");
            }
        }
    }

    public static abstract class User {
        private String nim;

        public User(String nim) {
            this.nim = nim;
        }

        public String getNim() {
            return nim;
        }

        public abstract void menuAdmin();

        public abstract void menuStudent();

        public abstract void displayBooks();
        public static void addTempStudent(Student student) {
            studentsList.add(student);
        }
        public static void addTempBook(Book book) {
            bookList.add(book);
        }
    }
}








