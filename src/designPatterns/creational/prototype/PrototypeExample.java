package designPatterns.creational.prototype;

public class PrototypeExample {
    public static void main(String[] args) {
        Car bmwModel1 = new Car("BMW", "Black");
        Car bmwModel2 = (Car) bmwModel1.clone();

        System.out.println(bmwModel1 == bmwModel2);

    }
}
interface Prototype{
    Prototype clone();
    void printDetails();
}
class Car implements Prototype{
    private String model;
    private String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }
    @Override
    public void printDetails() {
        System.out.println("Model: " + model + ", Color: " + color);
    }

    @Override
    public Prototype clone() {
        return new Car(this.model, this.color);
    }
}


