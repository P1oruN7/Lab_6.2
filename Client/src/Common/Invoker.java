package Common;

import Utility.ClientReceiver;
import Utility.ClientSender;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Invoker.
 */
public class Invoker  {
    private static Map<String, Command> commands = new TreeMap<>();
    /**
     * Regist.
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
    public static Map<String,Command> getCommandCollection(){
        return commands;
    }

    /**
     * Execute.
     *
     * @param s the  getting string.
     * @throws IOException the io exception
     */
    public static Map<Command,String> execute(String s) throws IOException {
        Map<Command,String> commandStringMap = new HashMap<>();
        String name[]=s.split(" ",2);
        Command command = commands.get(name[0].toLowerCase());
        if (s.equals("")){ System.out.print("$ "); }
       else if (command == null || name.length>2){
            System.out.println("Такой команды не существует,попробуйте другую. Для справки введите \"help\"");
            return null;
       }
       else if (name[0].toLowerCase().equals("help")) {
        command.execute("");
        }
        else if (name[0].toLowerCase().equals("add")) {
            commandStringMap.put(command, Common.Commands.Add.makeString());
            return commandStringMap;
        }
       else if(name[0].toLowerCase().equals("exit")){
           commandStringMap.put(command,null);
            ClientSender.send(commandStringMap);
            command.execute("");
        }
       else if(name[0].toLowerCase().equals("update")){
           String ID;
           if (name.length==2)ID=name[1];
                else ID = null;
            if (ID == null ) {
                System.out.println("Вы не ввели ID для апдейтинга.");
                return null;}
            commandStringMap.put(command,ID);
            ClientSender.send(commandStringMap);
            ClientReceiver.receive();
        }
        else if (name.length == 1){
            commandStringMap.put(command,null);
            return commandStringMap;
        }
        else if (name.length == 2){
            commandStringMap.put(command,name[1]);
            return commandStringMap;
        }
        return null;
    }
}

