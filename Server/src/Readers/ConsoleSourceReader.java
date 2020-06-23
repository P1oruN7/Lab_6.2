package Readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс для чтения из консоли
 */
public class ConsoleSourceReader extends Reader {

    public ConsoleSourceReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Ввод неожиданно прервался");
            return null;
        }
    }
}
