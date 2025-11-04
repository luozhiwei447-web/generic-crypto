package com.ray.crypto.module;

import lombok.Data;

/**
 * 最大网格数量响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MaxGridQuantityInfo {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 最大网格数量
     */
    private String maxGridNum;
}