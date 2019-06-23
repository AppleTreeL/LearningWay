package Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Classname Server
 * @Description TODO
 * @Date 2019/6/23 12:33
 * @Created by AppleTree
 */
public class SingleServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Server is runing");
            serverSocket = new ServerSocket(4406);
            Socket client = null;
            Scanner clientGet = null;
                client = serverSocket.accept();
            while (true) {
                InputStream in = client.getInputStream();
                clientGet = new Scanner(in);
                System.out.println(client.getLocalAddress() + "say that  " + clientGet.nextLine());
                if(clientGet.nextLine().equals("bye")) break;
            }
            clientGet.close();
            client.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
