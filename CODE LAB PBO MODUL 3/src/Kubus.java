import java.util.Scanner;

class Kubus extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double sisi;

    Kubus(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        super.inputNilai();
        System.out.print("Input sisi: ");
        sisi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 6 * sisi * sisi;
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = Math.pow(sisi, 3);
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}
