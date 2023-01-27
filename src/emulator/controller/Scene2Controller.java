package emulator.controller;

import emulator.data.SingletonData;
import emulator.temp.ReversedBinaryArrays;
import emulator.temp.TempRegisterIndex;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scene2Controller {
    SingletonData registerData = SingletonData.getInstance();
    @FXML
    private ChoiceBox<String> choiceBox1;
    @FXML
    private ChoiceBox<String> choiceBox2;

    public Scene2Controller() {
    }

    private void validtationAlert(String info) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alert");
        alert.setHeaderText(info);
        alert.showAndWait();
    }
    @FXML
    public void switchScene(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Scene1.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public ReversedBinaryArrays reverseToBinaryArray()
    {
        int temp1 =  initalizeTemp().temp1;
        int temp2 =   initalizeTemp().temp2;
        String[] arr1 = new String[8];
        String[] arr2 = new String[8];
        String liczba1 =
                Integer.toBinaryString(Integer.parseInt(Integer.toString(Integer.parseInt(registerData.getRegisterName()[temp1].getText(),16))));
         arr1 = liczba1.split("");
        String liczba2 =
                Integer.toBinaryString(Integer.parseInt(Integer.toString(Integer.parseInt(registerData.getRegisterName()[temp2].getText(),16))));
         arr2 = liczba2.split("");





        return new ReversedBinaryArrays(arr1,arr2);
    }

    public TempRegisterIndex initalizeTemp()
    {
        int temp1 = 0,temp2 = 0;
        for (int i = 0; i < 8; i++) {
            try {
                if (registerData.getRegisterName()[i].getId().substring(0, 2).equals(choiceBox1.getValue().substring(0, 2))) {
                    temp1 = i;
                }
            } catch (Exception e) {

            }
            try {
                if (registerData.getRegisterName()[i].getId().substring(0, 2).equals(choiceBox2.getValue().substring(0, 2))) {
                    temp2 = i;
                }
            }
            catch (Exception e){}
        }

        return new TempRegisterIndex(temp1,temp2);
    }

    String[] orArray()
    {
        String[] arr1 = reverseToBinaryArray().arr1; ;
        String[] arr2 = reverseToBinaryArray().arr2; ;
        String[] arr3 = {"0","0","0","0","0","0","0","0"};
        String[] arr4 = {"0","0","0","0","0","0","0","0"};
        String[] arr5 = {"0","0","0","0","0","0","0","0"};
        String[] xOrarray = new String[8];
        for (int i = 0; i < arr1.length; i++) {

            arr3[arr3.length-arr1.length+i ] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr4[arr4.length-arr2.length+i ] = arr2[i];
        }

        int temp1 =  initalizeTemp().temp1;
        int temp2 =   initalizeTemp().temp2;

        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i].equals("1"))
            {
                arr5[i]= "1";
            }

        }
        for (int i = 0; i < arr4.length; i++) {
            if(arr4[i].equals("1"))
            {
                arr5[i]= "1";
            }


        }
        StringBuilder builder = new StringBuilder();
        for (String a:arr5
        ) {
            builder.append(a);
        }
        for (int i = 0; i < arr3.length; i++) {
        }
        for (int i = 0; i < arr4.length; i++) {
        }
        xOrarray = arr5;
        return xOrarray;
    }



    @FXML
    void ADD() {
        int temp1 =  initalizeTemp().temp1;
        int temp2 =   initalizeTemp().temp2;
        int wynik =
                Integer.parseInt(registerData.getRegisterName()[temp1].getText(),16) +Integer.parseInt(registerData.getRegisterName()[temp2].getText(),16);
        if(wynik>255)
        {
            wynik=wynik-255;
        }

        registerData.getRegisterName()[temp1].setText(Integer.toHexString(wynik));
        registerData.getRegisterName()[temp2].setText(Integer.toHexString(wynik));
        initialize();

    }
    @FXML
    void AND() {
        int temp1 =  initalizeTemp().temp1;
        int temp2 =   initalizeTemp().temp2;
        String[] arr1 = reverseToBinaryArray().arr1;
        String[] arr2 = reverseToBinaryArray().arr2;

        Collections.reverse(Arrays.asList(arr1));
        Collections.reverse(Arrays.asList(arr2));

        StringBuilder wynik= new StringBuilder();
        if(arr1.length > arr2.length)
        {
            for (int i = 0; i <arr2.length; i++) {
                wynik.append(Integer.parseInt(arr1[i]) * Integer.parseInt(arr2[i]));
            }
        }
        else
        {
            for (int i = 0; i <arr1.length; i++) {
                wynik.append((Integer.parseInt(arr1[i]) * Integer.parseInt(arr2[i])));
            }
        }

        wynik.reverse();
        int output = Integer.parseInt(wynik.toString(),2) ;
        registerData.getRegisterName()[temp1].setText(Integer.toHexString(output));
        registerData.getRegisterName()[temp2].setText(Integer.toHexString(output));
        initialize();
        wynik.setLength(0);
    }



    @FXML
    void DEC() {
        try {
            int temp1;
            if(choiceBox1.getValue() == null)
            {
                temp1 = -1;
            }else
            {
                temp1 =  initalizeTemp().temp1;
            }
            if(Integer.parseInt(registerData.getRegisterName()[temp1].getText(),16)==0)
            {
                validtationAlert("wynik jest mniejszy od 0");
                registerData.getRegisterName()[temp1].setText("1");
            }
            registerData.getRegisterName()[temp1].setText( Integer.toHexString(Integer.parseInt(registerData.getRegisterName()[temp1].getText(),16)-1));


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

       try {
           int temp2;
           if(choiceBox2.getValue() == null)
           {
               temp2 = -1;
           }else
           {
               temp2 =  initalizeTemp().temp2;
           }
           if(Integer.parseInt(registerData.getRegisterName()[temp2].getText(),16)==0)
           {
               validtationAlert("wynik jest mniejszy od 0");
               registerData.getRegisterName()[temp2].setText("1");
           }
           registerData.getRegisterName()[temp2].setText( Integer.toHexString(Integer.parseInt(registerData.getRegisterName()[temp2].getText(),16)-1));

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }






        initialize();
    }

    @FXML
    void INC() {


        try {
            int temp1;
            if(choiceBox1.getValue() == null)
            {
                 temp1 = -1;
            }else
            {
                 temp1 =  initalizeTemp().temp1;
            }
            registerData.getRegisterName()[temp1].setText( Integer.toHexString(Integer.parseInt(registerData.getRegisterName()[temp1].getText(),16)+1));
            if(Integer.parseInt(registerData.getRegisterName()[temp1].getText(),16)>255)
            {
                validtationAlert("wynik jest większy od FF");
                registerData.getRegisterName()[temp1].setText("ff");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        try {
            int temp2;
            if(choiceBox2.getValue() == null)
            {
                 temp2 = -1;
            }else
            {
                 temp2 =  initalizeTemp().temp2;
            }
            registerData.getRegisterName()[temp2].setText( Integer.toHexString(Integer.parseInt(registerData.getRegisterName()[temp2].getText(),16)+1));

            if(Integer.parseInt(registerData.getRegisterName()[temp2].getText(),16)>255)
            {
                validtationAlert("wynik jest większy od FF");
                registerData.getRegisterName()[temp2].setText("ff");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        initialize();

    }

    @FXML
    void MOV() {
        int temp1 =  initalizeTemp().temp1;
        int temp2 =   initalizeTemp().temp2;
        registerData.getRegisterName()[temp2].setText(registerData.getRegisterName()[temp1].getText());
        initialize();
    }

    @FXML
    void NOT() {

        try
        {
            String[] arr1 = reverseToBinaryArray().arr1;

            String[] arr3 = {"0","0","0","0","0","0","0","0"};

            for (int i = 0; i < arr1.length; i++) {

                arr3[arr3.length-arr1.length+i ] = arr1[i];
            }
            int temp1;
            if(choiceBox1.getValue() == null)
            {
                temp1 = -1;
            }else
            {
                temp1 =  initalizeTemp().temp1;
            }


            for (int i = 0; i < arr3.length; i++) {
                if(arr3[i].equals("1"))
                {
                    arr3[i]="0";
                }
                else
                {
                    arr3[i]="1";
                }
            }


            StringBuilder builder = new StringBuilder();
            for (String a:arr3
            ) {
                builder.append(a);
            }


            int output = Integer.parseInt(builder.toString(),2) ;
            registerData.getRegisterName()[temp1].setText(Integer.toHexString(output));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            int temp2;
            if(choiceBox2.getValue() == null)
            {
                temp2 = -1;
            }else
            {
                temp2 =  initalizeTemp().temp2;
            }
            String[] arr2 = reverseToBinaryArray().arr2;

            String[] arr4 = {"0","0","0","0","0","0","0","0"};

            for (int i = 0; i < arr2.length; i++) {

                arr4[arr4.length-arr2.length+i ] = arr2[i];
            }


            for (int i = 0; i < arr4.length; i++) {
                if(arr4[i].equals("1"))
                {
                    arr4[i]="0";
                }
                else
                {
                    arr4[i]="1";
                }
            }


            StringBuilder builder2 = new StringBuilder();
            for (String a:arr4
            ) {
                builder2.append(a);
            }
            int output2 = Integer.parseInt(builder2.toString(),2) ;
            registerData.getRegisterName()[temp2].setText(Integer.toHexString(output2));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        initialize();


    }

    @FXML
    void OR() {
        int temp1 =  initalizeTemp().temp1;
        int temp2 =   initalizeTemp().temp2;
        StringBuilder builder = new StringBuilder();

        String[] arr5 = orArray();
        for (String a:arr5
        ) {
            builder.append(a);
        }
        int output = Integer.parseInt(builder.toString(),2) ;
        registerData.getRegisterName()[temp1].setText(Integer.toHexString(output));
        registerData.getRegisterName()[temp2].setText(Integer.toHexString(output));
        initialize();
    }

    @FXML
    void SUB() {
        Logger.global.info(Level.FINE + "INSTRUKCJA SUB");
        int temp1 =  initalizeTemp().temp1;
        int temp2 =   initalizeTemp().temp2;
        int wynik =
                Integer.parseInt(registerData.getRegisterName()[temp1].getText(),16) - Integer.parseInt(registerData.getRegisterName()[temp2].getText(),16);
        if(wynik<0)
        {
            validtationAlert("Wynik działania jest mniejszy od 0");
            return;
        }

        registerData.getRegisterName()[temp1].setText(Integer.toHexString(wynik));
        registerData.getRegisterName()[temp2].setText(Integer.toHexString(wynik));
        initialize();
    }

    @FXML
    void XCHG() {
        int temp1 =  initalizeTemp().temp1;
        int temp2 =   initalizeTemp().temp2;
        String tempValue =   registerData.getRegisterName()[temp2].getText();
        registerData.getRegisterName()[temp2].setText(registerData.getRegisterName()[temp1].getText());
        registerData.getRegisterName()[temp1].setText(tempValue);
        initialize();

    }

    @FXML
    void XOR(MouseEvent event) {
    }
    @FXML
    void saveData(MouseEvent event) throws IOException {
            File dataFile = new File("RegisterData\\data.txt");

            dataFile.createNewFile();

            FileWriter fileWriter = new FileWriter(dataFile);


        for (int i = 0; i < 8; i++) {
            fileWriter.append(registerData.getRegisterName()[i].getText() + String.format("%n"));

        }
        fileWriter.close();
    }
    @FXML
    void loadData(MouseEvent event) throws IOException, ClassNotFoundException {
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

    @FXML
    void register1() {
    }

    @FXML
    void register2() {
    }
    public void initialize() {
        choiceBox1.getItems().removeAll(choiceBox1.getItems());
        choiceBox2.getItems().removeAll(choiceBox2.getItems());


        for (int i = 0; i < 8; i++) {
            choiceBox1.getItems().add(registerData.getRegisterName()[i].getId() + " " + registerData.getRegisterName()[i].getText());
            choiceBox2.getItems().add(registerData.getRegisterName()[i].getId() + " " + registerData.getRegisterName()[i].getText());
        }


    }
}
