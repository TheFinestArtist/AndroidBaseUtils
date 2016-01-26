package com.thefinestartist.helpers;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by TheFinestArtist
 */
public class AgeHelper {

    public static String getFromBirthDay(Date birthDay) {
        if (birthDay == null)
            return "?";

        int year = Integer.parseInt((String) DateFormat.format("yyyy", birthDay));
        int month = Integer.parseInt((String) DateFormat.format("MM", birthDay));
        int day = Integer.parseInt((String) DateFormat.format("dd", birthDay));

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month - 1, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return String.format("%d", age);
    }
}
