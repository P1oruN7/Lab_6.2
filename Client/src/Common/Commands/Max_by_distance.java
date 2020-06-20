package Common.Commands;
import Common.*;
import Routes.Route;
//import Utility.ServerMain;

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
//                boolean first = true;
//        if (ServerMain.c.Routes.size() > 0) {
//                Route maxRoutebyDist = null;
//                for (Route r: ServerMain.c.Routes) {
//                        if (r.getDistance()!= null & first) {
//                                maxRoutebyDist = r;
//                                first = false;
//                        }
//                    if (r.getDistance()!=null) {
//                            if (r.getDistance()>maxRoutebyDist.getDistance() ) maxRoutebyDist = r;
//                    }
//                }
//                System.out.println(maxRoutebyDist);
//        } else
//        System.out.println("Коллекция пуста как моё сердце");
        }
        @Override
        public String getInfo() {
                return "max_by_distance: вывести любой объект из коллекции, значение поля distance которого является максимальным";
        }

}

