package solid.openclosedPrinciple.example1;

public class DiscountService {
    public static void main(String[] args) {
        Discount discount = new StudentDiscount();
        System.out.println(discount.getDiscount(123));
    }
    public double getDiscount(String type) {
        if (type.equals("STUDENT")) {
            return 0.1; // 10% discount for students
        } else if (type.equals("SENIOR")) {
            return 0.15; // 15% discount for seniors
        } else {
            return 0.0; // No discount for others
        }

    }
}
