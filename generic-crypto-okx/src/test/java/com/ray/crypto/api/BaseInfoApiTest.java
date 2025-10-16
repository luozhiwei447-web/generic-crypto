package com.ray.crypto.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * BaseInfoApi测试类
 * 
 * @author ray
 * @date 2024-01-01
 */
@SpringBootTest
@ActiveProfiles("test")
class BaseInfoApiTest {

    @Autowired
    private TradingAccountApi tradingAccountApi;

    /**
     * 测试获取系统时间
     */
    @Test
    void testGetSystemTime() {
        String result = tradingAccountApi.getSystemTime();
        assertNotNull(result);
        System.out.println("System Time: " + result);
    }

    /**
     * 测试获取交易产品基础信息
     */
    @Test
    void testGetInstruments() {
        String result = tradingAccountApi.getInstruments();
        assertNotNull(result);
        System.out.println("Instruments: " + result);
    }
}