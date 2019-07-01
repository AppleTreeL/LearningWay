package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    private String message;

    @FXML
    private Button send;

    @FXML
    private TextArea recordArea;

    @FXML
    private TextArea recordCilent;

    @FXML
    private TextArea inputArea;

    @FXML
    private Label image;

    @FXML
    private Button onStart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //image set
        try {
            InputStream in = new FileInputStream("D:\\_TestCode\\ClienrUI\\resource\\下载.jpg");
            Image im = new Image(in);
            image.setBackground(new Background(new BackgroundImage(im, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100,
                    true, true, true, true))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
        message = inputArea.getText();
        //recordArea.appendText(message + "\n");
    }

    public void onStart() {
        try {
            Socket socket = new Socket("127.0.0.1", 4407);
            new SendMessageToServer(socket).start();
            new ReceiveMessageFromServer(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SendMessageToServer extends Thread {
        private final Socket socket;

        public SendMessageToServer(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream out = this.socket.getOutputStream();
                PrintStream printStream = new PrintStream(out);
                while (true) {
                    //message = inputArea.getText();
                    recordArea.appendText("我说: " + message + "\n");
                    printStream.println(message);
                    printStream.flush();
                    if (message.equals("quit")) {
                        break;
                    }
                }
                this.socket.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }

    private class ReceiveMessageFromServer extends Thread{
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
                        recordArea.appendText("来自服务端: " + message + "\n");
                    }catch (NoSuchElementException e){
                        break;
                    }
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }
}