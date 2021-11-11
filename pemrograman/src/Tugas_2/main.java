package Tugas_2;

import Tugas_1.Matematika;

public class main {
    public static void main(String[] args) {
        System.out.println("TUGAS 1");
        Matematika matematika = new Matematika();
        System.out.println("Penjumlahan 20 + 20 = " + matematika.pertambahan(20, 20));
        System.out.println("Pengurangan 10 - 5  = " + matematika.pengurangan(10, 5));
        System.out.println("Perkalian   10 * 20 = " + matematika.perkalian(10, 20));
        System.out.println("Pembagian   21 / 2  = " + matematika.pembagian(21, 2));

        System.out.println("------------------------");
        System.out.println("TUGAS 2");
        Anjing anjing = new Anjing();
        anjing.setnama("Siberian");
        anjing.setumur(82);
        anjing.guk();
        System.out.println("Nama : "+ anjing.getnama());
        System.out.println("Umur : "+ anjing.getumur());       
    }
}

