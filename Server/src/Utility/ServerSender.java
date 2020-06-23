package Utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Отдаватель
 */
public class ServerSender {
    /**
     * Отправить
     *
     * @param message    сообщенька
     * @param needAnswer нужет ли ответ от клиента
     */
    public static void send(String message, Integer needAnswer) {
        try {
            //Параметр needAnswer: 0 - ответ не нужен, 1 - ждём ответа
            Map<String, Integer> answer = new HashMap<>();
            answer.put(message, needAnswer);
            Object o = answer;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(o);
            answer.clear();
            objectOutputStream.flush();
            byteArrayOutputStream.close();
            objectOutputStream.close();
            byte[] buff = byteArrayOutputStream.toByteArray();
            DatagramSocket datagramSocket = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), CreateServer.currentClientPort);
            datagramSocket.send(dp);
            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}