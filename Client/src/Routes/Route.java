package Routes;

import java.io.Serializable;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Класс, хранимый в Collection
 */
@XmlRootElement
public class Route implements Comparable<Route>, Serializable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private Float distance; //Поле может быть null, Значение поля должно быть больше 1

    public Route() { };

    @Override
    public String toString() {
        return "Route(" +
                "id = " + id +
                ", name = " + name +
                ", coordinates = " + coordinates +
                ", creationDate = " + creationDate +
                ", from = " + from +
                ", to = " + to +
                ", distance = " + distance +
                ')';
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @XmlJavaTypeAdapter(value = XmlManagers.XmlDateAdapter.class)
    @XmlElement
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @XmlElement
    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    @XmlElement
    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    @XmlElement
    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Route r) {
        if (this.getId() == r.getId()) {
            return 0;
        } else if (this.getId() > r.getId()) {
            return 1;
        } else return -1;

    }
}