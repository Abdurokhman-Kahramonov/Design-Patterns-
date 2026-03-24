# Open Closed Principle

### Code should be open for extension but closed for modification.

This simply means that you should be able to add new behavior without changing the existing code.

---

## 🍽️ Imagine a restaurant menu:

### ❌ Bad Design

Every time you add a new dish:

* You rewrite the whole menu
* Reprint everything
* Risk breaking old items

---

### ✅ Good Design with Open Closed Principle

Menu is structured like:

* Base menu stays the same
* You can add new dishes as extensions

##### You don’t touch old items!
##### You just add new ones!

---
## 🧑‍🍳 In software:
### ❌ Bad Design
```java
class Menu {
    void showMenu() {
        System.out.println("1. Pasta");
        System.out.println("2. Pizza");
    }
}
``` 
Every time you want to add a new dish, you have to modify the `showMenu` method, which can lead to bugs and maintenance issues.
### ✅ Good Design with Open Closed Principle
```java
abstract class MenuItem {
    abstract void show();
}   

class Pasta extends MenuItem {
    void show() {
        System.out.println("1. Pasta");
    }
}

class Pizza extends MenuItem {
    void show() {
        System.out.println("2. Pizza");
    }
}
```
Now, to add a new dish, you simply create a new class that extends `MenuItem` without modifying existing code. This way, the existing menu remains unchanged and you can easily add new items without risking bugs in the old code.