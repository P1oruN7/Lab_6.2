package Common.Commands;
import Common.*;
//import Utility.ServerMain;

import java.util.Collections;

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
        //Collections.reverse(ServerMain.c.Routes);
 }

    @Override
    public String getInfo() {
        return "reorder: отсортировать коллекцию в порядке, обратном нынешнему.";
    }
}
