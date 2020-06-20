package Common.Commands;
import Common.*;
import Readers.*;
import Routes.Coordinates;
import Routes.Location;
import Routes.Route;

import java.io.IOException;

/**
 * Команда  "ПРАВКИ!"
 */
public class Update implements Command {
    public Update(){
        Invoker.regist("update",this);
    }

    /**
     * Метод для изменения значений элемента по id
     * @throws IOException
     */
    @Override
        public  void execute (String s) throws IOException {
//        while (s.equals("") || s == null){
//            System.out.println("Введите ID элемента, который вы хотите апдейтнуть. Если хотите выйти из апдейтинга, введите -1.");
//            s = Utility.ClientMain.reader.readLine();
//            if(s. trim().equals("-1") | s. trim().equals("- 1")) return;
//        }
    }
    @Override
    public String getInfo() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному.";
    }
}
