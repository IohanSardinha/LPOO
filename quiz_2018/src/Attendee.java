public class Attendee extends Person{

    public boolean hasPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    private boolean paid = false;

    public Attendee(String name, int age) {
        super(name, age);
    }

    public Attendee(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Attendee " + name + (paid ? " has" : " hasn't") + " paid its registration.";
    }
}
