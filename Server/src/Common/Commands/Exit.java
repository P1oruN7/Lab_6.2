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
        System.out.println("\nСервер завершает свою работу.");
        System.exit(0);
    }
    @Override
    public String getInfo() {
        return "exit : завершить программу ";
    }
}
