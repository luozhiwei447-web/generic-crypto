package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取网格AI参数请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GridAiParameterRequest {
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
}