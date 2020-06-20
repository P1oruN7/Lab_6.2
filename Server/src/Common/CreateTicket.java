package Common;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The type Create ticket.
 */
public class CreateTicket implements Serializable {
    /**
     * Create new ticket.
     *
     * @param key the key
     * @return the ticket
     */
    public Ticket create(Long key) {
            Ticket ticket = new Ticket();
            ticket.setMapKey(key);
            ticket.setCreationDate();
            Ticket.Coordinates coords = ticket.new Coordinates();
            Ticket.Person person = ticket.new Person();
            Ticket.Location location = ticket.new Location();
            this.setNameForTicket(ticket);
            this.setCoordinateXForCoordinates(coords);
            this.setCoordinateYForCoordinates(coords);
            this.setComment(ticket);
            this.setTicketType(ticket);
            this.setPrice(ticket);
            person.setPassportID();
            this.setHairColor(person);
            this.setNationality(person);
            this.setCoordinateXForLocation(location);
            this.setCoordinateYForLocation(location);
            this.setLocationName(location);
            person.setLocation(location);
            ticket.setPerson(person);
            ticket.setCoordinates(coords);
            return ticket;
    }


    /**
     * Sets name for ticket.
     *
     * @param ticket the ticket
     */
    public void setNameForTicket(Ticket ticket) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя билета.");
            System.out.print("$ ");
            String name = scanner.nextLine();
            if (name.equals("") || name.equals("null")) {
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setNameForTicket(ticket);
            } else ticket.setName(name);
        } catch (InputMismatchException e) {
            System.out.println("Значение должно быть типа:\"String\". Введите значение заново");
            System.out.print("$ ");
            this.setNameForTicket(ticket);
        }
    }

    /**
     * Sets coordinate x for coordinates for ticket.
     *
     * @param coords the coords
     */
    public void setCoordinateXForCoordinates(Ticket.Coordinates coords) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату x");
            System.out.print("$ ");
            String x = scanner.nextLine();
            long xn = Long.parseLong(x);
            if (x.equals("") || x.equals(null) || xn > 297) {
                System.out.println("Значение не может быть нулевым или больше 297, попробуйте ещё раз.");
                this.setCoordinateXForCoordinates(coords);
            } else coords.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");

            this.setCoordinateXForCoordinates(coords);
        }
    }

    /**
     * Sets coordinate y for coordinates for ticket.
     *
     * @param coords the coords
     */
    public void setCoordinateYForCoordinates(Ticket.Coordinates coords) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату y");
            System.out.print("$ ");
            String y = scanner.nextLine();
            if (y.equals("") || y.equals(null)) {
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setCoordinateYForCoordinates(coords);
            } else {
                Integer yn = Integer.parseInt(y);
                coords.setY(yn);
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"integer\". Введите значение заново.");
            this.setCoordinateYForCoordinates(coords);
        }
    }

    /**
     * Sets price for ticket.
     *
     * @param ticket the ticket
     */
    public void setPrice(Ticket ticket) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите цену билета");
            System.out.print("$ ");
            String price = scanner.nextLine();
            float pricen = Float.parseFloat(price);
            if (price.equals("") || price.equals(null) || pricen<0) {
                System.out.println("Значение не может быть меньше нуля, попробуйте ещё раз.");
                this.setPrice(ticket);
            } else ticket.setPrice(pricen);
        } catch (InputMismatchException|NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"float\". Введите значение заново.");
            this.setPrice(ticket);
        }
    }

    /**
     * Sets comment for ticket.
     *
     * @param ticket the ticket
     */
    public void setComment(Ticket ticket) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите комментарий к билету");
            System.out.print("$ ");
            String comment = scanner.nextLine();
            if (comment.equals("") || comment.equals(null)) {
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setComment(ticket);
            } else ticket.setComment(comment);
        } catch (InputMismatchException e) {
            System.out.println("Значение должно быть типа:\"String\". Введите значение заново.");
            this.setComment(ticket);
        }
    }

    /**
     * Set ticket type for ticket.
     *
     * @param ticket the ticket
     */
    public void setTicketType(Ticket ticket){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите тип билета(VIP,USUAL,BUDGETARY,CHEAP)");
            System.out.print("$ ");
            String ticketType = scanner.nextLine();
            if (ticketType.equals("")||ticketType.equals(null)){
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setTicketType(ticket);
            } else if (ticketType.equals("VIP")||ticketType.equals("USUAL")||ticketType.equals("BUDGETARY")||ticketType.equals("CHEAP"))
                ticket.setType(Ticket.TicketType.valueOf(ticketType));
                else this.setTicketType(ticket);
        }
        catch (InputMismatchException e){
            System.out.println("Значение не подходит, введите значение заново.");
            this.setTicketType(ticket);
        }
    }

    /**
     * Set hair color for the person for ticket.
     *
     * @param person the person
     */
    public void setHairColor(Ticket.Person person){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите цвет волос человека(GREEN,BLACK,DARKBROWN,BLUE)");
            System.out.print("$ ");
            String hairColor = scanner.nextLine();
            if (hairColor.equals("")||hairColor.equals(null)){
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setHairColor(person);
            } else if (hairColor.equals("GREEN")||hairColor.equals("BLACK")||hairColor.equals("DARKBROWN")||hairColor.equals("BLUE"))
                person.setHairColor(Ticket.Color.valueOf(hairColor));
            else this.setHairColor(person);
        }
        catch (InputMismatchException e){
            System.out.println("Значение не подходит, введите значение заново.");
            this.setHairColor(person);
        }
    }

    /**
     * Set nationality for the person for ticket.
     *
     * @param person the person
     */
    public void setNationality(Ticket.Person person){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите национальность человека(RUSSIA,UNITED_KINGDOM,FRANCE,NORTH_KOREA,JAPAN)");
            System.out.print("$ ");
            String country = scanner.nextLine();
            if (country.equals("")||country.equals(null)){
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setNationality(person);
            } else if (country.equals("RUSSIA")||country.equals("UNITED_KINGDOM")||country.equals("FRANCE")||country.equals("NORTH_KOREA")||country.equals("JAPAN"))
                person.setNationality(Ticket.Country.valueOf(country));
            else this.setNationality(person);
        }
        catch (InputMismatchException e){
            System.out.println("Значение не подходит, введите значение заново.");
            this.setNationality(person);
        }
    }

    /**
     * Sets coordinate x for location for the person for ticket.
     *
     * @param location the location
     */
    public void setCoordinateXForLocation(Ticket.Location location) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату x");
            System.out.print("$ ");
            String x = scanner.nextLine();
            int xn = Integer.parseInt(x);
            if (x.equals("") || x.equals(null)) {
                System.out.println("Значение не может отсутствовать, попробуйте ещё раз.");
                this.setCoordinateXForLocation(location);
            } else location.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"integer\". Введите значение заново");

            this.setCoordinateXForLocation(location);
        }
    }

    /**
     * Sets coordinate y for location for the person for ticket.
     *
     * @param location the location
     */
    public void setCoordinateYForLocation(Ticket.Location location) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату y");
            System.out.print("$ ");
            String y = scanner.nextLine();
            if (y.equals("") || y.equals(null)) {
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setCoordinateYForLocation(location);
            } else {
                double yn = Double.parseDouble(y);
                location.setY(yn);
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"double\". Введите значение заново.");
            this.setCoordinateYForLocation(location);
        }
    }

    /**
     * Set location name for the person for ticketw.
     *
     * @param location the location
     */
    public void setLocationName(Ticket.Location location){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя локации");
            System.out.print("$ ");
            String name = scanner.nextLine();
            if (name.equals("")||name.equals(null)){
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setLocationName(location);
            } else location.setName(name);
            }
        catch (InputMismatchException | NumberFormatException e){
            System.out.println("Значение должно быть типа:\"string\". Введите значение заново.");
            this.setLocationName(location);
        }

    }

}