package Common;

import Common.Ticket;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

/**
 * The type Common.Ticket collection.
 */
public class TicketCollection implements Serializable {
    private static TreeMap<Long, Ticket> tickets = new TreeMap<>();
    private static ZonedDateTime DateOFCreation;

    /**
     * Sets date of creation.
     *
     * @param dateOFCreation the date of creation
     */
    public static void setDateOFCreation(ZonedDateTime dateOFCreation) {
        DateOFCreation = dateOFCreation;
    }

    /**
     * Get tickets tree map.
     *
     * @return the tree map
     */
    public TreeMap<Long, Ticket> getTickets(){
        return tickets;
    }

    /**
     * Set tickets.
     *
     * @param collection the collection
     */
    public void setTickets(TreeMap<Long, Ticket> collection){
        tickets = collection;
    }

    /**
     * Put ticket.
     *
     * @param key    the key
     * @param ticket the ticket
     */
    public void putTicket(Long key,Ticket ticket){
        tickets.put(key, ticket);
    }

    /**
     * Replace movie.
     *
     * @param key    the key
     * @param ticket the ticket
     */
    public void replaceMovie(Long key, Ticket ticket) {
        tickets.replace(key, ticket);
    }

    /**
     * Remove ticket.
     *
     * @param key the key
     */
    public void removeTicket(Long key){
        tickets.remove(key);
    }

    /**
     * Get key set java . util . set.
     *
     * @return the java . util . set
     */
    public java.util.Set<Long> getKeySet(){
    return tickets.keySet();
    }

    /**
     * Get size integer.
     *
     * @return the integer
     */
    public Integer getSize(){return tickets.size();}


    /**
     * Gets info about collection.
     */
    public String getInfo() {
        String s ="";
        s+="Тип коллекции: TreeMap\n";
        s+="Количество элементов коллекции: " + tickets.size() +"\n";
        if (DateOFCreation==null||tickets.size()==0){
            s+="";
        }
            else s+=("Дата создания колекции: " + DateOFCreation.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
       return s;
    }

    /**
     * Get ticket.
     *
     * @param key the key
     * @return the ticket
     */
    public Ticket getTicket (Long key){
        return tickets.get(key);
    }
}
