package com.ray.crypto.module;

import lombok.Data;

/**
 * 一键还币币种信息（新版）
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OneClickRepayCurrencyNewInfo {
    /**
     * 负债币种
     */
    private String debtCcy;
    
    /**
     * 还币币种
     */
    private String repayCcy;
    
    /**
     * 还币币种名称
     */
    private String repayCcyName;
    
    /**
     * 还币币种图标
     */
    private String repayCcyLogo;
    
    /**
     * 最小还币数量
     */
    private String minRepayAmt;
    
    /**
     * 最大还币数量
     */
    private String maxRepayAmt;
}