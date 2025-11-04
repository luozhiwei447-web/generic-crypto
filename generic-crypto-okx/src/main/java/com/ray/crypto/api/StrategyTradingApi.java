package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.AlgoOrderDetailsInfo;
import com.ray.crypto.module.AlgoOrderDetailsRequest;
import com.ray.crypto.module.AlgoOrderListRequest;
import com.ray.crypto.module.AlgoOrderHistoryRequest;
import com.ray.crypto.module.AlgoOrderInfo;
import com.ray.crypto.module.AlgoOrderRequest;
import com.ray.crypto.module.AmendAlgoOrderInfo;
import com.ray.crypto.module.AmendAlgoOrderRequest;
import com.ray.crypto.module.CancelAlgoOrderInfo;
import com.ray.crypto.module.CancelAlgoOrderRequest;
import com.ray.crypto.module.OkxResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 策略交易api
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/11/3
 */
@ConditionalOnProperty("crypto.okx.web-url")
@FeignClient(name = "StrategyTradingApi", url = "${crypto.okx.web-url}", configuration = {OkxFeignRequestInterceptor.class, OkxResponseDecoder.class})
public interface StrategyTradingApi {
    
    /**
     * 策略委托下单
     * 
     * @param request 策略委托下单请求参数
     * @return 策略委托下单结果
     */
    @PostMapping("/api/v5/trade/order-algo")
    OkxResponse<List<AlgoOrderInfo>> placeAlgoOrder(@RequestBody AlgoOrderRequest request);
    
    /**
     * 撤销策略委托订单
     * 
     * @param request 撤销策略委托订单请求参数
     * @return 撤销策略委托订单结果
     */
    @PostMapping("/api/v5/trade/cancel-algos")
    OkxResponse<List<CancelAlgoOrderInfo>> cancelAlgoOrder(@RequestBody CancelAlgoOrderRequest request);
    
    /**
     * 修改策略委托订单
     * 
     * @param request 修改策略委托订单请求参数
     * @return 修改策略委托订单结果
     */
    @PostMapping("/api/v5/trade/amend-algos")
    OkxResponse<List<AmendAlgoOrderInfo>> amendAlgoOrder(@RequestBody AmendAlgoOrderRequest request);
    
    /**
     * 获取策略委托订单详情
     * 
     * @param request 策略委托订单详情查询请求参数
     * @return 策略委托订单详情
     */
    @GetMapping("/api/v5/trade/order-algo")
    OkxResponse<List<AlgoOrderDetailsInfo>> getAlgoOrderDetails(@SpringQueryMap AlgoOrderDetailsRequest request);
    
    /**
     * 获取策略委托订单列表
     * 
     * @param request 策略委托订单列表查询请求参数
     * @return 策略委托订单列表
     */
    @GetMapping("/api/v5/trade/orders-algo-pending")
    OkxResponse<List<AlgoOrderDetailsInfo>> getAlgoOrderList(@SpringQueryMap AlgoOrderListRequest request);
    
    /**
     * 获取策略委托订单历史
     * 
     * @param request 策略委托订单历史查询请求参数
     * @return 策略委托订单历史
     */
    @GetMapping("/api/v5/trade/orders-algo-history")
    OkxResponse<List<AlgoOrderDetailsInfo>> getAlgoOrderHistory(@SpringQueryMap AlgoOrderHistoryRequest request);
}
