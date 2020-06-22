package Common;

import Common.Commands.Add;
import Utility.ClientReceiver;
import Utility.ClientSender;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
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
        if (s.equals("")){
            System.out.println("Пустая строка проигнорирована.");
        }
       else if (command == null || name.length>2){
            System.out.println("Такой команды не существует,попробуйте другую. Для справки введите \"help\"");
            return null;
       }
       else if (name[0].toLowerCase().equals("help")) {
        command.execute("");
        }
        else if (name[0].toLowerCase().equals("execute_script")) {
            command.execute(name[1]);
        }
        else if (name[0].toLowerCase().equals("add")) {
            String string = Common.Commands.Add.makeString();
            commandStringMap.put(command, string);
            return commandStringMap;
        }
       else if(name[0].toLowerCase().equals("exit")){
           commandStringMap.put(command,null);
            ClientSender.send(commandStringMap);
            command.execute("");
        }
       else if(name[0].toLowerCase().equals("update")) {
            String ID;
            if (name.length == 2) ID = name[1].trim();
            else ID = null;
            if (ID == null || ID.equals("")) {
                System.out.println("Вы не ввели ID для апдейтинга.");
                return null;
            }
            commandStringMap.put(command, ID);
            ClientSender.send(commandStringMap);
            ClientReceiver.receive();
            if (ClientReceiver.answer.entrySet().iterator().next().getKey().startsWith("Состояние элемента сейчас:")) {
                String s1 = Add.makeString();
                commandStringMap.put(command, s1);
                try {
                    DatagramChannel datagramChannel = DatagramChannel.open();
                    datagramChannel.bind(null);
                    SocketAddress serverAddress = new InetSocketAddress(InetAddress.getLocalHost(), 12345);
                    byte[] buff = s1.getBytes();
                    datagramChannel.configureBlocking(false);
                    datagramChannel.send(ByteBuffer.wrap(buff), serverAddress);
                    datagramChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ClientReceiver.receive();
            }
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

