package Utility;

import Common.Commands.Exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Класс - обработчик сигналов с консоли сервера
 */
public class InputString extends Thread {

    /**
     * Бег
     */
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Common.Commands.Save saveCommand = new Common.Commands.Save();
        Exit exit = new Exit();
        try {
            while (true) {
                System.out.print("Введите команду для сервера: ");
                String s = reader.readLine();
                switch (s.trim()) {
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
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }
    }
}