package Common.Commands;

import Common.*;
import Readers.*;
import Routes.Route;
import Utility.ServerMain;
import Utility.ServerSender;

/**
 * Команда "УДОЛИ!"
 */
public class Remove_by_id implements Command {
    /**
     * метод удаления элемента коллекции по его id
     */
    @Override
    public void execute(String s) {
        if (s == null | s.equals("")) {
            System.out.println("кажется вы забыли ввести айди");
            return;
        }
        long removeId = Checker.longChecker(s);
        Route r = ServerMain.c.searchById(removeId);
        if (r == null) {
            System.out.println("похоже элемента с таким айди не существует");
            ServerSender.send("Элемент успешно удалён из коллекции. Вот.", 0);
            return;
        }
        ServerMain.c.Routes.remove(ServerMain.c.Routes.indexOf(r));
    }

    @Override
    public String getInfo() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }

}
