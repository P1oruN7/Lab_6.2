package common.commands;

import common.*;
import routes.*;
import utility.ServerMain;
import utility.ServerSender;

/**
 * Команда "Добавить-ка ещё!"
 */
public class Add implements Command {
    static boolean hasName = false;  // показывает, было ли добавлено имя элемента
    static boolean hasCoordinates = false; // показывает, было ли добавлено поле coordinates
    static boolean hasFrom = false; //показывает, было ли добавлено поле from
    static boolean hasTo = false; // показывает, было ли добавлено поле to
    static boolean hasDist = false; // показывает, было ли добавлено поле distance

    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для добавления новых элементов в коллекцию
     *
     * @param string строка с полями объекта route
     */
    @Override
    public void execute(String string) {
//        0 - name
//        1 - Coordinate X
//        2 - Coordinate Y
//        3 - Location from X
//        4 - Location from Y
//        5 - Location from name
//        6 - Location to X
//        7 - Location to Y
//        8 - Location to qeqweq
//        9 - distance
        String[] s = string.split(" ");
        Route route = new Route();
        route.setId(ServerMain.c.generateUniqueID());
        route.setCreationDate(java.time.LocalDate.now());
        route.setName(s[0]);
        route.setCoordinates(new Coordinates(Integer.parseInt(s[1]), Float.parseFloat(s[2])));
        if (!s[3].equals("null")) route.setFrom(new Location(Long.parseLong(s[3]), Double.parseDouble(s[4]), s[5]));
        route.setTo(new Location(Long.parseLong(s[6]), Double.parseDouble(s[7]), s[8]));
        if (!s[9].equals("null")) route.setDistance(Float.parseFloat(s[9]));
        ServerMain.c.Routes.add(route);
        ServerSender.send("Объект был добавлен в коллекцию.", 0);
    }

    /**
     * Метод для создания строки
     *
     * @return строка
     */
    public static String makeString() {
        return null;
    }

    /**
     * Метод добавления имени в элемент
     */
    protected static void addName() {
    }

    /**
     * Метод добавления координат в элемент
     */
    protected static void addCoordinates() {
    }

    /**
     * Метод добавления поля from в элемент
     */
    protected static void addFrom() {
    }


    /**
     * Метод добавления поля to в элемент
     */
    protected static void addTo() {
    }

    /**
     * Метод добавления поля distance в элемент
     */
    protected static void addDist() {
    }


    @Override
    public String getInfo() {
        return "add {element} : добавить новый элемент в коллекцию";
    }
}