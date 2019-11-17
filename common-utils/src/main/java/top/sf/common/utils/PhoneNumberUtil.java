package top.sf.common.utils;

/**
 * @Description : 电话号码处理工具类
 * @Author : Yb.Z
 * @Date : 2019/10/29 - 10:03
 */
public final class PhoneNumberUtil {

    private final static String encryptionRegex = "(\\d{3})\\d{4}(\\d{4})";

    private final static String replaceRegex = "$1****$2";

    public static String encryptionPhoneNumber(String phoneNumber){
        return phoneNumber.replaceAll(encryptionRegex, replaceRegex);
    }
}
