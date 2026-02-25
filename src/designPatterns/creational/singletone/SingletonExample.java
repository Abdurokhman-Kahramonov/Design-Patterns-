package designPatterns.creational.singletone;

public class SingletonExample {
    public static void main(String[] args) {
        DatabaseConnection s1 = DatabaseConnection.getInstance();
        DatabaseConnection s2 = DatabaseConnection.getInstance();
        System.out.println(s1 == s2); // true

    }
}
class DatabaseConnection{
    private static DatabaseConnection instance;

    private DatabaseConnection(){
        // private constructor to prevent instantiation
    }
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}