import java.util.Objects;

public abstract class Person extends User{

    public Person(String name, int age) {
        super(name, age);
    }

    public Person(String name) {
        super(name);
    }
}
