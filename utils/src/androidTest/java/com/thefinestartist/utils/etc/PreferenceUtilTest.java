package com.thefinestartist.utils.etc;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.thefinestartist.Base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Tests the PreferenceUtil class.
 *
 * @author Robin Gustafsson
 */
public class PreferenceUtilTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Base.initialize(getContext());
    }

    @SmallTest
    public void testStoreBoolean() {
        final String key = "TEST_BOOLEAN";
        final boolean expected = true;
        final boolean defValue = false;

        PreferenceUtil.put(key, expected);
        boolean actual = PreferenceUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreInt() {
        final String key = "TEST_INT";
        final int expected = 321;
        final int defValue = 0;

        PreferenceUtil.put(key, expected);
        int actual = PreferenceUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreFloat() {
        final String key = "TEST_FLOAT";
        final float expected = 12.3f;
        final float defValue = 0.0f;

        PreferenceUtil.put(key, expected);
        float actual = PreferenceUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreLong() {
        final String key = "TEST_LONG";
        final long expected = 321L;
        final long defValue = 0L;

        PreferenceUtil.put(key, expected);
        long actual = PreferenceUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreString() {
        final String key = "TEST_STRING";
        final String expected = "Lorem ipsum";
        final String defValue = null;

        PreferenceUtil.put(key, expected);
        String actual = PreferenceUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreStringSet() {
        final String key = "TEST_STRINGSET";
        final Set<String> expected = new HashSet<>();
        expected.add("Lorem ipsum");
        expected.add("dolor sit amet");
        expected.add("consectetur adipiscing elit");
        final Set<String> defValue = null;

        PreferenceUtil.put(key, expected);
        Set<String> actual = PreferenceUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @MediumTest
    public void testStoreSerializable() {
        final String key = "TEST_SERIALIZABLE";
        final ArrayList<String> expected = new ArrayList<>();
        expected.add("Lorem ipsum");
        expected.add("dolor sit amet");
        expected.add("consectetur adipiscing elit");
        final ArrayList<String> defValue = new ArrayList<>();
        defValue.add("Proin mollis dictum");

        PreferenceUtil.put(key, expected);
        ArrayList<String> actual = PreferenceUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testRemove() {
        final String key = "TEST_REMOVE";
        final String expected = null;

        PreferenceUtil.put(key, "Lorem ipsum");
        PreferenceUtil.remove(key);
        String actual = PreferenceUtil.get(key, expected);
        assertEquals(expected, actual);
    }

}
