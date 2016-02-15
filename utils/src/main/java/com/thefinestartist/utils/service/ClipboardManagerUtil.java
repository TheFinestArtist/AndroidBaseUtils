package com.thefinestartist.utils.service;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;

/**
 * ClipboardManagerUtil helps to use Android {@link ClipboardManager} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ClipboardManagerUtil {

    public static void setText(CharSequence text) {
        android.text.ClipboardManager clipboardManager = ServiceUtil.getClipboardManager();
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            clipboardManager.setText(text);
        } else {
            ClipboardManager cm = (ClipboardManager) clipboardManager;
            ClipData clip = ClipData.newPlainText("ClipboardManagerUtil", text);
            cm.setPrimaryClip(clip);
        }
    }

    public static boolean hasText() {
        android.text.ClipboardManager clipboardManager = ServiceUtil.getClipboardManager();
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            return clipboardManager.hasText();
        } else {
            ClipboardManager cm = (ClipboardManager) clipboardManager;
            ClipDescription description = cm.getPrimaryClipDescription();
            ClipData clipData = cm.getPrimaryClip();
            return clipData != null
                    && description != null
                    && (description.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN));
        }
    }

    public static CharSequence getText() {
        android.text.ClipboardManager clipboardManager = ServiceUtil.getClipboardManager();
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            return clipboardManager.getText();
        } else {
            ClipboardManager cm = (ClipboardManager) clipboardManager;
            ClipDescription description = cm.getPrimaryClipDescription();
            ClipData clipData = cm.getPrimaryClip();
            if (clipData != null
                    && description != null
                    && description.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))
                return clipData.getItemAt(0).getText();
            else
                return null;
        }
    }
}
