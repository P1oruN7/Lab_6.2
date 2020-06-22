package Common.Commands;

import Common.*;

/**
 * Команда "ПАМЯТЬ"
 */

public class History implements Command {
    public History() {
        Invoker.regist("history", this);
    }

    static final int n = 12; //количество сохраняемых команд -1
    static String[] historyArray = new String[n]; //массив для хранения последних n+1 команд

    /**
     * Метод для отображения истории
     */
    @Override
    public void execute(String s) {
        for (int i = n - 1; i >= 0; i--) {
            if (historyArray[i] != null) System.out.println("   " + (i + 1) + "   " + historyArray[i]);
        }
    }

    /**
     * Запись команды в анналы истории
     *
     * @param s1 команда
     */
    public static void addInArray(String s1) {
        for (int i = n - 1; i > 0; i--) {
            historyArray[i] = historyArray[i - 1];
        }
        historyArray[0] = s1; //запись команды в изначальном регистре в массив
    }

    @Override
    public String getInfo() {
        return "history: вывести последние 13 команд (без их аргументов)";
    }
}
