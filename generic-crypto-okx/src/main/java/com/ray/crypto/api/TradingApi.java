package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.AccountRateLimitInfo;
import com.ray.crypto.module.AmendOrderInfo;
import com.ray.crypto.module.AmendOrderRequest;
import com.ray.crypto.module.CancelAllAfterInfo;
import com.ray.crypto.module.CancelAllAfterRequest;
import com.ray.crypto.module.CancelOrderInfo;
import com.ray.crypto.module.CancelOrderRequest;
import com.ray.crypto.module.ClosePositionInfo;
import com.ray.crypto.module.ClosePositionRequest;
import com.ray.crypto.module.EasyConvertCurrencyInfo;
import com.ray.crypto.module.EasyConvertHistoryRequest;
import com.ray.crypto.module.EasyConvertInfo;
import com.ray.crypto.module.EasyConvertRequest;
import com.ray.crypto.module.FillsInfo;
import com.ray.crypto.module.FillsRequest;
import com.ray.crypto.module.MassCancelOrderInfo;
import com.ray.crypto.module.MassCancelOrderRequest;
import com.ray.crypto.module.OneClickRepayCurrencyInfo;
import com.ray.crypto.module.OneClickRepayCurrencyNewInfo;
import com.ray.crypto.module.OneClickRepayHistoryRequest;
import com.ray.crypto.module.OneClickRepayInfo;
import com.ray.crypto.module.OneClickRepayNewInfo;
import com.ray.crypto.module.OneClickRepayNewRequest;
import com.ray.crypto.module.OneClickRepayRequest;
import com.ray.crypto.module.OrderDetailsInfo;
import com.ray.crypto.module.OrderDetailsRequest;
import com.ray.crypto.module.OrderHistoryRequest;
import com.ray.crypto.module.OrderListRequest;
import com.ray.crypto.module.OrderPrecheckInfo;
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
    
    /**
     * 获取订单历史（近3个月）
     * 
     * @param request 订单历史查询请求参数
     * @return 订单历史
     */
    @GetMapping("/api/v5/trade/orders-history-archive")
    OkxResponse<List<OrderDetailsInfo>> getOrderHistoryArchive(@SpringQueryMap OrderHistoryRequest request);
    
    /**
     * 获取成交明细（近3天）
     * 
     * @param request 成交明细查询请求参数
     * @return 成交明细
     */
    @GetMapping("/api/v5/trade/fills")
    OkxResponse<List<FillsInfo>> getFills(@SpringQueryMap FillsRequest request);
    
    /**
     * 获取成交明细（近3个月）
     * 
     * @param request 成交明细查询请求参数
     * @return 成交明细
     */
    @GetMapping("/api/v5/trade/fills-archive")
    OkxResponse<List<FillsInfo>> getFillsArchive(@SpringQueryMap FillsRequest request);
    
    /**
     * 获取闪兑币种列表
     * 
     * @return 闪兑币种列表
     */
    @GetMapping("/api/v5/trade/easy-convert-currency-list")
    OkxResponse<List<EasyConvertCurrencyInfo>> getEasyConvertCurrencyList();
    
    /**
     * 闪兑交易
     * 
     * @param request 闪兑交易请求参数
     * @return 闪兑交易结果
     */
    @PostMapping("/api/v5/trade/easy-convert")
    OkxResponse<List<EasyConvertInfo>> placeEasyConvert(@RequestBody EasyConvertRequest request);
    
    /**
     * 获取闪兑历史
     * 
     * @param request 闪兑历史查询请求参数
     * @return 闪兑历史
     */
    @GetMapping("/api/v5/trade/easy-convert-history")
    OkxResponse<List<EasyConvertInfo>> getEasyConvertHistory(@SpringQueryMap EasyConvertHistoryRequest request);
    
    /**
     * 获取一键还币币种列表
     * 
     * @return 一键还币币种列表
     */
    @GetMapping("/api/v5/trade/one-click-repay-currency-list")
    OkxResponse<List<OneClickRepayCurrencyInfo>> getOneClickRepayCurrencyList();
    
    /**
     * 一键还币交易
     * 
     * @param request 一键还币请求参数
     * @return 一键还币结果
     */
    @PostMapping("/api/v5/trade/one-click-repay")
    OkxResponse<List<OneClickRepayInfo>> placeOneClickRepay(@RequestBody OneClickRepayRequest request);
    
    /**
     * 获取一键还币历史
     * 
     * @param request 一键还币历史查询请求参数
     * @return 一键还币历史
     */
    @GetMapping("/api/v5/trade/one-click-repay-history")
    OkxResponse<List<OneClickRepayInfo>> getOneClickRepayHistory(@SpringQueryMap OneClickRepayHistoryRequest request);
    
    /**
     * 获取一键还币币种列表（新版）
     * 
     * @return 一键还币币种列表
     */
    @GetMapping("/api/v5/trade/one-click-repay-currency-list-new")
    OkxResponse<List<OneClickRepayCurrencyNewInfo>> getOneClickRepayCurrencyListNew();
    
    /**
     * 一键还币交易（新版）
     * 
     * @param request 一键还币请求参数
     * @return 一键还币结果
     */
    @PostMapping("/api/v5/trade/one-click-repay-new")
    OkxResponse<List<OneClickRepayNewInfo>> placeOneClickRepayNew(@RequestBody OneClickRepayNewRequest request);
    
    /**
     * 获取一键还币历史（新版）
     * 
     * @param request 一键还币历史查询请求参数
     * @return 一键还币历史
     */
    @GetMapping("/api/v5/trade/one-click-repay-history-new")
    OkxResponse<List<OneClickRepayNewInfo>> getOneClickRepayHistoryNew(@SpringQueryMap OneClickRepayHistoryRequest request);
    
    /**
     * 大宗撤单
     * 
     * @param request 大宗撤单请求参数
     * @return 大宗撤单结果
     */
    @PostMapping("/api/v5/trade/mass-cancel")
    OkxResponse<List<MassCancelOrderInfo>> massCancelOrder(@RequestBody MassCancelOrderRequest request);
    
    /**
     * 倒计时全部撤单
     * 
     * @param request 倒计时撤单请求参数
     * @return 倒计时撤单结果
     */
    @PostMapping("/api/v5/trade/cancel-all-after")
    OkxResponse<List<CancelAllAfterInfo>> cancelAllAfter(@RequestBody CancelAllAfterRequest request);
    
    /**
     * 获取账户限频信息
     * 
     * @return 账户限频信息
     */
    @GetMapping("/api/v5/trade/account-rate-limit")
    OkxResponse<List<AccountRateLimitInfo>> getAccountRateLimit();
    
    /**
     * 订单预检查
     * 
     * @param request 订单预检查请求参数
     * @return 订单预检查结果
     */
    @PostMapping("/api/v5/trade/order-precheck")
    OkxResponse<List<OrderPrecheckInfo>> orderPrecheck(@RequestBody PlaceOrderRequest request);
}
