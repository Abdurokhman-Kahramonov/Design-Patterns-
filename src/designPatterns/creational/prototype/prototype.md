# Prototype Pattern

Create new objects by copying an existing object, instead of building them from scratch.
This means that a prototype lets you clone ready-made objects quickly.

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

A customer wants the same custom cake again tomorrow.

You must recreate everything manually:

* same size
* same cream
* same decorations
* same message

👉 This is repetitive
👉 Easy to make mistakes

### ✅ Good Design with Prototype Pattern

You keep the original cake as a prototype.

When needed:

* clone the cake
* change only small details if necessary

You don’t rebuild from zero every time.

## 🧑‍💻 In software:

### ❌ Bad Design

```java
class Cake {
    String flavor;
    String size;
    String message;

    Cake(String flavor, String size, String message) {
        this.flavor = flavor;
        this.size = size;
        this.message = message;
    }

    void show() {
        System.out.println("Cake: " + flavor + ", " + size + ", " + message);
    }
}
```

Using it:

```java
Cake cake1 = new Cake("Chocolate", "Large", "Happy Birthday");
Cake cake2 = new Cake("Chocolate", "Large", "Happy Birthday");
cake1.show();
cake2.show();
```

👉 Same object data is repeated again and again

### ✅ Good Design with Prototype Pattern

```java
class Cake implements Cloneable {
    String flavor;
    String size;
    String message;

    Cake(String flavor, String size, String message) {
        this.flavor = flavor;
        this.size = size;
        this.message = message;
    }

    public Cake clone() {
        try {
            return (Cake) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    void setMessage(String message) {
        this.message = message;
    }

    void show() {
        System.out.println("Cake: " + flavor + ", " + size + ", " + message);
    }
}
```

Using it:

```java
Cake originalCake = new Cake("Chocolate", "Large", "Happy Birthday");

Cake copiedCake = originalCake.clone();
copiedCake.setMessage("Congratulations");

originalCake.show();
copiedCake.show();
```

Now you create new objects by cloning an existing one.

Useful when object creation is expensive or repetitive!
You copy and then adjust!

---