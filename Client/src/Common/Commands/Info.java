package Common.Commands;
import Common.*;
//import Utility.ServerMain;


/**
 * Команда "ИНФОРМБЮРО"
 */
public class Info implements Command {
    public Info(){
        Invoker.regist("info",this);
    }
    /**
     * Отображение актуальной информации о коллекции
     */
    @Override
    public  void execute(String s) {
//        System.out.println("Коллекция представляет собой: " + ServerMain.c.Routes.getClass().getName());
//        System.out.println("В коллекции: " + ServerMain.c.Routes.size()+ " элементов");
//        System.out.println("Коллеция была создана: " + ServerMain.c.getInitializationDate());
    }
    @Override
    public String getInfo() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
