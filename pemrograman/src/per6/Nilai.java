package per6;

import java.util.*;

public class Nilai {
    public static void main(String[] args) {

        // Input
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Nama : ");
        String nama = input.nextLine();
        System.out.print("Masukan Nilai UTS : ");
        int nuts = input.nextInt();
        System.out.print("Masukan Nilai UAS : ");
        int nuas = input.nextInt();
        System.out.print("Masukan Nilai Tugas : ");
        int ntugas = input.nextInt();
        System.out.print("Masukan Nilai Absen : ");
        int nabsen = input.nextInt();

        // Operasi
        double Nakhir = (0.4*nuas) + (0.3*nuts) + (0.2*ntugas) + ((nabsen/14)*10);
        
        // Output
        System.out.println("");
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("Nama : " + nama);
        System.out.println("Nilai UTS : " + nuts);
        System.out.println("Nilai UAS : " + nuas);
        System.out.println("Nilai Tugas : " + ntugas);
        System.out.println("Jumlah Absen : " + nabsen);
        System.out.println("Nilai Akhir : " + Nakhir);
        System.out.println("--------------------------");
        System.out.println("--------------------------");
    }  
}
