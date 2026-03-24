package solid.liskovSubstitionPrinciple.example1;

public class Bird {
    int age;
    String name;

    void eat(){
        System.out.println("Bird is eating");
    }
}
class Penguin extends Bird{

}
class Crow extends Bird implements Flyable{

    @Override
    public void fly() {
        System.out.println("Crow is flying");
    }
}