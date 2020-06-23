package Utility;

import Common.Invoker;
import Common.Commands.*;
import Common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Map;

/**
 * Главненький
 */
public class ClientMain {
    public static boolean work = true; // переменная, отвечающая за выход из программы. Как только она станет false, программа завершается
    public static BufferedReader reader = null;
    public static int port = 12345;

    /**
     * psvm
     *
     * @param args аргументики
     */
    public static void main(String[] args) {

        Add add = new Add();
        Average_of_distance average = new Average_of_distance();
        Clear clear = new Clear();
        Execute_script execute_script = new Execute_script();
        Exit exit = new Exit();
        Help help = new Help();
        Draw draw = new Draw();
        History history = new History();
        Info info = new Info();
        Max_by_distance max_by_distance = new Max_by_distance();
        Print_field_descending_distance print_field_descending_distance = new Print_field_descending_distance();
        Remove_by_id remove_by_id = new Remove_by_id();
        Show show = new Show();
        Reorder reorder = new Reorder();
        Sort sort = new Sort();
        Update update = new Update();

        reader = new BufferedReader(new InputStreamReader(System.in));
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


