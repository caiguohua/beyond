abstract class Animal{
     public abstract void noise();
}

class Dog extends Animal{
    @Override
    public void noise() {
        System.out.println("woof");
    }

    public void tail(){

    }
}

class Cat extends Animal{

    @Override
    public void noise() {
        System.out.println("miao");
    }

    public void paw(){

    }
}
public class DC extends Animal{

    Dog dog = new Dog();
    Cat cat = new Cat();

    public static void main(String[] args) {
        Animal animal = new DC();
        animal.noise();
//        ((DC) animal).test();
    }
//    public void test(){
//        noise();
//    }

    @Override
    public void noise() {
        dog.noise();
        cat.noise();
    }
}


