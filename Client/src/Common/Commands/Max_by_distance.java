package Common.Commands;
import Common.*;
/**
 * Команда "МАКСИМАЛЬНЫЙ"
 */
public class Max_by_distance implements Command  {
        public Max_by_distance(){
                Invoker.regist("max_by_distance",this);
        }
        /**
         *  Метод для вывода элемента коллекции Routes с максимальным значением поля distance
         */
        @Override
        public  void  execute (String s){
        }
        @Override
        public String getInfo() {
                return "max_by_distance: вывести любой объект из коллекции, значение поля distance которого является максимальным";
        }

}

