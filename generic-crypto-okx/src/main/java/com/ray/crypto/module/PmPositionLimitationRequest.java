package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取PM持仓限制请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class PmPositionLimitationRequest {
    
    /** 产品类型 */
    private String instType;
    
    /** 标的指数 */
    private String uly;
    
    /** 产品ID */
    private String instFamily;
}