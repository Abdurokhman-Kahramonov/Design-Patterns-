# Liskov Substitution Principle

### Child class should be able to replace the parent class without breaking its behavior.

This means that subclasses must behave in a way that does not break the expectations set by the parent class.
If you replace a parent object with its child, the program should still work correctly.

---

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

You hire a **chef**, but replace them with someone who:

* Doesn’t know how to cook
* Refuses to follow recipes
* Serves raw food

👉 Even though they are called a “chef”, they break expectations

---

### ✅ Good Design with Liskov Substitution Principle

You hire a **chef**, and replace them with another chef who:

* Knows how to cook
* Follows recipes
* Maintains food quality

##### You can swap them without problems!

##### The behavior stays consistent!

---

## 🧑‍💻 In software:

### ❌ Bad Design

```java
class Bird {
    void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
```

Here, `Penguin` breaks the expected behavior of `Bird`, causing errors when used as a replacement.

---

### ✅ Good Design with Liskov Substitution Principle

```
public interface Flyable {
    void fly();
}
```

```java
class Bird {
    // common things in all birds
}
 
```

```
class Penguin extends Bird{

}

class Crow extends Bird implements Flyable{

    @Override
    public void fly() {
        System.out.println("Crow is flying");
    }
}
```

Now each subclass respects the behavior of the parent, and no expectations are broken when substituting objects.
