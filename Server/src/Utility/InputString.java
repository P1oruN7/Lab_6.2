package Utility;

import Common.Commands.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс - обработчик сигналов с консоли сервера
 */
public class InputString extends Thread {

    /**
     * Бег
     */
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Common.Commands.Save saveCommand = new Common.Commands.Save();
        Exit exit = new Exit();
        Help help = new Help();
        while (true) {
            try {
                System.out.print("Введите команду для сервера: ");
                String s = reader.readLine();
                if (s == null | s.trim().equals("")) continue;
                switch (s.trim().toLowerCase()) {
                    case "save":
                        System.out.println("Пытаюсь сохранянить");
                        saveCommand.execute(null);
                        break;
                    case "exit":
                        System.out.println("Выхожу с сохранением");
                        saveCommand.execute(null);
                        exit.execute("NotNull");
                        System.out.println("Выход");
                        break;
                    case "help":
                        System.out.println("Список всех доступных команд:\n   " +
                                saveCommand.getInfo() +
                                "\n   " + exit.getInfo() +
                                "\n   " + help.getInfo()
                        );
                }
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            } catch (Exception e) {
                continue;
            }
        }
    }
}
