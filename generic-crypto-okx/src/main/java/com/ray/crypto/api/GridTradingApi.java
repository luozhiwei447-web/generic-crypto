package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.AmendGridAlgoOrderInfo;
import com.ray.crypto.module.AmendGridAlgoOrderRequest;
import com.ray.crypto.module.CancelClosePositionInfo;
import com.ray.crypto.module.CancelClosePositionRequest;
import com.ray.crypto.module.CloseContractGridPositionInfo;
import com.ray.crypto.module.CloseContractGridPositionRequest;
import com.ray.crypto.module.GridAlgoOrderInfo;
import com.ray.crypto.module.GridAlgoOrderDetailsRequest;
import com.ray.crypto.module.GridAlgoOrderPositionInfo;
import com.ray.crypto.module.GridAlgoOrderPositionsRequest;
import com.ray.crypto.module.AddInvestmentInfo;
import com.ray.crypto.module.AddInvestmentRequest;
import com.ray.crypto.module.ComputeMinInvestmentInfo;
import com.ray.crypto.module.ComputeMinInvestmentRequest;
import com.ray.crypto.module.MaxGridQuantityInfo;
import com.ray.crypto.module.MaxGridQuantityRequest;
import com.ray.crypto.module.RsiBackTestingInfo;
import com.ray.crypto.module.RsiBackTestingRequest;
import com.ray.crypto.module.GridAiParameterInfo;
import com.ray.crypto.module.GridAiParameterRequest;
import com.ray.crypto.module.AdjustMarginBalanceInfo;
import com.ray.crypto.module.AdjustMarginBalanceRequest;
import com.ray.crypto.module.ComputeMarginBalanceInfo;
import com.ray.crypto.module.ComputeMarginBalanceRequest;
import com.ray.crypto.module.SpotGridWithdrawIncomeInfo;
import com.ray.crypto.module.SpotGridWithdrawIncomeRequest;
import com.ray.crypto.module.GridAlgoSubOrderInfo;
import com.ray.crypto.module.GridAlgoSubOrdersRequest;
import com.ray.crypto.module.GridAlgoOrderHistoryRequest;
import com.ray.crypto.module.GridAlgoOrderListInfo;
import com.ray.crypto.module.GridAlgoOrderListRequest;
import com.ray.crypto.module.GridAlgoOrderRequest;
import com.ray.crypto.module.InstantTriggerGridInfo;
import com.ray.crypto.module.InstantTriggerGridRequest;
import com.ray.crypto.module.StopGridAlgoOrderInfo;
import com.ray.crypto.module.StopGridAlgoOrderRequest;
import com.ray.crypto.module.OkxResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 网格交易
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/11/3
 */
@ConditionalOnProperty("crypto.okx.web-url")
@FeignClient(name = "GridTradingApi", url = "${crypto.okx.web-url}", configuration = {OkxFeignRequestInterceptor.class, OkxResponseDecoder.class})
public interface GridTradingApi {
    
    /**
     * 网格策略委托下单
     * 
     * @param request 网格策略委托下单请求参数
     * @return 网格策略委托下单结果
     */
    @PostMapping("/api/v5/tradingBot/grid/order-algo")
    OkxResponse<List<GridAlgoOrderInfo>> placeGridAlgoOrder(@RequestBody GridAlgoOrderRequest request);
    
    /**
     * 修改网格策略委托订单
     * 
     * @param request 修改网格策略委托订单请求参数
     * @return 修改网格策略委托订单结果
     */
    @PostMapping("/api/v5/tradingBot/grid/amend-order-algo")
    OkxResponse<List<AmendGridAlgoOrderInfo>> amendGridAlgoOrder(@RequestBody AmendGridAlgoOrderRequest request);
    
    /**
     * 停止网格策略委托订单
     * 
     * @param request 停止网格策略委托订单请求参数
     * @return 停止网格策略委托订单结果
     */
    @PostMapping("/api/v5/tradingBot/grid/stop-order-algo")
    OkxResponse<List<StopGridAlgoOrderInfo>> stopGridAlgoOrder(@RequestBody StopGridAlgoOrderRequest request);
    
    /**
     * 合约网格平仓
     * 
     * @param request 合约网格平仓请求参数
     * @return 合约网格平仓结果
     */
    @PostMapping("/api/v5/tradingBot/grid/close-position")
    OkxResponse<List<CloseContractGridPositionInfo>> closeContractGridPosition(@RequestBody CloseContractGridPositionRequest request);
    
    /**
     * 撤销合约网格平仓订单
     * 
     * @param request 撤销合约网格平仓订单请求参数
     * @return 撤销合约网格平仓订单结果
     */
    @PostMapping("/api/v5/tradingBot/grid/cancel-close-order")
    OkxResponse<List<CancelClosePositionInfo>> cancelClosePosition(@RequestBody CancelClosePositionRequest request);
    
    /**
     * 立即触发网格策略订单
     * 
     * @param request 立即触发网格策略订单请求参数
     * @return 立即触发网格策略订单结果
     */
    @PostMapping("/api/v5/tradingBot/grid/order-instant-trigger")
    OkxResponse<List<InstantTriggerGridInfo>> instantTriggerGrid(@RequestBody InstantTriggerGridRequest request);
    
