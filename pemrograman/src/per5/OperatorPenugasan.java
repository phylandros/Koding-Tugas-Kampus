package per5;

public class OperatorPenugasan {
    public static void main(String[] args) {
        int a;
        int b;
        
        a = 5;
        b = 10;
        
        b += a;
        System.out.println("Hasil Pertambahan : " + b);
        b -= a;
        System.out.println("Hasil Pengurangan : " + b);
        b *= a;
        System.out.println("Hasil Perkalian : " + b);
        b /= a;
        System.out.println("Hasil Pembagian : " + b);
        b &= a;
        System.out.println("Hasil Sisa Bagi : " + b);
        
        
        System.out.println("");
        System.out.println("=====");
        System.out.println("Operation Pembandingan");
        System.out.println("=====");
        System.out.println("");
        
        int nilaiA = 12;
        int nilaiB = 4;
        
        boolean hasil;
        
        hasil = nilaiA > nilaiB;
        System.out.println("Apakah A lebih besar dari B = " + hasil);
        hasil = nilaiA < nilaiB;
        System.out.println("Apakah A lebih Kecil dari B = " + hasil);
        hasil = nilaiA >= nilaiB;
        System.out.println("Apakah A lebih besar sama dengan dari B = " + hasil);
        hasil = nilaiA <= nilaiB;
        System.out.println("Apakah A lebih Kecil sama dengan dari B = " + hasil);
        hasil = nilaiA == nilaiB;
        System.out.println("Apakah A sama dengan dari B = " + hasil);
        hasil = nilaiA != nilaiB;
        System.out.println("Apakah A tidak sama dengan dari B = " + hasil);
        
        System.out.println("");
        System.out.println("=====");
        System.out.println("Operation Logika");
        System.out.println("=====");
        System.out.println("");
        
        boolean aku = true;
        boolean kamu = false;
        boolean dia;
        
        dia = aku && kamu;
        System.out.println(" Aku dan kamu = " + dia);
        dia = aku || kamu;
        System.out.println(" Aku atau kamu = " + dia);
        System.out.println(" Aku kebalikan kamu = " + !aku);
        
        System.out.println("");
        System.out.println("=====");
        System.out.println("Bitwise");
        System.out.println("=====");
        System.out.println("");
        
        int A = 5;
        int B = 7;

        System.out.println("A & B = " + (A & B));   
        System.out.println("A & B = " + (A | B));   
        System.out.println("A & B = " + (A ^ B));   
        System.out.println("~a = " + ~A);   

        A &= B;
        System.out.println("a = " + a);

        System.out.println("");
        System.out.println("=====");
        System.out.println("Operasi Bitwise");
        System.out.println("=====");
        System.out.println("");

        int Ayam = 60;
        int Babi = 13;
        int Cacing = 0;
        Cacing = Ayam & Babi;
        System.out.println("Ayam AND Babi = " + Cacing);
        Cacing = Ayam | Babi;
        System.out.println("Ayam OR Babi = " + Cacing);
        Cacing = Ayam ^ Babi;
        System.out.println("Ayam XOR Babi = " + Cacing);
        Cacing = Ayam << Babi;
        System.out.println("Ayam Left Shift Babi = " + Cacing);
        Cacing = Ayam >> Babi;
        System.out.println("Ayam Right Shift Babi = " + Cacing);
        Cacing = Ayam >>> Babi;
        System.out.println("Ayam Right Shift (unsigned) Babi = " + Cacing);
        



        


    }
}
