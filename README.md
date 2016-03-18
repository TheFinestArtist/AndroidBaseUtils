# AndroidBaseUtils
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

![AndroidBaseUtils Art Image](art/256_1.png)

#### Context free and basic utils to build Android project conveniently

Any kinds of contributions including **pull requests**, **registering new issues**, **sending me personal emails** are always welcome. Let me know if you have any idea about basic utils for Android development.


# Table of Contents
1. [Get started](#get-started)
1. [Utils](#utils)
    1. [Base](#base-)
    1. [ContextUtil](#contextutil-)
    1. [ResourcesUtil](#resourcesutil-)
    1. [ExtrasBinder](#extrasbinder-)
    1. [PreferenceUtil](#preferenceutil-)
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

## ContextUtil (★★★★★)
ContextUtil helps to use Context conveniently.

```java
boolean bindService(Intent service, ServiceConnection conn, int flags);
int checkCallingOrSelfPermission(String permission);
int checkSelfPermission(@NonNull String permission);
void enforceCallingOrSelfPermission(String permission, String message);
void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message);
ApplicationInfo getApplicationInfo();
File getCacheDir();
File getExternalCacheDir();
File getExternalFilesDir(String type);
Looper getMainLooper();
Object getSystemService(String name);
void sendBroadcast(Intent intent, String receiverPermission);
void sendBroadcast(Intent intent);
boolean startActivities(Intent[] intents, Bundle options);
boolean startActivities(Intent[] intents);
void startActivity(@NonNull Intent intent);
void startActivity(Intent intent, Bundle options);
ComponentName startService(Intent service);
boolean stopService(Intent service);
void unbindService(ServiceConnection conn);
// and so on...
```

## ResourcesUtil (★★★★★)
ResourcesUtil helps to use Resources conveniently.

```java
XmlResourceParser   getAnimation(@AnimRes int animRes);
boolean             getBoolean(@BoolRes int boolRes);
int                 getColor(@ColorRes int colorRes);
int                 getColor(@ColorRes int colorRes, Resources.Theme theme);
ColorStateList      getColorStateList(@ColorRes int colorRes);
ColorStateList      getColorStateList(@ColorRes int colorRes, Resources.Theme theme);
float               getDimension(@DimenRes int dimenRes);
int                 getDimensionPixelOffset(@DimenRes int dimenRes);
int                 getDimensionPixelSize(@DimenRes int dimenRes);
DisplayMetrics      getDisplayMetrics();
Drawable            getDrawable(@DrawableRes int drawableRes);
int                 getIdentifier(String name, String defType, String defPackage);
int[]               getIntArray(@ArrayRes int arrayRes);
int                 getInteger(@IntegerRes int integerRes);
XmlResourceParser   getLayout(@LayoutRes int layoutRes);
String              getQuantityString(int id, int quantity, Object... formatArgs);
CharSequence        getQuantityText(int id, int quantity);
String              getResourceEntryName(@AnyRes int anyRes);
String              getResourceName(@AnyRes int anyRes);
String              getResourcePackageName(@AnyRes int anyRes);
String              getResourceTypeName(@AnyRes int anyRes);
String              getString(@StringRes int stringRes);
String              getString(@StringRes int stringRes, Object... formatArgs);
String[]            getStringArray(@ArrayRes int arrayRes);
CharSequence        getText(@StringRes int stringRes, CharSequence def);
CharSequence        getText(@StringRes int stringRes);
CharSequence[]      getTextArray(@ArrayRes int arrayRes);
void                getValue(String name, TypedValue outValue, boolean resolveRefs);
void                getValue(@AnyRes int anyRes, TypedValue outValue, boolean resolveRefs);
void                getValueForDensity(@AnyRes int anyRes, int density, TypedValue outValue, boolean resolveRefs);
XmlResourceParser   getXml(@XmlRes int xmlRes);
TypedArray          obtainAttributes(AttributeSet set, int[] attrs);
TypedArray          obtainTypedArray(@ArrayRes int anyRes);
InputStream         openRawResource(@RawRes int rawRes);
AssetFileDescriptor openRawResourceFd(@RawRes int rawRes);
int[]               getColorArray(@ArrayRes int array);
// and so on...
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

## PreferenceUtil (★★★★★)
PreferenceUtil helps to manage application-wide preferences conveniently.

```java
String         getDefaultName();
void           setDefaultName(String name);

boolean        get(String key, boolean defValue);
int            get(String key, int defValue);
float          get(String key, float defValue);
long           get(String key, long defValue);
String         get(String key, String defValue);
Set<String>    get(String key, Set<String> defValue);
C              get(String key, C defValue);

boolean        get(String name, String key, boolean defValue);
int            get(String name, String key, int defValue);
float          get(String name, String key, float defValue);
long           get(String name, String key, long defValue);
String         get(String name, String key, String defValue);
Set<String>    get(String name, String key, Set<String> defValue);
C              get(String name, String key, C defValue);

void           put(String key, boolean value);
void           put(String key, int value);
void           put(String key, float value);
void           put(String key, long value);
void           put(String key, String value);
void           put(String key, Set<String> value);
void           put(String key, C value);

void           put(String name, String key, boolean value);
void           put(String name, String key, int value);
void           put(String name, String key, float value);
void           put(String name, String key, long value);
void           put(String name, String key, String value);
void           put(String name, String key, Set<String> value);
void           put(String name, String key, C value);

void           remove(String key);
void           remove(String name, String key);

void           clear();
void           clear(String name);
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

Update your Android Studio lint option before you use this class. <a href="https://raw.githubusercontent.com/TheFinestArtist/AndroidBaseUtils/master/art/APILevel%20Lint%20Option.png" target="_blank">Show Image</a>  
```java
→ Android Studio  
→ Preferences...  
→ Editor  
→ Inspections  
→ Android Lint  
→ Set Severity of Calling new methods on older versions as Warning.
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
void        applyStyle(int resId, boolean force);
void        dump(int priority, String tag, String prefix);
int         getChangingConfigurations();
Drawable    getDrawable(@DrawableRes int drawableRes);
Resources   getResources();
TypedArray  obtainStyledAttributes(@StyleableRes int[] attrs);
TypedArray  obtainStyledAttributes(@StyleRes int resid, @StyleableRes int[] attrs);
TypedArray  obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes);
boolean     resolveAttribute(int resid, TypedValue outValue, boolean resolveRefs);
void        setTo(Resources.Theme other);
```

## ActivityBuilder (★★☆☆☆)
ActivityBuilder helps to build Activity Intent and start Activity.

```java
Constructor         ActivityBuilder(@NonNull Class<C> clazz);

ActivityBuilder     set(@NonNull String key, T value);
ActivityBuilder     set(@NonNull String key, Parcelable value);
ActivityBuilder     set(@NonNull String key, Parcelable[] value);
ActivityBuilder     set(@NonNull String key, ArrayList<T> value);
ActivityBuilder     remove(@NonNull String key);
ActivityBuilder     setFlags(int flags);
ActivityBuilder     addFlags(int flags);

Intent              buildIntent();
void                start();
void                startForResult(@NonNull Activity activity, int requestCode);
void                startForResult(@NonNull Activity activity, int requestCode, @Nullable Bundle options);
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
BundleBuilder   set(String key, T value);
T               get(String key);
Bundle          build();
```

```java
Bundle bundle = new BundleBuilder()
                    .set("values", new int[]{1, 2, 3})
                    .build();
```

## PackageUtil (★★☆☆☆)
PackageUtil helps to handle methods related to package.

```java
boolean     isInstalled(String packageName);
String      getPackageName();
void        openPlayStore();
void        openPlayStore(String packageName);
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
boolean     contains(int[] array, int value);
int[]       add(int[] array, int value);
```

## SparseArrayUtil (☆☆☆☆☆)
SparseArrayUtil helps to deal with SparseArray conveniently.

```java
ArrayList<C>    asArrayList(SparseArray<C> sparseArray);
```

## ThreadUtil (☆☆☆☆☆)
ThreadUtil helps to deal with thread conveniently.

```java
boolean     isMain();
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