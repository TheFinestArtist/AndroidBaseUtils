package com.thefinestartist.utils.log;

import android.support.annotation.StringRes;

import com.thefinestartist.enums.LogLevel;
import com.thefinestartist.utils.content.ResourcesUtil;

/**
 * Settings for {@link LogHelper}.
 *
 * @author Leonardo Taehwan Kim
 */
public class Settings {

    private String tag = Settings.class.getSimpleName();
    private boolean showThreadInfo = false;
    private int stackTraceCount = 0;
    private LogLevel logLevel = LogLevel.FULL;
    private boolean showDivider = false;
    private LogPrinter logPrinter = new AndroidLogPrinter();

    public Settings() {
    }

    public Settings(String tag) {
        this.tag = tag;
    }

    public Settings(@StringRes int tagRes) {
        this.tag = ResourcesUtil.getString(tagRes);
    }

    public Settings(Class clazz) {
        this.tag = clazz.getSimpleName();
    }

    public String getTag() {
        return tag;
    }

    public Settings setTag(String tag) {
        this.tag = tag;
        if (this == LogUtil.getDefaultSettings()) LogUtil.getInstance().setToDefault();
        return this;
    }

    public Settings setTag(@StringRes int tagRes) {
        this.tag = ResourcesUtil.getString(tagRes);
        if (this == LogUtil.getDefaultSettings()) LogUtil.getInstance().setToDefault();
        return this;
    }

    public Settings setTag(Class clazz) {
        this.tag = clazz.getSimpleName();
        if (this == LogUtil.getDefaultSettings()) LogUtil.getInstance().setToDefault();
        return this;
    }

    public boolean getShowThreadInfo() {
        return showThreadInfo;
    }

    public Settings setShowThreadInfo(boolean showThreadInfo) {
        this.showThreadInfo = showThreadInfo;
        if (this == LogUtil.getDefaultSettings()) LogUtil.getInstance().setToDefault();
        return this;
    }

    public int getStackTraceCount() {
        return stackTraceCount;
    }

    public Settings setStackTraceCount(int stackTraceCount) {
        this.stackTraceCount = stackTraceCount;
        if (this == LogUtil.getDefaultSettings()) LogUtil.getInstance().setToDefault();
        return this;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public Settings setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        if (this == LogUtil.getDefaultSettings()) LogUtil.getInstance().setToDefault();
        return this;
    }

    public boolean getShowDivider() {
        return showDivider;
    }

    public Settings setShowDivider(boolean showDivider) {
        this.showDivider = showDivider;
        if (this == LogUtil.getDefaultSettings()) LogUtil.getInstance().setToDefault();
        return this;
    }

    public LogPrinter getLogPrinter() {
        return logPrinter;
    }

    public Settings setLogPrinter(LogPrinter logPrinter) {
        this.logPrinter = logPrinter;
        if (this == LogUtil.getDefaultSettings()) LogUtil.getInstance().setToDefault();
        return this;
    }
}
