# Interface Segregation Principle

### 1. Do not force classes to implement methods they do not use.

### 2. Better many small interfaces than one fat interface.

This means that instead of having one large interface with many methods, you should split it into smaller, more specific ones.
Classes should only implement what they actually need.

---

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

You have one role called **Employee**, and everyone must:

* Cook food
* Serve customers
* Handle payments

👉 Even if someone is only a cashier, they are forced to cook and serve

---

### ✅ Good Design with Interface Segregation Principle

Roles are separated into smaller responsibilities:

* 👨‍🍳 Chef → cooks food
* 🧑‍💼 Waiter → serves customers
* 💵 Cashier → handles payments

##### Everyone only does what they need!

##### No unnecessary responsibilities!

---

## 🧑‍💻 In software:

### ❌ Bad Design

```java
interface Worker {
    void cook();
    void serve();
    void takePayment();
}
```

```java
class Waiter implements Worker {
    public void cook() {
        // not needed
    }

    public void serve() {
        System.out.println("Serving...");
    }

    public void takePayment() {
        System.out.println("Taking payment...");
    }
}
```

Here, `Waiter` is forced to implement `cook()` even though it doesn't use it.

---

### ✅ Good Design with Interface Segregation Principle

```java
interface Cook {
    void cook();
}

interface Serve {
    void serve();
}

interface Payment {
    void takePayment();
}
```

```java
class Waiter implements Serve, Payment {
    public void serve() {
        System.out.println("Serving...");
    }

    public void takePayment() {
        System.out.println("Taking payment...");
    }
}
```

Now classes implement only what they actually need, making the system cleaner and more flexible.
