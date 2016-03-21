package com.thefinestartist.utils.service;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;

import com.thefinestartist.utils.etc.APILevel;

/**
 * ClipboardManagerUtil helps to manage {@link ClipboardManager} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ClipboardManagerUtil {

    public static void setText(CharSequence text) {
        android.text.ClipboardManager clipboardManager = ServiceUtil.getClipboardManager();
        if (APILevel.require(11)) {
            ClipboardManager cm = (ClipboardManager) clipboardManager;
            ClipData clip = ClipData.newPlainText("ClipboardManagerUtil", text);
            cm.setPrimaryClip(clip);
        } else {
            clipboardManager.setText(text);
        }
    }

    public static boolean hasText() {
        android.text.ClipboardManager clipboardManager = ServiceUtil.getClipboardManager();
        if (APILevel.require(11)) {
            ClipboardManager cm = (ClipboardManager) clipboardManager;
            ClipDescription description = cm.getPrimaryClipDescription();
            ClipData clipData = cm.getPrimaryClip();
            return clipData != null
                    && description != null
                    && (description.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN));
        } else {
            return clipboardManager.hasText();
        }
    }

    public static CharSequence getText() {
        android.text.ClipboardManager clipboardManager = ServiceUtil.getClipboardManager();
        if (APILevel.require(11)) {
            ClipboardManager cm = (ClipboardManager) clipboardManager;
            ClipDescription description = cm.getPrimaryClipDescription();
            ClipData clipData = cm.getPrimaryClip();
            if (clipData != null
                    && description != null
                    && description.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))
                return clipData.getItemAt(0).getText();
            else
                return null;
        } else {
            return clipboardManager.getText();
        }
    }
}
