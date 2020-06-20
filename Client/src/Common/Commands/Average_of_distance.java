package Common.Commands;
import Common.*;
//import Utility.ServerMain;


/**
 * Команда "СРЗНАЧ"
 */
public class Average_of_distance implements Command {

    public Average_of_distance(){
        Invoker.regist("average_of_distance",this);
    }

    /**
     * Метод для вывода среднего значения поля distance для всех элементов коллекции
     */
    @Override
    public  void execute(String s) {
//        if (ServerMain.c.Routes.size() > 0) {
//            Float sum = 0f;
//            int countOfNull = 0;
//            for (Routes.Route r : ServerMain.c.Routes) {
//                if (r.getDistance() != null)
//                    sum += r.getDistance();
//                else
//                    countOfNull++;
//            }
//            if (ServerMain.c.Routes.size() - countOfNull > 0)
//                System.out.println("Среднее значение distance: " + sum / (ServerMain.c.Routes.size() - countOfNull));
//
//        } else
//        System.out.println("Коллекция пуста как банка кофе, купленая в начале выполнения этой работы");
    }
    @Override
    public String getInfo() {
        return "average_of_distance : вывести среднее значение поля distance для всех элементов коллекции.";
    }
}

