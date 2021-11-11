package test;

public class MatematikaBeraksi {
    public static void main(String[] args) {
        Matematika matematika = new Matematika();
        System.out.println("Penjumlahan 20 + 20 = " + matematika.pertambahan(20, 20));
        System.out.println("Pengurangan 10 - 5  = " + matematika.pengurangan(10, 5));
        System.out.println("Perkalian   10 * 20 = " + matematika.perkalian(10, 20));
        System.out.println("Pembagian   21 / 2  = " + matematika.pembagian(21, 2));
    }
}
