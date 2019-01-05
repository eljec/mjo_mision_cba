package aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.detail;

import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.Readings;

public interface ReadingDetailListItemGenerator {

    public List<Readings> getReadingForDay(int day);
}
