package common.commands;

import common.*;
import utility.ServerMain;
import utility.ServerSender;

import java.util.Collections;

/**
 * Команда "ПЕРЕВЁРТЫШ"
 */
public class Reorder implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для разворота коллекции
     */
    @Override
    public void execute(String S) {
        Collections.reverse(ServerMain.c.Routes);
        ServerSender.send("\n\nКоллекция была развёрнута задом наперёд \n\n", 0);
    }

    @Override
    public String getInfo() {
        return "reorder: отсортировать коллекцию в порядке, обратном нынешнему.";
    }
}
