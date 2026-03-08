package designPatterns.structural.decorator;

public class Decorator {
    public static void main(String[] args) {
        Laptop laptop32 = new Bit32Laptop();
        Laptop laptop64 = new Bit64Laptop("Tuff15", "Asus");

        System.out.println(laptop64.getDescription());
        System.out.println(laptop32.getDescription());

        Bit64LaptopDecorator bit64LaptopDecorator = new Bit64LaptopDecorator(laptop64);
        System.out.println(bit64LaptopDecorator.getDescription());
        bit64LaptopDecorator.addGPU();

    }
}

interface Laptop{
    public String getDescription();
}

class Bit64Laptop implements Laptop{
    String name;
    String brand;
    public Bit64Laptop(String name, String brand){
        this.name = name;
        this.brand = brand;
    }
    @Override
    public String getDescription() {
        return "This is "+ this.name + " This brand: " + this.brand;
    }
}


class Bit64LaptopDecorator extends LaptopDecorator{
    public Bit64LaptopDecorator(Laptop docoratedLaptop) {
        super(docoratedLaptop);
    }

    @Override
    public String getDescription() {
        return docoratedLaptop.getDescription();
    }
    public void addGPU(){

        System.out.println("I added GPU here");
    }
}
abstract class LaptopDecorator implements Laptop{
    public Laptop docoratedLaptop;

    public LaptopDecorator(Laptop docoratedLaptop){
        this.docoratedLaptop = docoratedLaptop;
    }
    public String getDescription(){
        return docoratedLaptop.getDescription();
    }
}



// *************************************************************************************

class Bit32Laptop implements Laptop{
    @Override
    public String getDescription() {
        return "This is laptop with 32 bits";
    }
}



class bit32LaptopDecorator extends LaptopDecorator{
    private String name;
    private String brand;

    public bit32LaptopDecorator(Laptop docoratedLaptop) {
        super(docoratedLaptop);
    }

    @Override
    public String getDescription() {
        return this.name + " " + this.brand + " 32 bit";
    }
    public void addRAM(){
        System.out.println("Also I added ram here");
    }
}