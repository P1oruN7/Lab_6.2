package Exceptions;

/**
 * Исключение для того самого момента, когда файл не нашёлся
 */
public class FileNotFoundException extends java.io.FileNotFoundException {
    @Override
    public String getMessage(){
       return "Кажется такого файла там нет";
    }
 }
