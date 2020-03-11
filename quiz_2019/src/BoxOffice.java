import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoxOffice {
    private static HashMap<Concert, Integer> last = new HashMap<>();
    public static List<Ticket> buy(Concert concert, int n_tickets) throws InvalidTicket
    {
        List<Ticket> tickets = new ArrayList<>();
        int i = last.getOrDefault(concert,1);
        int n = n_tickets+i;
        for(;i<n;i++)
        {
            tickets.add(new Ticket(i,concert));
        }
        last.put(concert,i);
        return tickets;
    }
}
