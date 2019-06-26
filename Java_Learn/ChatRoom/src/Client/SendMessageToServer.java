package Client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Classname SendMesageToServer
 * @Description TODO
 * @Date 2019/6/24 12:00
 * @Created by AppleTree
 */
public class SendMessageToServer extends Thread {
    private final Socket socket;

    public SendMessageToServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream out = this.socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("please input: ");
                String message = scanner.nextLine();
                printStream.println(message);
                printStream.flush();
                if(message.equals("quit")){
                    break;
                }
            }
            this.socket.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
