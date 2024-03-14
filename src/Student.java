
class Student {
    static String Nama;
    static String Fakultas;
    static String programStudi;

    static void displayBooks(String[][] databuku){
        System.out.println("===========================================================================================");
        System.out.println("|| No.\t|| Id buku\t\t|| Nama Buku\t|| Author\t|| Category\t|| Stok ||");
        System.out.println("===========================================================================================");
        for (String[] buku : databuku) {
            System.out.println("|| "+buku[0]+"\t|| "+buku[1]+"\t|| "+buku[2]+"\t|| "+buku[3]+"\t|| "+buku[4]+"\t|| "+buku[5]+"\t ||");
        }
        System.out.println("===========================================================================================\n");
        System.out.println("Input Id buku yang ingin dipinjam (input 99 untuk kembali)");
    }
    static void logout(){
        System.out.println("sistem keluar...\n");
    }
}
