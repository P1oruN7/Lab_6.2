package Common.Commands;

import Common.*;
import Utility.ServerMain;
import Utility.ServerSender;


/**
 * Команда "СРЗНАЧ"
 */
public class Average_of_distance implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для вывода среднего значения поля distance для всех элементов коллекции
     */
    @Override
    public void execute(String s) {
        if (ServerMain.c.Routes.size() > 0) {
            Float sum = 0f;
            int countOfNull = 0;
            for (Routes.Route r : ServerMain.c.Routes) {
                if (r.getDistance() != null)
                    sum += r.getDistance();
                else
                    countOfNull++;
            }
            if (ServerMain.c.Routes.size() - countOfNull > 0)
                ServerSender.send("\n \nСреднее значение distance: " + sum / (ServerMain.c.Routes.size() - countOfNull) + "\n \n", 0);

        } else
            ServerSender.send("\n \n Коллекция пуста как банка кофе, купленая в начале выполнения этой работы \n \n", 0);
    }

    @Override
    public String getInfo() {
        return "average_of_distance : вывести среднее значение поля distance для всех элементов коллекции.";
    }
}

