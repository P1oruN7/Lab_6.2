package Utility;

import Common.*;
import Common.Commands.*;
import Routes.Collection;
import XmlManagers.XmlReader;

import java.io.IOException;
import java.util.Map;

import Readers.ConsoleSourceReader;

import java.io.File;

/**
 * Главненький
 */
public class ServerMain {
    public static Collection c = null;

    /**
     * psvm
     *
     * @param args аргументики
     * @throws IOException
     */
    public static void main(String[] args) {
        Add add = new Add();
        Average_of_distance average = new Average_of_distance();
        Clear clear = new Clear();
        Exit exit = new Exit();
        Info info = new Info();
        Max_by_distance max_by_distance = new Max_by_distance();
        Print_field_descending_distance print_field_descending_distance = new Print_field_descending_distance();
        Remove_by_id remove_by_id = new Remove_by_id();
        Show show = new Show();
        Reorder reorder = new Reorder();
        Common.Commands.Save save = new Common.Commands.Save();
        Sort sort = new Sort();
        Update update = new Update();
        CreateServer.create();
        System.out.println("Сервер запущен.");
        ConsoleSourceReader bufferReader = new ConsoleSourceReader();///////
        String path = null;

        try {
            path = args[0];
            c = XmlReader.getCollection(path);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        while (c == null) {
            System.out.println("Введите расположение файла с коллекцией или нажмите Enter, чтобы начать работу с дефолтной коллекцией: ");
            path = bufferReader.getLine() + "";
            if (path.equals("")) {
                path = "resources/input.xml";
                System.out.println("Вы начали работу с коллекцией по умолчанию. Если хотите увидеть ее элементы, введите \"show\"");
            }

            c = XmlReader.getCollection(path);

        }

        try {
            if (new File(path).exists()) {
                c.setPath(path);
            }
        } catch (NullPointerException ignored) {
        }  //////////


        //   c = new Collection(); // !!!!
        InputString inputString = new InputString();
        inputString.start();
        while (true) {
            GetCommand();
        }
    }

    public static void GetCommand() {
        Map<Command, String> commandStringMap;
        try {
            System.out.println("Жду команду.");
            Object o = ByteToObject.Cast(ServerReceiver.receive());
            commandStringMap = (Map<Command, String>) o;
            CreateServer.serverIsAvaible = false;
            System.out.println("Выполняю команду " + commandStringMap.entrySet().iterator().next().getKey().getClass().getName());
            commandStringMap.entrySet().iterator().next().getKey().execute(commandStringMap.entrySet().iterator().next().getValue());
            CreateServer.serverIsAvaible = true;
            if (!commandStringMap.entrySet().iterator().next().getKey().getClass().getName().equals("Common.Commands.Exit"))
                System.out.println("Команда выполнена! Отправляю результат клиенту с портом " + CreateServer.currentClientPort + ".");
        } catch (ClassCastException e) {
            ServerSender.send("Сообщение от Сервера:\"Возникли небольшие неполадки с вашим подключением,но сейчас всё по кайфу,ожидаю команд.\"\n", 0);
        }
    }


}

