package Common;

import java.io.*;
import java.util.Scanner;

/**
 * The type File read.
 */
public class FileRead {
    private static final String envPath = "CollectionOfTickets.csv";

    /**
     * Get file path string.
     *
     * @return the string
     */
    public static String getFilePath(){
        return envPath;
    }

    /**
     * Read from file string.
     *
     * @param filePath the file path
     * @return the string
     * @throws FileNotFoundException the file not found exception
     */
    public static String readFromFile(String filePath) throws FileNotFoundException  {
        String data = "";
        try {
            Reader fileReader = new FileReader(filePath);
            while (fileReader.ready())
                data += (char) fileReader.read();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Read from console string.
     *
     * @return the string
     */
    public static String readFromConsole() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}


