package com.jyd.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

public class ZtSignUtil {

    public static final long SIGN_EXPIRE = 1000 * 60 * 5;

    /**
     * 通过传入参数加密
     * @param appkey appkey，每个系统唯一
     * @param timestamp 时间戳
     * @param appsecret 密钥，需要申请
     * @return 加密串
     */
    public static String sign(String appkey, String timestamp, String appsecret) {
        StringBuffer sb = new StringBuffer();
        sb.append("appkey=");
        sb.append(appkey);
        sb.append("&timestamp=");
        sb.append(timestamp);
        String signData = sb.toString();
        byte[] hmac = new HmacUtils(HmacAlgorithms.HMAC_MD5, appsecret).hmac(signData);
        return new String(Base64.encodeBase64(hmac));
    }

    /**
     * 时间戳校验
     * @param timestamp
     * @return
     */
    public static boolean isExpire(long timestamp) {
        long now = System.currentTimeMillis();
        if (now - timestamp > SIGN_EXPIRE) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String times = String.valueOf(System.currentTimeMillis());
        System.out.println(times);
        System.out.println(sign("whdsj",times,"0a74de3d4325ab36"));
    }
}
