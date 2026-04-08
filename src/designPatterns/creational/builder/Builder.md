# Builder Pattern

Construct a complex object step by step.
This means that a builder helps create objects with many optional parts, without using huge constructors.

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

A customer wants a burger.

Possible options:

* cheese
* tomato
* lettuce
* onion
* extra sauce
* double patty

So you make one constructor with many parameters.

👉 It becomes confusing
👉 Hard to read
👉 Easy to pass wrong values in wrong order

### ✅ Good Design with Builder Pattern

You prepare the burger step by step:

* add cheese
* add tomato
* add sauce
* build burger

You only choose what you need.
The code becomes readable and flexible.

## 🧑‍💻 In software:

### ❌ Bad Design

```java
class Burger {
    private String bread;
    private boolean cheese;
    private boolean tomato;
    private boolean lettuce;
    private boolean onion;
    private boolean extraSauce;

    Burger(String bread, boolean cheese, boolean tomato,
           boolean lettuce, boolean onion, boolean extraSauce) {
        this.bread = bread;
        this.cheese = cheese;
        this.tomato = tomato;
        this.lettuce = lettuce;
        this.onion = onion;
        this.extraSauce = extraSauce;
    }

    void show() {
        System.out.println("Burger: " + bread + ", cheese=" + cheese +
                ", tomato=" + tomato +
                ", lettuce=" + lettuce +
                ", onion=" + onion +
                ", extraSauce=" + extraSauce);
    }
}
```

Using it:

```java
Burger burger = new Burger("Sesame", true, true, false, true, true);
burger.show();
```

👉 Hard to understand what each `true` and `false` means

### ✅ Good Design with Builder Pattern

```java
class Burger {
    private String bread;
    private boolean cheese;
    private boolean tomato;
    private boolean lettuce;
    private boolean onion;
    private boolean extraSauce;

    private Burger(BurgerBuilder builder) {
        this.bread = builder.bread;
        this.cheese = builder.cheese;
        this.tomato = builder.tomato;
        this.lettuce = builder.lettuce;
        this.onion = builder.onion;
        this.extraSauce = builder.extraSauce;
    }

    void show() {
        System.out.println("Burger: " + bread + ", cheese=" + cheese +
                ", tomato=" + tomato +
                ", lettuce=" + lettuce +
                ", onion=" + onion +
                ", extraSauce=" + extraSauce);
    }

    static class BurgerBuilder {
        private String bread;
        private boolean cheese;
        private boolean tomato;
        private boolean lettuce;
        private boolean onion;
        private boolean extraSauce;

        BurgerBuilder(String bread) {
            this.bread = bread;
        }

        BurgerBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        BurgerBuilder addTomato() {
            this.tomato = true;
            return this;
        }

        BurgerBuilder addLettuce() {
            this.lettuce = true;
            return this;
        }

        BurgerBuilder addOnion() {
            this.onion = true;
            return this;
        }

        BurgerBuilder addExtraSauce() {
            this.extraSauce = true;
            return this;
        }

        Burger build() {
            return new Burger(this);
        }
    }
}
```

Using it:

```java
Burger burger = new Burger.BurgerBuilder("Sesame")
        .addCheese()
        .addTomato()
        .addExtraSauce()
        .build();

burger.show();
```

Now the object is built step by step.

Creation becomes clear!
Complex constructors are avoided!

---