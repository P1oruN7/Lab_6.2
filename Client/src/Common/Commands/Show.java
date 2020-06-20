package Common.Commands;
import Common.*;
import Routes.Route;
//import Utility.ServerMain;

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
//        if (ServerMain.c.Routes.size() == 0) {
//            System.out.println("Коллекция пуста, милорд");
//        } else {
//
//            for (Route r : ServerMain.c.Routes) {
//                System.out.println("  " + r.toString());
//            }
//        }
    }
    @Override
    public String getInfo(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
