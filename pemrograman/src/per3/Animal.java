package per3;

public class Animal {
    void eat(){
        System.out.println("eating...");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("Barking..");
    }
}

class Cat extends Animal{
    void meow(){
        System.out.println("meow...");
    }
}
