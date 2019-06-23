package Client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2019/6/23 12:24
 * @Created by AppleTree
 */
public class SingleClient {

    public static void main(String[] args) {
        int port = 4406;
        String address = "127.0.0.1";
        try {
                Socket socket = new Socket(address, port);
                PrintStream out = new PrintStream(socket.getOutputStream());
            while (true) {
                Scanner in = new Scanner(System.in);
                String message = in.nextLine();
                out.println(message);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
