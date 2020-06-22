package Common.Commands;

import Common.*;

/**
 * Команда "ВЫХОДА НЕТ"
 */
public class Exit implements Command {
    public Exit() {
        Invoker.regist("exit", this);
    }

    /**
     * Метод для прекращения работы программы
     */
    @Override
    public void execute(String s) {
        System.out.println("Программа завершает свою работу.");
        System.exit(0);
    }

    @Override
    public String getInfo() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
