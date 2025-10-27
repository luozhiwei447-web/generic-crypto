package com.ray.crypto.module;

import com.ray.crypto.constants.PositionSide;
import com.ray.crypto.constants.TradeMode;
import lombok.Data;

/**
 * 市价全平仓请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ClosePositionRequest {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 交易模式
     */
    private TradeMode mgnMode;
    
    /**
     * 持仓方向
     */
    private PositionSide posSide;
    
    /**
     * 保证金币种
     */
    private String ccy;
    
    /**
     * 是否自动撤销
     */
    private Boolean autoCxl;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 订单标签
     */
    private String tag;
}