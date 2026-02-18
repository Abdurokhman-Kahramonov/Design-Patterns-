package solid.interfaceSegregationPrinciple.example1;

public interface Worker {
    void work();
    void eat();
}

interface Workable{
    void work();
}
interface Eatable{
    void eat();
}

class Human implements Workable, Eatable{

    @Override
    public void work() {

    }

    @Override
    public void eat() {

    }
}
class Robot implements Workable{
    @Override
    public void work() {

    }
}