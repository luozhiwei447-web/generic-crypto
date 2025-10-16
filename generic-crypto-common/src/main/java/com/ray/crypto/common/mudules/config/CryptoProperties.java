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
    
    private String webUrl;
    private String apiKey;
    private String apiSecret;
    private String passphrase;
}