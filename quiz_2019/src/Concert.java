import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Act> getActs() {
        return acts;
    }

    private String city;
    private String country;
    private String date;
    private List<Act> acts;
    public Concert(String city, String country,String date)
    {
        this.city = city;
        this.country = country;
        this.date = date;
        acts = new ArrayList<>();
    }

    public void addAct(Act act)
    {
        acts.add(act);
    }

    public boolean isValid(Ticket ticket)
    {
        return ticket.getConcert().equals(this);
    }

    public boolean participates(Artist artist)
    {
        for(Act act: acts)
        {
            if(act.getClass() == Artist.class)
            {
                Artist a = (Artist) act;
                if(a.equals(artist))
                    return true;
            }
            else if(act.getClass() == Band.class)
            {
                Band b = (Band) act;
                if(b.containsArtist(artist))
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object object)
    {
        if(this == object) return true;
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;
        Concert concert = (Concert)object;
        return concert.getCity().equals(city) && concert.getActs().equals(acts) && concert.getCountry().equals(country) && concert.getDate().equals(date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, acts);
    }
}
