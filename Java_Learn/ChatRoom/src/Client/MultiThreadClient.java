package Client;

import java.io.IOException;
import java.net.Socket;

/**
 * @Classname MultiClient
 * @Description TODO
 * @Date 2019/6/24 11:47
 * @Created by AppleTree
 */
public class MultiThreadClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 4407);
            new SendMessageToServer(socket).start();
            new ReceiveMessageFromServer(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
