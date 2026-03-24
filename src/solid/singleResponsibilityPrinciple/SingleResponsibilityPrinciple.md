# Single Responsibility Principle

### A class should have only one responsibility.

This means that a class should have only **one reason to change**.
If a class has multiple responsibilities, it becomes harder to maintain, understand, and modify without introducing bugs.

---

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

One employee does everything:

* Cooks food
* Serves customers
* Handles payments

👉 This creates confusion, overload, and mistakes

---

### ✅ Good Design with Single Responsibility Principle

Each employee has a specific role:

* 👨‍🍳 Chef → cooks food
* 🧑‍💼 Waiter → serves customers
* 💵 Cashier → handles payments

##### Each person does one job well!

##### No overlapping responsibilities!

---

## 🧑‍💻 In software:

### ❌ Bad Design

```java
class RestaurantService {
    void cookFood() {
        System.out.println("Cooking...");
    }

    void serveCustomer() {
        System.out.println("Serving...");
    }

    void processPayment() {
        System.out.println("Processing payment...");
    }
}
```

A single class is responsible for multiple tasks, making it harder to maintain and change.

---

### ✅ Good Design with Single Responsibility Principle

```java
class Chef {
    void cookFood() {
        System.out.println("Cooking...");
    }
}

class Waiter {
    void serveCustomer() {
        System.out.println("Serving...");
    }
}

class Cashier {
    void processPayment() {
        System.out.println("Processing payment...");
    }
}
```

Now each class has only one responsibility, making the system easier to understand, maintain, and extend.
