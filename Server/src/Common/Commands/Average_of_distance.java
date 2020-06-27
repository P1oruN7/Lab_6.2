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
            Double averageOfDistance = ServerMain.c.Routes.stream()
                    .map(Route::getDistance)
                    .mapToDouble( (t) -> {
                        if ((t)==null) (t) = Float.valueOf(0);
                        return (t);
                    })
                    .average()
                    .getAsDouble();
            ServerSender.send("\n \nСреднее значение distance: " +averageOfDistance + "\n \n", 0);
        } else
            ServerSender.send("\n \n Коллекция пуста как банка кофе, купленая в начале выполнения этой работы \n \n", 0);
    }

    @Override
    public String getInfo() {
        return "average_of_distance : вывести среднее значение поля distance для всех элементов коллекции.";
    }
}

