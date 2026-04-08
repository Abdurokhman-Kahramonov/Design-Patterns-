package designPatterns.creational.singleton;

public class SingletonExample1 {
    public static void main(String[] args) {
        Cache s1 = Cache.getInstance();
        Cache s2 = Cache.getInstance();
        Cache thirdCacheAccess = Cache.getInstance();
        System.out.println(s1 == s2); // true
        System.out.println(thirdCacheAccess == s1); // true

    }
}


class Cache {
    private static Cache instance;

    private Cache() {
        // private constructor to prevent instantiation
    }

    public static Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }
}
