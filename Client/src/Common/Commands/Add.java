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

    public Add() {
        Invoker.regist("add", this);
    }

    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * Метод для добавления новых элементов в коллекцию
     */
    @Override
    public void execute(String s) {
    }


    /**
     * Метод для создания строки
     *
     * @return строка
     */
    public static String makeString() {

        while (!hasName) addName();
        while (!hasCoordinates) addCoordinates();
        while (!hasFrom) addFrom();
        while (!hasTo) addTo();
        while (!hasDist) addDist();
        String s = name + " " + coordinateX + " " + coordinateY + " " + LocationFromX + " " + LocationFromY + " " + LocationFromName + " " +
                LocationToX + " " + LocationToY + " " + LocationToName + " " + distance;
        hasName = false;
        hasCoordinates = false;
        hasFrom = false;
        hasTo = false;
        hasDist = false;
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
     */
    protected static void addName() {
        try {
            System.out.print("\n" + "Как вы хотите, чтобы его звали?  ");
            String name = Utility.ClientMain.reader.readLine() + "";
            if (name.equals("")) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }
            Add.name = name;
            hasName = true;
        } catch (IOException e) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            return;
        }
    }
    /**
     * Метод добавления координат в элемент
     */
    protected static void addCoordinates() {
        try {
            System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "int X = ");
            String s = Utility.ClientMain.reader.readLine() + "";
            if (s.equals("")) {
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
            if ((int) coordinateX <= -836) {
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
            if ((float) coordinateY >= 840) {
                System.out.println("Coordinate y должно быть меньше 840");
                return;
            }
            Add.coordinateX = coordinateX.toString();
            Add.coordinateY = coordinateY.toString();
            hasCoordinates = true;
        }
         catch (IOException e ) {
                System.out.println("Ошибка ввода.");
            } catch (Exception e ) {
            return;
        }
    }

    /**
     * Метод добавления поля from в элемент
     */
    protected static void addFrom() {
        try {
            System.out.print("\n" + "Откуда? (from)" + "\n" + "long x = ");

            String s = Utility.ClientMain.reader.readLine() + "";
            if (s.equals("")) {
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
            s = Utility.ClientMain.reader.readLine() + "";
            if (s.equals("")) {
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
            String locationFromName = Utility.ClientMain.reader.readLine() + "";
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
        catch (IOException e ) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            return;
        }
    }

    /**
     * Метод добавления поля to в элемент
     */
    protected static void addTo() {
        try {
            System.out.print("\n" + "Куда? (to)" + "\n" + "long x = ");
            String s = Utility.ClientMain.reader.readLine() + "";
            if (s.equals("")) {
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
            String locationToName = Utility.ClientMain.reader.readLine() + "";
            if (locationToName.equals("")) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }
            Add.LocationToX = locationToX.toString();
            Add.LocationToY = locationToY.toString();
            Add.LocationToName = locationToName;
            hasTo = true;
        }
        catch (IOException e ) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            return;
        }
    }

    /**
     * Метод добавления поля distance в элемент
     */
    protected static void addDist() {
        try {
            System.out.print("\n" + "Давай посмотрим, что у нас там с Distance. (float)  ");
            String s = Utility.ClientMain.reader.readLine() + "";
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
        } catch (IOException e ) {
            System.out.println("Ошибка ввода.");
        } catch (Exception e ) {
            return;
        }
    }

    @Override
    public String getInfo() {
        return "add {element} : добавить новый элемент в коллекцию";
    }


    /**
     * Метод для создания строки
     *
     * @param s массив строчек
     * @return строка
     */
    public static String makeString(String[] s){
        while (!hasName) addName(s[0]);
        System.out.println("name = " + name);
        while (!hasCoordinates) addCoordinates(s[1], s[2]);
        System.out.println("coordinate X = " + coordinateX + "\ncoordinate Y = " + coordinateY);
        while (!hasFrom) addFrom(s[3], s[4], s[5]);
        System.out.println("Location From X = " + LocationFromX + "\nLocation From Y = " + LocationFromY + "\nLocation From Name = " + LocationFromName);
        while (!hasTo) addTo(s[6], s[7], s[8]);
        System.out.println("Location To X = " + LocationToX + "\nLocation To Y = " + LocationToY + "\nLocation To Name = " + LocationToName);
        while (!hasDist) addDist(s[9]);
        System.out.println("distance = " + distance);
        String s1 = name + " " + coordinateX + " " + coordinateY + " " + LocationFromX + " " + LocationFromY + " " + LocationFromName + " " +
                LocationToX + " " + LocationToY + " " + LocationToName + " " + distance;
        hasName = false;
        hasCoordinates = false;
        hasFrom = false;
        hasTo = false;
        hasDist = false;
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

        return s1;
    }


    /**
     * Метод добавления имени в элемент
     *
     * @param s строка
     */
    protected static void addName(String s) {
        try {
            String name = s;
            if (name.equals("") | name == null) {
                return;
            }
            Add.name = name;
            hasName = true;
        } catch (Exception e ) {
            return;
        }
    }

    /**
     * Метод добавления координат в элемент
     *
     * @param s0 координата X
     * @param s1 координата Y
     */
    protected static void addCoordinates(String s0, String s1) {
        try {
            Integer coordinateX;
            try {
                coordinateX = Checker.intChecker(s0);
            } catch (NullPointerException e) {
                return;
            }
            if ((int) coordinateX <= -836) {
                return;
            }
            Float coordinateY;
            try {
                coordinateY = Checker.floatChecker(s1);
            } catch (NullPointerException e) {
                return;
            }
            if ((float) coordinateY >= 840) {
                return;
            }
            Add.coordinateX = coordinateX.toString();
            Add.coordinateY = coordinateY.toString();
            hasCoordinates = true;
        } catch (Exception e) {
            return;
        }
    }
    /**
     * Метод добавления поля from в элемент
     *
     * @param s0 Loc From X
     * @param s1 Loc From Y
     * @param s2 Loc From Name
     */
    protected static void addFrom(String s0, String s1, String s2) {
        try {
            if (s0.toLowerCase().trim().equals("null") | s0.toLowerCase().trim().equals("")) {
                hasFrom = true;
                return;
            }
            Long locationFromX;
            try {
                locationFromX = Checker.longChecker(s0);
            } catch (NullPointerException e) {
                return;
            }

            Double locationFromY;
            if (s1.toLowerCase().trim().equals("null") | s1.toLowerCase().trim().equals("")) {
                hasFrom = true;
                return;
            }
            try {
                locationFromY = Checker.doubleChecker(s1);
            } catch (NullPointerException e) {
                return;
            }

            if (s2.trim().equals("")) {
                hasFrom = true;
                return;
            }
            Add.LocationFromX = locationFromX.toString();
            Add.LocationFromY = locationFromY.toString();
            Add.LocationFromName = s2;
            hasFrom = true;
        } catch (Exception e) {
            return;
        }
    }

    /**
     * Метод добавления поля to в элемент
     *
     * @param s0 Loc To X
     * @param s1 Loc To Y
     * @param s2 Loc To Name
     */
    protected static void addTo(String s0, String s1, String s2) {
        try {
            if (s0.trim().equals("")) {
                return;
            }
            Long locationToX;
            try {
                locationToX = Checker.longChecker(s0);
            } catch (NullPointerException e) {
                return;
            }

            Double locationToY;
            if (s1.trim().equals("")) {
                return;
            }
            try {
                locationToY = Checker.doubleChecker(s1);
            } catch (NullPointerException e) {
                return;
            }

            if (s2.trim().equals("")) {
                return;
            }
            Add.LocationToX = locationToX.toString();
            Add.LocationToY = locationToY.toString();
            Add.LocationToName = s2;
            hasTo = true;

        } catch (Exception e) {
            return;
        }
    }

    /**
     * Метод добавления поля distance в элемент
     *
     * @param s собсна строчечка со значением dist
     */
    protected static void addDist(String s) {
        try {
            if (s.trim().equals("") | s.toLowerCase().trim().equals("null")) {
                hasDist = true;
                return;
            }
            Float distance;
            try {
                distance = Checker.floatChecker(s);
            } catch (NullPointerException e) {
                return;
            }
            if (!(distance > 1)) {
                return;
            }
            Add.distance = distance.toString();
            hasDist = true;
        } catch (Exception e) {
            return;
        }
    }
}
