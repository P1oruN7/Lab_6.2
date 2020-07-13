package common.commands;

import common.*;

/**
 * Команда  "ПРАВКИ!"
 */
public class Update implements Command {
    public Update() {
        Invoker.regist("update", this);
    }

    private static final long serialVersionUID = 6529685098267757690L;


    /**
     * Метод для изменения значений элемента по id
     */
    @Override
    public void execute(String s) {

    }

    @Override
    public String getInfo() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному.";
    }
}
