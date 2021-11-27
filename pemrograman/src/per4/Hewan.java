package per4;

public class Hewan {
    
    public void bernafas() {
        System.out.println("Hewan hidup yang bernafas");
    }
}


class Herbivora extends Hewan {
    void makan(){
        System.out.println("Herbivora memakan");
    }

    void minum(){
        System.out.println("Herbivora minum");
    }
}
