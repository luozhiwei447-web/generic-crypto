package com.ray.crypto.module;

import lombok.Data;

/**
 * 闪兑币种信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class EasyConvertCurrencyInfo {
    /**
     * 币种
     */
    private String ccy;
    
    /**
     * 币种名称
     */
    private String ccyName;
    
    /**
     * 币种图标
     */
    private String ccyLogo;
    
    /**
     * 最小兑换数量
     */
    private String minSz;
    
    /**
     * 最大兑换数量
     */
    private String maxSz;
}