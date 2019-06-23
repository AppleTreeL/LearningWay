package Client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname ClientHandler
 * @Description TODO
 * @Date 2019/6/23 17:27
 * @Created by AppleTree
 */
public class ClientHandler implements Runnable {

    private final static Map<String, Socket> socketMap = new ConcurrentHashMap<>();
    private final Socket client;
    //ssprivate String name;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try{
            InputStream in = this.client.getInputStream();
            Scanner scanner = new Scanner(in);
            while (true) {
                String line = scanner.nextLine();
                if(line.startsWith("register:")){
                    String[] function = line.split(":");
                    if(function.length == 2 && function[0].equals("register")){
                        String name = function[1];
                        socketMap.put(name, this.client);
                        System.out.println(name + "successfully register");
                        sendMessage(this.client, name + "register successfully");
                        for (String it: socketMap.keySet()) {
                            System.out.println(it);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendMessage(Socket client, String s) {
        //TODO
    }
}
