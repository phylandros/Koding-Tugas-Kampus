package Tugas;

public class Binatang {
    private String nama = "";
    private int umur;

    public void suara(){
        System.out.println("hewan bersuara...");
    }

    public String getnama(){
        return nama;
    }

    public void setnama(String nama){
        this.nama = nama;
    }

    public int getumur(){
        return umur;
    }

    public void setumur(int umur){
        this.umur = umur;
    }
}

class Kucing extends Binatang{
    public void meong(){
        System.out.println("Meong");
    }
}

class Anjing extends Binatang{
    public void guk(){
        System.out.println("Guk..Guk..");
    }
}
