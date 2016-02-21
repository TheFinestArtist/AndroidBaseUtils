package com.thefinestartist.wip;

import android.app.Activity;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import android.view.WindowManager;

import com.thefinestartist.utils.service.ServiceUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TheFinestArtist on 2/10/16.
 */
public class AwakeUtil {

//    private static Map<String, PowerManager.WakeLock> wakeLocks = new HashMap<>();
//    private static final String TAG = "AwakeUtil";
//
//    public static void awakeCPU() {
//        awakeCPU(TAG);
//    }
//
//    public static void awakeCPU(@NonNull String tag) {
//        PowerManager.WakeLock wakeLock = ServiceUtil.getPowerManager().newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, tag);
//        wakeLock.acquire();
//
//        if (wakeLocks.get(tag) != null)
//            releaseCPU(tag);
//        wakeLocks.put(tag, wakeLock);
//    }
//
//    public static void releaseCPU() {
//        releaseCPU(TAG);
//    }
//
//    public static void releaseCPU(@NonNull String tag) {
//        if (wakeLocks.get(tag) == null)
//            return;
//
//        wakeLocks.get(tag).release();
//        wakeLocks.remove(tag);
//    }
//
//    public static void awakeScreen(@NonNull Activity activity) {
//        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//    }
//
//    public static void releaseScreen(@NonNull Activity activity) {
//        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
//    }
//
//    public void turnOnScreen() {
//        ServiceUtil.getPowerManager().newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "tag").acquire();
//    }
//
//    public void turnOffScreen() {
//        if (APILevel.require(21))
//            ServiceUtil.getPowerManager().newWakeLock(PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "tag").acquire();
//    }
}
