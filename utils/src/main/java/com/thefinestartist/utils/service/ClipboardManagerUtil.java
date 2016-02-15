package com.thefinestartist.utils.service;

import android.support.annotation.NonNull;
import android.text.ClipboardManager;

import com.thefinestartist.utils.service.ServiceUtil;

/**
 * Created by TheFinestArtist on 2/14/16.
 */
public class ClipboardManagerUtil {

    public static void clip(@NonNull String text) {
        ClipboardManager clipboardManager = ServiceUtil.getClipboardManager();
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            clipboardManager.setText(text);
        } else {
            android.content.ClipData clip = android.content.ClipData.newPlainText("ClipboardManagerUtil", text);
            ((android.content.ClipboardManager) clipboardManager).setPrimaryClip(clip);
        }
    }
}
