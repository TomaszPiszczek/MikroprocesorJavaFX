package emulator.controller;

import emulator.data.SingletonData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Scene2Controller {
    private Parent root;
    SingletonData registerData = SingletonData.getInstance();

    public void switchScene(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../view/Scene1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("registerSwitchScene 1" + registerData.getRegisterName()[0].getText());


    }

    @FXML
    void ADD(MouseEvent event) {
    }

    @FXML
    void AND(MouseEvent event) {
    }

    @FXML
    void DEC(MouseEvent event) {
    }

    @FXML
    void INC(MouseEvent event) {
    }

    @FXML
    void MOV(MouseEvent event) {
    }

    @FXML
    void NOT(MouseEvent event) {
    }

    @FXML
    void OR(MouseEvent event) {
    }

    @FXML
    void SUB(MouseEvent event) {
    }

    @FXML
    void XCHG(MouseEvent event) {
    }

    @FXML
    void XOR(MouseEvent event) {
    }

    @FXML
    void register1(MouseEvent event) {
    }

    @FXML
    void register2(MouseEvent event) {
    }
}
