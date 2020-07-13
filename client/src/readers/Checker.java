package readers;

/**
 * Класс для проверки вводимых данных на тип
 */

public class Checker {
    /**
     * Проверка на Integer
     *
     * @param s строка
     * @return число (int) или null
     */
    public static Integer intChecker(String s) {
        if (s.equals("") || s == null) {
            System.out.println("Строка не читается или пустая. Попробуйте ещё разок, уверен, в следующий раз обязательно получится!");
            return null;
        }
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * Проверка на Long
     *
     * @param s строка
     * @return число (long) или null
     */
    public static Long longChecker(String s) {
        if (s.equals("") || s == null) {
            System.out.println("Строка не читается или пустая. Попробуйте ещё разок, уверен, в следующий раз обязательно получится!");
            return null;
        }
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Проверка на Float
     *
     * @param s строка
     * @return число (float) или null
     */
    public static Float floatChecker(String s) {
        if (s.equals("") || s == null) {
            System.out.println("Строка не читается или пустая. Попробуйте ещё разок, уверен, в следующий раз обязательно получится!");
            return null;
        }
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Проверка на Double
     *
     * @param s строка
     * @return число (double) или null
     */
    public static Double doubleChecker(String s) {
        if (s.equals("") || s == null) {
            System.out.println("Строка не читается или пустая. Попробуйте ещё разок, уверен, в следующий раз обязательно получится!");
            return null;
        }
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return null;
        }

    }


}
