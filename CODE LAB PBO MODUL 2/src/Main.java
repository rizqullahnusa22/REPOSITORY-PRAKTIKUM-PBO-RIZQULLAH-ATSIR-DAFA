import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    String jurusan;

    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public static void tampilUniversitas(){
        System.out.println("Universitas Muhammadiyah Malang");
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Mahasiswa[] daftarMhs = new Mahasiswa[100];
        int jumlahMhs = 0;

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    tambahDataMahasiswa(daftarMhs, jumlahMhs);
                    jumlahMhs++;
                    System.out.println("Data Mahasiswa Berhasil Ditambahkan");
                    break;

                case 2:
                    Mahasiswa.tampilUniversitas();
                    if (jumlahMhs == 0) {
                        System.out.println("Data mahasiswa masih kosong!");
                    } else {
                        for (int i = 0; i < jumlahMhs; i++) {
                            System.out.println("Nama: " + daftarMhs[i].getNama() + ", NIM: " + daftarMhs[i].getNim() + ", Jurusan: " + daftarMhs[i].getJurusan());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tambahDataMahasiswa(Mahasiswa[] daftarMhs, int jumlahMhs) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM (15 karakter): ");
        String nim = input.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = input.nextLine();

        if (nim.length() != 15) {
            System.out.println("Panjang NIM harus 15 karakter!");
            return;
        }

        Mahasiswa mhs = new Mahasiswa(nim, nama, jurusan);
        daftarMhs[jumlahMhs] = mhs;


    }
}

