package emulator.data;


import javafx.scene.control.TextField;

import java.io.Serializable;

public final class SingletonData implements Serializable {
    private static SingletonData instance;
    public TextField AL,AH,BL,BH,CL,CH,DL,DH;
    private int []registerValue = new int[8];
    private TextField []registerName = {AL,AH,BL,BH,CL,CH,DL,DH};

    private String []registerNameAndValue = new String[8];

    private SingletonData() {
        // The following code emulates slow initialization.
    }

    public static SingletonData getInstance() {
        if (instance == null) {
            instance = new SingletonData();
        }
        return instance;
    }

    public TextField getAL() {
        return AL;
    }

    public TextField getAH() {
        return AH;
    }

    public TextField getBL() {
        return BL;
    }

    public TextField getBH() {
        return BH;
    }

    public TextField getCL() {
        return CL;
    }

    public TextField getCH() {
        return CH;
    }

    public TextField getDL() {
        return DL;
    }

    public TextField getDH() {
        return DH;
    }

    public int[] getRegisterValue() {
        return registerValue;
    }

    public TextField[] getRegisterName() {
        return registerName;
    }



    public void setRegisterValue(int index, int value) {
        this.registerValue[index] = value;
    }

    public void setRegisterNameValue(int index,String value) {
        this.registerName[index].setText(value);
    }

    public void setRegisterName(int index,TextField field) {
        this.registerName[index] = field;
    }


}