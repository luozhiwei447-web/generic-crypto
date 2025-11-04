package com.ray.crypto.module;

import lombok.Data;

/**
 * 撤销合约网格平仓订单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelClosePositionRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 平仓订单ID
     */
    private String ordId;
}