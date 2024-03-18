import java.util.Scanner;

public class Kubus extends BangunRuang{
    Scanner scanner = new Scanner(System.in);
    private double sisi;
    
    @Override
    public void input(){
        super.inputNilai();
        System.o("Input sisi: ");
        sisi = scanner.nextnext();
    }

    @Override
    public void luasPermukaan(){
        double hasil = 6 * sisi * sisi;
        super.luasaan();
        out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume(){
        hasil = Math.pow(sisi, 3);
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}
