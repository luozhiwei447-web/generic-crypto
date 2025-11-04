package com.ray.crypto.module;

import lombok.Data;

/**
 * 计算最小投资数量请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ComputeMinInvestmentRequest {
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 产品ID
     */
    private String instId;
    
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
     * 网格类型
     */
    private String runType;
    
    /**
     * 网格方向
     */
    private String direction;
    
    /**
     * 杠杆倍数
     */
    private String lever;
    
    /**
     * 基础货币投资数量
     */
    private String basePos;
}