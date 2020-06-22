package Common.Commands;

import Common.*;

/**
 * Команда "СРЗНАЧ"
 */
public class Average_of_distance implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Average_of_distance() {
        Invoker.regist("average_of_distance", this);
    }

    /**
     * Метод для вывода среднего значения поля distance для всех элементов коллекции
     */
    @Override
    public void execute(String s) {
    }

    @Override
    public String getInfo() {
        return "average_of_distance : вывести среднее значение поля distance для всех элементов коллекции.";
    }
}

