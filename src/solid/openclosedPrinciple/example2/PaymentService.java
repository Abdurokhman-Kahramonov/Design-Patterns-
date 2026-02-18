package solid.openclosedPrinciple.example2;

public class PaymentService {
    public void pay(String paymentType){
        if(paymentType.equals("Uzcard")){

            // Process credit card payment - 2000
        } else if(paymentType.equals("Humo")){
            // Process PayPal payment - 3000
        }
    }
}
