package Utility;

import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;
public class CreateServer {
    public static boolean serverIsAvaible = true;
    public static int currentClientPort = 0;
    public static DatagramChannel datagramChannel;
    public static void create() throws IOException {
        SocketAddress it = new InetSocketAddress(InetAddress.getLocalHost(), 1489);
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        try {
            dc.bind(it);
        } catch (BindException e){
            System.out.println("Данный порт уже занят,возможно сервер уже запущен.\n Принудительно завершаю работу.");
            System.exit(0);
        }
        datagramChannel = dc;
    }
}
