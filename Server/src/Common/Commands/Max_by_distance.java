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
            double[] d = {0, 0};
            Route maxRouteByDistance = ServerMain.c.Routes.stream()
                    .max((p1, p2) -> {
                        if (p1.getDistance() == null) d[0] = 0; else d[0] = p1.getDistance();
                        if (p2.getDistance() == null) d[1] = 0; else d[1] = p2.getDistance();
                        return Double.compare(d[0],d[1]);
                    })
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

