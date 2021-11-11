import Tugas_2.Binatang;
import Tugas_1.Matematika;



public class Console {
    public static void main(String[] args) {

        System.out.println("TUGAS 1");
        Matematika matematika = new Matematika();
        System.out.println("Penjumlahan 20 + 20 = " + matematika.pertambahan(20, 20));
        System.out.println("Pengurangan 10 - 5  = " + matematika.pengurangan(10, 5));
        System.out.println("Perkalian   10 * 20 = " + matematika.perkalian(10, 20));
        System.out.println("Pembagian   21 / 2  = " + matematika.pembagian(21, 2));

        System.out.println("========================");
        System.out.println("TUGAS 2");
        Binatang binatang = new Binatang();
        binatang.setnama("Siberian");
        binatang.setumur(80);
        System.out.println("Nama : "+ binatang.getnama());
        System.out.println("Umur : "+ binatang.getumur());  
    }
}
