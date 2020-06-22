package Common;

import java.io.IOException;
import java.io.Serializable;

/**
 * Интерфейс Command
 */
public interface Command extends Serializable {
    /**
     * Экзекьюте
     *
     * @param par1 the par 1
     * @throws IOException the io exception
     */
    abstract public void execute(String par1) throws IOException;

    /**
     * Получить немножко информации о команде
     *
     * @return строчечка информации
     */
    abstract public String getInfo();
}

