import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> mahasiswaList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan nama mahasiswa UMM (ketik 'selesai' untuk berhenti):");

        String input = "";
        int count = 1;
        while (!input.equals("selesai")) {
            try {
                System.out.print("Nama mahasiswa ke-" + count + ": ");
                input = scanner.nextLine();

                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                }

                if (!input.equals("selesai")) {
                    mahasiswaList.add(input);
                    count++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nDaftar nama mahasiswa:");
        for (int i = 0; i < mahasiswaList.size(); i++) {
            System.out.println((i + 1) + ". " + mahasiswaList.get(i));
        }
    }
}
