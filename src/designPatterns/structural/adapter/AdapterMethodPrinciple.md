# Adapter Pattern (Adapter Method)

### Convert the interface of a class into another interface that clients expect.

This means that an adapter allows two incompatible interfaces to work together without modifying their existing code.

---

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

A **new coffee machine** arrives, but:

* It uses a different plug
* It doesn’t fit existing sockets

👉 You cannot use it with your current system

---

### ✅ Good Design with Adapter Pattern

You use an **adapter plug**:

* Converts the plug type
* Makes the machine compatible

##### You don’t change the machine!

##### You don’t change the socket!

##### You just add an adapter!

---

## 🧑‍💻 In software:

### ❌ Bad Design

```java id="9q2l7c"
class OldPrinter {
    void printText(String text) {
        System.out.println(text);
    }
}
```

```java id="w3m8k1"
class Client {
    void print(OldPrinter printer) {
        printer.printText("Hello");
    }
}
```

Now imagine a new printer with a different interface:

```java id="5x7p2v"
class NewPrinter {
    void printDocument(String doc) {
        System.out.println(doc);
    }
}
```

👉 `Client` cannot use `NewPrinter` without modification

---

### ✅ Good Design with Adapter Pattern

```java id="r8n4y2"
interface Printer {
    void print(String text);
}
```

```java id="u1k6z9"
class OldPrinterAdapter implements Printer {
    private OldPrinter oldPrinter;

    OldPrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    public void print(String text) {
        oldPrinter.printText(text);
    }
}
```

```java id="p0v3c7"
class NewPrinterAdapter implements Printer {
    private NewPrinter newPrinter;

    NewPrinterAdapter(NewPrinter newPrinter) {
        this.newPrinter = newPrinter;
    }

    public void print(String text) {
        newPrinter.printDocument(text);
    }
}
```

```java id="d5h8s2"
class Client {
    void print(Printer printer) {
        printer.print("Hello");
    }
}
```

Now both old and new printers can be used without changing the client code.

##### Existing code stays untouched!

##### New functionality is added through adapters!
