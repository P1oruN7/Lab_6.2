package common.commands;

import common.*;
//import Utility.ServerMain;


/**
 * Команда "ИНФОРМБЮРО"
 */
public class Info implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Info() {
        Invoker.regist("info", this);
    }

    /**
     * Отображение актуальной информации о коллекции
     */
    @Override
    public void execute(String s) {
    }

    @Override
    public String getInfo() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
