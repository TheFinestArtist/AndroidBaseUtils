package com.thefinestartist.utils.log;

import android.util.Log;

import com.thefinestartist.enums.LogLevel;
import com.thefinestartist.helpers.log.LogHelper;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * LogUtil helps to deal with {@link Log} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class LogUtil {

    // No Instance
    private LogUtil() {
    }

    // Defaults
    public static String defaultTag = LogUtil.class.getSimpleName();
    public static boolean defaultShowThreadInfo = false;
    public static int defaultShowStackTrace = 0;
    public static LogLevel defaultLogLevel = LogLevel.FULL;

    public static void setToDefault() {
        logHelper.setTag(defaultTag);
        logHelper.setShowThreadInfo(defaultShowThreadInfo);
        logHelper.setShowStackTrace(defaultShowStackTrace);
        logHelper.setLogLevel(defaultLogLevel);
    }

    public static void setDefaultTag(String tag) {
        LogUtil.defaultTag = tag;
        setToDefault();
    }

    public static void setDefaultShowThreadInfo(boolean showThreadInfo) {
        LogUtil.defaultShowThreadInfo = showThreadInfo;
        setToDefault();
    }

    public static void setDefaultShowStackTrace(int showStackTrace) {
        LogUtil.defaultShowStackTrace = showStackTrace;
        setToDefault();
    }

    public static void setDefaultLogLevel(LogLevel logLevel) {
        LogUtil.defaultLogLevel = logLevel;
        setToDefault();
    }

    // Singleton
    public static volatile LogHelper logHelper = new LogHelper()
            .tag(defaultTag)
            .showThreadInfo(defaultShowThreadInfo)
            .showStackTrace(defaultShowStackTrace)
            .logLevel(defaultLogLevel);

    // Builder
    public static LogHelper tag(String tag) {
        logHelper.setTag(tag);
        return logHelper;
    }

    public static LogHelper showThreadInfo(boolean showThreadInfo) {
        logHelper.setShowThreadInfo(showThreadInfo);
        return logHelper;
    }

    public static LogHelper showStackTrace(int showStackTrace) {
        logHelper.setShowStackTrace(showStackTrace);
        return logHelper;
    }

    public static LogHelper logLevel(LogLevel logLevel) {
        logHelper.setLogLevel(logLevel);
        return logHelper;
    }

    // Logging Verbose
    public static void v(byte message) {
        logHelper.v(message);
    }

    public static void v(char message) {
        logHelper.v(message);
    }

    public static void v(short message) {
        logHelper.v(message);
    }

    public static void v(int message) {
        logHelper.v(message);
    }

    public static void v(long message) {
        logHelper.v(message);
    }

    public static void v(float message) {
        logHelper.v(message);
    }

    public static void v(double message) {
        logHelper.v(message);
    }

    public static void v(boolean message) {
        logHelper.v(message);
    }

    public static void v(String message) {
        logHelper.v(message);
    }

    public static void v(JSONObject message) {
        logHelper.v(message);
    }

    public static void v(JSONArray message) {
        logHelper.v(message);
    }

    public static void v(Exception message) {
        logHelper.v(message);
    }

    public static void v(Object message) {
        logHelper.v(message);
    }

    // Logging Debug
    public static void d(byte message) {
        logHelper.d(message);
    }

    public static void d(char message) {
        logHelper.d(message);
    }

    public static void d(short message) {
        logHelper.d(message);
    }

    public static void d(int message) {
        logHelper.d(message);
    }

    public static void d(long message) {
        logHelper.d(message);
    }

    public static void d(float message) {
        logHelper.d(message);
    }

    public static void d(double message) {
        logHelper.d(message);
    }

    public static void d(boolean message) {
        logHelper.d(message);
    }

    public static void d(String message) {
        logHelper.d(message);
    }

    public static void d(JSONObject message) {
        logHelper.d(message);
    }

    public static void d(JSONArray message) {
        logHelper.d(message);
    }

    public static void d(Exception message) {
        logHelper.d(message);
    }

    public static void d(Object message) {
        logHelper.d(message);
    }

    // Logging Information
    public static void i(byte message) {
        logHelper.i(message);
    }

    public static void i(char message) {
        logHelper.i(message);
    }

    public static void i(short message) {
        logHelper.i(message);
    }

    public static void i(int message) {
        logHelper.i(message);
    }

    public static void i(long message) {
        logHelper.i(message);
    }

    public static void i(float message) {
        logHelper.i(message);
    }

    public static void i(double message) {
        logHelper.i(message);
    }

    public static void i(boolean message) {
        logHelper.i(message);
    }

    public static void i(String message) {
        logHelper.i(message);
    }

    public static void i(JSONObject message) {
        logHelper.i(message);
    }

    public static void i(JSONArray message) {
        logHelper.i(message);
    }

    public static void i(Exception message) {
        logHelper.i(message);
    }

    public static void i(Object message) {
        logHelper.i(message);
    }

    // Logging Warning
    public static void w(byte message) {
        logHelper.w(message);
    }

    public static void w(char message) {
        logHelper.w(message);
    }

    public static void w(short message) {
        logHelper.w(message);
    }

    public static void w(int message) {
        logHelper.w(message);
    }

    public static void w(long message) {
        logHelper.w(message);
    }

    public static void w(float message) {
        logHelper.w(message);
    }

    public static void w(double message) {
        logHelper.w(message);
    }

    public static void w(boolean message) {
        logHelper.w(message);
    }

    public static void w(String message) {
        logHelper.w(message);
    }

    public static void w(JSONObject message) {
        logHelper.w(message);
    }

    public static void w(JSONArray message) {
        logHelper.w(message);
    }

    public static void w(Exception message) {
        logHelper.w(message);
    }

    public static void w(Object message) {
        logHelper.w(message);
    }

    // Logging Error
    public static void e(byte message) {
        logHelper.e(message);
    }

    public static void e(char message) {
        logHelper.e(message);
    }

    public static void e(short message) {
        logHelper.e(message);
    }

    public static void e(int message) {
        logHelper.e(message);
    }

    public static void e(long message) {
        logHelper.e(message);
    }

    public static void e(float message) {
        logHelper.e(message);
    }

    public static void e(double message) {
        logHelper.e(message);
    }

    public static void e(boolean message) {
        logHelper.e(message);
    }

    public static void e(String message) {
        logHelper.e(message);
    }

    public static void e(JSONObject message) {
        logHelper.e(message);
    }

    public static void e(JSONArray message) {
        logHelper.e(message);
    }

    public static void e(Exception message) {
        logHelper.e(message);
    }

    public static void e(Object message) {
        logHelper.e(message);
    }

    // Logging Assert
    public static void wtf(byte message) {
        logHelper.wtf(message);
    }

    public static void wtf(char message) {
        logHelper.wtf(message);
    }

    public static void wtf(short message) {
        logHelper.wtf(message);
    }

    public static void wtf(int message) {
        logHelper.wtf(message);
    }

    public static void wtf(long message) {
        logHelper.wtf(message);
    }

    public static void wtf(float message) {
        logHelper.wtf(message);
    }

    public static void wtf(double message) {
        logHelper.wtf(message);
    }

    public static void wtf(boolean message) {
        logHelper.wtf(message);
    }

    public static void wtf(String message) {
        logHelper.wtf(message);
    }

    public static void wtf(JSONObject message) {
        logHelper.wtf(message);
    }

    public static void wtf(JSONArray message) {
        logHelper.wtf(message);
    }

    public static void wtf(Exception message) {
        logHelper.wtf(message);
    }

    public static void wtf(Object message) {
        logHelper.wtf(message);
    }

    // Logging JsonString
    public static void json(String jsonString) {
        json(LogLevel.DEBUG, jsonString);
    }

    public static void json(LogLevel logLevel, String jsonString) {
        logHelper.json(logLevel, jsonString);
    }

    // Logging XmlString
    public static void xml(String xmlString) {
        xml(LogLevel.DEBUG, xmlString);
    }

    public static void xml(LogLevel logLevel, String jsonString) {
        logHelper.xml(logLevel, jsonString);
    }
}
