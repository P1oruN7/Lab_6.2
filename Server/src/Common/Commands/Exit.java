package Common.Commands;
import Common.*;

/**
 * Команда "ВЫХОДА НЕТ"
 */
public class Exit implements Command  {
    /**
     * Метод для прекращения работы программы
     */
    @Override
    public void execute(String s){
       // System.out.println("\n Сервер завершает свою работу.");
    }
    @Override
    public String getInfo() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
