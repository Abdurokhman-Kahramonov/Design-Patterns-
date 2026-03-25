# Composite Pattern

### Treat individual objects and groups of objects in the same way.

This means that you can work with a **single object** and a **collection of objects** using the same interface.

---

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

You treat items differently:

* A single dish → handled one way
* A combo meal → handled another way

👉 Different logic for each case
👉 Code becomes complex and messy

---

### ✅ Good Design with Composite Pattern

You treat everything as a **menu item**:

* 🍕 Single dish → MenuItem
* 🍱 Combo meal (multiple dishes) → MenuItem

Now both can be handled the same way

##### No special cases needed!

##### Uniform behavior everywhere!

---

## 🧑‍💻 In software:

### ❌ Bad Design

```java id="n3x8k1"
class Dish {
    void showPrice() {
        System.out.println("Dish price");
    }
}

class ComboMeal {
    List<Dish> dishes;

    void showComboPrice() {
        // different logic
    }
}
```

You need separate logic for `Dish` and `ComboMeal`.

---

### ✅ Good Design with Composite Pattern

```java id="p7v2m4"
interface MenuItem {
    void showPrice();
}
```

```java id="k1z9q3"
class Dish implements MenuItem {
    public void showPrice() {
        System.out.println("Dish price");
    }
}
```

```java id="r4t6y8"
import java.util.List;

class ComboMeal implements MenuItem {
    private List<MenuItem> items;

    ComboMeal(List<MenuItem> items) {
        this.items = items;
    }

    public void showPrice() {
        for (MenuItem item : items) {
            item.showPrice();
        }
    }
}
```

Now you can treat both single dishes and combo meals the same way:

```java id="w8m3c2"
MenuItem dish = new Dish();
MenuItem combo = new ComboMeal(List.of(dish, new Dish()));

dish.showPrice();
combo.showPrice();
```

##### Same interface for single and grouped objects!

##### Simpler and more flexible design!
