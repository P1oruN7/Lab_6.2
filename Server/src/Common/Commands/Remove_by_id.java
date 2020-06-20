package Common.Commands;
import Common.*;
import Readers.*;
import Routes.Route;

/**
 * Команда "УДОЛИ!"
 */
public class Remove_by_id implements Command {
    /**
     * метод удаления элемента коллекции по его id
     */
    @Override
    public void execute(String s){
//    if (s2==null | s2.equals("")) {
//        System.out.println("кажется вы забыли ввести айди");
//        return;
//    }
//
//       long removeId = Checker.longChecker(s2);
//    Route r = c.searchById(removeId);
//    if (r ==null) {System.out.println("похоже элемента с таким айди не существует");
//        return;
//    }
//       c.Routes.remove(c.Routes.indexOf(r));
    }
    @Override
    public String getInfo() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }

}
