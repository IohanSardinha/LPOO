public class Speaker extends Person {
    private int fee = 0;

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Speaker(String name, int age) {
        super(name, age);
    }

    public Speaker(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Speaker " + name + " has a fee value of " + fee + ".";
    }

}
