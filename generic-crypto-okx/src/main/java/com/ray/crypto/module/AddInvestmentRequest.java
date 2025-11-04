package com.ray.crypto.module;

import lombok.Data;

/**
 * 追加投资请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AddInvestmentRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 追加投资数量
     */
    private String amt;
}