package aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.detail;

import java.util.ArrayList;
import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.ReadingDay;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.ReadingDayReading;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.ReadingTextContentModel;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.SectionReadings;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.Readings;

public class ReadingDetailListItemServerGenerator implements ReadingDetailListItemGenerator {

    private SectionReadings  sectionReadings;

    public ReadingDetailListItemServerGenerator(SectionReadings sectionReadings) {
        this.sectionReadings = sectionReadings;
    }

    @Override
    public List<Readings> getReadingForDay(int day) {

        List<Readings> readingForDay = new ArrayList<Readings>();

        if(sectionReadings.getDays() != null ){
            ReadingDay readingDay =  sectionReadings.getReadingModelForDay(day);
            if(readingDay != null && readingDay.getReadings() != null ){

                for (ReadingDayReading readingItem : readingDay.getReadings()) {

                    // Parseo la data

                    // Title
                    String title = processContentModel(readingItem.getTitle());

                    // Subtitle
                    String subtitle = processContentModel(readingItem.getSubtitle());

                    // Content
                    String content = processContentModel(readingItem.getContent());

                    Readings reading = new Readings(title, subtitle,content);
                    readingForDay.add(reading);
                }
            }
        }
        return readingForDay;
    }


    private String processContentModel (ReadingTextContentModel model) {

        StringBuilder textBuilder = new StringBuilder();

        for (String line : model.getArrayTextLines()) {
            textBuilder.append(line);

            if(model.getArrayTextLines().size() > 1){
                textBuilder.append("\n");
                if(model.isDoubleBrakeLine()) {
                    textBuilder.append("\n");
                }
            }
        }

        return  textBuilder.toString();
    }
}
