The Factory Method is a creational design pattern that defines an interface **for creating objects** but lets subclasses decide which object to instantiate.
 - Subclasses override the factory method to produce specific object types.
- Supports easy addition of new product types without modifying existing code.
- Enhances maintainability and adaptability at runtime.

# Factory Pattern

Create objects without exposing the exact creation logic to the client.
This means that the client asks for an object, and the factory decides which concrete class to create.

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

A waiter directly creates every drink:

* `new Tea()`
* `new Coffee()`
* `new Juice()`

So every place in the system must know all drink classes.

👉 Code becomes repetitive
👉 Adding new drinks requires changing many places

### ✅ Good Design with Factory Pattern

You create a `DrinkFactory`.

The client says:

* “Give me tea”
* “Give me coffee”

The factory decides which object to return.

The client doesn’t worry about exact creation details.

## 🧑‍💻 In software:

### ❌ Bad Design

```java
class Tea {
    void serve() {
        System.out.println("Serving tea");
    }
}

class Coffee {
    void serve() {
        System.out.println("Serving coffee");
    }
}

class Juice {
    void serve() {
        System.out.println("Serving juice");
    }
}

class CafeClient {
    void order(String type) {
        if (type.equals("tea")) {
            Tea tea = new Tea();
            tea.serve();
        } else if (type.equals("coffee")) {
            Coffee coffee = new Coffee();
            coffee.serve();
        } else if (type.equals("juice")) {
            Juice juice = new Juice();
            juice.serve();
        }
    }
}
```

👉 Object creation is mixed with business logic

### ✅ Good Design with Factory Pattern

```java
interface Drink {
    void serve();
}

class Tea implements Drink {
    public void serve() {
        System.out.println("Serving tea");
    }
}

class Coffee implements Drink {
    public void serve() {
        System.out.println("Serving coffee");
    }
}

class Juice implements Drink {
    public void serve() {
        System.out.println("Serving juice");
    }
}

class DrinkFactory {
    static Drink createDrink(String type) {
        if (type.equalsIgnoreCase("tea")) {
            return new Tea();
        } else if (type.equalsIgnoreCase("coffee")) {
            return new Coffee();
        } else if (type.equalsIgnoreCase("juice")) {
            return new Juice();
        }
        throw new IllegalArgumentException("Unknown drink type");
    }
}

class CafeClient {
    void order(String type) {
        Drink drink = DrinkFactory.createDrink(type);
        drink.serve();
    }
}
```

Now the client does not create objects directly.

Creation logic is centralized!
The client just requests a product!

---