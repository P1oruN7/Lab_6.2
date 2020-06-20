package XmlManagers;

import Exceptions.FileNotFoundException;
import Routes.Collection;
//import Utility.ServerMain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.PrintWriter;
import java.io.File;

/**
 * Класс - сохранщик
 */
public class Saver {

    /**
     * Метод для сохранения коллекции в файл
     * @param path путь до файла
     * @throws java.io.FileNotFoundException
     */
    public static void saveCollection( String path) throws java.io.FileNotFoundException {

//        try {
//            File newCollection = new File(path);
//            if (!newCollection.exists()) throw new FileNotFoundException();
//            if (!newCollection.canWrite()) {
//                System.out.println("Запись в файл невозможна. Сделайте что-нибудь, если хотите сохранить именно в этот файл.");
//                return;
//            }
//            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            PrintWriter printWriter = new PrintWriter(newCollection);
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(ServerMain.c, printWriter);
//        } catch (JAXBException e) {
//            System.out.println("Некорректный файл");
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл не найден");
//            return;
//        }
    }
}
