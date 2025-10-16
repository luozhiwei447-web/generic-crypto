package com.ray.crypto.api;

import com.ray.crypto.constants.InstrumentType;
import com.ray.crypto.module.InstrumentInfo;
import com.ray.crypto.module.InstrumentRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * BaseInfoApi测试类
 * 
 * @author ray
 * @date 2024-01-01
 */
@SpringBootTest
@EnableFeignClients(basePackages = "com.ray.crypto.api")
@Slf4j
class BaseInfoApiTest {

    @Autowired
    private TradingAccountApi tradingAccountApi;

    /**
     * 测试获取账户余额
     */
    @Test
    void testGetBalance() {
        InstrumentRequest instrumentRequest = new InstrumentRequest()
                .setInstType(InstrumentType.SPOT);
        InstrumentInfo instruments = tradingAccountApi.instruments(instrumentRequest);
        log.info("instruments:{}", instruments);
    }
}