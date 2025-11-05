package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 定投
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/11/5
 */
@ConditionalOnProperty("crypto.okx.web-url")
@FeignClient(name = "RegularInvestmentApi", url = "${crypto.okx.web-url}", configuration = {OkxFeignRequestInterceptor.class, OkxResponseDecoder.class})
public interface RegularInvestmentApi {
}
