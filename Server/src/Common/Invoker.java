package Common;

import Utility.ServerSender;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Invoker.
 */
public class Invoker {
    private static Map<String, Command> commands = new TreeMap<>();
    /**
     * Regist.
     *
     * @param name    the name
     * @param command the command
     */
    public static void regist(String name, Command command) {
        commands.put(name, command);
    }

    /**
     * Get command collection map.
     *
     * @return the map
     */
    public static Map<String, Command> getCommandCollection(){
        return commands;
    }

    /**
     * Execute.
     *
     * @param s the  getting string.
     * @throws IOException the io exception
     */
    public static void execute(String s) throws IOException {
        Map<Command,String> commandStringMap = new HashMap<>();
        String name[]=s.split(" ",1);
        Command command = commands.get(name[0]);
        if (s.equals("")){ System.out.print("$ "); }
        else if (name[0].equals("exit")){
        }
       else if (command == null || name.length>2){
            ServerSender.send("Такой команды не существует,попробуйте другую. Для справки введите \"help\"",2);
       }
        else if (name.length == 1){
            command.execute(null);
        }
        else if (name.length == 2){
            command.execute(name[1]);
        }
    }
}

