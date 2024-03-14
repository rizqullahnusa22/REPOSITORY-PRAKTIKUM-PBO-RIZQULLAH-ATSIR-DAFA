import java.util.Scanner;


public class Hitung_Deret {

    private int tot_ganjil, tot_genap, input_int;

    public void input() {
        // Membaca input dari user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan batas deret: ");
        input_int = scanner.nextInt();
    }

    public void deret() {
        // Menghitung deret bilangan ganjil dan genap
        tot_ganjil = 0;
        tot_genap = 0;
        for (int i = 1; i <= input_int; i++) {
            if (i % 2 == 0) {
                tot_genap += i;
            } else {
                tot_ganjil += i;
            }
        }
    }

    public void cetak() {
        // Menampilkan hasil deret
        System.out.println("Deret bilangan ganjil: ");
        for (int i = 1; i <= input_int; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("Deret bilangan genap: ");
        for (int i = 1; i <= input_int; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("Total bilangan ganjil: " + tot_ganjil);
        System.out.println("Total bilangan genap: " + tot_genap);
    }

     static void main(String[] args) {
        Hitung_Deret deret = new Hitung_Deret();
        deret.input();
        deret.deret();
        deret.cetak();
    }
}
