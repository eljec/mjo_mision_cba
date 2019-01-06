package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GenericTextContentModel {

    @SerializedName("doubleBrakeLine")
    @Expose
    private boolean doubleBrakeLine;

    @SerializedName("text")
    @Expose
    private ArrayList<String> arrayTextLines;

    public boolean isDoubleBrakeLine() {
        return doubleBrakeLine;
    }

    public void setDoubleBrakeLine(boolean doubleBrakeLine) {
        this.doubleBrakeLine = doubleBrakeLine;
    }

    public ArrayList<String> getArrayTextLines() {
        return arrayTextLines;
    }

    public void setArrayTextLines(ArrayList<String> arrayTextLines) {
        this.arrayTextLines = arrayTextLines;
    }
}
