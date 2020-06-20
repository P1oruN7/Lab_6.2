package Common.Commands;
import Common.*;
/**
 * Команда "ПЕРЕВЁРТЫШ"
 */
public class Reorder implements Command {
    public Reorder(){
        Invoker.regist("reorder",this);
    }
    /**
     * Метод для разворота коллекции
     */
    @Override
    public  void execute (String S) {
 }

    @Override
    public String getInfo() {
        return "reorder: отсортировать коллекцию в порядке, обратном нынешнему.";
    }
}
