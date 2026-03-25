# Dependency Inversion Principle

### 1. High-level modules should not depend on low-level modules. Both should depend on abstractions

### 2. Abstractions should not depend on details. Details should depend on abstractions

This means that instead of depending on concrete implementations, both high-level and low-level parts of the system should depend on **interfaces (abstractions)**.
This makes the system flexible and easier to change.

---

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

A **restaurant manager** directly depends on a specific worker:

* Only works with one specific chef
* If the chef changes → system breaks

👉 The manager is tightly coupled to one person

---

### ✅ Good Design with Dependency Inversion Principle

The manager depends on a **role (Chef interface)**, not a specific person:

* Any chef can be hired
* You can replace one chef with another easily

##### Manager doesn’t care *who* cooks

##### Only cares that the job gets done

---

## 🧑‍💻 In software:

### ❌ Bad Design

```java id="kz7d3s"
class Chef {
    void cook() {
        System.out.println("Cooking...");
    }
}

class Restaurant {
    private Chef chef = new Chef();

    void start() {
        chef.cook();
    }
}
```

`Restaurant` directly depends on a concrete `Chef`, making it hard to change or extend.

---

### ✅ Good Design with Dependency Inversion Principle

```java id="6z3k2q"
interface Chef {
    void cook();
}
```

```java id="9l1c8x"
class ItalianChef implements Chef {
    public void cook() {
        System.out.println("Cooking Italian food...");
    }
}

class JapaneseChef implements Chef {
    public void cook() {
        System.out.println("Cooking Japanese food...");
    }
}
```

```java id="2x0d7m"
class Restaurant {
    private Chef chef;

    Restaurant(Chef chef) {
        this.chef = chef;
    }

    void start() {
        chef.cook();
    }
}
```

Now `Restaurant` depends on an abstraction (`Chef`), and you can easily switch implementations without modifying existing code.
