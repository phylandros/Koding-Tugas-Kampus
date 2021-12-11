package UTS;

public class Pesawat {
    private String type;
    private String mode, pilih;
    private int rudal, radar, rudalTembak, jangkau;
    private boolean ulang;
    

    public String getPilih() {
        return pilih;
    }
    public boolean getUlang() {
        return ulang;
    }
    public String getType() {
        return type;
    }

    public String getMode() {
        return mode;
    }

    public int getRudal() {
        return rudal;
    }

    public int getRadar() {
        return radar;
    }
    
    public int getJangkau() {
        return jangkau;
    }

    public int getrudalTembak() {
        return rudalTembak;
    }
    public void setPilih(String pilih) {
        this.pilih = pilih;
    }
    public void setUlang(Boolean ulang) {
        this.ulang = ulang;
    }
    public void setType(String type) {
        this.type = type;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setRudal(int rudal) {
        this.rudal = rudal;
    }

    public void setRadar(int radar) {
        this.radar = radar;
    }
    public void setJangkau(int jangkau) {
        this.jangkau = jangkau;
    }
    public void setrudalTembak(int rudalTembak) {
        this.rudalTembak = rudalTembak;
    }

    void info() {
        System.out.println("Ini adalah Pesawat");
    }

}


class tempur extends Pesawat{
    void tembak(int juml){

        int i;
        i = juml - this.getrudalTembak();
        System.out.println("Jumlah Sisa Rudal : " + i);    

    } 
    void ulang(String ulng){

        boolean i;
        i = ulng == this.getPilih();  
        this.setUlang(i);
        
    } 
    
    @Override
    void info(){
        System.out.println("=============================");
        System.out.println(this.getrudalTembak() + "x tembak........" );
        System.out.println("=============================");
        
        System.out.println("Tipe Pesawat : " + this.getType());
        System.out.println("Mode Pesawat : " + this.getMode());
        System.out.println("Jumlah Rudal : " + this.getRudal());
        tembak(this.getRudal());
    }
    
    
}

class intai extends Pesawat{
    void radar(int juml){
        int i;

        i = this.getJangkau() + juml;
        System.out.println("jangkauan Radar Sekarang : " + i + " km");
    }
    
    @Override
    void info(){
        System.out.println("=====================================");
        System.out.println("Tipe Pesawat : " + this.getType());
        System.out.println("Mode Pesawat : " + this.getMode());
        System.out.println("Jangkauan Radar : " + this.getRadar() + " km");
        System.out.println("=====================================");
        radar(this.getRadar());
        System.out.println("=====================================");
    }

    

}

    
