package common;

import utility.ServerSender;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс - сортировщик
 */
public class Invoker {
    private static Map<String, Command> commands = new TreeMap<>();

    /**
     * Регистрация команды
     *
     * @param name    иня
     * @param command собсна команда
     */
    public static void regist(String name, Command command) {
        commands.put(name, command);
    }

    /**
     * Получить коллекцию команд
     *
     * @return map
     */
    public static Map<String, Command> getCommandCollection() {
        return commands;
    }

    /**
     * Исполнить
     *
     * @param s строчечка
     */
    public static void execute(String s) {
        Map<Command, String> commandStringMap = new HashMap<>();
        String name[] = s.split(" ", 1);
        Command command = commands.get(name[0]);
        if (s.equals("")) {
            System.out.print("$ ");
        } else if (name[0].equals("exit")) {
        } else if (command == null || name.length > 2) {
            ServerSender.send("Такой команды не существует,попробуйте другую. Для справки введите \"help\"", 2);
        } else if (name.length == 1) {
            command.execute(null);
        } else if (name.length == 2) {
            command.execute(name[1]);
        }
    }
}

