package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.Local;

/**
 * Created by jucastillo on 1/1/18.
 */

public class ReadingJsonModel
{
    private ReadingJsonModelItem firstReading;
    private ReadingJsonModelItemPsalm psalm;
    private ReadingJsonModelItem secondReading;
    private ReadingJsonModelItem gospelReading;

    public ReadingJsonModel() {
    }

    public ReadingJsonModel(ReadingJsonModelItem firstReading, ReadingJsonModelItemPsalm psalm, ReadingJsonModelItem secondReading, ReadingJsonModelItem gospelReading) {
        this.firstReading = firstReading;
        this.psalm = psalm;
        this.secondReading = secondReading;
        this.gospelReading = gospelReading;
    }

    public ReadingJsonModelItem getFirstReading() {
        return firstReading;
    }

    public void setFirstReading(ReadingJsonModelItem firstReading) {
        this.firstReading = firstReading;
    }

    public ReadingJsonModelItem getSecondReading() {
        return secondReading;
    }

    public void setSecondReading(ReadingJsonModelItem secondReading) {
        this.secondReading = secondReading;
    }

    public ReadingJsonModelItem getGospelReading() {
        return gospelReading;
    }

    public void setGospelReading(ReadingJsonModelItem gospelReading) {
        this.gospelReading = gospelReading;
    }

    public ReadingJsonModelItemPsalm getPsalm() {
        return psalm;
    }

    public void setPsalm(ReadingJsonModelItemPsalm psalm) {
        this.psalm = psalm;
    }
}
