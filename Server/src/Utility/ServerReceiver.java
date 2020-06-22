package Utility;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Получатель
 */
public class ServerReceiver {
    /**
     * Получить
     * @return массивчик байтиков
     */
    public static byte[] receive() {
        try {
            DatagramChannel datagramChannel = CreateServer.datagramChannel;
            ByteBuffer byteBuffer = ByteBuffer.allocate(1000000);
            byte[] bytes = null;
            while (true) {
                InetSocketAddress socketAddress = (InetSocketAddress) datagramChannel.receive(byteBuffer);
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

        }
        return new byte[0];
    }
}

