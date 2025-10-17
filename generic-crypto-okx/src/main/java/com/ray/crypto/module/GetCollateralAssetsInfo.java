package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX获取质押币种响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GetCollateralAssetsInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 是否可作为质押资产 */
    private String collateral;
    
    /** 质押率 */
    private String collateralRatio;
}