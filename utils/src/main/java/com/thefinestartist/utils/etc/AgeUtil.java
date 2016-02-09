package com.thefinestartist.utils.etc;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by TheFinestArtist
 */
public class AgeUtil {

    public static String getFromBirthDay(Date date) {
        if (date == null)
            return "?";

        int year = Integer.parseInt((String) DateFormat.format("yyyy", date));
        int month = Integer.parseInt((String) DateFormat.format("MM", date));
        int day = Integer.parseInt((String) DateFormat.format("dd", date));

        Calendar birthday = Calendar.getInstance();
        birthday.set(year, month - 1, day);
        Calendar today = Calendar.getInstance();


        int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birthday.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return String.format("%d", age);
    }
}
