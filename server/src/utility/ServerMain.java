package utility;

import common.*;
import common.commands.*;
import routes.Collection;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.Map;

import readers.ConsoleSourceReader;
import sun.misc.Signal;

/**
 * Главненький
 */
public class ServerMain {






    public static Collection c = null;
    public static Integer port;
    public static SocketAddress clientAdderss;
    /**
     * psvm
     *
     * @param args аргументики
     * @throws IOException
     */
    public static void main(String[] args) {
        Signal.handle(new Signal("INT"), sig ->  {
            System.out.println("\n" + "Контрлцешное завершение программы");
            System.exit(0);
        });

        Add add = new Add();
        AverageOfDistance average = new AverageOfDistance();
        Clear clear = new Clear();
        Exit exit = new Exit();
        Info info = new Info();
        MaxByDistance max_byDistance = new MaxByDistance();
        PrintFieldDescendingDistance print_fieldDescendingDistance = new PrintFieldDescendingDistance();
        RemoveById remove_byId = new RemoveById();
        Show show = new Show();
        Reorder reorder = new Reorder();
        common.commands.Save save = new common.commands.Save();
        Sort sort = new Sort();
        Update update = new Update();
      //  CreateServer.create();
       // System.out.println("Сервер запущен.");
       ConsoleSourceReader bufferReader = new ConsoleSourceReader();///////
//        String path = null;
//
//        try {
//            path = args[0];
//            c = XmlReader.getCollection(path);
//        } catch (ArrayIndexOutOfBoundsException ignored) {
//        }
//        while (c == null) {
//            System.out.println("Введите расположение файла с коллекцией или нажмите Enter, чтобы начать работу с дефолтной коллекцией: ");
//            path = bufferReader.getLine() + "";
//            if (path.equals("")) {
//                path = "resources/input.xml";
//                System.out.println("Вы начали работу с коллекцией по умолчанию. Если хотите увидеть ее элементы, введите \"show\"");
//            }
//
//            c = XmlReader.getCollection(path);
//
//        }
//
//        try {
//            if (new File(path).exists()) {
//                c.setPath(path);
//            }
//        } catch (NullPointerException ignored) {
//        }  //////////


           c = new Collection(); // !!!!
        boolean serverCreated = false;
        while (!serverCreated) {
            System.out.print("Введите порт:  ");

            try {
                port = Integer.parseInt(bufferReader.getLine());
            } catch (NumberFormatException e){
                System.out.println("Формат неправильный");
                continue;
            }
            serverCreated = CreateServer.create();
        }
        System.out.println("Советик: введите help, чтобы увидеть доступные команды.");
        InputString inputString = new InputString();
        inputString.start();
        while (true) {
            GetCommand();
        }
    }

    public static void GetCommand() {
        Map<Command, String> commandStringMap;
        try {
            System.out.println("\nЖду команду от клиента.");
            Object o = ByteToObject.Cast(ServerReceiver.receive());
            commandStringMap = (Map<Command, String>) o;
            CreateServer.serverIsAvaible = false;
            System.out.println("\nВыполняю команду " + commandStringMap.entrySet().iterator().next().getKey().getClass().getName());
            commandStringMap.entrySet().iterator().next().getKey().execute(commandStringMap.entrySet().iterator().next().getValue());
            CreateServer.serverIsAvaible = true;
            if (!commandStringMap.entrySet().iterator().next().getKey().getClass().getName().equals("Common.Commands.Exit"))
                System.out.println("\nКоманда выполнена! Отправляю результат клиенту.");
        } catch (ClassCastException e) {
            ServerSender.send("\nСообщение от Сервера:\"Возникли небольшие неполадки с вашим подключением,но сейчас всё по кайфу,ожидаю команд.\"\n", 0);
        }
    }
}

