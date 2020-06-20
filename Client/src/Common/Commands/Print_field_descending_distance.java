package Common.Commands;
import Common.*;
import Routes.Collection;
import Routes.Route;

import java.util.Arrays;

/**
 * Команда "Выведи-ка мне поле distance всех элементов коллекции, да в обратном порядке!"
 */
public class Print_field_descending_distance  implements Command {
        public Print_field_descending_distance(){
                Invoker.regist("print_field_descending_distance",this);
        }
        /**
         * Метод для вывода поля distance всех элементов коллекции в обратном порядке
         */
        @Override
        public void execute (String S) {
//        if (!c.Routes.isEmpty()) {
//                float[] array = new float[c.Routes.size()]; // создаётся массив размером с коллекцию
//                int i = 0;
//                for (Route r : c.Routes) {
//                        if (r.getDistance()!=null) array[i] = r.getDistance(); // в массив вносятся значения distance
//                        i++;
//                }
//
//                Arrays.sort(array); // массив сортируется в порядке возрастания
//                for (i = c.Routes.size() - 1; i >= 0; i--) {
//                        System.out.println(array[i]); // массив выводится в обратном порядке
//                }
//        }else System.out.println("Коллекция пуста, в отличие от моего рабочего стола.");
}
        @Override
        public String getInfo() {
                return "print_field_descending_distance: вывести значение поля distance в порядке убывания.";
        }
}
