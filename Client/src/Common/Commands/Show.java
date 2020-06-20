package Common.Commands;
import Common.*;
/**
 * Команда "ГЛЯДИ! "
 */
public class Show implements Command {
    public Show(){
        Invoker.regist("show",this);
    }
    /**
     * Метод для отображения всех элементов коллекции
     */
    @Override
    public  void execute (String S) {
    }
    @Override
    public String getInfo(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
