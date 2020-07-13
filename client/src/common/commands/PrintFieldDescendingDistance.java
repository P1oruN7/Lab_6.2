package common.commands;

import common.*;

/**
 * Команда "Выведи-ка мне поле distance всех элементов коллекции, да в обратном порядке!"
 */
public class PrintFieldDescendingDistance implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public PrintFieldDescendingDistance() {
        Invoker.regist("print_field_descending_distance", this);
    }

    /**
     * Метод для вывода поля distance всех элементов коллекции в обратном порядке
     */
    @Override
    public void execute(String S) {
    }

    @Override
    public String getInfo() {
        return "print_field_descending_distance: вывести значение поля distance в порядке убывания.";
    }
}
