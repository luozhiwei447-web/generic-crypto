package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.InstrumentInfo;
import com.ray.crypto.module.InstrumentRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * OKX基础信息API
 * 
 * @author ray
 * @date 2024-01-01
 */
@ConditionalOnProperty("crypto.okx.web-url")
@FeignClient(name = "TradingAccountApi", url = "${crypto.okx.web-url}", configuration = {OkxFeignRequestInterceptor.class, OkxResponseDecoder.class})
public interface TradingAccountApi {

    /**
     * 获取交易产品基础信息
     * @param request
     * @return
     */
    @GetMapping("/api/v5/public/instruments")
    List<InstrumentInfo> instruments(@SpringQueryMap InstrumentRequest request);
}
