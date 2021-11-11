package Tugas_2;

public class BinatangBeraksi {
    public static void main(String[] args) {
        System.out.println("TUGAS 2");
        Anjing anjing = new Anjing();
        anjing.setnama("Siberian");
        anjing.setumur(82);
        anjing.guk();
        System.out.println("Nama : "+ anjing.getnama());
        System.out.println("Umur : "+ anjing.getumur());  
    }
}