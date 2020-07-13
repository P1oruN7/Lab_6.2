package common.commands;

import common.Command;
import common.Invoker;
import readers.ConsoleSourceReader;
import readers.FileSourceReader;
import utility.ClientMain;
import utility.ClientReceiver;
import utility.ClientSender;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Команда "СКРИПТ"
 */

public class ExecuteScript implements Command {

    public ExecuteScript() {
        Invoker.regist("execute_script", this);
    }

    protected static ArrayList<String> usedFiles = new ArrayList<>();
    static boolean fileWork = true;

    /**
     * Метод для выполнения скрипта
     *
     * @param s2 имя файла
     * @return fileWork
     */

    public void execute(String s2) {

        if (s2 == null | s2.equals("")) {
            ConsoleSourceReader consoleSourceReader = new ConsoleSourceReader();
            while (s2 == null | s2.equals("")) {
                System.out.println("кажется, вы забыли ввести расположение файла. Где он лежит?");
                s2 = consoleSourceReader.getLine();
            }
            System.out.println("спасибо, но в следующий раз введите его в той же строке, что и команду" + "\n");
        }
        Map<String, Command> commands = common.Invoker.getCommandCollection();
        if (theSameExist(s2)) {
            System.out.println("\n" + "-ать с рекурсией не надо игр-" + "\n");
            System.out.println("Рекурсивное чтение файла было завершено во избежание разрыва пространственно-временного континуума.");
        } else {
            usedFiles.add(s2);
            try {
                FileSourceReader fileSourceReader = new FileSourceReader(s2);
                String line;
                line = fileSourceReader.getLine();
                while (fileWork && line != null) {
                    String[] s = line.split(" ", 2);
                    System.out.println("Пытаемся выполнить команду \" " + line + " \"");
                    Command command = commands.get(s[0].toLowerCase());
                    if (s[0].toLowerCase().equals("add")) {
                        History.addInArray(s[0]);
                        try {
                            String[] array = {
                                    fileSourceReader.getLine(), // 1 Name
                                    fileSourceReader.getLine(), // 2 Coord X
                                    fileSourceReader.getLine(), // 3 Coord Y
                                    fileSourceReader.getLine(), // 4 Loc From X
                                    fileSourceReader.getLine(), // 5 Loc From Y
                                    fileSourceReader.getLine(), // 6 Loc From Name
                                    fileSourceReader.getLine(), // 7 Loc To X
                                    fileSourceReader.getLine(), // 8 Loc To Y
                                    fileSourceReader.getLine(), // 9 Loc To Name
                                    fileSourceReader.getLine(), // 10 Dist
                            };
                            String string = common.commands.Add.makeString(array);
                            Map<Command, String> commandparamMap = new HashMap<>();
                            commandparamMap.put(command, string);
                            ClientSender.send(commandparamMap);
                            try {
                                ClientReceiver.receive();
                            } catch (SocketTimeoutException e) {
                                System.out.println("Сервер не отвечает или занят,попробуйте ещё раз и убедитесь,что сервер работает.");
                            }

                        } catch (Exception e) {
                            System.out.println("Невозможно создать элемент.");
                            return;
                        }

                    } else if (s[0].toLowerCase().equals("update")) {
                        History.addInArray(s[0]);
                        String ID;
                        if (s.length == 2) ID = s[1].trim();
                        else ID = null;
                        if (ID == null || ID.equals("")) {
                            System.out.println("Вы не ввели ID для апдейтинга.");
                            return;
                        }
                        Map<Command, String> commandparamMap = new HashMap<>();
                        commandparamMap.put(command, ID);
                        ClientSender.send(commandparamMap);
                        ClientReceiver.receive();
                        if (ClientReceiver.answer.entrySet().iterator().next().getKey().startsWith("Состояние элемента сейчас:")) {
                            String[] array = {
                                    fileSourceReader.getLine(), // 1 Name
                                    fileSourceReader.getLine(), // 2 Coord X
                                    fileSourceReader.getLine(), // 3 Coord Y
                                    fileSourceReader.getLine(), // 4 Loc From X
                                    fileSourceReader.getLine(), // 5 Loc From Y
                                    fileSourceReader.getLine(), // 6 Loc From Name
                                    fileSourceReader.getLine(), // 7 Loc To X
                                    fileSourceReader.getLine(), // 8 Loc To Y
                                    fileSourceReader.getLine(), // 9 Loc To Name
                                    fileSourceReader.getLine(), // 10 Dist
                            };
                            String s1 = Add.makeString(array);
                            commandparamMap.put(command, s1);
                            try {
                                DatagramChannel datagramChannel = DatagramChannel.open();
                                datagramChannel.bind(null);
                                SocketAddress serverAddress = new InetSocketAddress(InetAddress.getLocalHost(), ClientMain.port);
                                byte[] buff = s1.getBytes();
                                datagramChannel.configureBlocking(false);
                                datagramChannel.send(ByteBuffer.wrap(buff), serverAddress);
                                datagramChannel.close();
                            } catch (IOException e) {
                                System.out.println("Невозможно соедениться с сервером.");
                                return;
                            }
                            ClientReceiver.receive();
                        }
                    } else {
                        Map<Command, String> commandparamMap = new HashMap<>();
                        commandparamMap = Invoker.execute(line);

                        if (commandparamMap != null) {
                            ClientSender.send(commandparamMap);
                            try {
                                ClientReceiver.receive();
                            } catch (SocketTimeoutException e) {
                                System.out.println("Сервер не отвечает или занят,попробуйте ещё раз и убедитесь,что сервер работает.");
                            }
                        }
                    }
                    line = fileSourceReader.getLine();
                }
                fileSourceReader.close();
                usedFiles.clear();
                System.out.println("Завершение скрипта");
            } catch (IOException e) {
                System.out.println("ошибка чтения файла");
                usedFiles.clear();
            } catch (Exception e) {
                System.out.println("непредвиденный конец файла");
                usedFiles.clear();
            }
        }
    }

    /**
     * Поиск передаваемого файла среди уже запущенных
     *
     * @param s2 путь файла
     * @return true - если найден
     */
    private static boolean theSameExist(String s2) {
        for (String s : usedFiles) if (s.equals(s2)) return true;
        return false;
    }


    @Override
    public String getInfo() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла.В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}