package Generators;

import java.time.LocalDate;

/**
 * Генератор даты
 */
public class DateGenerator {

    /**
     * Получить актуальную дату
     * @return LocalDate
     */
    public static LocalDate generateCurrentDate() {
        return LocalDate.now();
    }

}
