import java.util.Objects;

public abstract class Act {
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String country;
    protected String name;

    public Act(String name, String country)
    {
        this.country = country;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Act act = (Act) o;
        return country.equals(act.country) && name.equals(act.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, name);
    }
}
