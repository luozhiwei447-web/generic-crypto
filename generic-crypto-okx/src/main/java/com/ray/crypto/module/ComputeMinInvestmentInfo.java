package com.ray.crypto.module;

import lombok.Data;

/**
 * 计算最小投资数量响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ComputeMinInvestmentInfo {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 最小投资数量
     */
    private String minInvestment;
    
    /**
     * 币种
     */
    private String ccy;
    
    /**
     * 单网格买入数量
     */
    private String perGridAmt;
}