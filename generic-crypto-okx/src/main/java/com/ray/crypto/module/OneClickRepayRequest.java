package com.ray.crypto.module;

import lombok.Data;

/**
 * 一键还币请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OneClickRepayRequest {
    /**
     * 负债币种
     */
    private String debtCcy;
    
    /**
     * 还币币种
     */
    private String repayCcy;
    
    /**
     * 还币数量
     */
    private String repayAmt;
}