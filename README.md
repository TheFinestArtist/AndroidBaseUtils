# AndroidBaseUtils
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

#### Context free and basic utils to build Android project conveniently

Any kinds of contributions including **pull requests**, **writing issues**, **email me personally** are always welcome. Let me know if you have any idea about basic utils for Android development.


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
    1. [ActivityBuilder](https://github.com/TheFinestArtist/AndroidBaseUtils#activitybuilder-)
    1. [BundleBuilder](https://github.com/TheFinestArtist/AndroidBaseUtils#bundlebuilder-)
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

# Utils

## Base (★★★★★)
Base helps to get `Context`, `Resources`, `Assets`, `Configuration` and `DisplayMetrics` in any class.

```java
void            Base.initialize(Context context);

Context         Base.getContext();
Resources       Base.getResources();
Theme           Base.getResources();
AssetManager    Base.getTheme();
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

## ViewUtil (★★☆☆☆)
ViewUtil helps to set background drawable conveniently.

```java
void    ViewUtil.setBackground(View view, Drawable drawable);
void    ViewUtil.setBackground(View view, int drawableRes);
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

## ActivityBuilder (★★☆☆☆)
ActivityBuilder helps to build Activity Intent and start Activity.

```java
                ActivityBuilder(@NonNull Class<C> clazz);

ActivityBuilder set(@NonNull String key, T value);
ActivityBuilder set(@NonNull String key, Parcelable value);
ActivityBuilder set(@NonNull String key, Parcelable[] value);
ActivityBuilder set(@NonNull String key, ArrayList<T> value);
ActivityBuilder remove(@NonNull String key);
ActivityBuilder setFlags(int flags);
ActivityBuilder addFlags(int flags);

Intent          buildIntent();
void            start();
void            startForResult(@NonNull Activity activity, int requestCode);
void            startForResult(@NonNull Activity activity, int requestCode, @Nullable Bundle options);
```

```java
new ActivityBuilder(YourActivity.class)
    .set(YourActivity.TITLE, "Title")
    .set(YourActivity.CONTENT, 1)
    .set("values", new int[]{1, 2, 3})
    .set(YourActivity.ARRAY_LIST, list)
    .start();
```

## BundleBuilder (★★☆☆☆)
BundleBuilder helps to build Bundle conveniently.

```java
BundleBuilder set(String key, T value);
T get(String key);
Bundle build();
```

```java
Bundle bundle = new BundleBuilder()
                    .set("values", new int[]{1, 2, 3})
                    .build();
```


## VibratorUtil (★☆☆☆☆)
VibratorUtil helps to use `Vibrator` conveniently.

```java
void    VibratorUtil.vibrate(); // vibrate device for 200 milliseconds
void    VibratorUtil.vibrate(milliseconds);
// and more...
```

## ClipboardManagerUtil (★☆☆☆☆)
ClipboardManagerUtil helps to use `ClipboardManager` conveniently.

```java
void            ClipboardManagerUtil.setText(CharSequence text);
boolean         ClipboardManagerUtil.hasText();
CharSequence    ClipboardManagerUtil.getText();
```

## TypedValueUtil (☆☆☆☆☆)
TypedValueUtil helps to use `TypedValue` class conveniently.

```java
float   TypedValueUtil.applyDimension(int unit, float value);
float   TypedValueUtil.complexToDimension(int data);
int     TypedValueUtil.complexToDimensionPixelOffset(int data);
int     TypedValueUtil.complexToDimensionPixelSize(int data);
```

## WindowManagerUtil (☆☆☆☆☆)
WindowManagerUtil helps to use Android {@link WindowManager} conveniently.

```java
Display     WindowManagerUtil.getDefaultDisplay();
void        WindowManagerUtil.removeViewImmediate(View view);
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