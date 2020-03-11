import java.util.Objects;

public class User implements Comparable{
    protected String name;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public String getUsername()
    {
        return name + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != Speaker.class && o.getClass() != Attendee.class)) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        if(p.hashCode() == this.hashCode())
            return 0;
        if(p.hashCode() < this.hashCode())
            return 1;
        return -1;
    }
}
