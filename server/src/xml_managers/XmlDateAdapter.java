package xml_managers;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Класс для адаптации даты к xml
 */

public class XmlDateAdapter extends XmlAdapter<String, LocalDate> {

    public LocalDate unmarshal(String v) {
        return LocalDate.parse(v);
    }

    public String marshal(LocalDate v) {
        return v.toString();
    }
}

