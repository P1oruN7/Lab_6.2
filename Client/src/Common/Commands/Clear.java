package Common.Commands;
import Common.*;
//import Utility.ServerMain;

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
       // ServerMain.c.Routes.clear();
    }


    @Override
    public String getInfo() {
        return "clear : очистить коллекцию";
    }
}
