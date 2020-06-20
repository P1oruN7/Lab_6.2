package Common.Commands;
import Common.*;

/**
 * Команда "ЧИСТИЛЬЩИК "
 */
public class Clear implements Command  {
    public Clear(){
        Invoker.regist("clear",this);
    }
    /**
     * Метод для очистки коллекции, подаваемой на вход
     */
    @Override
    public  void execute(String s) {
    }


    @Override
    public String getInfo() {
        return "clear : очистить коллекцию";
    }
}
