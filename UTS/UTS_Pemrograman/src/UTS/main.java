package UTS;

import java.util.*;

public class main {
    public static void main(String[] args) {

            System.out.println("+++++++++++++++++++++++++");
            System.out.println("|  AIRCRAFT SIMULATION  |");
            System.out.println("|1. Pesawat Tempur      |");
            System.out.println("|2. Pesawat Intai       |");
            System.out.println("+++++++++++++++++++++++++");
            Scanner input = new Scanner(System.in);
            System.out.print("Pilih ? :  ");
            String pilih = input.nextLine();
                switch (pilih) {
                case "1":
                
                Scanner tempur_input = new Scanner(System.in);
                System.out.print("Masukan Type Pesawat : ");  
                String type_tempur = tempur_input.nextLine();
                
                System.out.print("Mode Pesawat (awak/tanpa) : "); 
                String mode_tempur = tempur_input.nextLine();
                
                System.out.print("Jumlah missile : "); 
                int misil = tempur_input.nextInt();
                
                System.out.print("Jumlah roket yang di tembak : "); 
                int misil_tembak = tempur_input.nextInt();
                
                tempur Tempur = new tempur();
                Tempur.setType(type_tempur);
                Tempur.setMode(mode_tempur);
                Tempur.setRudal(misil);
                Tempur.setrudalTembak(misil_tembak);
                Tempur.info();                           
                break;

            case "2":
                Scanner intai_input = new Scanner(System.in);
                System.out.print("Masukan Type Pesawat : ");  
                String type_intai = intai_input.nextLine();
                        
                System.out.print("Mode Pesawat (awak/tanpa) : "); 
                String mode_intai = intai_input.nextLine();
    
                System.out.print("Jangkauan Radar: "); 
                int radar = intai_input.nextInt();
    
                System.out.print("Penguatan Jangkauan Radar : "); 
                int penguatan_radar  = intai_input.nextInt();

                intai Intai = new intai();
                Intai.setType(type_intai);
                Intai.setMode(mode_intai);
                Intai.setRadar(radar);
                Intai.setJangkau(penguatan_radar);
                Intai.info();
                break;
    
            default:
            System.out.println("Salah Pilihan");
                break;
        }
    }
}
