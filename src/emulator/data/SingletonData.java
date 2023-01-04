package emulator.data;


import javafx.scene.control.TextField;

public final class SingletonData {
    private static SingletonData instance;
    public TextField AL,AH,BL,BH,CL,CH,DL,DH;
    private int []registerValue = new int[8];
    private TextField []registerName = {AL,AH,BL,BH,CL,CH,DL,DH};

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

    public void setRegisterValue(int index,int value) {
        this.registerValue[index] = value;
    }

     public void setRegisterName(int index,TextField textField) {
        this.registerName[index] = textField;
    }
}