    /**
     * 获取网格策略委托订单列表
     * 
     * @param request 获取网格策略委托订单列表请求参数
     * @return 网格策略委托订单列表
     */
    @GetMapping("/api/v5/tradingBot/grid/orders-algo-pending")
    OkxResponse<List<GridAlgoOrderListInfo>> getGridAlgoOrderList(@SpringQueryMap GridAlgoOrderListRequest request);
    
    /**
     * 获取网格策略委托订单历史
     * 
     * @param request 获取网格策略委托订单历史请求参数
     * @return 网格策略委托订单历史
     */
    @GetMapping("/api/v5/tradingBot/grid/orders-algo-history")
    OkxResponse<List<GridAlgoOrderListInfo>> getGridAlgoOrderHistory(@SpringQueryMap GridAlgoOrderHistoryRequest request);
    
    /**
     * 获取网格策略委托订单详情
     * 
     * @param request 获取网格策略委托订单详情请求参数
     * @return 网格策略委托订单详情
     */
    @GetMapping("/api/v5/tradingBot/grid/orders-algo-details")
    OkxResponse<List<GridAlgoOrderListInfo>> getGridAlgoOrderDetails(@SpringQueryMap GridAlgoOrderDetailsRequest request);
    
    /**
     * 获取网格策略委托子订单信息
     * 
     * @param request 获取网格策略委托子订单信息请求参数
     * @return 网格策略委托子订单信息
     */
    @GetMapping("/api/v5/tradingBot/grid/sub-orders")
    OkxResponse<List<GridAlgoSubOrderInfo>> getGridAlgoSubOrders(@SpringQueryMap GridAlgoSubOrdersRequest request);
    
    /**
     * 获取网格策略委托订单持仓信息
     * 
     * @param request 获取网格策略委托订单持仓信息请求参数
     * @return 网格策略委托订单持仓信息
     */
    @GetMapping("/api/v5/tradingBot/grid/positions")
    OkxResponse<List<GridAlgoOrderPositionInfo>> getGridAlgoOrderPositions(@SpringQueryMap GridAlgoOrderPositionsRequest request);
    
    /**
     * 现货网格提取收益
     * 
     * @param request 现货网格提取收益请求参数
     * @return 现货网格提取收益结果
     */
    @PostMapping("/api/v5/tradingBot/grid/withdraw-income")
    OkxResponse<List<SpotGridWithdrawIncomeInfo>> spotGridWithdrawIncome(@RequestBody SpotGridWithdrawIncomeRequest request);
    
    /**
     * 计算保证金余额
     * 
     * @param request 计算保证金余额请求参数
     * @return 计算保证金余额结果
     */
    @PostMapping("/api/v5/tradingBot/grid/compute-margin-balance")
    OkxResponse<List<ComputeMarginBalanceInfo>> computeMarginBalance(@RequestBody ComputeMarginBalanceRequest request);
    
    /**
     * 调整保证金余额
     * 
     * @param request 调整保证金余额请求参数
     * @return 调整保证金余额结果
     */
    @PostMapping("/api/v5/tradingBot/grid/margin-balance")
    OkxResponse<List<AdjustMarginBalanceInfo>> adjustMarginBalance(@RequestBody AdjustMarginBalanceRequest request);
    
    /**
     * 追加投资
     * 
     * @param request 追加投资请求参数
     * @return 追加投资结果
     */
    @PostMapping("/api/v5/tradingBot/grid/add-investment")
    OkxResponse<List<AddInvestmentInfo>> addInvestment(@RequestBody AddInvestmentRequest request);
    
    /**
     * 获取网格AI参数（公共）
     * 
     * @param request 获取网格AI参数请求参数
     * @return 网格AI参数信息
     */
    @GetMapping("/api/v5/tradingBot/grid/ai-param")
    OkxResponse<List<GridAiParameterInfo>> getGridAiParameter(@SpringQueryMap GridAiParameterRequest request);
    
    /**
     * 计算最小投资数量（公共）
     * 
     * @param request 计算最小投资数量请求参数
     * @return 最小投资数量信息
     */
    @PostMapping("/api/v5/tradingBot/grid/min-investment")
    OkxResponse<List<ComputeMinInvestmentInfo>> computeMinInvestment(@RequestBody ComputeMinInvestmentRequest request);
    
    /**
     * RSI策略回测（公共）
     * 
     * @param request RSI策略回测请求参数
     * @return RSI策略回测信息
     */
    @GetMapping("/api/v5/tradingBot/grid/rsi-back-testing")
    OkxResponse<List<RsiBackTestingInfo>> getRsiBackTesting(@SpringQueryMap RsiBackTestingRequest request);
    
    /**
     * 获取最大网格数量（公共）
     * 
     * @param request 获取最大网格数量请求参数
     * @return 最大网格数量信息
     */
    @GetMapping("/api/v5/tradingBot/grid/grid-quantity")
    OkxResponse<List<MaxGridQuantityInfo>> getMaxGridQuantity(@SpringQueryMap MaxGridQuantityRequest request);
}
