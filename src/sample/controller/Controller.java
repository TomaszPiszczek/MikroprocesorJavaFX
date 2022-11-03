package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

   private void showAlertWithHeaderText() {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Test Connection");
      alert.setHeaderText("Results:");
      alert.setContentText("Connect to the database successfully!");

      alert.showAndWait();
   }


   int []registerValues = new int[8];
   int []registerNames = new int[8];
   @FXML
   private TextField textField1;

   @FXML
   void button(MouseEvent event) {

   }

   @FXML
   void textField0(MouseEvent event) {
     /* try
      {
         registerValues[0] = Integer.parseInt(String.valueOf(textField1));

      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
      System.out.println(registerValues[0]);*/
      try
      {
        registerValues[0]=  Integer.parseInt(textField1.getText(),16);


      }
      catch (Exception e)

      {
         System.out.println(e);
      }
      System.out.println(registerValues[0]);
   }

   @FXML
   void textField1(MouseEvent event) {

   }

   @FXML
   void textField2(MouseEvent event) {

   }

   @FXML
   void textField3(MouseEvent event) {

   }

   @FXML
   void textField4(MouseEvent event) {

   }

   @FXML
   void textField5(MouseEvent event) {

   }

   @FXML
   void textField6(MouseEvent event) {

   }

   @FXML
   void textField7(MouseEvent event) {

   }
   public void inputValidation(int registerValue)
   {

   }


}
