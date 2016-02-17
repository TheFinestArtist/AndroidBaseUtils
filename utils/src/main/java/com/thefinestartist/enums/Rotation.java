package com.thefinestartist.enums;

/**
 * Created by TheFinestArtist on 2/16/16.
 */
public enum Rotation {
    DEGREES_0(0),
    DEGREES_90(1),
    DEGREES_180(2),
    DEGREES_270(3);

    int value;

    Rotation(int value) {
        this.value = value;
    }

    public static Rotation fromValue(int value) {
        for (Rotation rotation : values())
            if (rotation.value == value)
                return rotation;

        return DEGREES_0;
    }
}
