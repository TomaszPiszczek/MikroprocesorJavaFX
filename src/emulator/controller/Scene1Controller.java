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

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Scene1Controller {
   /**
    * Alert wyświetlany przy walidacji wartości rejestrów
    */

   int []registerValues = new int[8];
   boolean editPressed = false;
   SingletonData registerData = SingletonData.getInstance();
   @FXML
   private TextField AL,AH,BL,BH,CL,CH,DL,DH;



   private void validtationAlert() {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Alert");
      alert.setHeaderText("Podano błędną wartość ");
      alert.showAndWait();
   }
   private Parent root;

   public void switchScene(MouseEvent event) throws IOException {
      root = FXMLLoader.load(getClass().getResource("../view/Scene2.fxml"));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      System.out.println("registerSwitchScene" + registerData.getRegisterName()[0].getText());
   }



   public void inputValidation(int registerNumber,TextField registerValue){
      try
      {
         if(Integer.parseInt(registerValue.getText(),16) > 255 )
         {
            validtationAlert();
            registerValue.setText("");

         }
      }
      catch (Exception e)
      {

         if(!(registerValue.getText().equals("")))
         {
            validtationAlert();
            registerValue.setText("");
         }

      }
   }


   @FXML
   void edytuj() {
      for (TextField t :
              registerData.getRegisterName()) {
         t.setEditable(true);
      }
      editPressed= true;

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


    /*  for (TextField t :
              registerData.getRegisterName()) {
         System.out.println("AL " + t.getText());
         t.setEditable(false);
      }
      for (int t :
              registerData.getRegisterValue()) {
         System.out.println("int" + t);

      }*/
    editPressed=false;
   }


   //generyczne 3001
   @FXML
      public void initialize() {

      if (editPressed == true || registerData.getRegisterName()[0] == null) {
         System.out.println("initalize");
         AL.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(0, AL);

            }
         });

         AH.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(1, AH);

            }
         });

         BL.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(2, BL);

            }
         });
         BH.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(3, BH);

            }
         });

         CL.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(4, CL);

            }
         });

         CH.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(5, CH);

            }
         });

         DL.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(6, DL);

            }
         });

         DH.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) { // focus lost
               inputValidation(7, DH);

            }
         });
      }
      else
      {
         System.out.println("else");
         AL.setText(registerData.getRegisterName()[0].getText());
         AH.setText(registerData.getRegisterName()[1].getText());
         BL.setText(registerData.getRegisterName()[2].getText());
         BH.setText(registerData.getRegisterName()[3].getText());
         CL.setText(registerData.getRegisterName()[4].getText());
         CH.setText(registerData.getRegisterName()[5].getText());
         DL.setText(registerData.getRegisterName()[6].getText());
         DH.setText(registerData.getRegisterName()[7].getText());

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
      }
      if(registerData.getRegisterName()[0] !=null)
      {
         System.out.println(registerData.getRegisterName()[0].getText());

      }
   }




}

