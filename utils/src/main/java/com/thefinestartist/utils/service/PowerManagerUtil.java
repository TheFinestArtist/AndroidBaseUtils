package com.thefinestartist.utils.service;

import android.os.PowerManager;

import com.thefinestartist.utils.etc.APILevel;

/**
 * Created by TheFinestArtist on 2/18/16.
 */
public class PowerManagerUtil {

    public void turnOnScreen() {
        ServiceUtil.getPowerManager().newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "tag").acquire();
    }

    public void turnOffScreen() {
        if (APILevel.require(21))
            ServiceUtil.getPowerManager().newWakeLock(PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "tag").acquire();
    }
}
