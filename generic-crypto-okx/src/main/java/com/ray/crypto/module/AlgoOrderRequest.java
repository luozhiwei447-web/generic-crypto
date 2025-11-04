package com.ray.crypto.module;

import com.ray.crypto.constants.OrderSide;
import com.ray.crypto.constants.OrderType;
import com.ray.crypto.constants.PositionSide;
import com.ray.crypto.constants.TradeMode;
import lombok.Data;

/**
 * 策略委托下单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AlgoOrderRequest {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 交易模式
     */
    private TradeMode tdMode;
    
    /**
     * 订单方向
     */
    private OrderSide side;
    
    /**
     * 持仓方向
     */
    private PositionSide posSide;
    
    /**
     * 订单类型
     */
    private String ordType;
    
    /**
     * 委托数量
     */
    private String sz;
    
    /**
     * 委托价格
     */
    private String px;
    
    /**
     * 触发价格
     */
    private String triggerPx;
    
    /**
     * 委托价格类型
     */
    private String orderPx;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 订单标签
     */
    private String tag;
    
    /**
     * 是否只减仓
     */
    private Boolean reduceOnly;
}