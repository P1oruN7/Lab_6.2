package Readers;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * Абстрактный класс для BufferedReader
 * Наследники: ConsoleSourceReader и FileSourceReader
 */
public abstract class Reader {

    protected BufferedReader bufferedReader;

    public abstract String getLine() throws IOException;

    public void close(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}