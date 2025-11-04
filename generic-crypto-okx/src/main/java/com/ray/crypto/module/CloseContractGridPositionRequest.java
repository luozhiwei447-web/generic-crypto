package com.ray.crypto.module;

import lombok.Data;

/**
 * 合约网格平仓请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CloseContractGridPositionRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 市价全平仓
     */
    private String mktClose;
    
    /**
     * 平仓数量
     */
    private String sz;
    
    /**
     * 平仓价格
     */
    private String px;
}