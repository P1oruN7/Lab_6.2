package Common.Commands;

import Common.*;

/**
 * Команда "УДОЛИ!"
 */
public class Remove_by_id implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Remove_by_id() {
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
