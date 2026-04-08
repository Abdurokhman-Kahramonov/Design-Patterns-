# Abstract Factory Pattern

Create families of related objects without specifying their concrete classes.
This means that an abstract factory lets you produce matching objects together, while keeping the client independent from the exact implementations.

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

You want to open different themed restaurants:

Italian restaurant needs:

* Italian main dish
* Italian dessert

Japanese restaurant needs:

* Japanese main dish
* Japanese dessert

But your code creates each item manually:

* `new Pizza()`
* `new Tiramisu()`
* `new Sushi()`
* `new Mochi()`

👉 The client becomes tightly coupled to concrete classes
👉 It is easy to accidentally mix families, like `Pizza + Mochi`

### ✅ Good Design with Abstract Factory Pattern

You use a factory for each family:

* `ItalianMealFactory`
* `JapaneseMealFactory`

Each factory creates matching products:

* Italian factory → Pizza + Tiramisu
* Japanese factory → Sushi + Mochi

You don’t hardcode product classes in the client!
You just ask the factory for a full related set.

## 🧑‍💻 In software:

### ❌ Bad Design

```java
class Pizza {
    void serve() {
        System.out.println("Serving pizza");
    }
}

class Tiramisu {
    void serve() {
        System.out.println("Serving tiramisu");
    }
}

class Sushi {
    void serve() {
        System.out.println("Serving sushi");
    }
}

class Mochi {
    void serve() {
        System.out.println("Serving mochi");
    }
}

class RestaurantClient {
    void serveItalianMenu() {
        Pizza main = new Pizza();
        Tiramisu dessert = new Tiramisu();

        main.serve();
        dessert.serve();
    }

    void serveJapaneseMenu() {
        Sushi main = new Sushi();
        Mochi dessert = new Mochi();

        main.serve();
        dessert.serve();
    }
}
```

👉 The client directly depends on concrete classes
👉 Adding new families becomes harder

### ✅ Good Design with Abstract Factory Pattern

```java
interface MainDish {
    void serve();
}

interface Dessert {
    void serve();
}

class Pizza implements MainDish {
    public void serve() {
        System.out.println("Serving pizza");
    }
}

class Sushi implements MainDish {
    public void serve() {
        System.out.println("Serving sushi");
    }
}

class Tiramisu implements Dessert {
    public void serve() {
        System.out.println("Serving tiramisu");
    }
}

class Mochi implements Dessert {
    public void serve() {
        System.out.println("Serving mochi");
    }
}

interface MealFactory {
    MainDish createMainDish();
    Dessert createDessert();
}

class ItalianMealFactory implements MealFactory {
    public MainDish createMainDish() {
        return new Pizza();
    }

    public Dessert createDessert() {
        return new Tiramisu();
    }
}

class JapaneseMealFactory implements MealFactory {
    public MainDish createMainDish() {
        return new Sushi();
    }

    public Dessert createDessert() {
        return new Mochi();
    }
}

class RestaurantClient {
    private MealFactory factory;

    RestaurantClient(MealFactory factory) {
        this.factory = factory;
    }

    void serveMenu() {
        MainDish mainDish = factory.createMainDish();
        Dessert dessert = factory.createDessert();

        mainDish.serve();
        dessert.serve();
    }
}
```

Now the client works with families of related objects without knowing exact classes.

Matching products stay together!
New families can be added easily!

---

