package emulator.controller;

import emulator.data.SingletonData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Scene1Controller {
   /**
    * Alert wyświetlany przy walidacji wartości rejestrów
    */


   boolean editPressed = false;
   SingletonData registerData = SingletonData.getInstance();
   @FXML
   private TextField AL,AH,BL,BH,CL,CH,DL,DH;

   TextField []registerTemp = new TextField[8];



   private void validtationAlert(String alertT) {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Alert");
      alert.setHeaderText(alertT);
      alert.showAndWait();
   }

   public void switchScene(MouseEvent event) throws IOException {
      for (int i = 0; i < 8; i++) {
         if(registerData.getRegisterName()[0]==null)
         {
            validtationAlert("Nie ustawiono wszystkich rejestrów");
            break;
         }
      }
      Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Scene2.fxml")));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();


   }



   public void inputValidation(TextField registerValue){
      try
      {
         if(Integer.parseInt(registerValue.getText(),16) > 255  || Integer.parseInt(registerValue.getText(),16) <0 )
         {
            validtationAlert("Podano złą wartość");
            registerValue.setText("");

         }
      }
      catch (Exception e)
      {

         if(!(registerValue.getText().equals("")))
         {
            validtationAlert("Podano złą wartość");
            registerValue.setText("");
         }

      }
   }


   @FXML
   void edytuj() {
      editPressed=true;
      AL.setEditable(true);
      AH.setEditable(true);
      BL.setEditable(true);
      BH.setEditable(true);
      CL.setEditable(true);
      CH.setEditable(true);
      DL.setEditable(true);
      DH.setEditable(true);
      initialize();

   }

   @FXML
   void zatwierdz() {


      registerData.setRegisterName(0,AL);
      registerData.setRegisterName(1,AH);
      registerData.setRegisterName(2,BL);
      registerData.setRegisterName(3,BH);
      registerData.setRegisterName(4,CL);
      registerData.setRegisterName(5,CH);
      registerData.setRegisterName(6,DL);
      registerData.setRegisterName(7,DH);


      registerData.setRegisterValue(0, Integer.parseInt(AL.getText(),16));
      registerData.setRegisterValue(1, Integer.parseInt(AH.getText(),16));
      registerData.setRegisterValue(2, Integer.parseInt(BL.getText(),16));
      registerData.setRegisterValue(3, Integer.parseInt(BH.getText(),16));
      registerData.setRegisterValue(4, Integer.parseInt(CL.getText(),16));
      registerData.setRegisterValue(5, Integer.parseInt(CH.getText(),16));
      registerData.setRegisterValue(6, Integer.parseInt(DL.getText(),16));
      registerData.setRegisterValue(7, Integer.parseInt(DH.getText(),16));

      AL = registerData.getRegisterName()[0];
      AH = registerData.getRegisterName()[1];
      BL = registerData.getRegisterName()[2];
      BH = registerData.getRegisterName()[3];
      CL = registerData.getRegisterName()[4];
      CH = registerData.getRegisterName()[5];
      DL = registerData.getRegisterName()[6];
      DH = registerData.getRegisterName()[7];



      for (TextField t :
              registerData.getRegisterName()) {
         t.setEditable(false);
      }
    editPressed=false;
   }

   @FXML
   void loadData(MouseEvent event) throws IOException, ClassNotFoundException {
      registerData.setRegisterName(0,AL);
      registerData.setRegisterName(1,AH);
      registerData.setRegisterName(2,BL);
      registerData.setRegisterName(3,BH);
      registerData.setRegisterName(4,CL);
      registerData.setRegisterName(5,CH);
      registerData.setRegisterName(6,DL);
      registerData.setRegisterName(7,DH);

      File dataFile = new File("RegisterData\\data.txt");
      int i=0;
      Scanner scanner = new Scanner(dataFile);
      while (scanner.hasNextLine())
      {

         registerData.setRegisterNameValue(i,scanner.nextLine());
         Logger.global.info("rejestr od " + i + " " +   registerData.getRegisterName()[i].getText());
         i++;
      }

      scanner.close();
      initialize();
   }


   //generyczne 3001
   @FXML
      public void initialize() {

      if (editPressed || registerData.getRegisterName()[0] == null) {
         AL.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(AL);

            }
         });

         AH.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(AH);

            }
         });

         BL.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(BL);

            }
         });
         BH.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(BH);

            }
         });

         CL.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(CL);

            }
         });

         CH.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(CH);

            }
         });

         DL.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(DL);

            }
         });

         DH.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(DH);

            }
         });
      }
      else
      {
         AL.setText(registerData.getRegisterName()[0].getText());
         AH.setText(registerData.getRegisterName()[1].getText());
         BL.setText(registerData.getRegisterName()[2].getText());
         BH.setText(registerData.getRegisterName()[3].getText());
         CL.setText(registerData.getRegisterName()[4].getText());
         CH.setText(registerData.getRegisterName()[5].getText());
         DL.setText(registerData.getRegisterName()[6].getText());
         DH.setText(registerData.getRegisterName()[7].getText());

         AL.setEditable(false);
         AH.setEditable(false);
         BL.setEditable(false);
         BH.setEditable(false);
         CL.setEditable(false);
         CH.setEditable(false);
         DL.setEditable(false);
         DH.setEditable(false);


      }

   }




}

