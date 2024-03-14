import java.util.Scanner;
import java.util.Arrays;

class Main {
    static String[][] bookList = {
            {"1","11","Petani Menyembelih Banteng","Joko Widodo","Action","4"},
            {"2","22","Banteng Merah","Megawati","Horror","0"},
            {"3","33","Amin For Indonesia","Anies","Comedy","2"},
    };
    static String[][] userStudent ={
            {"Rizqullah Atsir Dafa Childyasa Nusa", "202310370311119","Teknik","Informatika"},
    };

    static void menu(){//menampilkan pilihan
        System.out.println("===== Sistem Perpustakaan =====");
        System.out.println("1. Masuk sebagai Mahasiswa");
        System.out.println("2. Masuk Sebagai Admin");
        System.out.println("3. Exit");
        System.out.print("Pilih Opsi berikut(1-3): ");
        Scanner scan = new Scanner(System.in);
        int pilih = scan.nextInt();

        if(pilih == 1){
            inputNim();
        }else if(pilih == 2){
            log_admin();
        }else{
            System.out.println("terima kasih abangkuu");
            System.exit(0);
        }
    }

    static void menuAdmin(){//menyediakan pilihan
        while(true){
            System.out.println("=== Menu Admin Slot ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Keluar Boss");
            System.out.print("Pilih Opsi berikut(1-3): ");
            Scanner scan = new Scanner(System.in);
            int pilih = scan.nextInt();

            if(pilih == 1){
                Admin.addStudent();
            }else if(pilih == 2){
                Admin.displayStudents();
            }else if(pilih == 3){
                break;
            }
        }
    }

    static void menuStudent(){//menyediakan pilihan
        while(true){
            System.out.println("=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam buku atau Logout");
            System.out.print("Choose Option(1-3): ");
            Scanner scan = new Scanner(System.in);
            int pilih = scan.nextInt();

            if(pilih == 1){
                //
            }else if(pilih == 2){
                Student.displayBooks(bookList);
            }else if(pilih == 3){
                Student.logout();
                break;
            }else if(pilih == 99){
                break;
            }
        }
    }

    static void checkNim(String data){
        for (int i = 0 ; i<userStudent.length ; i++ ) {
            if (data.equals(userStudent[i][2])) {
                menuStudent();
            }
        }
    }

    static void inputNim(){

        System.out.print("Enter your NIM : ");
        Scanner scan = new Scanner(System.in);
        String nim = scan.nextLine();

        while(true){
            if (nim.length() != 15 ) {
                System.out.print("Nim Harus 15 Digit!!!\n");
                System.out.print("Masukkan NIM mahasiswa: ");
                nim = scan.nextLine();
            }else{
                Main cn = new Main();
                cn.checkNim(nim);
                break;
            }
        }
    }

    static void log_admin(){

        System.out.print("Masukan username admin(admin) : ");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        System.out.print("Masukan pasword admin(adminslotgacor) : ");
        String pwd = scan.nextLine();

        if (user.equals(Admin.adminUsername)&&pwd.equals(Admin.adminPassword)) {
            System.out.println();
            Main.menuAdmin();
        }else{
            System.out.println("maaf salah masuk abangkuu.\n");
        }
    }

    public static void main(String[] args) {
        while(true){
            Main.menu();
        }
    }

}


