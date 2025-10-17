package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取质押币种请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class GetCollateralAssetsRequest {
    
    /** 币种 */
    private String ccy;
}