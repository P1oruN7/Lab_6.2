package Common.Commands;
import Common.*;
import Readers.*;
import java.io.IOException;

/**
 * Команда "Добавить-ка ещё!"
 */

public class Add implements Command {
    static boolean hasName = false;  // показывает, было ли добавлено имя элемента
    static boolean hasCoordinates = false; // показывает, было ли добавлено поле coordinates
    static boolean hasFrom = false; //показывает, было ли добавлено поле from
    static boolean hasTo = false; // показывает, было ли добавлено поле to
    static boolean hasDist = false; // показывает, было ли добавлено поле distance

    static String name = null;
    static String coordinateX = null;
    static String coordinateY = null;
    static String LocationFromX = null;
    static String LocationFromY = null;
    static String LocationFromName = null;
    static String LocationToX = null;
    static String LocationToY = null;
    static String LocationToName = null;
    static String distance = null;

    public Add(){
        Invoker.regist("add",this);
    }

    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для добавления новых элементов в коллекцию
     */
    @Override
    public void execute(String s) { }

    public static String makeString () throws IOException{
        while (!hasName) addName();
        while (!hasCoordinates) addCoordinates();
        while (!hasFrom) addFrom();
        while (!hasTo) addTo();
        while (!hasDist) addDist();
        String s = name + " " + coordinateX + " " + coordinateY + " " + LocationFromX + " " + LocationFromY + " " + LocationFromName + " " +
                LocationToX + " " + LocationToY + " " + LocationToName + " " + distance;
        boolean hasName = false;
        boolean hasCoordinates = false;
        boolean hasFrom = false;
        boolean hasTo = false;
        boolean hasDist = false;
        Add.name = null;
        Add.coordinateX = null;
        Add.coordinateY = null;
        Add.LocationFromX = null;
        Add.LocationFromY = null;
        Add.LocationFromName = null;
        Add.LocationToX = null;
        Add.LocationToY = null;
        Add.LocationToName = null;
        Add.distance = null;

        return s;
    }

    /**
     * Метод добавления имени в элемент
     *
     */
    protected static void addName() throws IOException {
        System.out.print( "\n" + "Как вы хотите, чтобы его звали?  ");
        String name = Utility.ClientMain.reader.readLine()+"";
        if (name.equals("") ) {
            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
            return;
        }
        Add.name = name;
        hasName = true;
    }

    /**
     * Метод добавления координат в элемент
     *
     */
    protected static void addCoordinates() throws IOException {
        System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "int X = ");
        String s = Utility.ClientMain.reader.readLine()+"";
        if (s.equals("") ) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        Integer coordinateX;
        try {
            coordinateX = Checker.intChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate X должно быть типа int." + "\n Попробуем ещё разок!");
            return;
        }
        if ((int)coordinateX <= -836) {
            System.out.println("Coordinate x должно быть больше -836");
            return;
        }

        System.out.print("float Y = ");
        Float coordinateY;
        try {
            coordinateY = Checker.floatChecker(Utility.ClientMain.reader.readLine());
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate Y должно быть типа float" + "\n Попробуем ещё разок!");
            return;
        }
        if ((float)coordinateY >= 840 ) {
            System.out.println("Coordinate y должно быть меньше 840");
            return;
        }
        Add.coordinateX = coordinateX.toString();
        Add.coordinateY = coordinateY.toString();
        hasCoordinates = true;
    }

    /**
     * Метод добавления поля from в элемент
     *
     */
    protected static void addFrom() throws IOException {
        System.out.print("\n" + "Откуда? (from)" + "\n" + "long x = ");

        String s = Utility.ClientMain.reader.readLine()+"";
        if (s.equals("") ) {
            System.out.println("LocationFrom = null.");
            hasFrom = true;
            return;
        }
        Long locationFromX;
        try {
            locationFromX = Checker.longChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. location From (X) должно быть типа long." + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("double y = ");
        Double locationFromY;
        s =Utility.ClientMain.reader.readLine()+"";
        if (s.equals("") ) {
            System.out.println("LocationFrom = null.");
            hasFrom = true;
            return;
        }
        try {
            locationFromY = Checker.doubleChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. location From (Y) должно быть типа double." + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("Имя откуда:  ");
        String locationFromName = Utility.ClientMain.reader.readLine()+"";
        if (locationFromName.equals("")) {
            System.out.println("LocationFrom = null.");
            hasFrom = true;
            return;
        }
        Add.LocationFromX = locationFromX.toString();
        Add.LocationFromY = locationFromY.toString();
        Add.LocationFromName = locationFromName;
        hasFrom = true;
    }

    /**
     * Метод добавления поля to в элемент
     *
     */
    protected static void addTo() throws IOException {
        System.out.print("\n" + "Куда? (to)" + "\n" + "long x = ");
        String s = Utility.ClientMain.reader.readLine()+"";
        if (s.equals("") ) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        Long locationToX;
        try {
            locationToX = Checker.longChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. location To (X) должно быть типа long." + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("double y = ");
        Double locationToY;
        try {
            locationToY = Checker.doubleChecker(Utility.ClientMain.reader.readLine());
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. location To (Y) должно быть типа double." + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("Имя куда:  ");
        String locationToName = Utility.ClientMain.reader.readLine()+"";
        if (locationToName.equals("") ) {
            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
            return;
        }
        Add.LocationToX = locationToX.toString();
        Add.LocationToY = locationToY.toString();
        Add.LocationToName = locationToName;
        hasTo = true;

    }

    /**
     * Метод добавления поля distance в элемент
     *
     */
    protected static void addDist() throws IOException {
        System.out.print("\n" + "Давай посмотрим, что у нас там с Distance. (float)  ");
        String s = Utility.ClientMain.reader.readLine()+"";
        if (s.equals("")) {
            System.out.println("Теперь distance = null");
            hasDist = true;
            return;
        }
        Float distance;
        try {
            distance = Checker.floatChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. distance должно быть типа float." + "\n Попробуем ещё разок!");
            return;
        }
        if (!(distance > 1)) {
            System.out.println("Значение Distance должно быть больше 1");
            return;
        }
        Add.distance = distance.toString();
        hasDist = true;
    }
    @Override
    public String getInfo() {
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
