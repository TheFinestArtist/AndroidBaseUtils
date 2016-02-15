package com.thefinestartist.enums;

/**
 * Created by TheFinestArtist on 2/16/16.
 */
public enum Rotation {
    ROTATION_0(0),
    ROTATION_90(1),
    ROTATION_180(2),
    ROTATION_270(3);

    int value;

    Rotation(int value) {
        this.value = value;
    }

    public static Rotation fromValue(int value) {
        for (Rotation rotation : values())
            if (rotation.value == value)
                return rotation;

        return ROTATION_0;
    }
}
