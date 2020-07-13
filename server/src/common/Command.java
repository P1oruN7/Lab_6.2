package common;

import java.io.Serializable;

/**
 * Интерфейс Command
 */
public interface Command extends Serializable {
    /**
     * Экзекьюте
     *
     * @param par1 Входная строка
     */
    abstract public void execute(String par1);

    /**
     * Получить немножко информации о команде
     *
     * @return строчечка информации
     */
    abstract public String getInfo();
}

