package Readers;

/**
 * Класс для разделения строки
 */
public class CommandArgumentSplitter {
    /**
     * Метод для разделения вводимой строки на две и удаления пробелов
     *
     * @param readLine строка
     * @return массив строк из двух элементов или null
     */
    public static String[] comArgSplitter(String readLine) {

        if (readLine != null && !readLine.equals("")) {

            readLine = readLine.trim();
            String[] ComArg = readLine.split(" ", 2);

            if (ComArg.length == 2) {
                ComArg[1] = ComArg[1].trim();
                return ComArg;
            } else
                return new String[]{ComArg[0], ""};

        }

        System.out.println("\n" + "Вы не ввели команду. Попробуйте еще раз");
        return null;

    }

}
