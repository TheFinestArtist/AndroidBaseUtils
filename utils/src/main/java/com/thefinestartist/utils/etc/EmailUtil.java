package com.thefinestartist.utils.etc;

import android.content.Intent;

import com.thefinestartist.Base;
import com.thefinestartist.utils.BuildConfig;

/**
 * Created by TheFinestArtist
 */
public class EmailUtil {

    public static void sendSupportMail(String url) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{url});
        i.putExtra(Intent.EXTRA_SUBJECT, "[FEEDBACK] Android App (" + BuildConfig.VERSION_NAME + ")");
        i.putExtra(Intent.EXTRA_TEXT, "");
        try {
            Base.getContext().startActivity(Intent.createChooser(i, "Send Feedback"));
        } catch (android.content.ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
// TODO: better email format