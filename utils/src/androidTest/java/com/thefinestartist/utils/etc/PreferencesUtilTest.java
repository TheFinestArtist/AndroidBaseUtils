package com.thefinestartist.utils.etc;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.thefinestartist.Base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Tests of the {@link PreferencesUtil} class.
 *
 * @author Robin Gustafsson
 */
public class PreferencesUtilTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Base.initialize(getContext());
    }

    @SmallTest
    public void testSetGetDefaultName() {
        final String expected = "TEST_DEFAULT_NAME";

        PreferencesUtil.setDefaultName(expected);
        String actual = PreferencesUtil.getDefaultName();
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testDifferentNames() {
        final String name1 = "TEST_DIFFERENTNAMES_NAME1";
        final String name2 = "TEST_DIFFERENTNAMES_NAME2";
        final String key = "TEST_DIFFERENTNAMES_KEY";
        final boolean value = true;
        final boolean expected = false;

        PreferencesUtil.put(name1, key, value);
        boolean actual = PreferencesUtil.get(name2, key, expected);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreBoolean() {
        final String key = "TEST_BOOLEAN";
        final boolean expected = true;
        final boolean defValue = false;

        PreferencesUtil.put(key, expected);
        boolean actual = PreferencesUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreBooleanNamed() {
        final String name = "TEST_NAMED";
        final String key = "TEST_BOOLEAN";
        final boolean expected = true;
        final boolean defValue = false;

        PreferencesUtil.put(name, key, expected);
        boolean actual = PreferencesUtil.get(name, key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreInt() {
        final String key = "TEST_INT";
        final int expected = 321;
        final int defValue = 0;

        PreferencesUtil.put(key, expected);
        int actual = PreferencesUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreIntNamed() {
        final String name = "TEST_NAMED";
        final String key = "TEST_INT";
        final int expected = 321;
        final int defValue = 0;

        PreferencesUtil.put(name, key, expected);
        int actual = PreferencesUtil.get(name, key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreFloat() {
        final String key = "TEST_FLOAT";
        final float expected = 12.3f;
        final float defValue = 0.0f;

        PreferencesUtil.put(key, expected);
        float actual = PreferencesUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreFloatNamed() {
        final String name = "TEST_NAMED";
        final String key = "TEST_FLOAT";
        final float expected = 12.3f;
        final float defValue = 0.0f;

        PreferencesUtil.put(name, key, expected);
        float actual = PreferencesUtil.get(name, key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreLong() {
        final String key = "TEST_LONG";
        final long expected = 321L;
        final long defValue = 0L;

        PreferencesUtil.put(key, expected);
        long actual = PreferencesUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreLongNamed() {
        final String name = "TEST_NAMED";
        final String key = "TEST_LONG";
        final long expected = 321L;
        final long defValue = 0L;

        PreferencesUtil.put(name, key, expected);
        long actual = PreferencesUtil.get(name, key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreString() {
        final String key = "TEST_STRING";
        final String expected = "Lorem ipsum";
        final String defValue = null;

        PreferencesUtil.put(key, expected);
        String actual = PreferencesUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreStringNamed() {
        final String name = "TEST_NAMED";
        final String key = "TEST_STRING";
        final String expected = "Lorem ipsum";
        final String defValue = null;

        PreferencesUtil.put(name, key, expected);
        String actual = PreferencesUtil.get(name, key, defValue);
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

        PreferencesUtil.put(key, expected);
        Set<String> actual = PreferencesUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testStoreStringSetNamed() {
        final String name = "TEST_NAMED";
        final String key = "TEST_STRINGSET";
        final Set<String> expected = new HashSet<>();
        expected.add("Lorem ipsum");
        expected.add("dolor sit amet");
        expected.add("consectetur adipiscing elit");
        final Set<String> defValue = null;

        PreferencesUtil.put(name, key, expected);
        Set<String> actual = PreferencesUtil.get(name, key, defValue);
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

        PreferencesUtil.put(key, expected);
        ArrayList<String> actual = PreferencesUtil.get(key, defValue);
        assertEquals(expected, actual);
    }

    @MediumTest
    public void testStoreSerializableNamed() {
        final String name = "TEST_NAMED";
        final String key = "TEST_SERIALIZABLE";
        final ArrayList<String> expected = new ArrayList<>();
        expected.add("Lorem ipsum");
        expected.add("dolor sit amet");
        expected.add("consectetur adipiscing elit");
        final ArrayList<String> defValue = new ArrayList<>();
        defValue.add("Proin mollis dictum");

        PreferencesUtil.put(name, key, expected);
        ArrayList<String> actual = PreferencesUtil.get(name, key, defValue);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testRemove() {
        final String key = "TEST_REMOVE";
        final String expected = null;

        PreferencesUtil.put(key, "Lorem ipsum");
        PreferencesUtil.remove(key);
        String actual = PreferencesUtil.get(key, expected);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testRemoveNamed() {
        final String name = "TEST_NAMED";
        final String key = "TEST_REMOVE";
        final String expected = null;

        PreferencesUtil.put(name, key, "Lorem ipsum");
        PreferencesUtil.remove(name, key);
        String actual = PreferencesUtil.get(name, key, expected);
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testClear() {
        final String[] keys = {"TEST_REMOVE_1", "TEST_REMOVE_2", "TEST_REMOVE_2"};
        final String expected = null;

        for (String key : keys) {
            PreferencesUtil.put(key, "Lorem ipsum");
        }
        PreferencesUtil.clear();
        for (String key : keys) {
            String actual = PreferencesUtil.get(key, expected);
            assertEquals(expected, actual);
        }
    }

    @SmallTest
    public void testClearNamed() {
        final String name = "TEST_NAMED";
        final String[] keys = {"TEST_REMOVE_1", "TEST_REMOVE_2", "TEST_REMOVE_2"};
        final String expected = null;

        for (String key : keys) {
            PreferencesUtil.put(name, key, "Lorem ipsum");
        }
        PreferencesUtil.clear(name);
        for (String key : keys) {
            String actual = PreferencesUtil.get(name, key, expected);
            assertEquals(expected, actual);
        }
    }

}
