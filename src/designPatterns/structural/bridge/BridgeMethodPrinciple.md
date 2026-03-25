# Bridge Pattern

### Decouple abstraction from implementation so that both can vary independently.

This means that instead of tightly connecting two parts of a system, you separate them so each can change without affecting the other.

---

## 🍽️ Imagine a restaurant:

### ❌ Bad Design

You create separate roles for every combination:

* ItalianChefWaiter
* JapaneseChefWaiter
* ItalianChefCashier
* JapaneseChefCashier

👉 Too many combinations
👉 Hard to maintain and extend
👉 Number of combinations = roles × specializations

---

### ✅ Good Design with Bridge Pattern

You separate **roles** and **specializations**:

* 👨‍🍳 Chef (role)
* 🍝 Italian cuisine / 🍣 Japanese cuisine (implementation)

Now you can mix them freely:

* Chef + Italian cuisine
* Chef + Japanese cuisine
👉 Number of combinations = roles + specializations
##### No explosion of classes!

##### Each part evolves independently!

---

## 🧑‍💻 In software:

### ❌ Bad Design

```java id="x8k2m1"
class RemoteControlForTV {
    void turnOn() {
        System.out.println("TV ON");
    }
}

class RemoteControlForRadio {
    void turnOn() {
        System.out.println("Radio ON");
    }
}
```

Every new device requires a new remote class → duplication and tight coupling.

---

### ✅ Good Design with Bridge Pattern

```java id="b7n3q4"
interface Device {
    void turnOn();
}
```

```java id="m2z6p9"
class TV implements Device {
    public void turnOn() {
        System.out.println("TV ON");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio ON");
    }
}
```

```java id="c5r1x8"
class RemoteControl {
    protected Device device;

    RemoteControl(Device device) {
        this.device = device;
    }

    void turnOn() {
        device.turnOn();
    }
}
```

```java id="v9t4k2"
class AdvancedRemote extends RemoteControl {
    AdvancedRemote(Device device) {
        super(device);
    }

    void mute() {
        System.out.println("Muted");
    }
}
```

Now you can combine:

* RemoteControl + TV
* RemoteControl + Radio
* AdvancedRemote + any device

##### Abstraction (Remote) and implementation (Device) are separated!

##### Both can grow independently!
