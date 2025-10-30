package com.ray.crypto.module;

import lombok.Data;

/**
 * 一键还币币种信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OneClickRepayCurrencyInfo {
    /**
     * 负债币种
     */
    private String debtCcy;
    
    /**
     * 还币币种
     */
    private String repayCcy;
}