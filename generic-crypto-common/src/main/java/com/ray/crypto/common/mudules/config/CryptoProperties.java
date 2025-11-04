package com.ray.crypto.common.mudules.config;

import lombok.Data;

/**
 * 加密配置属性
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CryptoProperties {

    /**
     * 接口base url
     */
    private String webUrl;
    /**
     * api key
     */
    private String apiKey;
    /**
     * api 密钥
     */
    private String apiSecret;
    /**
     * 密码
     */
    private String passphrase;
    /**
     * 是否模拟盘
     */
    private String isDemo;
}