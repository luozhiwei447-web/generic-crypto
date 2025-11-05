package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.CancelSignalBotInfo;
import com.ray.crypto.module.CancelSignalBotsRequest;
import com.ray.crypto.module.AmendSignalBotTpSlInfo;
import com.ray.crypto.module.AmendSignalBotTpSlRequest;
import com.ray.crypto.module.SetSignalBotInstrumentsInfo;
import com.ray.crypto.module.SetSignalBotInstrumentsRequest;
import com.ray.crypto.module.ActiveSignalBotRequest;
import com.ray.crypto.module.HistorySignalBotRequest;
import com.ray.crypto.module.CloseSignalBotPositionInfo;
import com.ray.crypto.module.CloseSignalBotPositionRequest;
import com.ray.crypto.module.CancelSignalBotSubOrderInfo;
import com.ray.crypto.module.CancelSignalBotSubOrderRequest;
import com.ray.crypto.module.SignalBotEventHistoryInfo;
import com.ray.crypto.module.SignalBotEventHistoryRequest;
import com.ray.crypto.module.SignalBotSubOrderInfo;
import com.ray.crypto.module.SignalBotSubOrdersRequest;
import com.ray.crypto.module.PlaceSignalBotSubOrderInfo;
import com.ray.crypto.module.PlaceSignalBotSubOrderRequest;
import com.ray.crypto.module.PositionHistoryInfo;
import com.ray.crypto.module.PositionHistoryRequest;
import com.ray.crypto.module.SignalBotOrderPositionInfo;
import com.ray.crypto.module.SignalBotOrderPositionsRequest;
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
    
    /**
     * 获取活跃信号机器人
     * 
     * @param request 获取活跃信号机器人请求参数
     * @return 活跃信号机器人信息
     */
    @GetMapping("/api/v5/tradingBot/signal/orders-algo-pending")
    OkxResponse<List<SignalBotOrderDetailsInfo>> getActiveSignalBot(@SpringQueryMap ActiveSignalBotRequest request);
    
    /**
     * 获取历史信号机器人
     * 
     * @param request 获取历史信号机器人请求参数
     * @return 历史信号机器人信息
     */
    @GetMapping("/api/v5/tradingBot/signal/orders-algo-history")
    OkxResponse<List<SignalBotOrderDetailsInfo>> getHistorySignalBot(@SpringQueryMap HistorySignalBotRequest request);
    
    /**
     * 获取信号机器人订单持仓信息
     * 
     * @param request 获取信号机器人订单持仓信息请求参数
     * @return 信号机器人订单持仓信息
     */
    @GetMapping("/api/v5/tradingBot/signal/positions")
    OkxResponse<List<SignalBotOrderPositionInfo>> getSignalBotOrderPositions(@SpringQueryMap SignalBotOrderPositionsRequest request);
    
    /**
     * 获取持仓历史
     * 
     * @param request 获取持仓历史请求参数
     * @return 持仓历史信息
     */
    @GetMapping("/api/v5/tradingBot/signal/positions-history")
    OkxResponse<List<PositionHistoryInfo>> getPositionHistory(@SpringQueryMap PositionHistoryRequest request);
    
    /**
     * 信号机器人平仓
     * 
     * @param request 信号机器人平仓请求参数
     * @return 信号机器人平仓结果
     */
    @PostMapping("/api/v5/tradingBot/signal/close-position")
    OkxResponse<List<CloseSignalBotPositionInfo>> closeSignalBotPosition(@RequestBody CloseSignalBotPositionRequest request);
    
    /**
     * 信号机器人子订单下单
     * 
     * @param request 信号机器人子订单下单请求参数
     * @return 信号机器人子订单下单结果
     */
    @PostMapping("/api/v5/tradingBot/signal/sub-order")
    OkxResponse<List<PlaceSignalBotSubOrderInfo>> placeSignalBotSubOrder(@RequestBody PlaceSignalBotSubOrderRequest request);
    
    /**
     * 撤销信号机器人子订单
     * 
     * @param request 撤销信号机器人子订单请求参数
     * @return 撤销信号机器人子订单结果
     */
    @PostMapping("/api/v5/tradingBot/signal/cancel-sub-order")
    OkxResponse<List<CancelSignalBotSubOrderInfo>> cancelSignalBotSubOrder(@RequestBody CancelSignalBotSubOrderRequest request);
    
    /**
     * 获取信号机器人子订单信息
     * 
     * @param request 获取信号机器人子订单信息请求参数
     * @return 信号机器人子订单信息
     */
    @GetMapping("/api/v5/tradingBot/signal/sub-orders")
    OkxResponse<List<SignalBotSubOrderInfo>> getSignalBotSubOrders(@SpringQueryMap SignalBotSubOrdersRequest request);
    
    /**
     * 获取信号机器人事件历史
     * 
     * @param request 获取信号机器人事件历史请求参数
     * @return 信号机器人事件历史信息
     */
    @GetMapping("/api/v5/tradingBot/signal/event-history")
    OkxResponse<List<SignalBotEventHistoryInfo>> getSignalBotEventHistory(@SpringQueryMap SignalBotEventHistoryRequest request);
}
