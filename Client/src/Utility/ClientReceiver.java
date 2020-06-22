package Utility;

import java.io.*;
import java.net.*;
import java.util.Map;
/**
 * Получатель
 */
public class ClientReceiver {
    public static DatagramSocket sock;
    public static int clientport;
    public static Map<String, Integer> answer;

    /**
     * Получить
     * @return массивчик байтиков
     */
    public static void receive() throws SocketTimeoutException {
        byte[] buffer = new byte[1000000];
        try {
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            sock.setSoTimeout(5000);
            sock.receive(reply);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(reply.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object obj = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            answer = (Map<String, Integer>) obj;
            if (answer.entrySet().iterator().next().getValue() == 0) {
                System.out.println("Ответ с сервера: " + answer.entrySet().iterator().next().getKey());
            } else if (answer.entrySet().iterator().next().getValue() == 1) {
                System.out.println("Ответ с сервера: " + answer.entrySet().iterator().next().getKey());
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String s = reader.readLine();
                ClientSender.send(s);
                ClientReceiver.receive();
            } else if (answer.entrySet().iterator().next().getValue() == 2) {
                System.out.println("Ответ с сервера: " + answer.entrySet().iterator().next().getKey());
                ClientReceiver.receive();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            System.out.println("Возможно сервер занят или выключен,попробуйте ещё раз.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
