package Common.Commands;

import Common.*;
import Utility.ServerMain;
import Utility.ServerSender;


/**
 * Команда "ИНФОРМБЮРО"
 */
public class Info implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Отображение актуальной информации о коллекции
     */
    @Override
    public void execute(String s) {
        ServerSender.send("\n \nКоллекция представляет собой: " + ServerMain.c.Routes.getClass().getName() + "\n" +
                "В коллекции: " + ServerMain.c.Routes.size() + " элементов" + "\n" +
                "Коллеция была создана: " + ServerMain.c.getInitializationDate() + "\n \n", 0);
    }

    @Override
    public String getInfo() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
