# AndroidBaseUtils
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

#### Context free and basic utils to build Android project conveniently

Any kinds of contribution including **pull request**, **writing issue**, **email me personally** is always welcome. Let me know if you have any idea about basic utils for Android development.

# Table of Contents
1. [How to set up](https://github.com/TheFinestArtist/AndroidBaseUtils#how-to-set-up)
1. [Utils](https://github.com/TheFinestArtist/AndroidBaseUtils#base-)
    1. [Base](https://github.com/TheFinestArtist/AndroidBaseUtils#base-)
    1. [ExtrasBinder](https://github.com/TheFinestArtist/AndroidBaseUtils#extrasbinder-)
    1. [KeyboardUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#keyboardutil-)
    1. [UnitConverter](https://github.com/TheFinestArtist/AndroidBaseUtils#unitconverter-)
    1. [ScreenUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#screenutil-)
    1. [ViewUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#viewutil-)
    1. [ServiceUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#serviceutil-)
    1. [VibratorUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#vibratorutil-)
    1. [ClipboardManagerUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#clipboardmanagerutil-)
    1. [TypedValueUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#typedvalueutil-)
    1. [WindowManagerUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#windowmanagerutil-)
1. [License](https://github.com/TheFinestArtist/AndroidBaseUtils#license)

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
Base helps to get `Context`, `Resources`, `Assets`, `Configuration` and `DisplayMetrics` in any class.

```java
void            Base.initialize(Context context);

Context         Base.getContext();
Resources       Base.getResources();
AssetManager    Base.getAssets();
Configuration   Base.getConfiguration();
DisplayMetrics  Base.getDisplayMetrics();
```

## ExtrasBinder (★★★★☆)
Simply call `ExtrasBinder.bind(this)` in your `Activity` or `Fragment`. ExtrasBinder binds data from `Intent` or `Bundle` to matching variable. ExtrasBinder will consider `annotation variable` as key. If there is no annotation variable, it will consider `variable name` as key.

```java
// Start YourActivity with extras
Intent intent = new Intent(this, YourActivity.class);
intent.putExtra(YourActivity.EXTRA_TITLE, "Activity title");
intent.putExtra("ids", new ArrayList<Integer>());
startActivity(intent);
```
```java
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
// Show YourFragment with extras
YourFragment fragment = new YourFragment();
Bundle bundle = new Bundle();
bundle.putString("Name", "Fragment name");
fragment.setArguments(bundle);
```
```java
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

`ExtrasBinder` method also can be called from `Base`.
```java
void    Base.bindExtras(Activity activity);
void    Base.bindExtras(Fragment fragment);
```

## KeyboardUtil (★★★★☆)
KeyboardUtil helps to `show` and `hide` keyboard conveniently.

```java
void    KeyboardUtil.show(View);
void    KeyboardUtil.showImmediately(View); // Call this method if your activity or fragment is resumed.

void    KeyboardUtil.hide(View);
void    KeyboardUtil.hide(Activity);
void    KeyboardUtil.hide(Fragment);
void    KeyboardUtil.hide(Dialog);
```

`KeyboardUtil` method also can be called from `Base`.
```java
void    Base.showKeyboard(View);
void    Base.showKeyboardImmediately(View); // Call this method if your activity or fragment is resumed.

void    Base.hideKeyboard(View);
void    Base.hideKeyboard(Activity);
void    Base.hideKeyboard(Fragment);
void    Base.hideKeyboard(Dialog);
```

## UnitConverter (★★★★☆)
UnitConverter helps to convert dp or sp size into pixel.

```java
float   UnitConverter.dpToPx(float dp);
int     UnitConverter.dpToPx(int dp);
float   UnitConverter.pxToDp(float px);
int     UnitConverter.pxToDp(int px);
float   UnitConverter.spToPx(float sp);
int     UnitConverter.spToPx(int sp);
float   UnitConverter.pxToSp(float px);
int     UnitConverter.pxToSp(int px);
```

`UnitConverter` method also can be called from `Base`.
```java
float   Base.dpToPx(float dp);
int     Base.dpToPx(int dp);
float   Base.pxToDp(float px);
int     Base.pxToDp(int px);
float   Base.spToPx(float sp);
int     Base.spToPx(int sp);
float   Base.pxToSp(float px);
int     Base.pxToSp(int px);
```

## ScreenUtil (★★★☆☆)
ScreenUtil helps to calculate screen size conveniently.

```java
int         ScreenUtil.getDeviceWidth();
int         ScreenUtil.getDeviceHeight();
Rotation    ScreenUtil.getRotation();
int         ScreenUtil.getStatusBarHeight();
int         ScreenUtil.getToolbarHeight();
int         ScreenUtil.getActionBarHeight();
int         ScreenUtil.getNavigationBarHeight(); // Navigation bar is located bottom of device for `back`, `home` and `menu` buttons.
```

`ScreenUtil` method also can be called from `Base`.
```java
int         Base.getDeviceWidth();
int         Base.getDeviceHeight();
Rotation    Base.getRotation();
int         Base.getStatusBarHeight();
int         Base.getToolbarHeight();
int         Base.getActionBarHeight();
int         Base.getNavigationBarHeight(); // Navigation bar is located bottom of device for `back`, `home` and `menu` buttons.
```

## ViewUtil (★★☆☆☆)
ViewUtil helps to set background drawable conveniently.

```java
void    ViewUtil.setBackground(View view, Drawable drawable);
void    ViewUtil.setBackground(View view, int drawableRes);
```

`ViewUtil` method also can be called from `Base`.
```java
void    Base.setViewBackground(View view, Drawable drawable);
void    Base.setViewBackground(View view, int drawableRes);
```

## ServiceUtil (★★☆☆☆)
ServiceUtil helps to get Android system service conveniently.

```java
Object                  ServiceUtil.getSystemService(Context.ServiceName);

AccessibilityManager    ServiceUtil.getAccessibilityManager();
CaptioningManager       ServiceUtil.getCaptioningManager();
AccountManager          ServiceUtil.getAccountManager();
ActivityManager         ServiceUtil.getActivityManager();
AlarmManager            ServiceUtil.getAlarmManager();
AudioManager            ServiceUtil.getAudioManager();
MediaRouter             ServiceUtil.getMediaRouter();
// and so on...
```

`ServiceUtil` method also can be called from `Base`.
```java
Object                  Base.getSystemService(Context.ServiceName);

AccessibilityManager    Base.getAccessibilityManager();
CaptioningManager       Base.getCaptioningManager();
AccountManager          Base.getAccountManager();
ActivityManager         Base.getActivityManager();
AlarmManager            Base.getAlarmManager();
AudioManager            Base.getAudioManager();
MediaRouter             Base.getMediaRouter();
// and so on...
```

## VibratorUtil (★☆☆☆☆)
VibratorUtil helps to use `Vibrator` conveniently.

```java
void    VibratorUtil.vibrate(); // vibrate device for 200 milliseconds
void    VibratorUtil.vibrate(milliseconds);
// and more...
```

`VibratorUtil` method also can be called from `Base`.
```java
void    Base.vibrate(); // vibrate device for 200 milliseconds
void    Base.vibrate(milliseconds);
// and more...
```

## ClipboardManagerUtil (★☆☆☆☆)
ClipboardManagerUtil helps to use `ClipboardManager` conveniently.

```java
void            ClipboardManagerUtil.setText(CharSequence text);
boolean         ClipboardManagerUtil.hasText();
CharSequence    ClipboardManagerUtil.getText();
```

`ClipboardManagerUtil` method also can be called from `Base`.
```java
void            Base.clipText(CharSequence text);
boolean         Base.hasClipedText();
CharSequence    Base.getClipedText();
```

## TypedValueUtil (☆☆☆☆☆)
TypedValueUtil helps to use `TypedValue` class conveniently.

```java
float   TypedValueUtil.applyDimension(int unit, float value);
float   TypedValueUtil.complexToDimension(int data);
int     TypedValueUtil.complexToDimensionPixelOffset(int data);
int     TypedValueUtil.complexToDimensionPixelSize(int data);
```

`TypedValueUtil` method also can be called from `Base`.
```java
float   Base.applyDimension(int unit, float value);
float   Base.complexToDimension(int data);
int     Base.complexToDimensionPixelOffset(int data);
int     Base.complexToDimensionPixelSize(int data);
```

## WindowManagerUtil (☆☆☆☆☆)
WindowManagerUtil helps to use Android {@link WindowManager} conveniently.

```java
Display     WindowManagerUtil.getDefaultDisplay();
void        WindowManagerUtil.removeViewImmediate(View view);
```

`WindowManagerUtil` method also can be called from `Base`.
```java
Display     Base.getDefaultDisplay();
void        Base.removeViewImmediate(View view);
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