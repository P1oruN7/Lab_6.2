package utility;

import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;

/**
 * В начале был сервер...
 */
public class CreateServer {
    public static boolean serverIsAvaible = true;
    public static int currentClientPort = 0;
    public static DatagramChannel datagramChannel;

    /**
     * Создание сервера
     */
    public static boolean create() {
        try {
            SocketAddress it = new InetSocketAddress(InetAddress.getLocalHost(), ServerMain.port);
            DatagramChannel dc = DatagramChannel.open();
            dc.configureBlocking(false);
            dc.bind(it);
            datagramChannel = dc;
        } catch (IOException | java.lang.IllegalArgumentException e) {
            System.out.println("Данный порт не может быть использован.");
            return false;
        }
        return true;
    }
}
