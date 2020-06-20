package Common.Commands;
import Common.*;
import Utility.ServerMain;

import static XmlManagers.Saver.saveCollection;

/**
 * Команда "Сохрани мою речь"
 */
public class Save implements Command {
    /**
     * Метод для сохранения коллекции в файл
     */
    @Override
    public void execute (String S) {
        try{ saveCollection(ServerMain.c.getPath()); }
        catch (Exception e){
            System.out.println("Ошибочка вышла");
        }
    }

    @Override
    public String getInfo() {
        return "save : сохранить коллекцию в файл";
    }
}