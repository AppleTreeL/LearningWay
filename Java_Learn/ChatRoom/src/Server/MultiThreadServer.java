package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname MultiThreadServer
 * @Description TODO
 * @Date 2019/6/23 17:11
 * @Created by AppleTree
 */
public class MultiThreadServer  {

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors());
        try {
            System.out.println("server is running...");
            ServerSocket serverSocket = new ServerSocket(4407);
            System.out.println("server is running..." + serverSocket.getLocalSocketAddress());


            while(true){
                final Socket socket = serverSocket.accept();

                System.out.println("Connection from Client" + socket.getRemoteSocketAddress());

                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

}
