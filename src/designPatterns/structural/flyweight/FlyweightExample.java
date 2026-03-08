package designPatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FlyweightExample {
    public static void main(String[] args) {
        String word = "Beetle";
        for (int i = 0; i < word.length(); i++) {
            CharacterFlyweight flyweight = CharacterFlyweightFactory.getCharacter("Arial", 12, "Black");
            flyweight.displayCharacter();
        }
    }
}


// Bekzod ( font-family, font-size, color)
// B -> ( font-family, font-size, color)
// e -> ( font-family, font-size, color)

interface CharacterFlyweight{
    void displayCharacter();
}

class ConcreteCharacterFlyweight implements CharacterFlyweight{

    private String font_family;
    private int font_size;
    private String color;

    public ConcreteCharacterFlyweight(String font_family, int font_size, String color) {
        this.font_family = font_family;
        this.font_size = font_size;
        this.color = color;
    }

    @Override
    public void displayCharacter() {
        System.out.println("Displaying character with font family: " + font_family + ", font size: " + font_size + ", color: " + color);
    }
}
class CharacterFlyweightFactory{
    private static HashMap<Integer, CharacterFlyweight> cache = new HashMap<>();

    public static CharacterFlyweight getCharacter(String font_family, int font_size, String color) {
        int key = Objects.hashCode(font_family + font_size + color);
        if (!(cache.containsKey(key)))
            cache.put(key, new ConcreteCharacterFlyweight(font_family, font_size, color));

        return cache.get(key);
    }
}
