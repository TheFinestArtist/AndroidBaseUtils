package com.thefinestartist.wip;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by TheFinestArtist on 1/26/16.
 */
public class DateUtil {

//    public static String SERVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.'000Z'";
//    public static String POST_FORMAT = "yy/MM/dd HH:mm";
//    public static String CLICKER_FORMAT = "yyyy/MM/dd kk:mm";
//    public static String DATE_FORMAT = "yyyy/MM/dd";
//    public static String TIME_FORMAT = "HH:mm";
//    private static SimpleDateFormat server_format = new SimpleDateFormat(SERVER_FORMAT);
//    private static SimpleDateFormat post_format = new SimpleDateFormat(POST_FORMAT);
//    private static SimpleDateFormat date_format = new SimpleDateFormat(DATE_FORMAT);
//    private static SimpleDateFormat time_format = new SimpleDateFormat(TIME_FORMAT);
//
//    public static synchronized long getCurrentGMTTimeMillis() {
//        final Date currentTime = new Date();
//        final SimpleDateFormat sdf = new SimpleDateFormat(SERVER_FORMAT);
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//        String time = sdf.format(currentTime);
//        return getTime(time);
//    }
//
//    public static String getCurrentTimeString() {
//        return (String) DateFormat.format(CLICKER_FORMAT, System.currentTimeMillis());
//    }
//
//    public static long getTime(String timeStr) {
//        Date date;
//        try {
//            server_format.setTimeZone(TimeZone.getTimeZone("GMT"));
//            date = server_format.parse(timeStr);
//            return date.getTime();
//        } catch (ParseException e) {
//            return 0;
//        }
//    }
//
//    public static Date getDate(String timeStr) {
//        Date date;
//        try {
//            server_format.setTimeZone(TimeZone.getTimeZone("GMT"));
//            date = server_format.parse(timeStr);
//            return date;
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//
//    public static String getPostFormatString(String timeStr) {
//        Date date;
//        try {
//            server_format.setTimeZone(TimeZone.getTimeZone("GMT"));
//            post_format.setTimeZone(TimeZone.getDefault());
//            date = server_format.parse(timeStr);
//            return post_format.format(date);
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//
//    public static String getDateFormatString(String timeStr) {
//        Date date;
//        try {
//            server_format.setTimeZone(TimeZone.getTimeZone("GMT"));
//            date_format.setTimeZone(TimeZone.getDefault());
//            date = server_format.parse(timeStr);
//            return date_format.format(date);
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//
//    public static String getTimeFormatString(String timeStr) {
//        Date date;
//        try {
//            server_format.setTimeZone(TimeZone.getTimeZone("GMT"));
//            time_format.setTimeZone(TimeZone.getDefault());
//            date = server_format.parse(timeStr);
//            return time_format.format(date);
//        } catch (ParseException e) {
//            return null;
//        }
//    }
}
