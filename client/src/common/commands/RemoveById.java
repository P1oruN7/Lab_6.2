package common.commands;

import common.*;

/**
 * Команда "УДОЛИ!"
 */
public class RemoveById implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public RemoveById() {
        Invoker.regist("remove_by_id", this);
    }

    /**
     * метод удаления элемента коллекции по его id
     */
    @Override
    public void execute(String s) {
    }

    @Override
    public String getInfo() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }

}
