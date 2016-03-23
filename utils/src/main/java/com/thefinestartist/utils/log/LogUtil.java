package com.thefinestartist.utils.log;

import android.support.annotation.StringRes;
import android.util.Log;

import com.thefinestartist.enums.LogLevel;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * LogUtil helps to manage application-wide {@link Log} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class LogUtil {

    // Defaults
    private static Settings defaultSettings = new Settings(LogUtil.class.getSimpleName());

    public static Settings getDefaultSettings() {
        return defaultSettings;
    }

    // Singleton
    private static volatile LogHelper logHelper = new LogHelper()
            .tag(defaultSettings.getTag())
            .showThreadInfo(defaultSettings.getShowThreadInfo())
            .stackTraceCount(defaultSettings.getStackTraceCount())
            .logLevel(defaultSettings.getLogLevel())
            .showDivider(defaultSettings.getShowDivider());

    public static LogHelper getInstance() {
        return logHelper;
    }

    // Builder
    public static LogHelper tag(String tag) {
        return logHelper.tag(tag);
    }

    public static LogHelper tag(@StringRes int tagRes) {
        return logHelper.tag(tagRes);
    }

    public static LogHelper tag(Class clazz) {
        return logHelper.tag(clazz);
    }

    public static LogHelper showThreadInfo(boolean showThreadInfo) {
        return logHelper.showThreadInfo(showThreadInfo);
    }

    public static LogHelper stackTraceCount(int stackTraceCount) {
        return logHelper.stackTraceCount(stackTraceCount);
    }

    public static LogHelper logLevel(LogLevel logLevel) {
        return logHelper.logLevel(logLevel);
    }

    public static LogHelper showDivider(boolean showDivider) {
        return logHelper.showDivider(showDivider);
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
