package common.commands;

import common.*;

/**
 * Команда "ПЕРЕВЁРТЫШ"
 */
public class Reorder implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Reorder() {
        Invoker.regist("reorder", this);
    }

    /**
     * Метод для разворота коллекции
     */
    @Override
    public void execute(String S) {
    }

    @Override
    public String getInfo() {
        return "reorder: отсортировать коллекцию в порядке, обратном нынешнему.";
    }
}
