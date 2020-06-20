package Generators;

/**
 * Генератор id
 */
public class IDGenerator {
    /**
     * Метод для создания id
     * @return id (Long)
     */
    public static long generateNewID(){
        return (long) (1 + Math.random() * (Long.MAX_VALUE - 1));
    }

}
