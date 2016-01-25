package com.thefinestartist.helpers;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.NetworkStatsManager;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.midi.MidiManager;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/**
 * Created by TheFinestArtist on 1/25/16.
 */
public class ServiceHelper {

    private static final HashMap<Class<?>, String> SYSTEM_SERVICE_NAMES = new HashMap<>();

    static {
        SYSTEM_SERVICE_NAMES.put(AccessibilityManager.class, Context.ACCESSIBILITY_SERVICE);
        SYSTEM_SERVICE_NAMES.put(CaptioningManager.class, Context.CAPTIONING_SERVICE);
        SYSTEM_SERVICE_NAMES.put(AccountManager.class, Context.ACCOUNT_SERVICE);
        SYSTEM_SERVICE_NAMES.put(ActivityManager.class, Context.ACTIVITY_SERVICE);
        SYSTEM_SERVICE_NAMES.put(AlarmManager.class, Context.ALARM_SERVICE);
        SYSTEM_SERVICE_NAMES.put(AudioManager.class, Context.AUDIO_SERVICE);
        SYSTEM_SERVICE_NAMES.put(MediaRouter.class, Context.MEDIA_ROUTER_SERVICE);
        SYSTEM_SERVICE_NAMES.put(BluetoothManager.class, Context.BLUETOOTH_SERVICE);
        SYSTEM_SERVICE_NAMES.put(ClipboardManager.class, Context.CLIPBOARD_SERVICE);
        SYSTEM_SERVICE_NAMES.put(android.text.ClipboardManager.class, Context.CLIPBOARD_SERVICE);
        SYSTEM_SERVICE_NAMES.put(ConnectivityManager.class, Context.CONNECTIVITY_SERVICE);
        SYSTEM_SERVICE_NAMES.put(DevicePolicyManager.class, Context.DEVICE_POLICY_SERVICE);
        SYSTEM_SERVICE_NAMES.put(DownloadManager.class, Context.DOWNLOAD_SERVICE);
        SYSTEM_SERVICE_NAMES.put(BatteryManager.class, Context.BATTERY_SERVICE);
        SYSTEM_SERVICE_NAMES.put(NfcManager.class, Context.NFC_SERVICE);
        SYSTEM_SERVICE_NAMES.put(DropBoxManager.class, Context.DROPBOX_SERVICE);
        SYSTEM_SERVICE_NAMES.put(InputManager.class, Context.INPUT_SERVICE);
        SYSTEM_SERVICE_NAMES.put(DisplayManager.class, Context.DISPLAY_SERVICE);
        SYSTEM_SERVICE_NAMES.put(InputMethodManager.class, Context.INPUT_METHOD_SERVICE);
        SYSTEM_SERVICE_NAMES.put(TextServicesManager.class, Context.TEXT_SERVICES_MANAGER_SERVICE);
        SYSTEM_SERVICE_NAMES.put(KeyguardManager.class, Context.KEYGUARD_SERVICE);
        SYSTEM_SERVICE_NAMES.put(LayoutInflater.class, Context.LAYOUT_INFLATER_SERVICE);
        SYSTEM_SERVICE_NAMES.put(LocationManager.class, Context.LOCATION_SERVICE);
        SYSTEM_SERVICE_NAMES.put(NotificationManager.class, Context.NOTIFICATION_SERVICE);
        SYSTEM_SERVICE_NAMES.put(NsdManager.class, Context.NSD_SERVICE);
        SYSTEM_SERVICE_NAMES.put(PowerManager.class, Context.POWER_SERVICE);
        SYSTEM_SERVICE_NAMES.put(SearchManager.class, Context.SEARCH_SERVICE);
        SYSTEM_SERVICE_NAMES.put(SensorManager.class, Context.SENSOR_SERVICE);
        SYSTEM_SERVICE_NAMES.put(StorageManager.class, Context.STORAGE_SERVICE);
        SYSTEM_SERVICE_NAMES.put(TelephonyManager.class, Context.TELEPHONY_SERVICE);
        SYSTEM_SERVICE_NAMES.put(SubscriptionManager.class, Context.TELEPHONY_SUBSCRIPTION_SERVICE);
        SYSTEM_SERVICE_NAMES.put(CarrierConfigManager.class, Context.CARRIER_CONFIG_SERVICE);
        SYSTEM_SERVICE_NAMES.put(TelecomManager.class, Context.TELECOM_SERVICE);
        SYSTEM_SERVICE_NAMES.put(UiModeManager.class, Context.UI_MODE_SERVICE);
        SYSTEM_SERVICE_NAMES.put(UsbManager.class, Context.USB_SERVICE);
        SYSTEM_SERVICE_NAMES.put(Vibrator.class, Context.VIBRATOR_SERVICE);
        SYSTEM_SERVICE_NAMES.put(WallpaperManager.class, Context.WALLPAPER_SERVICE);
        SYSTEM_SERVICE_NAMES.put(WifiManager.class, Context.WIFI_SERVICE);
        SYSTEM_SERVICE_NAMES.put(WifiP2pManager.class, Context.WIFI_P2P_SERVICE);
        SYSTEM_SERVICE_NAMES.put(WindowManager.class, Context.WINDOW_SERVICE);
        SYSTEM_SERVICE_NAMES.put(UserManager.class, Context.USER_SERVICE);
        SYSTEM_SERVICE_NAMES.put(AppOpsManager.class, Context.APP_OPS_SERVICE);
        SYSTEM_SERVICE_NAMES.put(CameraManager.class, Context.CAMERA_SERVICE);
        SYSTEM_SERVICE_NAMES.put(LauncherApps.class, Context.LAUNCHER_APPS_SERVICE);
        SYSTEM_SERVICE_NAMES.put(RestrictionsManager.class, Context.RESTRICTIONS_SERVICE);
        SYSTEM_SERVICE_NAMES.put(PrintManager.class, Context.PRINT_SERVICE);
        SYSTEM_SERVICE_NAMES.put(ConsumerIrManager.class, Context.CONSUMER_IR_SERVICE);
        SYSTEM_SERVICE_NAMES.put(MediaSessionManager.class, Context.MEDIA_SESSION_SERVICE);
        SYSTEM_SERVICE_NAMES.put(FingerprintManager.class, Context.FINGERPRINT_SERVICE);
        SYSTEM_SERVICE_NAMES.put(TvInputManager.class, Context.TV_INPUT_SERVICE);
        SYSTEM_SERVICE_NAMES.put(UsageStatsManager.class, Context.USAGE_STATS_SERVICE);
        SYSTEM_SERVICE_NAMES.put(NetworkStatsManager.class, Context.NETWORK_STATS_SERVICE);
        SYSTEM_SERVICE_NAMES.put(JobScheduler.class, Context.JOB_SCHEDULER_SERVICE);
        SYSTEM_SERVICE_NAMES.put(MediaProjectionManager.class, Context.MEDIA_PROJECTION_SERVICE);
        SYSTEM_SERVICE_NAMES.put(AppWidgetManager.class, Context.APPWIDGET_SERVICE);
        SYSTEM_SERVICE_NAMES.put(MidiManager.class, Context.MIDI_SERVICE);
    }

    public static Object getSystemService(@NonNull String serviceName) {
        return Base.getContext().getSystemService(serviceName);
    }

    public static <T> T getSystemService(Class<T> serviceClass) {
        String serviceName = SYSTEM_SERVICE_NAMES.get(serviceClass);
        return serviceName != null ? (T) getSystemService(serviceName) : null;
    }
}
