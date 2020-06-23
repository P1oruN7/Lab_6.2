package Routes;

import Generators.DateGenerator;
import Generators.IDGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Класс-коллекция
 */
public class Collection implements Serializable {

    @XmlElement
    public static ArrayList<Route> Routes;

    @XmlTransient
    private final LocalDate initializationDate;
    @XmlTransient
    private String path;


    /**
     * Конструктор коллекии
     */
    public Collection() {
        this.Routes = new ArrayList<>();
        this.initializationDate = DateGenerator.generateCurrentDate();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @XmlTransient
    /**
     * Метод для получения даты
     * @return LocalDate
     */
    public LocalDate getInitializationDate() {
        return initializationDate;
    }


    /**
     * Метод поиска элемента по id
     *
     * @param id id
     * @return элемент коллекции
     */
    public Route searchById(long id) {
        for (Route r : Routes) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

    /**
     * Метод для создания уникального id
     *
     * @return уникальный id (long)
     */
    public long generateUniqueID() {
        long id;
        do {
            id = IDGenerator.generateNewID();
        } while (this.searchById(id) != null);
        return id;
    }

}