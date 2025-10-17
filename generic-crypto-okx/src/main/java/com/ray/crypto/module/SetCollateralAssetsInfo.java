package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置抵押资产响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetCollateralAssetsInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 是否可作为抵押资产 */
    private String collateral;
}