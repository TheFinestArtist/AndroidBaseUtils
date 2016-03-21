package com.thefinestartist.utils.service;

import android.accounts.AccountManager;
import android.annotation.TargetApi;
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
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;

import com.thefinestartist.Base;

/**
 * ServiceUtil helps to manage Android system service conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ServiceUtil {

    public static Object getSystemService(@NonNull String serviceName) {
        return Base.getContext().getSystemService(serviceName);
    }

    public static AccessibilityManager getAccessibilityManager() {
        return (AccessibilityManager) getSystemService(Context.ACCESSIBILITY_SERVICE);
    }

    @TargetApi(19)
    public static CaptioningManager getCaptioningManager() {
        return (CaptioningManager) getSystemService(Context.CAPTIONING_SERVICE);
    }

    public static AccountManager getAccountManager() {
        return (AccountManager) getSystemService(Context.ACCOUNT_SERVICE);
    }

    public static ActivityManager getActivityManager() {
        return (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
    }

    public static AlarmManager getAlarmManager() {
        return (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    }

    public static AudioManager getAudioManager() {
        return (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    @TargetApi(16)
    public static MediaRouter getMediaRouter() {
        return (MediaRouter) getSystemService(Context.MEDIA_ROUTER_SERVICE);
    }

    @TargetApi(18)
    public static BluetoothManager getBluetoothManager() {
        return (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
    }

    public static ClipboardManager getClipboardManager() {
        return (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @TargetApi(8)
    public static DevicePolicyManager getDevicePolicyManager() {
        return (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
    }

    @TargetApi(9)
    public static DownloadManager getDownloadManager() {
        return (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
    }

    @TargetApi(21)
    public static BatteryManager getBatteryManager() {
        return (BatteryManager) getSystemService(Context.BATTERY_SERVICE);
    }

    @TargetApi(10)
    public static NfcManager getNfcManager() {
        return (NfcManager) getSystemService(Context.NFC_SERVICE);
    }

    @TargetApi(8)
    public static DropBoxManager getDropBoxManager() {
        return (DropBoxManager) getSystemService(Context.DROPBOX_SERVICE);
    }

    @TargetApi(16)
    public static InputManager getInputManager() {
        return (InputManager) getSystemService(Context.INPUT_SERVICE);
    }

    @TargetApi(17)
    public static DisplayManager getDisplayManager() {
        return (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
    }

    public static InputMethodManager getInputMethodManager() {
        return (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @TargetApi(14)
    public static TextServicesManager getTextServicesManager() {
        return (TextServicesManager) getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
    }

    public static KeyguardManager getKeyguardManager() {
        return (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
    }

    public static LayoutInflater getLayoutInflater() {
        return (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static LocationManager getLocationManager() {
        return (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    public static NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @TargetApi(16)
    public static NsdManager getNsdManager() {
        return (NsdManager) getSystemService(Context.NSD_SERVICE);
    }

    public static PowerManager getPowerManager() {
        return (PowerManager) getSystemService(Context.POWER_SERVICE);
    }

    public static SearchManager getSearchManager() {
        return (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    }

    public static SensorManager getSensorManager() {
        return (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @TargetApi(9)
    public static StorageManager getStorageManager() {
        return (StorageManager) getSystemService(Context.STORAGE_SERVICE);
    }

    public static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    }

    @TargetApi(22)
    public static SubscriptionManager getSubscriptionManager() {
        return (SubscriptionManager) getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
    }

    @TargetApi(23)
    public static CarrierConfigManager getCarrierConfigManager() {
        return (CarrierConfigManager) getSystemService(Context.CARRIER_CONFIG_SERVICE);
    }

    @TargetApi(21)
    public static TelecomManager getTelecomManager() {
        return (TelecomManager) getSystemService(Context.TELECOM_SERVICE);
    }

    @TargetApi(8)
    public static UiModeManager getUiModeManager() {
        return (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);
    }

    @TargetApi(12)
    public static UsbManager getUsbManager() {
        return (UsbManager) getSystemService(Context.USB_SERVICE);
    }

    public static Vibrator getVibrator() {
        return (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public static WallpaperManager getWallpaperManager() {
        return WallpaperManager.getInstance(Base.getContext());
    }

    public static WifiManager getWifiManager() {
        return (WifiManager) getSystemService(Context.WIFI_SERVICE);
    }

    @TargetApi(14)
    public static WifiP2pManager getWifiP2pManager() {
        return (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
    }

    public static WindowManager getWindowManager() {
        return (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    }

    @TargetApi(17)
    public static UserManager getUserManager() {
        return (UserManager) getSystemService(Context.USER_SERVICE);
    }

    @TargetApi(19)
    public static AppOpsManager getAppOpsManager() {
        return (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
    }

    @TargetApi(21)
    public static CameraManager getCameraManager() {
        return (CameraManager) getSystemService(Context.CAMERA_SERVICE);
    }

    @TargetApi(21)
    public static LauncherApps getLauncherApps() {
        return (LauncherApps) getSystemService(Context.LAUNCHER_APPS_SERVICE);
    }

    @TargetApi(21)
    public static RestrictionsManager getRestrictionsManager() {
        return (RestrictionsManager) getSystemService(Context.RESTRICTIONS_SERVICE);
    }

    @TargetApi(19)
    public static PrintManager getPrintManager() {
        return (PrintManager) getSystemService(Context.PRINT_SERVICE);
    }

    @TargetApi(19)
    public static ConsumerIrManager getConsumerIrManager() {
        return (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);
    }

    @TargetApi(21)
    public static MediaSessionManager getMediaSessionManager() {
        return (MediaSessionManager) getSystemService(Context.MEDIA_SESSION_SERVICE);
    }

    @TargetApi(23)
    public static FingerprintManager getFingerprintManager() {
        return (FingerprintManager) getSystemService(Context.FINGERPRINT_SERVICE);
    }

    @TargetApi(21)
    public static TvInputManager getTvInputManager() {
        return (TvInputManager) getSystemService(Context.TV_INPUT_SERVICE);
    }

    @TargetApi(22)
    public static UsageStatsManager getUsageStatsManager() {
        return (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
    }

    @TargetApi(23)
    public static NetworkStatsManager getNetworkStatsManager() {
        return (NetworkStatsManager) getSystemService(Context.NETWORK_STATS_SERVICE);
    }

    @TargetApi(21)
    public static JobScheduler getJobScheduler() {
        return (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }

    @TargetApi(21)
    public static MediaProjectionManager getMediaProjectionManager() {
        return (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
    }

    @TargetApi(21)
    public static AppWidgetManager getAppWidgetManager() {
        return (AppWidgetManager) getSystemService(Context.APPWIDGET_SERVICE);
    }

    @TargetApi(23)
    public static MidiManager getMidiManager() {
        return (MidiManager) getSystemService(Context.MIDI_SERVICE);
    }
}