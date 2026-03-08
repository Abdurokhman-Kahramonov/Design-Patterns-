package designPatterns.structural.proxy;
class Image {
    private String filename;

    public Image(String filename) {
        this.filename = filename;
        _loadFromDisk();
    }

    private void _loadFromDisk() {
        System.out.println("Loading " + filename + " from disk");
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage {
    private String filename;
    private Image image;

    public ProxyImage(String filename) {
        this.filename = filename;
        this.image = null;
    }

    public void display() {
        if (image == null) {
            image = new Image(filename);
        }
        image.display();
    }
}

// Client code
public class ProxyExample {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("example.jpg");

        // Image will be loaded from disk only when display() is called
        image.display();

        // Image will not be loaded again, as it has been cached in the Proxy
        image.display();
    }
}