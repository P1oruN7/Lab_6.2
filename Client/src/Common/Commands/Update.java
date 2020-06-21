package Common.Commands;
import Common.*;
import Readers.*;
import Routes.Coordinates;
import Routes.Location;
import Routes.Route;
import Utility.*;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Map;

/**
 * Команда  "ПРАВКИ!"
 */
public class Update implements Command {
    static boolean changedName = false;  // показывает, было ли изменено имя элемента
    static boolean changedCoordinates = false; // показывает, было ли изменено поле coordinates
    static boolean changedFrom = false; //показывает, было ли изменено поле from
    static boolean changedTo = false; // показывает, было ли изменено поле to
    static boolean changedDist = false; // показывает, было ли изменено поле distance
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для изменения значений элемента по id
     * @throws IOException
     */
    @Override
        public  void execute (String s) {
                s = s.trim();
                Long id = Checker.longChecker(s);
                Route r = ServerMain.c.searchById(id);
                if (r ==null) {
                    ServerSender.send("похоже элемента с таким айди не существует",0);
                    return;
                }
                int index =  ServerMain.c.Routes.indexOf(r);
               ServerSender.send("Состояние элемента сейчас: " + ServerMain.c.Routes.get(index).toString(),0);
               Route route = new Route();
               route.setCreationDate(ServerMain.c.Routes.get(index).getCreationDate());
               String s2 = new String( ServerReceiver.receive() );
               String [] arrayOfStrings = s2.split(" ");
               route.setId(id);
               route.setName(arrayOfStrings[0]);
               route.setCoordinates(new Coordinates(Integer.parseInt(arrayOfStrings[1]), Float.parseFloat(arrayOfStrings[2])));
              if (!arrayOfStrings[3].equals("null") ) route.setFrom(new Location(Long.parseLong(arrayOfStrings[3]), Double.parseDouble(arrayOfStrings[4]), arrayOfStrings[5]));
               route.setTo(new Location(Long.parseLong(arrayOfStrings[6]), Double.parseDouble(arrayOfStrings[7]), arrayOfStrings[8]));
              if (!arrayOfStrings[9].equals("null") ) route.setDistance(Float.parseFloat(arrayOfStrings[9]));
               Remove_by_id remove_by_id = new Remove_by_id();
               remove_by_id.execute(s);
               ServerMain.c.Routes.add(route);
               ServerSender.send("\n" +"Вы достигли успеха в замене элемента по айди!",0);
    }
    @Override
    public String getInfo() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному.";
    }
}
