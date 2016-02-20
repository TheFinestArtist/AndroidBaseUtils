# AndroidBaseUtils
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

#### Context free and basic utils to build Android project conveniently

Any kinds of contribution including **pull request**, **writing issue**, **email me personally** is always welcome. Let me know if you have any idea about basic utils for Android development.


# Table of Contents
1. [Get started](https://github.com/TheFinestArtist/AndroidBaseUtils#get-started)
1. [Utils](https://github.com/TheFinestArtist/AndroidBaseUtils#utils)
    1. [Base](https://github.com/TheFinestArtist/AndroidBaseUtils#base-)
    1. [ExtrasBinder](https://github.com/TheFinestArtist/AndroidBaseUtils#extrasbinder-)
    1. [KeyboardUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#keyboardutil-)
    1. [UnitConverter](https://github.com/TheFinestArtist/AndroidBaseUtils#unitconverter-)
    1. [APILevel](https://github.com/TheFinestArtist/AndroidBaseUtils#apilevel-)
    1. [DisplayUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#displayutil-)
    1. [ViewUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#viewutil-)
    1. [ServiceUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#serviceutil-)
    1. [VibratorUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#vibratorutil-)
    1. [ClipboardManagerUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#clipboardmanagerutil-)
    1. [TypedValueUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#typedvalueutil-)
    1. [WindowManagerUtil](https://github.com/TheFinestArtist/AndroidBaseUtils#windowmanagerutil-)
1. [License](https://github.com/TheFinestArtist/AndroidBaseUtils#license)

# Get started

#### Gradle Dependency (jcenter)
```java
dependencies {
}
```

#### Initialization (Application)
Call `BaseUtil.initialize(context)` within your `Application` `onCreate()` method.
```java
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseUtil.initialize(this);
    }
}
```

# Utils

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

`ExtrasBinder` method also can be called from `BaseUtil`.
```java
void    BaseUtil.bindExtras(Activity activity);
void    BaseUtil.bindExtras(Fragment fragment);
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

`KeyboardUtil` method also can be called from `BaseUtil`.
```java
void    BaseUtil.showKeyboard(View);
void    BaseUtil.showKeyboardImmediately(View); // Call this method if your activity or fragment is resumed.

void    BaseUtil.hideKeyboard(View);
void    BaseUtil.hideKeyboard(Activity);
void    BaseUtil.hideKeyboard(Fragment);
void    BaseUtil.hideKeyboard(Dialog);
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

`UnitConverter` method also can be called from `BaseUtil`.
```java
float   BaseUtil.dpToPx(float dp);
int     BaseUtil.dpToPx(int dp);
float   BaseUtil.pxToDp(float px);
int     BaseUtil.pxToDp(int px);
float   BaseUtil.spToPx(float sp);
int     BaseUtil.spToPx(int sp);
float   BaseUtil.pxToSp(float px);
int     BaseUtil.pxToSp(int px);
```

## APILevel (★★★☆☆)
`APILevel` helps to check device API `Build.VERSION` conveniently.
```java
boolean APILevel.require(int level); // Build.VERSION.SDK_INT >= level
boolean APILevel.requireCupcake();
boolean APILevel.requireDonut();
boolean APILevel.requireEclair();
boolean APILevel.requireFroyo();
boolean APILevel.requireGingerbread();
// and so on...

boolean APILevel.depecatedAt(int level); // Build.VERSION.SDK_INT < level
boolean APILevel.depecatedAtCupcake();
boolean APILevel.depecatedAtDonut();
boolean APILevel.depecatedAtEclair();
boolean APILevel.depecatedAtFroyo();
boolean APILevel.depecatedAtGingerbread();
// and so on...
```

`APILevel` method also can be called from `BaseUtil`.
```java
boolean BaseUtil.requireAPI(int level); // Build.VERSION.SDK_INT >= level
boolean BaseUtil.requireAPICupcake();
boolean BaseUtil.requireAPIDonut();
boolean BaseUtil.requireAPIEclair();
boolean BaseUtil.requireAPIFroyo();
boolean BaseUtil.requireAPIGingerbread();
// and so on...

boolean BaseUtil.depecatedAtAPI(int level); // Build.VERSION.SDK_INT < level
boolean BaseUtil.depecatedAtAPICupcake();
boolean BaseUtil.depecatedAtAPIDonut();
boolean BaseUtil.depecatedAtAPIEclair();
boolean BaseUtil.depecatedAtAPIFroyo();
boolean BaseUtil.depecatedAtAPIGingerbread();
// and so on...
```

## DisplayUtil (★★★☆☆)
DisplayUtil helps to calculate screen size conveniently.

```java
int         DisplayUtil.getWidth();
int         DisplayUtil.getHeight();
Rotation    DisplayUtil.getRotation();
boolean     DisplayUtil.isDisplayPortrait();
boolean     DisplayUtil.isDisplayLandscape();
int         DisplayUtil.getStatusBarHeight();
int         DisplayUtil.getToolbarHeight();
int         DisplayUtil.getActionBarHeight();
int         DisplayUtil.getNavigationBarHeight(); // Navigation bar is located bottom of device for `back`, `home` and `menu` buttons.
```

`DisplayUtil` method also can be called from `BaseUtil`.
```java
int         BaseUtil.getDisplayWidth();
int         BaseUtil.getDisplayHeight();
Rotation    BaseUtil.getDisplayRotation();
boolean     BaseUtil.isPortrait();
boolean     BaseUtil.isLandscape();
int         BaseUtil.getStatusBarHeight();
int         BaseUtil.getToolbarHeight();
int         BaseUtil.getActionBarHeight();
int         BaseUtil.getNavigationBarHeight(); // Navigation bar is located bottom of device for `back`, `home` and `menu` buttons.
```

## ViewUtil (★★☆☆☆)
ViewUtil helps to set background drawable conveniently.

```java
void    ViewUtil.setBackground(View view, Drawable drawable);
void    ViewUtil.setBackground(View view, int drawableRes);
```

`ViewUtil` method also can be called from `BaseUtil`.
```java
void    BaseUtil.setViewBackground(View view, Drawable drawable);
void    BaseUtil.setViewBackground(View view, int drawableRes);
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

`ServiceUtil` method also can be called from `BaseUtil`.
```java
Object                  BaseUtil.getSystemService(Context.ServiceName);

AccessibilityManager    BaseUtil.getAccessibilityManager();
CaptioningManager       BaseUtil.getCaptioningManager();
AccountManager          BaseUtil.getAccountManager();
ActivityManager         BaseUtil.getActivityManager();
AlarmManager            BaseUtil.getAlarmManager();
AudioManager            BaseUtil.getAudioManager();
MediaRouter             BaseUtil.getMediaRouter();
// and so on...
```

## VibratorUtil (★☆☆☆☆)
VibratorUtil helps to use `Vibrator` conveniently.

```java
void    VibratorUtil.vibrate(); // vibrate device for 200 milliseconds
void    VibratorUtil.vibrate(milliseconds);
// and more...
```

`VibratorUtil` method also can be called from `BaseUtil`.
```java
void    BaseUtil.vibrate(); // vibrate device for 200 milliseconds
void    BaseUtil.vibrate(milliseconds);
// and more...
```

## ClipboardManagerUtil (★☆☆☆☆)
ClipboardManagerUtil helps to use `ClipboardManager` conveniently.

```java
void            ClipboardManagerUtil.setText(CharSequence text);
boolean         ClipboardManagerUtil.hasText();
CharSequence    ClipboardManagerUtil.getText();
```

`ClipboardManagerUtil` method also can be called from `BaseUtil`.
```java
void            BaseUtil.clipText(CharSequence text);
boolean         BaseUtil.hasClipedText();
CharSequence    BaseUtil.getClipedText();
```

## TypedValueUtil (☆☆☆☆☆)
TypedValueUtil helps to use `TypedValue` class conveniently.

```java
float   TypedValueUtil.applyDimension(int unit, float value);
float   TypedValueUtil.complexToDimension(int data);
int     TypedValueUtil.complexToDimensionPixelOffset(int data);
int     TypedValueUtil.complexToDimensionPixelSize(int data);
```

`TypedValueUtil` method also can be called from `BaseUtil`.
```java
float   BaseUtil.applyDimension(int unit, float value);
float   BaseUtil.complexToDimension(int data);
int     BaseUtil.complexToDimensionPixelOffset(int data);
int     BaseUtil.complexToDimensionPixelSize(int data);
```

## WindowManagerUtil (☆☆☆☆☆)
WindowManagerUtil helps to use Android {@link WindowManager} conveniently.

```java
Display     WindowManagerUtil.getDefaultDisplay();
void        WindowManagerUtil.removeViewImmediate(View view);
```

`WindowManagerUtil` method also can be called from `BaseUtil`.
```java
Display     BaseUtil.getDefaultDisplay();
void        BaseUtil.removeViewImmediate(View view);
```

# License

```
The MIT License (MIT)

Copyright (c) 2016 The Finest Artist

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