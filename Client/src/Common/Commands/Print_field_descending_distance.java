package Common.Commands;
import Common.*;
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
}
        @Override
        public String getInfo() {
                return "print_field_descending_distance: вывести значение поля distance в порядке убывания.";
        }
}
