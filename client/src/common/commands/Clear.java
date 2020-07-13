package common.commands;

import common.*;

/**
 * Команда "ЧИСТИЛЬЩИК "
 */
public class Clear implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Clear() {
        Invoker.regist("clear", this);
    }

    /**
     * Метод для очистки коллекции, подаваемой на вход
     */
    @Override
    public void execute(String s) {
    }


    @Override
    public String getInfo() {
        return "clear : очистить коллекцию";
    }
}
