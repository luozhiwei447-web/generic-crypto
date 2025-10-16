package com.ray.crypto.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 加密工具类
 * 
 * @author ray
 * @date 2024-01-01
 */
@Slf4j
public class SignatureUtils {

    private final static String HMAC_SHA256 = "HmacSHA256";

    /**
     * HMAC加密
     * 
     * @param data 待加密数据
     * @param key 密钥
     * @return 加密后的十六进制字符串
     */
    public static String hmacSha256(String data, String key) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
            mac.init(secretKeySpec);
            byte[] hash = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return new String(hash,StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("HMAC算法不可用: " + HMAC_SHA256, e);
        }
    }

    /**
     * Base64编码
     * 
     * @param data 待编码数据
     * @return Base64编码后的字符串
     */
    public static String base64Encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Base64解码
     * 
     * @param encodedData Base64编码的字符串
     * @return 解码后的字符串
     */
    public static String base64Decode(String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}