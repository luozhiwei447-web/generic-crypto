package com.ray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Generic Crypto应用启动类
 * 
 * @author ray
 * @date 2024-01-01
 */
@EnableFeignClients("com.ray.crypto.api")
@SpringBootApplication
public class GenericCryptoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenericCryptoApplication.class, args);
    }
}
