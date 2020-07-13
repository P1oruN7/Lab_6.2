package common.commands;

import common.*;

/**
 * Команда "МАКСИМАЛЬНЫЙ"
 */
public class MaxByDistance implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public MaxByDistance() {
        Invoker.regist("max_by_distance", this);
    }

    /**
     * Метод для вывода элемента коллекции Routes с максимальным значением поля distance
     */
    @Override
    public void execute(String s) {
    }

    @Override
    public String getInfo() {
        return "max_by_distance: вывести любой объект из коллекции, значение поля distance которого является максимальным";
    }

}

