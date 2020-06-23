package XmlManagers;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Класс для адаптации даты к xml
 */

public class XmlDateAdapter extends XmlAdapter<String, LocalDate> {

    public LocalDate unmarshal(String v) {
        try {
            return LocalDate.parse(v);
        }
        catch (Exception e) {
            System.out.println("Ошибка преобразования даты (да, и такое бывает)");
            return null;
        }
    }

    public String marshal(LocalDate v) {
        return v.toString();
    }
}

