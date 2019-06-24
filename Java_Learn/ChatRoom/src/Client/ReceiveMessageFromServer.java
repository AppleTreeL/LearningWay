package Client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @Classname ReceiveMessageFromServer
 * @Description TODO
 * @Date 2019/6/24 11:52
 * @Created by AppleTree
 */
public class ReceiveMessageFromServer extends Thread{
    private final Socket socket;

    public ReceiveMessageFromServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = this.socket.getInputStream(); //获取收入流
            Scanner scanner = new Scanner(in);
            while (true) {
                try {
                        String message = scanner.nextLine();
                    System.out.println("来自服务端: " + message);
                }catch (NoSuchElementException e){
                    break;
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
