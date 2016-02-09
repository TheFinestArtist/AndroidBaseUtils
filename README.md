# AndroidBaseUtils
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

#### Context free and basic utils to build Android project conveniently

## How to set up
Call `Base.initialize(context)` within your `Application` `onCreate()` method.
```java
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Base.initialize(this);
    }
}
```

## Base (★★★★★)
Base helps to get `Context`, `Resources`, `Configuration` and `DisplayMetrics` in any class.

```java
Base.initialize(Context context);

Base.getContext();
Base.getResources();
Base.getConfiguration();
Base.getDisplayMetrics();
```

## ExtrasBinder (★★★★☆)
Simply call `ExtrasBinder.bind(this)` in your `Activity` or `Fragment`. ExtrasBinder binds data from `Intent` or `Bundle` to matching variable. ExtrasBinder will consider `annotation variable` as key. If there is no annotation variable, it will consider `variable name` as key.

```java
Intent intent = new Intent(this, YourActivity.class);
intent.putExtra(YourActivity.EXTRA_TITLE, "Title");
intent.putExtra("ids", new ArrayList<Integer>());
startActivity(intent);

public class YourActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "TITLE";

    @Extra(EXTRA_TITLE) String title;
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
YourFragment fragment = new YourFragment();
Bundle bundle = new Bundle();
bundle.putString("Name", "Name");
fragment.setArguments(bundle);

public class YourFragment extends Fragment {

    @Extra("NAME") String name;
    
    @Nullable 
    @Override 
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ExtrasBinder.bind(this);
        // do something...
    }
}
```

## KeyboardUtil (★★★★☆)
KeyboardUtil helps to `show` and `hide` keyboard conveniently.

```java
KeyboardUtil.show(View);
KeyboardUtil.showImmediately(View); // Call this method if your activity or fragment is resumed.

KeyboardUtil.hide(View);
KeyboardUtil.hide(Activity);
KeyboardUtil.hide(Fragment);
KeyboardUtil.hide(Dialog);
```

## ScaleUtil (★★★★☆)
ScaleUtil helps to convert dp or sp size into pixel.

```java
ScaleUtil.applyDimension(int unit, float value);
ScaleUtil.applyDimension(int unit, int value);
ScaleUtil.toPixel(float dp);
ScaleUtil.toPixel(int dp);
ScaleUtil.toPixelFromSP(float sp);
ScaleUtil.toPixelFromSP(int sp);
```

## ScreenUtil (★★★☆☆)
ScreenUtil helps to calculate screen size conveniently.

```java
ScreenUtil.getDeviceWidth();
ScreenUtil.getDeviceHeight();
ScreenUtil.getStatusBarHeight();
ScreenUtil.getToolbarHeight();
ScreenUtil.getActionBarHeight();
ScreenUtil.getNavigationBarHeight(); // Navigation bar is located bottom of device for `back`, `home` and `menu` buttons.
```

## ViewUtil (★★☆☆☆)
ViewUtil helps to set background drawable conveniently.

```java
ViewUtil.setBackground(View view, Drawable drawable);
ViewUtil.setBackground(View view, int drawableRes);
```

## ServiceUtil (★★☆☆☆)
ServiceUtil helps to get Android system service conveniently.

```java
(ServiceType) ServiceUtil.getSystemService(Context.ServiceName);

ServiceUtil.getAccessibilityManager();
ServiceUtil.getCaptioningManager();
ServiceUtil.getAccountManager();
ServiceUtil.getActivityManager();
ServiceUtil.getAlarmManager();
ServiceUtil.getAudioManager();
ServiceUtil.getMediaRouter();
// and so on...
```

## VibratorUtil (★☆☆☆☆)
VibratorUtil helps to use `Vibrator` conveniently.

```java
VibratorUtil.eee(); // vibrate device for 200 milliseconds
VibratorUtil.vibrate(milliseconds);
// and more...
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