package common.commands;
import common.*;
import routes.Route;
import utility.ServerMain;
import utility.ServerSender;
/**
 * Команда "МАКСИМАЛЬНЫЙ"
 */
public class MaxByDistance implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для вывода элемента коллекции Routes с максимальным значением поля distance
     */
    @Override
    public void execute(String s) {
        boolean first = true;
        if (ServerMain.c.Routes.size() > 0) {
            Route maxRoutebyDist = null;
            for (Route r : ServerMain.c.Routes) {
                if (r.getDistance() != null & first) {
                    maxRoutebyDist = r;
                    first = false;
                }
                if (r.getDistance() != null) if (r.getDistance() > maxRoutebyDist.getDistance()) maxRoutebyDist = r;

            }
            ServerSender.send("\n \n" + maxRoutebyDist + "\n \n", 0);
        } else
            ServerSender.send("\nКоллекция пуста как моё сердце \n \n", 0);
    }
    @Override
    public String getInfo() {
        return "max_by_distance: вывести любой объект из коллекции, значение поля distance которого является максимальным";
    }
}