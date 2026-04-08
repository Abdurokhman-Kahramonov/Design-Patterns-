package designPatterns.creational.prototype;

public class PrototypeExample1 {
    public static void main(String[] args) {
        Smartphone SamsungA15 = new Smartphone("A15", "Samsung", 3596000);
        Smartphone SamsungPhone = (Smartphone) SamsungA15.clone();
        SamsungA15.printDetails();
        System.out.println(SamsungA15 == SamsungPhone);
    }
}


class Smartphone implements Prototype{
    private String model;
    private String producer;
    private int cost;
    public Smartphone(String model, String producer, int cost) {
        this.model = model;
        this.producer = producer;
        this.cost = cost;
    }
    @Override
    public void printDetails() {
        System.out.println("Model: " + model + ", producer: " + producer+", cost: "+cost);
    }

    @Override
    public Prototype clone() {
        return new Smartphone(this.model, this.producer, this.cost);
    }


}


