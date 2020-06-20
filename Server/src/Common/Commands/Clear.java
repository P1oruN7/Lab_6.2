package Common.Commands;
import Common.*;
import Utility.ServerMain;
import Utility.ServerSender;

/**
 * Команда "ЧИСТИЛЬЩИК "
 */
public class Clear implements Command  {
    /**
     * Метод для очистки коллекции, подаваемой на вход
     */
    @Override
    public  void execute(String s) {
        ServerMain.c.Routes.clear();
        ServerSender.send("\n \nКоллекция была очищена, как картошечка для супчика \n \n",0);
    }


    @Override
    public String getInfo() {
        return "clear : очистить коллекцию";
    }
}
