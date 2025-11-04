package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.CancelSignalBotInfo;
import com.ray.crypto.module.CancelSignalBotsRequest;
import com.ray.crypto.module.AmendSignalBotTpSlInfo;
import com.ray.crypto.module.AmendSignalBotTpSlRequest;
import com.ray.crypto.module.SetSignalBotInstrumentsInfo;
import com.ray.crypto.module.SetSignalBotInstrumentsRequest;
import com.ray.crypto.module.SignalBotOrderDetailsInfo;
import com.ray.crypto.module.SignalBotOrderDetailsRequest;
import com.ray.crypto.module.SignalBotAdjustMarginInfo;
import com.ray.crypto.module.SignalBotAdjustMarginRequest;
import com.ray.crypto.module.CreateSignalBotInfo;
import com.ray.crypto.module.CreateSignalBotRequest;
import com.ray.crypto.module.OkxResponse;
import com.ray.crypto.module.SignalBotOrderInfo;
import com.ray.crypto.module.SignalBotOrderRequest;
import com.ray.crypto.module.SignalInfo;
import com.ray.crypto.module.SignalsRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 信号交易
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/11/3
 */
@ConditionalOnProperty("crypto.okx.web-url")
@FeignClient(name = "SignalTradingApi", url = "${crypto.okx.web-url}", configuration = {OkxFeignRequestInterceptor.class, OkxResponseDecoder.class})
public interface SignalTradingApi {
    
    /**
     * 信号交易下单
     * 
     * @param request 信号交易下单请求参数
     * @return 信号交易下单结果
     */
    @PostMapping("/api/v5/tradingBot/signal/order-algo")
    OkxResponse<List<SignalBotOrderInfo>> placeSignalBotOrder(@RequestBody SignalBotOrderRequest request);
    
    /**
     * 获取信号
     * 
     * @param request 获取信号请求参数
     * @return 信号信息
     */
    @GetMapping("/api/v5/tradingBot/signal/signals")
    OkxResponse<List<SignalInfo>> getSignals(@SpringQueryMap SignalsRequest request);
    
    /**
     * 创建信号机器人
     * 
     * @param request 创建信号机器人请求参数
     * @return 创建信号机器人结果
     */
    @PostMapping("/api/v5/tradingBot/signal/create-signal")
    OkxResponse<List<CreateSignalBotInfo>> createSignalBot(@RequestBody CreateSignalBotRequest request);
    
    /**
     * 撤销信号机器人
     * 
     * @param request 撤销信号机器人请求参数
     * @return 撤销信号机器人结果
     */
    @PostMapping("/api/v5/tradingBot/signal/cancel-signal")
    OkxResponse<List<CancelSignalBotInfo>> cancelSignalBots(@RequestBody CancelSignalBotsRequest request);
    
    /**
     * 信号机器人调整保证金余额
     * 
     * @param request 信号机器人调整保证金余额请求参数
     * @return 信号机器人调整保证金余额结果
     */
    @PostMapping("/api/v5/tradingBot/signal/margin-balance")
    OkxResponse<List<SignalBotAdjustMarginInfo>> adjustSignalBotMargin(@RequestBody SignalBotAdjustMarginRequest request);
    
    /**
     * 修改信号机器人止盈止损
     * 
     * @param request 修改信号机器人止盈止损请求参数
     * @return 修改信号机器人止盈止损结果
     */
    @PostMapping("/api/v5/tradingBot/signal/amendTPSL")
    OkxResponse<List<AmendSignalBotTpSlInfo>> amendSignalBotTpSl(@RequestBody AmendSignalBotTpSlRequest request);
    
    /**
     * 设置信号机器人产品
     * 
     * @param request 设置信号机器人产品请求参数
     * @return 设置信号机器人产品结果
     */
    @PostMapping("/api/v5/tradingBot/signal/set-instruments")
    OkxResponse<List<SetSignalBotInstrumentsInfo>> setSignalBotInstruments(@RequestBody SetSignalBotInstrumentsRequest request);
    
    /**
     * 获取信号机器人订单详情
     * 
     * @param request 获取信号机器人订单详情请求参数
     * @return 信号机器人订单详情
     */
    @GetMapping("/api/v5/tradingBot/signal/orders-algo-details")
    OkxResponse<List<SignalBotOrderDetailsInfo>> getSignalBotOrderDetails(@SpringQueryMap SignalBotOrderDetailsRequest request);
}
