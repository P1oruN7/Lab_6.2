package Readers;

import java.io.*;

/**
 * Класс для чтения из файла
 */

public class FileSourceReader extends Reader {

    public FileSourceReader(String path) {
        try {
            File script = new File(path);
            this.bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла. Файл не найден");
        }
    }

    @Override
    public String getLine() {
        try {
            String s = bufferedReader.readLine();
            if (s != null) {
                System.out.print(s + "\n");
            }
            return s;
        } catch (IOException e) {
            System.out.println("Ввод неожиданно прервался");
            return null;
        }
    }

}