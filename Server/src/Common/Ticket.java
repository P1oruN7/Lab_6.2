package Common;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Ticket.
 */
public class Ticket implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //time.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) форматирование даты
    private Float price; //Поле может быть null, Значение поля должно быть больше 0
    private String comment; //Поле не может быть null
    private TicketType type; //Поле не может быть null
    private Person person; //Поле не может быть null
    private Long MapKey;
    private String formatter= ("dd.MM.yyyy HH:mm:ss");

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Gets map key.
     *
     * @return the map key
     */
    public Long getMapKey() {
        return MapKey;
    }

    /**
     * Sets map key.
     *
     * @param mapKey the map key
     */
    public void setMapKey(Long mapKey) {
        MapKey = mapKey;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets person.
     *
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets person.
     *
     * @param person the person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets creation date.
     */
    public void setCreationDate() {
        ZonedDateTime time = ZonedDateTime.now();
        this.creationDate = time;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TicketType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(TicketType type) {
        this.type = type;
    }


    /**
     * The type Coordinates.
     */
    public class Coordinates implements Serializable {
    private Long x; //Максимальное значение поля: 297, Поле не может быть null
    private Integer y; //Поле не может быть null

        /**
         * Gets x.
         *
         * @return the x
         */
        public Long getX() {
            return x;
        }

        /**
         * Sets x.
         *
         * @param x the x
         */
        public void setX(Long x) {
            this.x = x;
        }

        /**
         * Gets y.
         *
         * @return the y
         */
        public Integer getY() {
            return y;
        }

        /**
         * Sets y.
         *
         * @param y the y
         */
        public void setY(Integer y) {
            this.y = y;
        }
    }

    /**
     * The type Person.
     */
    public class Person implements Serializable,Comparable<Person> {
    private String passportID; //Длина строки не должна быть больше 24, Значение этого поля должно быть уникальным, Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле не может быть null

        /**
         * Gets passport id.
         *
         * @return the passport id
         */
        public String getPassportID() {
        return passportID;
    }

        /**
         * Sets passport id.
         */
        public void setPassportID() {
        this.passportID = String.valueOf(this.hashCode());
    }

        /**
         * Gets hair color.
         *
         * @return the hair color
         */
        public Color getHairColor() {
        return hairColor;
    }

        /**
         * Sets hair color.
         *
         * @param hairColor the hair color
         */
        public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

        /**
         * Gets nationality.
         *
         * @return the nationality
         */
        public Country getNationality() {
        return nationality;
    }

        /**
         * Sets nationality.
         *
         * @param nationality the nationality
         */
        public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

        /**
         * Gets location.
         *
         * @return the location
         */
        public Location getLocation() {
        return location;
    }

        /**
         * Sets location.
         *
         * @param location the location
         */
        public void setLocation(Location location) {
        this.location = location;
    }

        @Override
        public int compareTo(Person o) {
            int result = this.hairColor.compareTo(o.hairColor);
            if (result==0) {
                result = ((Integer) this.location.x).compareTo(((Integer) o.location.getX()));
            }
            if (result==0){
               result=((Double)this.location.y).compareTo(((Double)o.location.getY()));

            }
            if (result==0){
                result = (this.nationality.compareTo(o.nationality));
            }
            return result;
        }
    }

    /**
     * The type Location.
     */
    public class Location implements Serializable{
    private int x;
    private Double y; //Поле не может быть null
    private String name; //Поле не может быть null

        /**
         * Gets x.
         *
         * @return the x
         */
        public int getX() {
        return x;
    }

        /**
         * Sets x.
         *
         * @param x the x
         */
        public void setX(int x) {
        this.x = x;
    }

        /**
         * Gets y.
         *
         * @return the y
         */
        public Double getY() {
        return y;
    }

        /**
         * Sets y.
         *
         * @param y the y
         */
        public void setY(Double y) {
        this.y = y;
    }

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
        return name;
    }

        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName(String name) {
        this.name = name;
    }
}

    /**
     * The enum Ticket type.
     */
    public enum TicketType implements Serializable{
        /**
         * Vip ticket type.
         */
        VIP,
        /**
         * Usual ticket type.
         */
        USUAL,
        /**
         * Budgetary ticket type.
         */
        BUDGETARY,
        /**
         * Cheap ticket type.
         */
        CHEAP;
}

    /**
     * The enum Color.
     */
    public enum Color implements Serializable {
        /**
         * Green color.
         */
        GREEN,
        /**
         * Black color.
         */
        BLACK,
        /**
         * Darkbrown color.
         */
        DARKBROWN,
        /**
         * Blue color.
         */
        BLUE;
}

    /**
     * The enum Country.
     */
    public enum Country  implements Serializable{
        /**
         * Russia country.
         */
        RUSSIA,
        /**
         * United kingdom country.
         */
        UNITED_KINGDOM,
        /**
         * France country.
         */
        FRANCE,
        /**
         * North korea country.
         */
        NORTH_KOREA,
        /**
         * Japan country.
         */
        JAPAN;
}

    /**
     * Get ticket string.
     *
     * @return the string
     */
    public String getTicket(){
    return ("Полная информация о билете №"+this.getMapKey()+"\nНазвание:"+this.getName()+"\nКоординаты Х и У:"+this.coordinates.getX()+" И "+this.coordinates.getY()+"\nВремя создания билета:"+this.getCreationDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))+"\nЦена:"+this.getPrice()+"\nКомментарий:"+this.getComment()+"\nТип билета:"+this.getType()+"\nИнформация о человеке:\n   Паспорт номер:"+this.person.getPassportID()+"\n   Цвет волос:"+this.person.getHairColor()+"\n   Национальность:"+this.person.getNationality()+"\n   Родной город:"+this.person.location.getName()+"\n   Координаты города Х и У:"+this.person.location.getX()+" и "+this.person.location.getY());
}

    /**
     * Get csv ticket string.
     *
     * @return the string
     */
    public String getCsvTicket(){
        return(this.getName()+","+this.getCoordinates().getX()+","+this.getCoordinates().getY()+","+this.getPrice()+","+this.getComment()+","+this.getType()+","+this.getPerson().getHairColor()+","+this.getPerson().getNationality()+","+this.getPerson().getLocation().getX()+","+this.getPerson().getLocation().getY()+","+this.getPerson().getLocation().getName());
}
}