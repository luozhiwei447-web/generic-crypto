package com.ray.crypto.module;

import lombok.Data;

/**
 * 现货网格提取收益请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SpotGridWithdrawIncomeRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
}