package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取网格策略委托订单持仓信息请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GridAlgoOrderPositionsRequest {
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 策略订单ID
     */
    private String algoId;
}