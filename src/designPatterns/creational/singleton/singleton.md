1. Singleton
   What it is

Ensures that a class has only one instance and provides a global way to access it.

When to use it

Use it for shared resources like:

configuration
logger
cache
connection manager
Bad design

Different parts of the app create their own logger/config object.

# Singleton Pattern

Ensure that a class has only one instance and provide a global access point to it.
This means that singleton is used when exactly one shared object should exist in the whole system.

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

A restaurant should have only one cashier system.

But every employee creates a new cashier system:

* one at the counter
* one in the kitchen
* one in the manager room

👉 Data becomes inconsistent
👉 Bills and payments may not match

### ✅ Good Design with Singleton Pattern

You allow only one cashier system in the restaurant.

Everyone uses the same shared instance.

There is only one central source of truth.

## 🧑‍💻 In software:

### ❌ Bad Design

```java
class CashierSystem {
    void showMessage() {
        System.out.println("Cashier system is running");
    }
}

class Client {
    void useSystem() {
        CashierSystem c1 = new CashierSystem();
        CashierSystem c2 = new CashierSystem();

        System.out.println(c1 == c2); // false
    }
}
```

👉 Multiple objects are created, even though only one should exist

### ✅ Good Design with Singleton Pattern

```java
class CashierSystem {
    private static CashierSystem instance;

    private CashierSystem() {
    }

    public static CashierSystem getInstance() {
        if (instance == null) {
            instance = new CashierSystem();
        }
        return instance;
    }

    void showMessage() {
        System.out.println("Cashier system is running");
    }
}
```

Using it:

```java
class Client {
    void useSystem() {
        CashierSystem c1 = CashierSystem.getInstance();
        CashierSystem c2 = CashierSystem.getInstance();

        System.out.println(c1 == c2); // true
        c1.showMessage();
    }
}
```

Now only one object exists in the whole application.

The constructor is hidden!
The same instance is reused everywhere!

---
Here is a very short difference summary:

* **Factory** → creates one object
* **Abstract Factory** → creates families of related objects
* **Builder** → builds a complex object step by step
* **Prototype** → creates objects by cloning
* **Singleton** → ensures only one instance exists