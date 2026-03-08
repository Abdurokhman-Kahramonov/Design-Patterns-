package designPatterns.structural.bridge;

public class BridgePatternExample {
    public static void main(String[] args) {
        Shape circle = new Circle(new Blue());
        circle.draw();
    }
}
// color: red, blue, green. shape: circle, square

// n = color*shape
// n = color + shape

// Box:
// 1 Product (Item)
// 2 Mini Box:
        // 1 Product(Item)
        // 2 Mini Box:'
                //......




abstract class Shape{
    public Color color;

    public Shape(Color color){
        this.color = color;
    }

    abstract void draw();
}
interface Color{
    void setColor();
}
class Red implements Color{
    @Override
    public void setColor() {
        System.out.println("This is red color");
    }
}
class Green implements Color{
    @Override
    public void setColor() {
        System.out.println("This is green color");
    }
}
class Blue implements Color{
    @Override
    public void setColor() {
        System.out.println("This is blue color");
    }
}
class Square extends Shape{

    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Setting square");
        color.setColor();
    }
}
class Circle extends Shape{

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Setting circle");
        color.setColor();
    }
}

interface Common{
    void draw();
}