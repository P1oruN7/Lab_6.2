package Common.Commands;

import Common.*;
import Routes.Route;
import Utility.ServerMain;
import Utility.ServerSender;

/**
 * Команда "ГЛЯДИ! "
 */
public class Show implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для отображения всех элементов коллекции
     */
    @Override
    public void execute(String S) {
        if (ServerMain.c.Routes.size() == 0) {
            ServerSender.send("\n\nКоллекция пуста, милорд\n\n", 0);
        } else {
            ServerMain.c.Routes.stream()
                    .forEachOrdered(x -> ServerSender.send(x.toString(), 0));
        }
    }

    @Override
    public String getInfo() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
