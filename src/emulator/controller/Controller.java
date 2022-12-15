package emulator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
   /**
    * Alert wyświetlany przy walidacji wartości rejestrów
    */

   int []registerValues = new int[8];
   @FXML
   private TextField AL,AH,BL,BH,CL,CH,DL,DH;

   TextField []registers = new TextField[8];


   private void validtationAlert() {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Alert");
      alert.setHeaderText("Podano błędną wartość ");
      alert.showAndWait();
   }
   
   public void inputValidation(int registerNumber,TextField registerValue){

      try
      {
         if(Integer.parseInt(registerValue.getText(),16) > 255 )
         {
            validtationAlert();
            registerValue.setText("");

         }
         else
         {
            registerValues[registerNumber]=  Integer.parseInt(registerValue.getText(),16);

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
   void edytuj(MouseEvent event) {
      /*for (TextField t :registers
              ) {
         System.out.println(t);
      }
      System.out.println(registers[0]);
      System.out.println(AL);*/
      System.out.println(registers[0].getClass().getName());
      System.out.println(AL.getClass().getName());
   }

   @FXML
   void zatwierdz(MouseEvent event) {
    /*  for (TextField t :
              registers) {
         t.setEditable(false);
      }*/
     /* AL.setEditable(true);
      AL.setVisible(true);

*/


   }
   @FXML
      public void initialize() {
         AL.focusedProperty().addListener((ov,oldV,newV) -> {
            if (!newV) { // focus lost
               inputValidation(0,AL);
            }
         });

         AH.focusedProperty().addListener((ov,oldV,newV) -> {
            if (!newV) { // focus lost
               inputValidation(1,AH);
             
            }
         });

         BL.focusedProperty().addListener((ov,oldV,newV) -> {
            if (!newV) { // focus lost
               inputValidation(2,BL);
             
            }
         });
        BH.focusedProperty().addListener((ov,oldV,newV) -> {
            if (!newV) { // focus lost
               inputValidation(3,BH);
             
            }
         });

         CL.focusedProperty().addListener((ov,oldV,newV) -> {
            if (!newV) { // focus lost
               inputValidation(4,CL);
             
            }
         });

         CH.focusedProperty().addListener((ov,oldV,newV) -> {
            if (!newV) { // focus lost
               inputValidation(5,CH);
             
            }
         });

         DL.focusedProperty().addListener((ov,oldV,newV) -> {
            if (!newV) { // focus lost
               inputValidation(6,DL);
             
            }
         });

         DH.focusedProperty().addListener((ov,oldV,newV) -> {
            if (!newV) { // focus lost
               inputValidation(7,DH);
             
            }
         });
      }






}

