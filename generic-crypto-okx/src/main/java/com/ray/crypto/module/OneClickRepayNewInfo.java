package com.ray.crypto.module;

import lombok.Data;

/**
 * 一键还币响应（新版）
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OneClickRepayNewInfo {
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
    
    /**
     * 实际偿还的负债数量
     */
    private String repayDebtAmt;
    
    /**
     * 兑换汇率
     */
    private String rate;
    
    /**
     * 交易时间戳
     */
    private String ts;
}