package Common.Commands;
import Common.*;
//import Utility.ServerMain;

import java.util.Collections;

/**
 * Команда "СОРТИРОВКА"
 */
public class Sort implements Command {
    public Sort(){
        Invoker.regist("sort",this);
    }
    /**
     * Метод для сортировки коллекции в ествественном порядке (по возрастанию id)
     */
    @Override
    public  void  execute (String S) {
           //Collections.sort(ServerMain.c.Routes);
        }
    @Override
    public String getInfo() {
        return "sort: отсортиовать коллекцию в ествественном порядке.";
    }

}
