package xml_managers;

import exceptions.FileNotFoundException;
import routes.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс для чтения xml
 */
public class XmlReader {
    /**
     * Метод для получения коллекции из файла xml
     *
     * @param path путь
     * @return Коллекция  (Collection)
     */
    public static Collection getCollection(String path) {

        try {
            File input = new File(path);
            if (!input.canRead()) {
                System.out.println("Невозможно прочитать файл.");
                return null;
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            return (Collection) unmarshaller.unmarshal(bufferedReader);
        } catch (JAXBException e) {
            System.out.println("Некорректный файл");
            return null;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла");
            return null;
        }
    }
}