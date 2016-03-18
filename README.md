# AndroidBaseUtils
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

<img align="center" src="https://github.com/TheFinestArtist/AndroidBaseUtils/blob/master/art/256_1.png"/>

#### Context free and basic utils to build Android project conveniently

Any kinds of contributions including **pull requests**, **registering new issues**, **sending me personal emails** are always welcome. Let me know if you have any idea about basic utils for Android development.


# Table of Contents
1. [Get started](#get-started)
1. [Utils](#utils)
    1. [Base](#base-)
    1. [LogUtil](#logutil-)
    1. [LogHelper](#loghelper-)
    1. [ContextUtil](#contextutil-)
    1. [ResourcesUtil](#resourcesutil-)
    1. [PreferenceUtil](#preferenceutil-)
    1. [ExtrasBinder](#extrasbinder-)
    1. [UnitConverter](#unitconverter-)
    1. [KeyboardUtil](#keyboardutil-)
    1. [APILevel](#apilevel-)
    1. [DisplayUtil](#displayutil-)
    1. [ViewUtil](#viewutil-)
    1. [ServiceUtil](#serviceutil-)
    1. [ThemeUtil](#themeutil-)
    1. [ActivityBuilder](#activitybuilder-)
    1. [BundleBuilder](#bundlebuilder-)
    1. [PackageUtil](#packageutil-)
    1. [VibratorUtil](#vibratorutil-)
    1. [ClipboardManagerUtil](#clipboardmanagerutil-)
    1. [TypedValueUtil](#typedvalueutil-)
    1. [WindowManagerUtil](#windowmanagerutil-)
    1. [IntArrayUtil](#intarrayutil-)
    1. [SparseArrayUtil](#sparsearrayutil-)
    1. [ThreadUtil](#threadutil-)
1. [Contributors](#contributors)
1. [License](#license)

# Get started

#### Gradle Dependency (jcenter)
Release is in process...
```java
buildscript {
    dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
}

apply plugin: 'com.neenbedankt.android-apt'

dependencies {
    compile 'com.thefinestartist:utils:0.8.5'
    apt 'com.thefinestartist:compilers:0.8.5'
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
Theme           Base.getTheme();
AssetManager    Base.getAssets();
Configuration   Base.getConfiguration();
DisplayMetrics  Base.getDisplayMetrics();
```

## LogUtil (★★★★★)
LogUtil helps to deal with Log conveniently.

```java
void        LogUtil.setDefaultTag(String tag);
void        LogUtil.setDefaultShowThreadInfo(boolean showThreadInfo);
void        LogUtil.setDefaultMethodCount(int methodCount);
void        LogUtil.setDefaultLogLevel(LogLevel logLevel);

LogHelper   LogUtil.tag(String tag);
LogHelper   LogUtil.showThreadInfo(boolean showThreadInfo);
LogHelper   LogUtil.methodCount(int methodCount);
LogHelper   LogUtil.logLevel(LogLevel logLevel);

void        LogUtil.v(byte message);
void        LogUtil.v(char message);
void        LogUtil.v(short message);
void        LogUtil.v(int message);
void        LogUtil.v(long message);
void        LogUtil.v(float message);
void        LogUtil.v(double message);
void        LogUtil.v(boolean message);
void        LogUtil.v(String message);
void        LogUtil.v(JSONObject message);
void        LogUtil.v(JSONArray message);
void        LogUtil.v(Exception message);
void        LogUtil.v(Object message);
// and so on...

void        LogUtil.json(String jsonString);
void        LogUtil.json(LogLevel logLevel, String jsonString);
void        LogUtil.xml(String xmlString);
void        LogUtil.xml(LogLevel logLevel, String jsonString);
```

```java
LogUtil.v("Hello World");
LogUtil.tag("MainActivity").e(12.0f);
LogUtil.methodCount(3).json("{\"name\":\"Leonardo Taehwan Kim\",\"email\":\"leonardo@thefinestartist.com\"}");
```

## LogHelper (★★★★★)
LogHelper helps to deal with Log conveniently.

```java
LogHelper   new LogHelper();
LogHelper   new LogHelper(String tag);
LogHelper   new LogHelper(Class clazz);

LogHelper   tag(String tag);
LogHelper   showThreadInfo(boolean showThreadInfo);
LogHelper   methodCount(int methodCount);
LogHelper   logLevel(LogLevel logLevel);

void        v(byte message);
void        v(char message);
void        v(short message);
void        v(int message);
void        v(long message);
void        v(float message);
void        v(double message);
void        v(boolean message);
void        v(String message);
void        v(JSONObject message);
void        v(JSONArray message);
void        v(Exception message);
void        v(Object message);
// and so on...

void        json(String jsonString);
void        json(LogLevel logLevel, String jsonString);
void        xml(String xmlString);
void        xml(LogLevel logLevel, String jsonString);
```

```java
LogHelper logHelper = new LogHelper(MainActivity.class).showThreadInfo(true);

logHelper.v("Hello World");
logHelper.e(12.0f);
logHelper.json("{\"name\":\"Leonardo Taehwan Kim\",\"email\":\"leonardo@thefinestartist.com\"}");
```

## ContextUtil (★★★★★)
ContextUtil helps to use Context conveniently.

```java
boolean         ContextUtil.bindService(Intent service, ServiceConnection conn, int flags);
int             ContextUtil.checkCallingOrSelfPermission(String permission);
int             ContextUtil.checkSelfPermission(@NonNull String permission);
void            ContextUtil.enforceCallingOrSelfPermission(String permission, String message);
void            ContextUtil.enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message);
ApplicationInfo ContextUtil.getApplicationInfo();
File            ContextUtil.getCacheDir();
File            ContextUtil.getExternalCacheDir();
File            ContextUtil.getExternalFilesDir(String type);
Looper          ContextUtil.getMainLooper();
Object          ContextUtil.getSystemService(String name);
void            ContextUtil.sendBroadcast(Intent intent, String receiverPermission);
void            ContextUtil.sendBroadcast(Intent intent);
boolean         ContextUtil.startActivities(Intent[] intents, Bundle options);
boolean         ContextUtil.startActivities(Intent[] intents);
void            ContextUtil.startActivity(@NonNull Intent intent);
void            ContextUtil.startActivity(Intent intent, Bundle options);
ComponentName   ContextUtil.startService(Intent service);
boolean         ContextUtil.stopService(Intent service);
void            ContextUtil.unbindService(ServiceConnection conn);
// and so on...
```

## ResourcesUtil (★★★★★)
ResourcesUtil helps to use Resources conveniently.

```java
XmlResourceParser   ResourcesUtil.getAnimation(@AnimRes int animRes);
boolean             ResourcesUtil.getBoolean(@BoolRes int boolRes);
int                 ResourcesUtil.getColor(@ColorRes int colorRes);
int                 ResourcesUtil.getColor(@ColorRes int colorRes, Resources.Theme theme);
ColorStateList      ResourcesUtil.getColorStateList(@ColorRes int colorRes);
ColorStateList      ResourcesUtil.getColorStateList(@ColorRes int colorRes, Resources.Theme theme);
float               ResourcesUtil.getDimension(@DimenRes int dimenRes);
int                 ResourcesUtil.getDimensionPixelOffset(@DimenRes int dimenRes);
int                 ResourcesUtil.getDimensionPixelSize(@DimenRes int dimenRes);
DisplayMetrics      ResourcesUtil.getDisplayMetrics();
Drawable            ResourcesUtil.getDrawable(@DrawableRes int drawableRes);
int                 ResourcesUtil.getIdentifier(String name, String defType, String defPackage);
int[]               ResourcesUtil.getIntArray(@ArrayRes int arrayRes);
int                 ResourcesUtil.getInteger(@IntegerRes int integerRes);
XmlResourceParser   ResourcesUtil.getLayout(@LayoutRes int layoutRes);
String              ResourcesUtil.getQuantityString(int id, int quantity, Object... formatArgs);
CharSequence        ResourcesUtil.getQuantityText(int id, int quantity);
String              ResourcesUtil.getResourceEntryName(@AnyRes int anyRes);
String              ResourcesUtil.getResourceName(@AnyRes int anyRes);
String              ResourcesUtil.getResourcePackageName(@AnyRes int anyRes);
String              ResourcesUtil.getResourceTypeName(@AnyRes int anyRes);
String              ResourcesUtil.getString(@StringRes int stringRes);
String              ResourcesUtil.getString(@StringRes int stringRes, Object... formatArgs);
String[]            ResourcesUtil.getStringArray(@ArrayRes int arrayRes);
CharSequence        ResourcesUtil.getText(@StringRes int stringRes, CharSequence def);
CharSequence        ResourcesUtil.getText(@StringRes int stringRes);
CharSequence[]      ResourcesUtil.getTextArray(@ArrayRes int arrayRes);
void                ResourcesUtil.getValue(String name, TypedValue outValue, boolean resolveRefs);
void                ResourcesUtil.getValue(@AnyRes int anyRes, TypedValue outValue, boolean resolveRefs);
void                ResourcesUtil.getValueForDensity(@AnyRes int anyRes, int density, TypedValue outValue, boolean resolveRefs);
XmlResourceParser   ResourcesUtil.getXml(@XmlRes int xmlRes);
TypedArray          ResourcesUtil.obtainAttributes(AttributeSet set, int[] attrs);
TypedArray          ResourcesUtil.obtainTypedArray(@ArrayRes int anyRes);
InputStream         ResourcesUtil.openRawResource(@RawRes int rawRes);
AssetFileDescriptor ResourcesUtil.openRawResourceFd(@RawRes int rawRes);
int[]               ResourcesUtil.getColorArray(@ArrayRes int array);
// and so on...
```

## PreferenceUtil (★★★★★)
PreferenceUtil helps to manage application-wide preferences conveniently.

```java
String         PreferenceUtil.getDefaultName();
void           PreferenceUtil.setDefaultName(String name);

boolean        PreferenceUtil.get(String key, boolean defValue);
int            PreferenceUtil.get(String key, int defValue);
float          PreferenceUtil.get(String key, float defValue);
long           PreferenceUtil.get(String key, long defValue);
String         PreferenceUtil.get(String key, String defValue);
Set<String>    PreferenceUtil.get(String key, Set<String> defValue);
C              PreferenceUtil.get(String key, C defValue);

boolean        PreferenceUtil.get(String name, String key, boolean defValue);
int            PreferenceUtil.get(String name, String key, int defValue);
float          PreferenceUtil.get(String name, String key, float defValue);
long           PreferenceUtil.get(String name, String key, long defValue);
String         PreferenceUtil.get(String name, String key, String defValue);
Set<String>    PreferenceUtil.get(String name, String key, Set<String> defValue);
C              PreferenceUtil.get(String name, String key, C defValue);

void           PreferenceUtil.put(String key, boolean value);
void           PreferenceUtil.put(String key, int value);
void           PreferenceUtil.put(String key, float value);
void           PreferenceUtil.put(String key, long value);
void           PreferenceUtil.put(String key, String value);
void           PreferenceUtil.put(String key, Set<String> value);
void           PreferenceUtil.put(String key, C value);

void           PreferenceUtil.put(String name, String key, boolean value);
void           PreferenceUtil.put(String name, String key, int value);
void           PreferenceUtil.put(String name, String key, float value);
void           PreferenceUtil.put(String name, String key, long value);
void           PreferenceUtil.put(String name, String key, String value);
void           PreferenceUtil.put(String name, String key, Set<String> value);
void           PreferenceUtil.put(String name, String key, C value);

void           PreferenceUtil.remove(String key);
void           PreferenceUtil.remove(String name, String key);

void           PreferenceUtil.clear();
void           PreferenceUtil.clear(String name);
```

## ExtrasBinder (★★★★★)
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

Proguard
```java
-keep class com.thefinestartist.annotations.** { *; }
-keep class **$$ExtraBinder { *; }
-keepclasseswithmembernames class * {
    @com.thefinestartist.annotations.Extra <fields>;
}
```

## UnitConverter (★★★★★)
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

## APILevel (★★★★☆)
`APILevel` helps to check device API `Build.VERSION` conveniently.

* Update your Android Studio lint option before you use this class. <a href="https://raw.githubusercontent.com/TheFinestArtist/AndroidBaseUtils/master/art/APILevel%20Lint%20Option.png" target="_blank">Show Image</a>  
```java
→ Android Studio  
→ Preferences...  
→ Editor  
→ Inspections  
→ Android Lint  
→ Calling new methods on older versions
→ Set Severity as Warning.
```

```java
boolean APILevel.require(int level); // Build.VERSION.SDK_INT >= level
boolean APILevel.requireCupcake();
boolean APILevel.requireDonut();
boolean APILevel.requireEclair();
boolean APILevel.requireFroyo();
boolean APILevel.requireGingerbread();
// and so on...

boolean APILevel.deprecatedAt(int level); // Build.VERSION.SDK_INT < level
boolean APILevel.deprecatedAtCupcake();
boolean APILevel.deprecatedAtDonut();
boolean APILevel.deprecatedAtEclair();
boolean APILevel.deprecatedAtFroyo();
boolean APILevel.deprecatedAtGingerbread();
// and so on...
```

## DisplayUtil (★★★★☆)
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

## ViewUtil (★★★☆☆)
ViewUtil helps to set background drawable conveniently.

```java
void    ViewUtil.setBackground(View view, Drawable drawable);
void    ViewUtil.setBackground(View view, int drawableRes);
```

## ServiceUtil (★★★☆☆)
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

## ThemeUtil (★★★★☆)
ThemeUtil helps to use Theme conveniently.

```java
void        ThemeUtil.applyStyle(int resId, boolean force);
void        ThemeUtil.dump(int priority, String tag, String prefix);
int         ThemeUtil.getChangingConfigurations();
Drawable    ThemeUtil.getDrawable(@DrawableRes int drawableRes);
Resources   ThemeUtil.getResources();
TypedArray  ThemeUtil.obtainStyledAttributes(@StyleableRes int[] attrs);
TypedArray  ThemeUtil.obtainStyledAttributes(@StyleRes int resid, @StyleableRes int[] attrs);
TypedArray  ThemeUtil.obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes);
boolean     ThemeUtil.resolveAttribute(int resid, TypedValue outValue, boolean resolveRefs);
void        ThemeUtil.setTo(Resources.Theme other);
```

## ActivityBuilder (★★☆☆☆)
ActivityBuilder helps to build Activity Intent and start Activity.

```java
Constructor         ActivityBuilder(@NonNull Class<C> clazz);

ActivityBuilder     ActivityBuilder.set(@NonNull String key, T value);
ActivityBuilder     ActivityBuilder.set(@NonNull String key, Parcelable value);
ActivityBuilder     ActivityBuilder.set(@NonNull String key, Parcelable[] value);
ActivityBuilder     ActivityBuilder.set(@NonNull String key, ArrayList<T> value);
ActivityBuilder     ActivityBuilder.remove(@NonNull String key);
ActivityBuilder     ActivityBuilder.setFlags(int flags);
ActivityBuilder     ActivityBuilder.addFlags(int flags);

Intent              ActivityBuilder.buildIntent();
void                ActivityBuilder.start();
void                ActivityBuilder.startForResult(@NonNull Activity activity, int requestCode);
void                ActivityBuilder.startForResult(@NonNull Activity activity, int requestCode, @Nullable Bundle options);
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
BundleBuilder   BundleBuilder.set(String key, T value);
T               BundleBuilder.get(String key);
Bundle          BundleBuilder.build();
```

```java
Bundle bundle = new BundleBuilder()
                    .set("values", new int[]{1, 2, 3})
                    .build();
```

## PackageUtil (★★☆☆☆)
PackageUtil helps to handle methods related to package.

```java
boolean     PackageUtil.isInstalled(String packageName);
String      PackageUtil.getPackageName();
void        PackageUtil.openPlayStore();
void        PackageUtil.openPlayStore(String packageName);
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

## IntArrayUtil (☆☆☆☆☆)
IntArrayUtil helps to deal with IntArray conveniently.

```java
boolean     IntArrayUtil.contains(int[] array, int value);
int[]       IntArrayUtil.add(int[] array, int value);
```

## SparseArrayUtil (☆☆☆☆☆)
SparseArrayUtil helps to deal with SparseArray conveniently.

```java
ArrayList<C>    SparseArrayUtil.asArrayList(SparseArray<C> sparseArray);
```

## ThreadUtil (☆☆☆☆☆)
ThreadUtil helps to deal with thread conveniently.

```java
boolean     ThreadUtil.isMain();
```

# Contributors
[Leonardo Taehwan Kim](https://github.com/thefinestartist)  
[Min Kim](https://github.com/openyourboxes)  
[Robin Gustafsson](https://github.com/rgson)  
[Marcos Trujillo](https://github.com/Aracem)  

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