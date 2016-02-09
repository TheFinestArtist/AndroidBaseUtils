package com.thefinestartist.utils.etc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;

/**
 * Created by TheFinestArtist
 */
public class PhotoUtil {

    public static final int IMAGE_MAX_WIDTH = 800;

    public static SoftReference<byte[]> convertToByte(String path) {
        if (path == null)
            return new SoftReference<>(new byte[0]);

        BitmapFactory.Options options = new BitmapFactory.Options();
        int inSampleSize = getInSampleSize(path, IMAGE_MAX_WIDTH * 2);
        options.inSampleSize = inSampleSize;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);

        if (bitmap == null) {
            inSampleSize = getInSampleSize(path, IMAGE_MAX_WIDTH * 2);
            options.inSampleSize = inSampleSize;
            bitmap = BitmapFactory.decodeFile(path, options);
        }

        if (bitmap == null)
            return new SoftReference<>(new byte[0]);

        // Scale the bitmap
        if (inSampleSize > 1) {
            float height;
            switch (getRotation(path)) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                case ExifInterface.ORIENTATION_ROTATE_270:
                    height = ((float) bitmap.getWidth()) * ((float) IMAGE_MAX_WIDTH) / ((float) bitmap.getHeight());
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) height, IMAGE_MAX_WIDTH, true);
                    break;
                case ExifInterface.ORIENTATION_NORMAL:
                case ExifInterface.ORIENTATION_ROTATE_180:
                default:
                    height = ((float) bitmap.getHeight()) * ((float) IMAGE_MAX_WIDTH) / ((float) bitmap.getWidth());
                    bitmap = Bitmap.createScaledBitmap(bitmap, IMAGE_MAX_WIDTH, (int) height, true);
                    break;
            }
        }

        // Rotate the bitmap
        switch (getRotation(path)) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                bitmap = rotateBitmap(bitmap, 90);
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                bitmap = rotateBitmap(bitmap, 270);
                break;
        }

        byte[] bytes = null;
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
            bytes = stream.toByteArray();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SoftReference<>(bytes);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }


    public static int getInSampleSize(String path, int maxWidth) {
        SoftReference<Bitmap> bitmap = getBitmap(path);
        int inSampleSize = 1;
        float currentWidth = 0;
        switch (getRotation(path)) {
            case ExifInterface.ORIENTATION_ROTATE_90:
            case ExifInterface.ORIENTATION_ROTATE_270:
                if (bitmap != null && bitmap.get() != null)
                    currentWidth = bitmap.get().getHeight();
                break;
            case ExifInterface.ORIENTATION_NORMAL:
            case ExifInterface.ORIENTATION_ROTATE_180:
            default:
                if (bitmap != null && bitmap.get() != null)
                    currentWidth = bitmap.get().getWidth();
                break;
        }

        currentWidth /= (float) maxWidth;
        while (currentWidth > 1) {
            inSampleSize *= 2;
            currentWidth /= 2;
        }

        return inSampleSize;
    }

    public static SoftReference<Bitmap> getBitmap(String path) {
        SoftReference<Bitmap> bitmap = null;

        try {
            bitmap = new SoftReference<>(BitmapFactory.decodeStream(new FileInputStream(new File(path))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    public static int getRotation(String path) {
        int rotate = ExifInterface.ORIENTATION_NORMAL;
        try {
            File imageFile = new File(path);
            ExifInterface exif = new ExifInterface(imageFile.getAbsolutePath());
            rotate = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotate;
    }
}
