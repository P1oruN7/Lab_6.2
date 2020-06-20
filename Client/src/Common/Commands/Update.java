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




    static boolean changedName = false;  // показывает, было ли изменено имя элемента
    static boolean changedCoordinates = false; // показывает, было ли изменено поле coordinates
    static boolean changedFrom = false; //показывает, было ли изменено поле from
    static boolean changedTo = false; // показывает, было ли изменено поле to
    static boolean changedDist = false; // показывает, было ли изменено поле distance
    /**
     * Метод для изменения значений элемента по id
     * @throws IOException
     */
    @Override
        public  void execute (String S) throws IOException {
//                if (s2==null | s2.equals("")) {
//                        System.out.println("кажется вы забыли ввести айди");
//                        return;
//                }
//
//                long id = Checker.longChecker(s2);
//                Route r = c.searchById(id);
//                if (r ==null) {System.out.println("похоже элемента с таким айди не существует");
//                        return;
//                }
//
//               int index =  c.Routes.indexOf(r);
//                Route route = new Route();
//
//                System.out.print("\n" +"Давайте попробуем изменить элемент по введённому айди." + "\n" +
//                        "Раньше его звали \""+ c.Routes.get(index).getName() );
//            while (!changedName) changeName(reader, route);
//                System.out.print("\n" +"Раньше координаты были  "+  c.Routes.get(index).getCoordinates() );
//            while (!changedCoordinates) changeCoordinates(reader, route);
//
//                System.out.print("\n" +"Раньше откуда было "+c.Routes.get(index).getFrom());
//            while (!changedFrom) changeFrom(reader, route);
//                System.out.print("\n" +"Раньше куда было "+c.Routes.get(index).getTo());
//            while (!changedTo) changeTo(reader, route);
//                System.out.print("\n" +"Раньше Distance было "+c.Routes.get(index).getDistance());
//            while (!changedDist) changeDist(reader, route);
//
//            route.setCreationDate(c.Routes.get(index).getCreationDate());
//            Remove_by_id.execute(c,s2);
//            route.setId(id);
//
//            c.Routes.add(route);
//                System.out.println("\n" +"Вы достигли успеха в замене элемента по айди!");
//
//            changedName = false;
//            changedCoordinates = false;
//            changedFrom =false;
//            changedTo = false;
//            changedDist = false;
//
//        }
//
//
//
//    /**
//     * Метод изменения имени в элемент
//     *
//     * @param reader объект - считыватель
//     * @param route  объект
//     * @throws IOException
//     */
//    protected static void changeName(Reader reader, Route route) throws IOException {
//        System.out.print( "\n" + "Как вы хотите, чтобы его звали?  ");
//        String name = reader.getLine()+"";
//        if (name.equals("") ) {
//            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
//            return;
//        }
//        route.setName(name);
//        Update.changedName = true;
//    }
//
//    /**
//     * Метод изменения координат в элемент
//     *
//     * @param reader объект - считыватель
//     * @param route  объект
//     * @throws IOException
//     */
//    protected static void changeCoordinates(Reader reader, Route route) throws IOException {
//        System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "int X = ");
//        String s = reader.getLine()+"";
//        if (s.equals("") ) {
//            System.out.println("Введена пустая строка. Не надо так.");
//            return;
//        }
//        int coordinateX;
//        try {
//            coordinateX = Checker.intChecker(s);
//        } catch (NullPointerException e) {
//            System.out.println("Неправильный тип. Coordinate X должно быть типа int." + "\n Попробуем ещё разок!");
//            return;
//        }
//        if (coordinateX <= -836) {
//            System.out.println("Coordinate x должно быть больше -836");
//            return;
//        }
//
//        System.out.print("float Y = ");
//        float coordinateY;
//        try {
//            coordinateY = Checker.floatChecker(reader.getLine());
//        } catch (NullPointerException e) {
//            System.out.println("Неправильный тип. Coordinate Y должно быть типа float" + "\n Попробуем ещё разок!");
//            return;
//        }
//        if (coordinateY >= 840) {
//            System.out.println("Coordinate y должно быть меньше 840");
//            return;
//        }
//
//        route.setCoordinates(new Coordinates(coordinateX, coordinateY));
//        Update.changedCoordinates = true;
//    }
//
//    /**
//     * Метод изменения поля from в элемент
//     *
//     * @param reader объект - считыватель
//     * @param route  объект
//     * @throws IOException
//     */
//    protected static void changeFrom(Reader reader, Route route) throws IOException {
//        System.out.print("\n" + "Откуда? (from)" + "\n" + "long x = ");
//
//        String s = reader.getLine()+"";
//        if (s.equals("") ) {
//            System.out.println("LocationFrom = null.");
//            Update.changedFrom = true;
//            return;
//        }
//        long locationFromX;
//        try {
//            locationFromX = Checker.longChecker(s);
//        } catch (NullPointerException e) {
//            System.out.println("Неправильный тип. location From (X) должно быть типа long." + "\n Попробуем ещё разок!");
//            return;
//        }
//        System.out.print("double y = ");
//        double locationFromY;
//        s = reader.getLine()+"";
//        if (s.equals("") ) {
//            System.out.println("LocationFrom = null.");
//            Update.changedFrom = true;
//            return;
//        }
//        try {
//            locationFromY = Checker.doubleChecker(s);
//        } catch (NullPointerException e) {
//            System.out.println("Неправильный тип. location From (Y) должно быть типа double." + "\n Попробуем ещё разок!");
//            return;
//        }
//
//        System.out.print("Имя откуда:  ");
//        String locationFromName = reader.getLine()+"";
//        if (locationFromName.equals("")) {
//            System.out.println("LocationFrom = null.");
//            Update.changedFrom = true;
//            return;
//        }
//        route.setFrom(new Location(locationFromX, locationFromY, locationFromName));
//        Update.changedFrom = true;
//    }
//
//
//    /**
//     * Метод изменения поля to в элемент
//     *
//     * @param reader объект - считыватель
//     * @param route  объект
//     * @throws IOException
//     */
//    protected static void changeTo(Reader reader, Route route) throws IOException {
//        System.out.print("\n" + "Куда? (to)" + "\n" + "long x = ");
//        String s = reader.getLine()+"";
//        if (s.equals("") ) {
//            System.out.println("Введена пустая строка. Не надо так.");
//            return;
//        }
//        long locationToX;
//        try {
//            locationToX = Checker.longChecker(s);
//        } catch (NullPointerException e) {
//            System.out.println("Неправильный тип. location To (X) должно быть типа long." + "\n Попробуем ещё разок!");
//            return;
//        }
//
//        System.out.print("double y = ");
//        double locationToY;
//        try {
//            locationToY = Checker.doubleChecker(reader.getLine());
//        } catch (NullPointerException e) {
//            System.out.println("Неправильный тип. location To (Y) должно быть типа double." + "\n Попробуем ещё разок!");
//            return;
//        }
//
//        System.out.print("Имя куда:  ");
//        String locationToName = reader.getLine()+"";
//        if (locationToName.equals("") ) {
//            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
//            return;
//        }
//
//        route.setTo(new Location(locationToX, locationToY, locationToName));
//        Update.changedTo = true;
//    }
//
//    /**
//     * Метод изменения поля distance в элемент
//     *
//     * @param reader объект - считыватель
//     * @param route  объект
//     * @throws IOException
//     */
//    protected static void changeDist(Reader reader, Route route) throws IOException {
//        System.out.print("\n" + "Давай посмотрим, что у нас там с Distance. (float)  ");
//        String s = reader.getLine()+"";
//        if (s.equals("")) {
//            System.out.println("Теперь distance = null. Надеемся, вы именно этого и добивались.");
//            Update.changedDist = true;
//            return;
//        }
//        float distance;
//        try {
//            distance = Checker.floatChecker(s);
//        } catch (NullPointerException e) {
//            System.out.println("Неправильный тип. distance должно быть типа float." + "\n Попробуем ещё разок!");
//            return;
//        }
//        if (!(distance > 1)) {
//            System.out.println("Значение Distance должно быть больше 1");
//            return;
//        }
//        route.setDistance(distance);
//        Update.changedDist = true;
    }
    @Override
    public String getInfo() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному.";
    }
}
