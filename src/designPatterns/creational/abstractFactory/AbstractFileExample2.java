package designPatterns.creational.abstractFactory;

public class AbstractFileExample2 {
    public static void main(String[] args) {
        City Tokyo = new City();
        PassengerVehicle transport = Tokyo.buyPassengerVehicle();
        GoodsVehicle delivery = Tokyo.buyGoodsVehicle();
        transport.buy();
        delivery.buy();
        Company UzEnergo = new Company();
        PassengerVehicle companyTransport = UzEnergo.buyPassengerVehicle();
        GoodsVehicle companyDelivery = UzEnergo.buyGoodsVehicle();
        companyTransport.buy();
        companyDelivery.buy();
    }

}


// Types of vehicles
// there are two types of vehicles: passenger and good;

// passenger transports: car and buse
// goods vehicles: CityDelivery and Beverage

interface Vehicles{
    PassengerVehicle buyPassengerVehicle();
    GoodsVehicle buyGoodsVehicle();
}
interface PassengerVehicle{
    void buy();
}
interface GoodsVehicle{
    void buy();
}

class Car implements PassengerVehicle{
    @Override
    public void buy(){}
}
class Bus implements PassengerVehicle{
    @Override
    public void buy(){}
}
class CityDelivery implements GoodsVehicle{
    @Override
    public void buy(){}
}
class Beverage implements GoodsVehicle{
    @Override
    public void buy(){}
}

class City implements Vehicles{

    @Override
    public PassengerVehicle buyPassengerVehicle() {
        return new Bus();
    }

    @Override
    public GoodsVehicle buyGoodsVehicle() {
        return new CityDelivery();
    }
}

class Company implements Vehicles{
    @Override
    public PassengerVehicle buyPassengerVehicle(){
        return new Car();
    }
    @Override
    public GoodsVehicle buyGoodsVehicle(){
        return new Beverage();
    }

}