package Common.Commands;

import Common.*;
import Routes.Route;
import Utility.ServerMain;
import Utility.ServerSender;

/**
 * Команда "МАКСИМАЛЬНЫЙ"
 */
public class Max_by_distance implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для вывода элемента коллекции Routes с максимальным значением поля distance
     */
    @Override
    public void execute(String s) {
        if (ServerMain.c.Routes.size() > 0) {
            Route maxRouteByDistance = ServerMain.c.Routes.stream()
                    .max((p1, p2) -> p1.getDistance().compareTo(p2.getDistance()))
                    .get();
            ServerSender.send("\n \n" + maxRouteByDistance + "\n \n", 0);
        } else
            ServerSender.send("\n Коллекция пуста как моё сердце \n \n", 0);
    }

    @Override
    public String getInfo() {
        return "max_by_distance: вывести любой объект из коллекции, значение поля distance которого является максимальным";
    }

}

