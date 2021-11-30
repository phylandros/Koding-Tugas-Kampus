package per6;

import java.util.*;

public class Struk {
    public static void main(String[] args) {

        System.out.println("++++++++++++++++++++++++++");
        System.out.println("|    TOKO Segala Aya     |");
        System.out.println("++++++++++++++++++++++++++");
        
        // Input
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Nama Barang : ");
        String nama = input.nextLine();
        System.out.print("Masukan Harga Satuan : ");
        int harga = input.nextInt();
        System.out.print("Masukan Total Barang : ");
        int total_brg = input.nextInt();

        double Total = harga * total_brg;
        double disc = ( Total > 50000 ) ? 0.05:0;
        double potongan = Total * disc;
        double Total_bayar =  Total - potongan;
    
        // Output
        System.out.println("Total : " + Total);
        System.out.println("Disc : " + disc);
        System.out.println("Potongan : " + potongan);
        System.out.println("Total Bayar : " + Total_bayar);
    }  
}
