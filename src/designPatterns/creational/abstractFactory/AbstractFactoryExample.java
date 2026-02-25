package designPatterns.creational.abstractFactory;


// This is restaurant
public class AbstractFactoryExample {
    public static void main(String[] args) {
        MealFactory oshCity = new OshFactory();
        Meal osh = oshCity.createMeal();
        Drink choy = oshCity.createDrink();
        osh.prepare();
        choy.prepare();
        MealFactory evos = new BurgerFactory();
        Meal lavash = evos.createMeal();
        Drink colaRazliv = evos.createDrink();
        lavash.prepare();
        colaRazliv.prepare();
    }
}

// Types of meals and drinks
// Types of restaurants

// 1. We defined Meal and Drink types which are Osh/Burger and Choy/Cola respectively.
// 2. We defined Restaurant types which are OshFactory and BurgerFactory respectively.




interface Meal{
    void prepare();
}
interface Drink{
    void prepare();
}
interface MealFactory{
    Meal createMeal();
    Drink createDrink();
}

class Osh implements Meal{
    @Override
    public void prepare() {
        System.out.println("Preparing Osh");
    }
}
class Burger implements Meal{
    @Override
    public void prepare() {
        System.out.println("Preparing Burger");
    }
}
class Choy implements Drink{
    @Override
    public void prepare() {
        System.out.println("Preparing Choy");
    }
}
class Cola implements Drink{
    @Override
    public void prepare() {
        System.out.println("Preparing Cola");
    }
}

class OshFactory implements MealFactory{
    @Override
    public Meal createMeal() {
        return new Osh();
    }

    @Override
    public Drink createDrink() {
        return new Choy();
    }
}
class BurgerFactory implements MealFactory{

    @Override
    public Meal createMeal() {
        return new Burger();
    }

    @Override
    public Drink createDrink() {
        return new Cola();
    }
}
