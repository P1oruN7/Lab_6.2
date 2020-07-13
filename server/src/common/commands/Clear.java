package common.commands;

import common.*;
import utility.ServerMain;
import utility.ServerSender;

/**
 * Команда "ЧИСТИЛЬЩИК "
 */
public class Clear implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для очистки коллекции, подаваемой на вход
     */
    @Override
    public void execute(String s) {
        ServerMain.c.Routes.clear();
        ServerSender.send("\n \nКоллекция была очищена, как картошечка для супчика \n \n", 0);
    }


    @Override
    public String getInfo() {
        return "clear : очистить коллекцию";
    }
}
