package Common;

import java.io.Serializable;

/**
 * Интерфейс Command
 */
public interface Command extends Serializable {
    /**
     * Экзекьюте
     *
     * @param par1 the par 1
     */
    abstract public void execute(String par1);

    /**
     * Получить немножко информации о команде
     *
     * @return строчечка информации
     */
    abstract public String getInfo();
}

