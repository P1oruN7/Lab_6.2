package Utility;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Получатель
 */
public class ServerReceiver {
  // public static InetSocketAddress socketAddress;
 // public static SocketAddress socketAddress;
    /**
     * Получить
     *
     * @return массивчик байтиков
     */
    public static byte[] receive() {
        try {
            DatagramChannel datagramChannel = CreateServer.datagramChannel;
            ByteBuffer byteBuffer = ByteBuffer.allocate(1000000);
            byte[] bytes = null;
            while (true) {
                // socketAddress = (InetSocketAddress) datagramChannel.receive(byteBuffer);
                 SocketAddress socketAddress = datagramChannel.receive(byteBuffer); //
                 ServerMain.clientAdderss = socketAddress;
                    if (socketAddress != null) {
                        byteBuffer.flip();
                        int limit = byteBuffer.limit();
                        bytes = new byte[limit];
                        byteBuffer.get(bytes, 0, limit);
                        byteBuffer.clear();
                        return bytes;
                    }
                }
        } catch (IOException e) {
            System.out.println("123");
        }
        return new byte[0];
    }
}

