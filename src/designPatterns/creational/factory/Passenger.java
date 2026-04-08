package designPatterns.creational.factory;
// Library classes
abstract class Transport {
    public abstract void printTransport();
}

class Train extends Transport{
    public void printTransport(){
        System.out.println("I am moving on the train");
    }
}

class Airplane extends Transport{
    public void printTransport(){
        System.out.println("I am flying on the Airplane");
    }
}
// Class for booking
class Book{
    private Transport PassengerTransport;

    public Book(int type){
        if (type == 1){
            PassengerTransport = new Train();
        }
        else if(type == 2){
            PassengerTransport = new Airplane();
        }
        else{
            PassengerTransport = null;
        }
    }
    public void cleanUp(){
        if (PassengerTransport != null){
            PassengerTransport = null;
        }
    }
    public Transport chooseTransport() {return PassengerTransport;}
}

// for user, passenger
public class Passenger{
    public static void main(String[] args) {
        Book FirstPassenger = new Book(2);
        Transport pTransport = FirstPassenger.chooseTransport();
        if(pTransport != null){
            pTransport.printTransport();
        }
        FirstPassenger.cleanUp();
    }

}