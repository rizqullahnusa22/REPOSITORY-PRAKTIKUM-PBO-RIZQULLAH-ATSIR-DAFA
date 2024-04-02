import java.util.Scanner;

public class LoginSiswa {
    private static String[] students = { "202310370311119", "dafanusa" };
    private static String adminNIM = "admin";
    private static String adminPassword = "adminslot99";
    private static int studentIndex = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library System Login");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih antara (1-3): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Masukkan NIM : ");
                String nim = scanner.next();
                if (loginStudent(nim)) {
                    System.out.println("Login berhasil sebagai Mahasiswa");
                } else {
                    System.out.println("Username Mahasiswa tidak ditemukan");
                }
            } else if (choice == 2) {
                System.out.print("Masukkan Username (admin): ");
                String username = scanner.next();
                System.out.print("Masukkan Password (admin): ");
                String password = scanner.next();
                if (loginAdmin(username, password)) {
                    System.out.println("Login berhasil sebagai Admin Slot");
                } else {
                    System.out.println("User Admin tidak ditemukan");
                }
            } else if (choice == 3) {
                System.out.println("terima kasih semoga puas dengan pelayanan kami");
                break;
            }
        }
    }

    private static boolean loginStudent(String nim) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(nim)) {
                studentIndex = i;
                return true;
            }
        }
        return false;
    }

    private static boolean loginAdmin(String username, String password) {
        return adminNIM.equals(username) && adminPassword.equals(password);
    }
}