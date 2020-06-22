package Common.Commands;

import Common.*;

/**
 * Команда "СОРТИРОВКА"
 */
public class Sort implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Sort() {
        Invoker.regist("sort", this);
    }

    /**
     * Метод для сортировки коллекции в ествественном порядке (по возрастанию id)
     */
    @Override
    public void execute(String S) {
    }

    @Override
    public String getInfo() {
        return "sort: отсортиовать коллекцию в ествественном порядке.";
    }

}
