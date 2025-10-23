package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.CancelOrderInfo;
import com.ray.crypto.module.CancelOrderRequest;
import com.ray.crypto.module.OrderDetailsInfo;
import com.ray.crypto.module.OrderDetailsRequest;
import com.ray.crypto.module.PlaceOrderInfo;
import com.ray.crypto.module.PlaceOrderRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 交易相关api
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/10/18
 */
@ConditionalOnProperty("crypto.okx.web-url")
@FeignClient(name = "TradingApi", url = "${crypto.okx.web-url}", configuration = {OkxFeignRequestInterceptor.class, OkxResponseDecoder.class})
public interface TradingApi {

    /**
     * 下单
     * @param request 下单请求
     * @return 下单结果
     */
    @PostMapping("/api/v5/trade/order")
    List<PlaceOrderInfo> placeOrder(@RequestBody PlaceOrderRequest request);

    /**
     * 撤单
     * @param request 撤单请求
     * @return 撤单结果
     */
    @PostMapping("/api/v5/trade/cancel-order")
    List<CancelOrderInfo> cancelOrder(@RequestBody CancelOrderRequest request);

    /**
     * 获取订单信息
     * @param request 查询请求
     * @return 订单详情
     */
    @GetMapping("/api/v5/trade/order")
    List<OrderDetailsInfo> getOrderDetails(@SpringQueryMap OrderDetailsRequest request);
}
