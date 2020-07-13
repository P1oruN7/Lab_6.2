package utility;

import common.Invoker;
import common.commands.*;
import common.Command;
import sun.misc.Signal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;

/**
 * Главненький
 */
public class ClientMain {

    public static boolean work = true; // переменная, отвечающая за выход из программы. Как только она станет false, программа завершается
    public static BufferedReader reader = null;
    public static int port;
    public static InetAddress address;


    /**
     * psvm
     *
     * @param args аргументики
     */
    public static void main(String[] args) {
        Signal.handle(new Signal("INT"), sig ->  {
            System.out.println("\n" + "Контрлцешное завершение программы");
            System.exit(0);
        });
        Add add = new Add();
        AverageOfDistance average = new AverageOfDistance();
        Clear clear = new Clear();
        ExecuteScript execute_script = new ExecuteScript();
        Exit exit = new Exit();
        Help help = new Help();
        Draw draw = new Draw();
        History history = new History();
        Info info = new Info();
        MaxByDistance max_byDistance = new MaxByDistance();
        PrintFieldDescendingDistance print_fieldDescendingDistance = new PrintFieldDescendingDistance();
        RemoveById remove_byd = new RemoveById();
        Show show = new Show();
        Reorder reorder = new Reorder();
        Sort sort = new Sort();
        Update update = new Update();

        reader = new BufferedReader(new InputStreamReader(System.in));

//        boolean hasAdderss = false;
//        while (!hasAdderss) {
//            System.out.print("Введите адрес сервера (нажмите энтер, если приложение запущено на сервере):  ");
           try{
//                String s = reader.readLine().trim();
//                if (s.equals("") | s == null) {
                    address = InetAddress.getLocalHost();
//                }
//                else {
//                address = InetAddress.getByName(s);
//                }
          } catch (UnknownHostException e) {
               System.out.println("Невозможно найти сервер с таким адресом");
               System.exit(0); //
           }  //
//                continue;
//            } catch (IOException e) {
//                System.out.println("Ошибка ввода");
//                continue;
//            }
//            try{
//            if (!address.isReachable(2500) ) {
//                System.out.println("Невозможно достучаться до сервера");
//                continue;
//            } } catch (IOException e ){
//                System.out.println("Ошибка ввода.");
//                continue;
//            }
//            hasAdderss = true;
//        }

        boolean hasPort = false;
        while (!hasPort) {
            System.out.print("Введите порт:  ");
            try {
                port = Integer.parseInt(reader.readLine().trim());
            } catch (NumberFormatException e){
                System.out.println("Формат неправильный");
                continue;
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
                continue;
            }
            hasPort = true;
        }
//        System.out.println("Тестовый котик: ");
//        Map<Command, String> commandparamMap;
//        commandparamMap = Invoker.execute("draw   ");
//        ClientSender.send(commandparamMap);
//        try {
//            ClientReceiver.receive();
//        } catch (SocketTimeoutException e) {
//            System.out.println("Сервер не отвечает или занят,попробуйте ещё раз и убедитесь,что сервер работает.");
//        } catch (NullPointerException e) {
//            System.out.println("123");
//        }





        try {
            DatagramSocket ds = new DatagramSocket();
            ClientReceiver.sock = ds;
            ClientReceiver.clientport = ds.getLocalPort();
        } catch (SocketException e) {
            System.out.println("Ошибка подключения. Завершение программы.");
            System.exit(0);

        }
        while (work) {
            Map<Command, String> commandparamMap = null;
            System.out.print("Введите команду:  ");
            try {
                String s = reader.readLine();
                commandparamMap = Invoker.execute(s);
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
                continue;
            }
            if (commandparamMap != null) {
                ClientSender.send(commandparamMap);
                try {
                    ClientReceiver.receive();
                } catch (SocketTimeoutException e) {
                    System.out.println("Сервер не отвечает или занят,попробуйте ещё раз и убедитесь,что сервер работает.");
                }
            }
        }
    }
}


