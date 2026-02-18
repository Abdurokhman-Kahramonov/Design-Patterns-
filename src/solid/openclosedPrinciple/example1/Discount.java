package solid.openclosedPrinciple.example1;

public interface Discount {
        double getDiscount(double price);
}
class StudentDiscount implements Discount {
    @Override
    public double getDiscount(double price) {
        return price * 0.1; // 10% discount for students
    }
}
class SeniorDiscount implements Discount {
    @Override
    public double getDiscount(double price) {
        return price * 0.15; // 15% discount for seniors
    }
}
