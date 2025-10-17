package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置抵押资产请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetCollateralAssetsRequest {
    
    /** 币种 */
    private String ccy;
    
    /** 是否可作为抵押资产 */
    private Boolean collateral;
}