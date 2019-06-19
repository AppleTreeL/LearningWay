package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea t_1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Button_Click() {
        System.out.println("first");
    }

    public void right_Click(){
        System.out.println(t_1.getAccessibleHelp());
    }
}
