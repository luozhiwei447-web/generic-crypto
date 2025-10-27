package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.AmendOrderInfo;
import com.ray.crypto.module.AmendOrderRequest;
import com.ray.crypto.module.CancelOrderInfo;
import com.ray.crypto.module.CancelOrderRequest;
import com.ray.crypto.module.ClosePositionInfo;
import com.ray.crypto.module.ClosePositionRequest;
import com.ray.crypto.module.OrderDetailsInfo;
import com.ray.crypto.module.OrderDetailsRequest;
import com.ray.crypto.module.OrderHistoryRequest;
import com.ray.crypto.module.OrderListRequest;
import com.ray.crypto.module.OkxResponse;
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
     * 
     * @param request 下单请求参数
     * @return 下单结果
     */
    @PostMapping("/api/v5/trade/order")
    OkxResponse<List<PlaceOrderInfo>> placeOrder(@RequestBody PlaceOrderRequest request);
    
    /**
     * 批量下单
     * 
     * @param requests 批量下单请求参数列表
     * @return 批量下单结果
     */
    @PostMapping("/api/v5/trade/batch-orders")
    OkxResponse<List<PlaceOrderInfo>> placeBatchOrders(@RequestBody List<PlaceOrderRequest> requests);
    
    /**
     * 撤单
     * 
     * @param request 撤单请求参数
     * @return 撤单结果
     */
    @PostMapping("/api/v5/trade/cancel-order")
    OkxResponse<List<CancelOrderInfo>> cancelOrder(@RequestBody CancelOrderRequest request);
    
    /**
     * 批量撤单
     * 
     * @param requests 批量撤单请求参数列表
     * @return 批量撤单结果
     */
    @PostMapping("/api/v5/trade/cancel-batch-orders")
    OkxResponse<List<CancelOrderInfo>> cancelBatchOrders(@RequestBody List<CancelOrderRequest> requests);
    
    /**
     * 改单
     * 
     * @param request 改单请求参数
     * @return 改单结果
     */
    @PostMapping("/api/v5/trade/amend-order")
    OkxResponse<List<AmendOrderInfo>> amendOrder(@RequestBody AmendOrderRequest request);
    
    /**
     * 批量改单
     * 
     * @param requests 批量改单请求参数列表
     * @return 批量改单结果
     */
    @PostMapping("/api/v5/trade/amend-batch-orders")
    OkxResponse<List<AmendOrderInfo>> amendBatchOrders(@RequestBody List<AmendOrderRequest> requests);
    
    /**
     * 市价全平仓
     * 
     * @param request 市价全平仓请求参数
     * @return 市价全平仓结果
     */
    @PostMapping("/api/v5/trade/close-position")
    OkxResponse<List<ClosePositionInfo>> closePosition(@RequestBody ClosePositionRequest request);
    
    /**
     * 获取订单详情
     * 
     * @param request 订单详情查询请求参数
     * @return 订单详情
     */
    @GetMapping("/api/v5/trade/order")
    OkxResponse<List<OrderDetailsInfo>> getOrderDetails(@SpringQueryMap OrderDetailsRequest request);
    
    /**
     * 获取未完成订单列表
     * 
     * @param request 订单列表查询请求参数
     * @return 订单列表
     */
    @GetMapping("/api/v5/trade/orders-pending")
    OkxResponse<List<OrderDetailsInfo>> getOrderList(@SpringQueryMap OrderListRequest request);
    
    /**
     * 获取订单历史（近7天）
     * 
     * @param request 订单历史查询请求参数
     * @return 订单历史
     */
    @GetMapping("/api/v5/trade/orders-history")
    OkxResponse<List<OrderDetailsInfo>> getOrderHistory(@SpringQueryMap OrderHistoryRequest request);
}
