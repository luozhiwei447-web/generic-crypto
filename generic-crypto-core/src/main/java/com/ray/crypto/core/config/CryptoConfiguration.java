package com.ray.crypto.core.config;

import com.ray.crypto.common.mudules.config.CryptoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态加密配置类
 * 
 * @author ray
 * @date 2024-01-01
 */
@Configuration
public class CryptoConfiguration {

    private final Environment environment;

    public CryptoConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @ConfigurationProperties(prefix = "crypto")
    public CryptoProperties cryptoProperties() {
        return new CryptoProperties();
    }
    public Map<String, CryptoProperties> cryptoPropertiesMap() {
        Map<String, CryptoProperties> configMap = new HashMap<>();
        
        Binder binder = Binder.get(environment);
        
        // 绑定crypto下的所有二级配置
        Map<String, Object> cryptoConfigs = binder.bind("crypto", Map.class).orElse(new HashMap<>());
        
        cryptoConfigs.forEach((key, value) -> {
            if (value instanceof Map) {
                CryptoProperties properties = binder.bind("crypto." + key, CryptoProperties.class)
                    .orElse(new CryptoProperties());
                configMap.put(key, properties);
            }
        });
        
        return configMap;
    }

    @Bean("okxCryptoProperties")
    @ConfigurationProperties(prefix = "crypto.okx")
    public CryptoProperties okxCryptoProperties() {
        return cryptoPropertiesMap().get("okx");
    }
}