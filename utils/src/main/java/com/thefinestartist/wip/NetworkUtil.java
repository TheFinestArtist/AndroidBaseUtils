package com.thefinestartist.wip;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.thefinestartist.utils.service.ServiceUtil;

/**
 * Created by TheFinestArtist on 2/21/16.
 */
public class NetworkUtil {

//    public static NetworkInfo getNetworkInfo() {
//        return ServiceUtil.getConnectivityManager().getActiveNetworkInfo();
//    }
//
//    public static boolean isConnected() {
//        NetworkInfo info = getNetworkInfo();
//        return (info != null && info.isConnected());
//    }
//
//    public static boolean isConnectedWifi() {
//        NetworkInfo info = getNetworkInfo();
//        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
//    }
//
//    public static boolean isConnectedMobile() {
//        NetworkInfo info = getNetworkInfo();
//        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE);
//    }
//
//    public static boolean isConnectedFast() {
//        NetworkInfo info = getNetworkInfo();
//        return (info != null && info.isConnected() && isConnectionFast(info.getType(), info.getSubtype()));
//    }
//
//    public static boolean isConnectionFast(int type, int subType) {
//        if (type == ConnectivityManager.TYPE_WIFI) {
//            return true;
//        } else if (type == ConnectivityManager.TYPE_MOBILE) {
//            switch (subType) {
//                case TelephonyManager.NETWORK_TYPE_1xRTT:
//                    return false; // ~ 50-100 kbps
//                case TelephonyManager.NETWORK_TYPE_CDMA:
//                    return false; // ~ 14-64 kbps
//                case TelephonyManager.NETWORK_TYPE_EDGE:
//                    return false; // ~ 50-100 kbps
//                case TelephonyManager.NETWORK_TYPE_EVDO_0:
//                    return true; // ~ 400-1000 kbps
//                case TelephonyManager.NETWORK_TYPE_EVDO_A:
//                    return true; // ~ 600-1400 kbps
//                case TelephonyManager.NETWORK_TYPE_GPRS:
//                    return false; // ~ 100 kbps
//                case TelephonyManager.NETWORK_TYPE_HSDPA:
//                    return true; // ~ 2-14 Mbps
//                case TelephonyManager.NETWORK_TYPE_HSPA:
//                    return true; // ~ 700-1700 kbps
//                case TelephonyManager.NETWORK_TYPE_HSUPA:
//                    return true; // ~ 1-23 Mbps
//                case TelephonyManager.NETWORK_TYPE_UMTS:
//                    return true; // ~ 400-7000 kbps
//            /*
//             * Above API level 7, make sure to set android:targetSdkVersion
//			 * to appropriate level to use these
//			 */
//                case TelephonyManager.NETWORK_TYPE_EHRPD: // API level 11
//                    return true; // ~ 1-2 Mbps
//                case TelephonyManager.NETWORK_TYPE_EVDO_B: // API level 9
//                    return true; // ~ 5 Mbps
//                case TelephonyManager.NETWORK_TYPE_HSPAP: // API level 13
//                    return true; // ~ 10-20 Mbps
//                case TelephonyManager.NETWORK_TYPE_IDEN: // API level 8
//                    return false; // ~25 kbps
//                case TelephonyManager.NETWORK_TYPE_LTE: // API level 11
//                    return true; // ~ 10+ Mbps
//                // Unknown
//                case TelephonyManager.NETWORK_TYPE_UNKNOWN:
//                default:
//                    return false;
//            }
//        } else {
//            return false;
//        }
//    }
}
