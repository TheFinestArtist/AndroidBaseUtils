package com.thefinestartist.helpers.log;

import android.text.TextUtils;
import android.util.Log;

import com.thefinestartist.enums.LogLevel;
import com.thefinestartist.utils.etc.APILevel;
import com.thefinestartist.utils.log.LogUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * LogHelper helps to deal with {@link Log} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class LogHelper {

    private static final int INDENT_SPACES = 4;
    // http://unicode.org/cldr/utility/list-unicodeset.jsp?a=%5B%E2%94%80-%E2%95%BF%EF%BF%A8%5D
    private static final String TOP_DIVIDER = "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    private static final String MIDDLE_DIVIDER = "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    private static final String BOTTOM_DIVIDER = "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";

    public String tag;
    public boolean showThreadInfo;
    public int methodCount;
    public LogLevel logLevel;

    public LogHelper() {
        setToDefault();
    }

    public LogHelper(String tag) {
        setToDefault();
        this.tag = tag;
    }

    public LogHelper(Class clazz) {
        setToDefault();
        this.tag = clazz.getSimpleName();
    }

    public LogHelper tag(String tag) {
        this.tag = tag;
        return this;
    }

    public LogHelper showThreadInfo(boolean showThreadInfo) {
        this.showThreadInfo = showThreadInfo;
        return this;
    }

    public LogHelper methodCount(int methodCount) {
        this.methodCount = methodCount;
        return this;
    }

    public LogHelper logLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public void setToDefault() {
        tag = LogUtil.defaultTag;
        showThreadInfo = LogUtil.defaultShowThreadInfo;
        methodCount = LogUtil.defaultMethodCount;
        logLevel = LogUtil.defaultLogLevel;
    }

    // Logging Verbose
    public void v(byte message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(char message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(short message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(int message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(long message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(float message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(double message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(boolean message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(String message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(JSONObject message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(JSONArray message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(Exception message) {
        log(LogLevel.VERBOSE, message);
    }

    public void v(Object message) {
        log(LogLevel.VERBOSE, message);
    }

    // Logging Debug
    public void d(byte message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(char message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(short message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(int message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(long message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(float message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(double message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(boolean message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(JSONObject message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(JSONArray message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(Exception message) {
        log(LogLevel.DEBUG, message);
    }

    public void d(Object message) {
        log(LogLevel.DEBUG, message);
    }

    // Logging Information
    public void i(byte message) {
        log(LogLevel.INFO, message);
    }

    public void i(char message) {
        log(LogLevel.INFO, message);
    }

    public void i(short message) {
        log(LogLevel.INFO, message);
    }

    public void i(int message) {
        log(LogLevel.INFO, message);
    }

    public void i(long message) {
        log(LogLevel.INFO, message);
    }

    public void i(float message) {
        log(LogLevel.INFO, message);
    }

    public void i(double message) {
        log(LogLevel.INFO, message);
    }

    public void i(boolean message) {
        log(LogLevel.INFO, message);
    }

    public void i(String message) {
        log(LogLevel.INFO, message);
    }

    public void i(JSONObject message) {
        log(LogLevel.INFO, message);
    }

    public void i(JSONArray message) {
        log(LogLevel.INFO, message);
    }

    public void i(Exception message) {
        log(LogLevel.INFO, message);
    }

    public void i(Object message) {
        log(LogLevel.INFO, message);
    }

    // Logging Warning
    public void w(byte message) {
        log(LogLevel.WARN, message);
    }

    public void w(char message) {
        log(LogLevel.WARN, message);
    }

    public void w(short message) {
        log(LogLevel.WARN, message);
    }

    public void w(int message) {
        log(LogLevel.WARN, message);
    }

    public void w(long message) {
        log(LogLevel.WARN, message);
    }

    public void w(float message) {
        log(LogLevel.WARN, message);
    }

    public void w(double message) {
        log(LogLevel.WARN, message);
    }

    public void w(boolean message) {
        log(LogLevel.WARN, message);
    }

    public void w(String message) {
        log(LogLevel.WARN, message);
    }

    public void w(JSONObject message) {
        log(LogLevel.WARN, message);
    }

    public void w(JSONArray message) {
        log(LogLevel.WARN, message);
    }

    public void w(Exception message) {
        log(LogLevel.WARN, message);
    }

    public void w(Object message) {
        log(LogLevel.WARN, message);
    }

    // Logging Error
    public void e(byte message) {
        log(LogLevel.ERROR, message);
    }

    public void e(char message) {
        log(LogLevel.ERROR, message);
    }

    public void e(short message) {
        log(LogLevel.ERROR, message);
    }

    public void e(int message) {
        log(LogLevel.ERROR, message);
    }

    public void e(long message) {
        log(LogLevel.ERROR, message);
    }

    public void e(float message) {
        log(LogLevel.ERROR, message);
    }

    public void e(double message) {
        log(LogLevel.ERROR, message);
    }

    public void e(boolean message) {
        log(LogLevel.ERROR, message);
    }

    public void e(String message) {
        log(LogLevel.ERROR, message);
    }

    public void e(JSONObject message) {
        log(LogLevel.ERROR, message);
    }

    public void e(JSONArray message) {
        log(LogLevel.ERROR, message);
    }

    public void e(Exception message) {
        log(LogLevel.ERROR, message);
    }

    public void e(Object message) {
        log(LogLevel.ERROR, message);
    }

    // Logging Assert
    public void wtf(byte message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(char message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(short message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(int message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(long message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(float message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(double message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(boolean message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(String message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(JSONObject message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(JSONArray message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(Exception message) {
        log(LogLevel.ASSERT, message);
    }

    public void wtf(Object message) {
        log(LogLevel.ASSERT, message);
    }

    // Logging JsonString
    public void json(String jsonString) {
        json(LogLevel.DEBUG, jsonString);
    }

    public void json(LogLevel logLevel, String jsonString) {
        if (TextUtils.isEmpty(jsonString)) {
            log(logLevel, "Json string is empty.");
        } else {
            jsonString = jsonString.trim();

            try {
                if (jsonString.startsWith("{")) {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    String message = jsonObject.toString(INDENT_SPACES);
                    log(logLevel, message);
                    return;
                }
                if (jsonString.startsWith("[")) {
                    JSONArray jsonArray = new JSONArray(jsonString);
                    String message = jsonArray.toString(INDENT_SPACES);
                    log(logLevel, message);
                }
            } catch (JSONException e) {
                log(logLevel, e);
            }
        }
    }

    // Logging XmlString
    public void xml(String xmlString) {
        xml(LogLevel.DEBUG, xmlString);
    }

    public void xml(LogLevel logLevel, String xmlString) {
        if (TextUtils.isEmpty(xmlString)) {
            log(logLevel, "Xml string is empty.");
        } else {
            if (APILevel.require(8)) {
                try {
                    Source xmlInput = new StreamSource(new StringReader(xmlString));
                    StreamResult xmlOutput = new StreamResult(new StringWriter());
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    transformer.transform(xmlInput, xmlOutput);
                    log(logLevel, xmlOutput.getWriter().toString().replaceFirst(">", ">\n"));
                } catch (TransformerException e) {
                    log(logLevel, e);
                }
            } else {
                log(logLevel, xmlString);
            }
        }
    }

    // Printing
    private void log(LogLevel logLevel, byte message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, char message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, short message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, int message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, long message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, float message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, double message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, boolean message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, String message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, message);
    }

    private void log(LogLevel logLevel, JSONObject message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        try {
            print(logLevel, message.toString(INDENT_SPACES));
        } catch (JSONException e) {
            log(logLevel, e);
        }
    }

    private void log(LogLevel logLevel, JSONArray message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, Exception message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private void log(LogLevel logLevel, Object message) {
        if (logLevel.ordinal() < logLevel.ordinal())
            return;

        print(logLevel, String.valueOf(message));
    }

    private String getSimpleClassName(String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }

    private void print(LogLevel logLevel, String message) {

        String TAG = tag;
        if (showThreadInfo) TAG += "(" + Thread.currentThread().getName() + ")";

        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        int stackIndex = 5;
        if (methodCount > 0) print(logLevel, TAG, TOP_DIVIDER);
        String indent = "";
        while (stackIndex < Math.min(trace.length, 5 + methodCount)) {
            StringBuilder builder = new StringBuilder();
            builder.append("┃ ")
                    .append(indent)
                    .append(getSimpleClassName(trace[stackIndex].getClassName()))
                    .append(".")
                    .append(trace[stackIndex].getMethodName())
                    .append("(")
                    .append(trace[stackIndex].getFileName())
                    .append(":")
                    .append(trace[stackIndex].getLineNumber())
                    .append(")");

            print(logLevel, TAG, builder.toString());
            indent += "  ";
            stackIndex++;
        }
        if (methodCount > 0) print(logLevel, TAG, MIDDLE_DIVIDER);

        String[] lines = message.split(System.getProperty("line.separator"));
        for (String line : lines) print(logLevel, TAG, methodCount > 0 ? "┃ " + line : line);
        if (methodCount > 0) print(logLevel, TAG, BOTTOM_DIVIDER);
    }

    private void print(LogLevel logLevel, String TAG, String message) {
        switch (logLevel) {
            case FULL:
            case VERBOSE:
                Log.v(TAG, message);
                break;
            case DEBUG:
                Log.d(TAG, message);
                break;
            case INFO:
                Log.i(TAG, message);
                break;
            case WARN:
                Log.w(TAG, message);
                break;
            case ERROR:
                Log.e(TAG, message);
                break;
            case ASSERT:
                if (APILevel.require(8))
                    Log.wtf(TAG, message);
                else
                    Log.e(TAG, message);
                break;
        }
    }
}
// TODO: exception & trace count