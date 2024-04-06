class teknik {


    String jurusan;
    String fakultas;

    public informatika(String jurusan, String fakultas) {
        this.jurusan = jurusan;
        this.fakultas = fakultas;
    }

    public static void jumlahRuangan(){
        System.out.println("Jumlah ruangan Informatika");
    }


    class prodi extends teknik;
    String Mahasiswa;

    public informatika(String jurusan, String fakultas, String mahasiswa) {
        this.jurusan = jurusan;
        this.fakultas = fakultas;
        Mahasiswa = mahasiswa;
    }
}

public class informatika {
    public static void main (String[]args) {
        prodi obj = new teknik.prodi( "Informatika", "Teknik", "umm");
        System.out.println();

    }
}

