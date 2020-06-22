package Common.Commands;

import Common.*;
import Utility.ServerMain;
import Utility.ServerSender;

import java.util.Collections;

/**
 * Команда "СОРТИРОВКА"
 */
public class Sort implements Command {
    /**
     * Метод для сортировки коллекции в ествественном порядке (по возрастанию id)
     */
    @Override
    public void execute(String S) {
        Collections.sort(ServerMain.c.Routes);
        ServerSender.send("\n\nКоллекция была отсортирована по возрастанию id\n\n", 0);
    }

    @Override
    public String getInfo() {
        return "sort: отсортиовать коллекцию в ествественном порядке.";
    }

}
