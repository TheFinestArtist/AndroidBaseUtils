package com.thefinestartist.utils.etc;

/**
 * Created by TheFinestArtist on 2/9/16.
 */
public class BitmapUtil {

//        private final static String TAG = ImageUtils.class.getSimpleName();
//
//        private static final String ERROR_URI_NULL = "Uri cannot be null";
//
//        /***
//         * Scales the image depending upon the display density of the device. Maintains image aspect
//         * ratio.
//         *
//         * When dealing with the bitmaps of bigger size, this method must be called from a non-UI
//         * thread.
//         * ***/
//        public static Bitmap scaleDownBitmap(Context ctx, Bitmap source, int newHeight) {
//            final float densityMultiplier = Utils.getDensityMultiplier(ctx);
//
//            // Log.v( TAG, "#scaleDownBitmap Original w: " + source.getWidth() + " h: " +
//            // source.getHeight() );
//
//            int h = (int) (newHeight * densityMultiplier);
//            int w = (int) (h * source.getWidth() / ((double) source.getHeight()));
//
//            // Log.v( TAG, "#scaleDownBitmap Computed w: " + w + " h: " + h );
//
//            Bitmap photo = Bitmap.createScaledBitmap(source, w, h, true);
//
//            // Log.v( TAG, "#scaleDownBitmap Final w: " + w + " h: " + h );
//
//            return photo;
//        }
//
//        /***
//         * Scales the image independently of the screen density of the device. Maintains image aspect
//         * ratio.
//         *
//         * When dealing with the bitmaps of bigger size, this method must be called from a non-UI
//         * thread.
//         * ***/
//        public static Bitmap scaleBitmap(Context ctx, Bitmap source, int newHeight) {
//
//            // Log.v( TAG, "#scaleDownBitmap Original w: " + source.getWidth() + " h: " +
//            // source.getHeight() );
//
//            int w = (int) (newHeight * source.getWidth() / ((double) source.getHeight()));
//
//            // Log.v( TAG, "#scaleDownBitmap Computed w: " + w + " h: " + newHeight );
//
//            Bitmap photo = Bitmap.createScaledBitmap(source, w, newHeight, true);
//
//            // Log.v( TAG, "#scaleDownBitmap Final w: " + w + " h: " + newHeight );
//
//            return photo;
//        }
//
//        /***
//         * Scales the image independently of the screen density of the device. Maintains image aspect
//         * ratio.
//         *
//         * @param uri
//         *            Uri of the source bitmap
//         ****/
//        public static Bitmap scaleDownBitmap(Context ctx, Uri uri, int newHeight) throws FileNotFoundException, IOException {
//            Bitmap original = Media.getBitmap(ctx.getContentResolver(), uri);
//            return scaleBitmap(ctx, original, newHeight);
//        }
//
//        /***
//         * Scales the image independently of the screen density of the device. Maintains image aspect
//         * ratio.
//         *
//         * @param uri
//         *            Uri of the source bitmap
//         ****/
//        public static Uri scaleDownBitmapForUri(Context ctx, Uri uri, int newHeight) throws FileNotFoundException, IOException {
//
//            if (uri == null)
//                throw new NullPointerException(ERROR_URI_NULL);
//
//            if (!isMediaContentUri(uri))
//                return null;
//
//            Bitmap original = Media.getBitmap(ctx.getContentResolver(), uri);
//            Bitmap bmp = scaleBitmap(ctx, original, newHeight);
//
//            Uri destUri = null;
//            String uriStr = Utils.writeImageToMedia(ctx, bmp, "", "");
//
//            if (uriStr != null) {
//                destUri = Uri.parse(uriStr);
//            }
//
//            return destUri;
//        }
//
//        /***
//         * Gets the orientation of the image pointed to by the parameter uri
//         *
//         * @return Image orientation value corresponding to <code>ExifInterface.ORIENTATION_*</code> <br/>
//         *         Returns -1 if the row for the {@link android.net.Uri} is not found.
//         ****/
//        public static int getOrientation(Context context, Uri uri) {
//
//            int invalidOrientation = -1;
//            if (uri == null) {
//                throw new NullPointerException(ERROR_URI_NULL);
//            }
//
//            if (!isMediaContentUri(uri)) {
//                return invalidOrientation;
//            }
//
//            String filePath = Utils.getImagePathForUri(context, uri);
//            ExifInterface exif = null;
//
//            try {
//                exif = new ExifInterface(filePath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            int orientation = invalidOrientation;
//            if (exif != null) {
//                orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, invalidOrientation);
//            }
//
//            return orientation;
//        }
//
//        /***
//         * @deprecated Use {@link MediaUtils#isMediaContentUri(android.net.Uri)} instead. <br/>
//         *             Checks if the parameter {@link android.net.Uri} is a
//         *             {@link android.provider.MediaStore.Audio.Media} content uri.
//         ****/
//        public static boolean isMediaContentUri(Uri uri) {
//            if (!uri.toString().contains("content://media/")) {
//                Log.w(TAG, "#isContentUri The uri is not a media content uri");
//                return false;
//            } else {
//                return true;
//            }
//        }
//
//        /***
//         * Rotate the image at the specified uri. For the rotation of the image the
//         * {@link android.media.ExifInterface} data in the image will be used.
//         *
//         * @param uri
//         *            Uri of the image to be rotated.
//         ****/
//        public static Uri rotateImage(Context context, Uri uri) throws FileNotFoundException, IOException {
//            // rotate the image
//            if (uri == null) {
//                throw new NullPointerException(ERROR_URI_NULL);
//            }
//
//            if (!isMediaContentUri(uri)) {
//                return null;
//            }
//
//            int invalidOrientation = -1;
//            byte[] data = Utils.getMediaData(context, uri);
//
//            int orientation = getOrientation(context, uri);
//
//            Uri newUri = null;
//
//            try {
//
//                Log.d(TAG, "#rotateImage Exif orientation: " + orientation);
//
//                if (orientation != invalidOrientation) {
//                    Matrix matrix = new Matrix();
//
//                    switch (orientation) {
//                        case ExifInterface.ORIENTATION_ROTATE_90:
//                            matrix.postRotate(90);
//                            break;
//                        case ExifInterface.ORIENTATION_ROTATE_180:
//                            matrix.postRotate(180);
//                            break;
//                        case ExifInterface.ORIENTATION_ROTATE_270:
//                            matrix.postRotate(270);
//                            break;
//                    }
//
//                    // set some options so the memory is manager properly
//                    BitmapFactory.Options options = new BitmapFactory.Options();
//                    // options.inPreferredConfig = Bitmap.Config.RGB_565; // try to enable this if
//                    // OutOfMem issue still persists
//                    options.inPurgeable = true;
//                    options.inInputShareable = true;
//
//                    Bitmap original = BitmapFactory.decodeByteArray(data, 0, data.length, options);
//                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true); // rotating
//                    // bitmap
//                    String newUrl = Media.insertImage(((Activity) context).getContentResolver(), rotatedBitmap, "", "");
//
//                    if (newUrl != null) {
//                        newUri = Uri.parse(newUrl);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return newUri;
//        }
}
