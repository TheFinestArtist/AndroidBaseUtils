package com.thefinestartist.utils.etc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import com.thefinestartist.Base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;

/**
 * PreferenceUtil helps to manage application-wide preferences conveniently.
 *
 * @author Robin Gustafsson
 */
public class PreferenceUtil {

    private static final String TAG = PreferenceUtil.class.getCanonicalName();

    private static String defaultName = PreferenceUtil.class.getCanonicalName();


    private PreferenceUtil() { }


    private static SharedPreferences getPreferences(String name) {
        return Base.getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
    }


    public static String getDefaultName() {
        return defaultName;
    }

    public static void setDefaultName(String name) {
        defaultName = name;
    }


    public static boolean get(String key, boolean defValue) {
        return get(defaultName, key, defValue);
    }

    public static int get(String key, int defValue) {
        return get(defaultName, key, defValue);
    }

    public static float get(String key, float defValue) {
        return get(defaultName, key, defValue);
    }

    public static long get(String key, long defValue) {
        return get(defaultName, key, defValue);
    }

    public static String get(String key, String defValue) {
        return get(defaultName, key, defValue);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> get(String key, Set<String> defValue) {
        return get(defaultName, key, defValue);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static <C extends Serializable> C get(String key, C defValue) {
        return get(defaultName, key, defValue);
    }


    public static boolean get(String name, String key, boolean defValue) {
        return getPreferences(name).getBoolean(key, defValue);
    }

    public static int get(String name, String key, int defValue) {
        return getPreferences(name).getInt(key, defValue);
    }

    public static float get(String name, String key, float defValue) {
        return getPreferences(name).getFloat(key, defValue);
    }

    public static long get(String name, String key, long defValue) {
        return getPreferences(name).getLong(key, defValue);
    }

    public static String get(String name, String key, String defValue) {
        return getPreferences(name).getString(key, defValue);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> get(String name, String key, Set<String> defValue) {
        return getPreferences(name).getStringSet(key, defValue);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static <C extends Serializable> C get(String name, String key, C defValue) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        C result = defValue;

        String value = getPreferences(name).getString(key, null);
        if (value != null) {
            try {
                byte[] decoded = Base64.decode(value.getBytes(), Base64.DEFAULT);
                bais = new ByteArrayInputStream(decoded);
                ois = new ObjectInputStream(bais);
                result = (C) ois.readObject();

            } catch (Exception e) {
                Log.e(TAG, e.toString());

            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        Log.e(TAG, e.toString());
                    }
                }
                if (bais != null) {
                    try {
                        bais.close();
                    } catch (IOException e) {
                        Log.e(TAG, e.toString());
                    }
                }
            }
        }

        return result;
    }


    public static void put(String key, boolean value) {
        put(defaultName, key, value);
    }

    public static void put(String key, int value) {
        put(defaultName, key, value);
    }

    public static void put(String key, float value) {
        put(defaultName, key, value);
    }

    public static void put(String key, long value) {
        put(defaultName, key, value);
    }

    public static void put(String key, String value) {
        put(defaultName, key, value);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void put(String key, Set<String> value) {
        put(defaultName, key, value);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static <C extends Serializable> void put(String key, C value) {
        put(defaultName, key, value);
    }


    public static void put(String name, String key, boolean value) {
        getPreferences(name).edit().putBoolean(key, value).commit();
    }

    public static void put(String name, String key, int value) {
        getPreferences(name).edit().putInt(key, value).commit();
    }

    public static void put(String name, String key, float value) {
        getPreferences(name).edit().putFloat(key, value).commit();
    }

    public static void put(String name, String key, long value) {
        getPreferences(name).edit().putLong(key, value).commit();
    }

    public static void put(String name, String key, String value) {
        getPreferences(name).edit().putString(key, value).commit();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void put(String name, String key, Set<String> value) {
        getPreferences(name).edit().putStringSet(key, value).commit();
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static <C extends Serializable> void put(String name, String key, C value) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(value);
            byte[] encoded = Base64.encode(baos.toByteArray(), Base64.DEFAULT);
            getPreferences(name).edit().putString(key, new String(encoded)).commit();

        } catch (IOException e) {
            Log.e(TAG, e.toString());
            throw new RuntimeException(e);

        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                }
            }
        }
    }


    public static void remove(String key) {
        remove(defaultName, key);
    }

    public static void remove(String name, String key) {
        getPreferences(name).edit().remove(key).commit();
    }


    public static void clear() {
        clear(defaultName);
    }

    public static void clear(String name) {
        getPreferences(name).edit().clear().commit();
    }

}