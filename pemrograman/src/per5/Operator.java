package per5;

public class Operator {
   private int a;
   private int b;


   public int geta(){
       return a;
   }

   public int getb(){
       return b;
   }

   public int seta(int a){
       this.a = a;

       return this.a;
    }
    
    public int setb(int b){
        this.b = b;
        
        return this.b;

   }

 void hitung() {
       System.out.println("Menghitung....");
   }
}

class Aritmatika extends Operator {
    @Override
    void hitung() {
        System.out.println(this.geta() + " + " + this.getb() + " = " +(this.geta() + this.getb()));
        System.out.println(this.geta() + " - " + this.getb() + " = " +(this.geta() - this.getb()));
        System.out.println(this.geta() + " * " + this.getb() + " = " +(this.geta() * this.getb()));
        System.out.println(this.geta() + " / " + this.getb() + " = " +(this.geta() / this.getb()));
        System.out.println(this.geta() + " % " + this.getb() + " = " +(this.geta() % this.getb()));
    }
}

class Bitwise extends Operator{
    
    int jml;
    
    @Override
    void hitung(){
        System.out.println(this.geta() + " AND " + this.getb() + " = " +(this.geta() & this.getb()));
        System.out.println(this.geta() + " OR " + this.getb() + " = " +(this.geta() | this.getb()));
        System.out.println(this.geta() + " XOR " + this.getb() + " = " +(this.geta() ^ this.getb()));
    }

    void geser(int jml){
       
        int i = 0;
        i = geta() << jml;
        System.out.println("Left shift A = " + i);
        i = getb() << jml;
        System.out.println("Left shift B = " + i);
        i = geta() >> jml;
        System.out.println("Right shift A = " + i);
        i = getb() >> jml;
        System.out.println("Right shift B = " + i);

    }



}

