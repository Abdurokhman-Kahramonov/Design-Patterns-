package designPatterns.creational.factory;

import java.io.*;
import java.util.Calendar;

// Library classes
abstract class Vehicle {
    public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {
    public void printVehicle()
    {
        System.out.println("I am two wheeler");
    }
}

class FourWheeler extends Vehicle {
    public void printVehicle()
    {
        System.out.println("I am four wheeler");
    }
}

// Client (or user) class
class Client {
    private Vehicle pVehicle;

    public Client(int type){
        if (type == 1) {
            pVehicle = new TwoWheeler();
        }
        else if (type == 2) {
            pVehicle = new FourWheeler();
        }
        else {
            pVehicle = null;
        }
    }

    public void cleanup()
    {
        if (pVehicle != null) {
            pVehicle = null;
        }
    }

    public Vehicle createVehicle() { return pVehicle; }
}

// Driver Code
public class GFG {
    public static void main(String[] args) {
        Client pClient = new Client(1);
        Vehicle pVehicle = pClient.createVehicle();
        if (pVehicle != null) {
            pVehicle.printVehicle();
        }
        pClient.cleanup();
    }
}

