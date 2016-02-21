package com.thefinestartist.wip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by TheFinestArtist on 2/18/16.
 */
public class Validator {

//    public static final String SPECIAL_CHARS = "\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]";
//    public static final String VALID_CHARS = "[^\\s" + SPECIAL_CHARS + "]";
//    public static final String QUOTED_USER = "(\"[^\"]*\")";
//    public static final String WORD = "((" + VALID_CHARS + "|')+|" + QUOTED_USER + ")";
//
//    public static final String EMAIL_REGEX = "^\\s*?(.+)@(.+?)\\s*$";
//    public static final String IP_DOMAIN_REGEX = "^\\[(.*)\\]$";
//    public static final String USER_REGEX = "^\\s*" + WORD + "(\\." + WORD + ")*$";
//
//    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
//    public static final Pattern IP_DOMAIN_PATTERN = Pattern.compile(IP_DOMAIN_REGEX);
//    public static final Pattern USER_PATTERN = Pattern.compile(USER_REGEX);
//
//
//    // Regular expression strings for hostnames (derived from RFC2396 and RFC 1123)
//
//    // RFC2396: domainlabel   = alphanum | alphanum *( alphanum | "-" ) alphanum
//    // Max 63 characters
//    public static final String DOMAIN_LABEL_REGEX = "\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?";
//
//    // RFC2396 toplabel = alpha | alpha *( alphanum | "-" ) alphanum
//    // Max 63 characters
//    public static final String TOP_LABEL_REGEX = "\\p{Alpha}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?";
//
//    // RFC2396 hostname = *( domainlabel "." ) toplabel [ "." ]
//    // Note that the regex currently requires both a domain label and a top level label, whereas
//    // the RFC does not. This is because the regex is used to detect if a TLD is present.
//    // If the match fails, input is checked against DOMAIN_LABEL_REGEX (hostnameRegex)
//    // RFC1123 sec 2.1 allows hostnames to start with a digit
//    public static final String DOMAIN_NAME_REGEX = "^(?:" + DOMAIN_LABEL_REGEX + "\\.)+" + "(" + TOP_LABEL_REGEX + ")\\.?$";
//
//
//    public static boolean isEmail(String email) {
//        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//        Pattern pattern = Pattern.compile(emailPattern);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
}
// https://github.com/throrin19/Android-Validator/tree/master/library/src/com/throrinstudio/android/common/libs/validator/validator
// https://github.com/ragunathjawahar/android-saripaar/tree/master/saripaar/src/main/java/commons/validator/routines