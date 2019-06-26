package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
    private String name;

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

                //用户注册
                if(line.startsWith("register")){
                    String[] function = line.split(":");
                    if(function.length == 2 && function[0].equals("register")){
                        this.name = function[1];
                        socketMap.put(this.name, this.client);
                        System.out.println(this.name + " successfully register");
                        sendMessage(this.client, this.name + " register successfully");
                        printOnlineClient();
                    }
                    continue;
                }

                //群聊的实现
                if(line.startsWith("groupchat")){
                    String[] function = line.split(":");
                    if(function.length == 2 && function[0].equals("groupchat")){
                        for(Map.Entry<String, Socket> entry: socketMap.entrySet()){
                            if(entry.getValue() != this.client) {
                                sendMessage(entry.getValue(), this.name+"say that: "+function[1]);
                                printOnlineClient();
                            }
                        }
                    }
                    continue;
                }

                //私聊的实现
                if(line.startsWith("privatechat")){
                    String[] function = line.split(":");
                    if(function.length == 3 && function[0].equals("privatechat")){
                        if(socketMap.get(function[1]) != null)
                            sendMessage(socketMap.get(function[1]),this.name + "say that: " + function[2]);
                    }
                    continue;
                }

                //下线的实现
                if(line.startsWith("quit")){
                    //String[] function = line.split(":");
                    socketMap.remove(this.name);
                    System.out.println(this.name + "下线了");
                    printOnlineClient();
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printOnlineClient(){
        System.out.println("当前在线的用户有");
        for (String it: socketMap.keySet()) {
            System.out.println(it);
        }
    }


    /**
     * send message to selected client
     * @param client , a pointed client
     * @param s, a message you want to send
     */
    private void sendMessage(Socket client, String s) {
        try {
            OutputStream out = client.getOutputStream();
            PrintStream send = new PrintStream(out);
            send.println(s);
            send.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
