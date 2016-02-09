# AndroidBaseUtils
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

#### Context free and basic utils for building Android project

## KeyboardUtil
KeyboardUtil helps to `show` and `hide` keyboard easily.
```java
KeyboardUtil.show(View);
KeyboardUtil.showImmediately(View); // Call this method if your activity or fragment is resumed.

KeyboardUtil.hide(View);
KeyboardUtil.hide(Activity);
KeyboardUtil.hide(Fragment);
KeyboardUtil.hide(Dialog);
```

## ExtrasBinder
Simply call `ExtrasBinder.bind(this);` in your `Activity` or `Fragment`. ExtrasBinder bind data from `Intent` or `Bundle` into matching variable.

```java
public class YourActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "TITLE";

    // ExtrasBinder will consider annotation variable as key. 
    // In this case, key is "TITLE".
    @Extra(EXTRA_TITLE) String title;
    
    // ExtrasBinder will consider variable name as key. 
    // In this case, key is "ids".
    @Extra ArrayList<Integer> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExtrasBinder.bind(this);
        // do something...
    }
}
```
```java
public class YourFragment extends Fragment {

    // ExtrasBinder will consider annotation variable as key. 
    // In this case, key is "NAME".
    @Extra("NAME") String name;
    
    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ExtrasBinder.bind(this);
        // do something...
    }
}
```

## ServiceUtil
ServiceUtil helps to get Android system service conveniently.
```java
ServiceUtil.getSystemService(@NonNull String serviceName);

ServiceUtil.getAccessibilityManager();
ServiceUtil.getCaptioningManager();
ServiceUtil.getAccountManager();
ServiceUtil.getActivityManager();
ServiceUtil.getAlarmManager();
ServiceUtil.getAudioManager();
ServiceUtil.getMediaRouter();
ServiceUtil.getBluetoothManager();
ServiceUtil.getClipboardManager();
ServiceUtil.getConnectivityManager();
ServiceUtil.getDevicePolicyManager();
ServiceUtil.getDownloadManager();
ServiceUtil.getBatteryManager();
ServiceUtil.getNfcManager();
ServiceUtil.getDropBoxManager();
ServiceUtil.getInputManager();
ServiceUtil.getDisplayManager();
ServiceUtil.getInputMethodManager();
ServiceUtil.getTextServicesManager();
ServiceUtil.getKeyguardManager();
ServiceUtil.getLayoutInflater();
ServiceUtil.getLocationManager();
ServiceUtil.getNotificationManager();
ServiceUtil.getNsdManager();
ServiceUtil.getPowerManager();
ServiceUtil.getSearchManager();
ServiceUtil.getSensorManager();
ServiceUtil.getStorageManager();
ServiceUtil.getTelephonyManager();
ServiceUtil.getSubscriptionManager();
ServiceUtil.getCarrierConfigManager();
ServiceUtil.getTelecomManager();
ServiceUtil.getUiModeManager();
ServiceUtil.getUsbManager();
ServiceUtil.getVibrator();
ServiceUtil.getWallpaperManager();
ServiceUtil.getWifiManager();
ServiceUtil.getWifiP2pManager();
ServiceUtil.getWindowManager();
ServiceUtil.getUserManager();
ServiceUtil.getAppOpsManager();
ServiceUtil.getCameraManager();
ServiceUtil.getLauncherApps();
ServiceUtil.getRestrictionsManager();
ServiceUtil.getPrintManager();
ServiceUtil.getConsumerIrManager();
ServiceUtil.getMediaSessionManager();
ServiceUtil.getFingerprintManager();
ServiceUtil.getTvInputManager();
ServiceUtil.getUsageStatsManager();
ServiceUtil.getNetworkStatsManager();
ServiceUtil.getJobScheduler();
ServiceUtil.getMediaProjectionManager();
ServiceUtil.getAppWidgetManager();
ServiceUtil.getMidiManager();
```

## License

```
The MIT License (MIT)

Copyright (c) 2016 TheFinestArtist

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```