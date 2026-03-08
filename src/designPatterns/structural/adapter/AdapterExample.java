package designPatterns.structural.adapter;

import java.io.FileReader;

public class AdapterExample {
    public static void main(String[] args) {
        Humo humo = new Humo();
        ModernPaymentOperations paymentAdapter = new PaymentAdapter(humo);
        paymentAdapter.pay(23);

    }
}

interface ModernPaymentOperations{
    public void pay(double amount);
}

class PaymentAdapter implements ModernPaymentOperations{
    private Humo humo;
    public PaymentAdapter(Humo humo){
        this.humo = humo;
    }

    @Override
    public void pay(double amount) {
        humo.humoPay((int) amount);
    }
}

class PaymentProcessor implements ModernPaymentOperations{

    // UzCard - modern transaction
    @Override
    public void pay(double amount){
        // UzCard transaction logic...
    }

    //Huma humoPay(int amountToPay); // old method
}


class Humo{
    public void humoPay(int amountToPay){
        System.out.println("Paying this shit.." + amountToPay);
    }
}