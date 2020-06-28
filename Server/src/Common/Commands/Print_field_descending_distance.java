package Common.Commands;

import Common.*;
import Routes.Collection;
import Routes.Route;
import Utility.ServerSender;

import java.util.Arrays;

/**
 * Команда "Выведи-ка мне поле distance всех элементов коллекции, да в обратном порядке!"
 */
public class Print_field_descending_distance implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для вывода поля distance всех элементов коллекции в обратном порядке
     */
    @Override
    public void execute(String S) {
        if (!ServerMain.c.Routes.isEmpty()) {
            String[] q = {"\n"};
            ServerMain.c.Routes.stream()
                        .map(Route::getDistance)
                        .mapToDouble( (t) -> {
                           if ((t)==null) (t) = Float.valueOf(0);
                          return (t); })
                        .map((t) -> 0-t)
                        .sorted()
                        .map((t) -> 0-t)
                        .forEachOrdered(x -> q[0] += Double.toString(x) + "\n");
            ServerSender.send("Значения distance: " + q[0], 0);
        } else ServerSender.send("Коллекция пуста, в отличие от моего рабочего стола.", 0);
    }
    
    @Override
    public String getInfo() {
        return "print_field_descending_distance: вывести значение поля distance в порядке убывания.";
    }
}
