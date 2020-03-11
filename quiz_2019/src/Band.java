import java.util.ArrayList;
import java.util.List;

public class Band extends Act {
    public List<Artist> getArtists() {
        return artists;
    }

    List<Artist> artists;
    public Band(String name,String country)
    {
        super(name,country);
        artists = new ArrayList<>();
    }

    public void addArtist(Artist artist)
    {
        artists.add(artist);
    }

    public boolean containsArtist(Artist artist)
    {
        return artists.contains(artist);
    }
}
