package com.ray.crypto.module;

import lombok.Data;

/**
 * 网格AI参数信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GridAiParameterInfo {
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 网格方向
     */
    private String direction;
    
    /**
     * 持续时间
     */
    private String duration;
    
    /**
     * 网格上限价格
     */
    private String maxPx;
    
    /**
     * 网格下限价格
     */
    private String minPx;
    
    /**
     * 网格数量
     */
    private String gridNum;
    
    /**
     * 年化收益率
     */
    private String annualizedRate;
    
    /**
     * 最小投资数量
     */
    private String minInvestment;
    
    /**
     * 币种
     */
    private String ccy;
    
    /**
     * 网格类型
     */
    private String runType;
    
    /**
     * 产品类型
     */
    private String instType;
}