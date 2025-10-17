package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX Greeks信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GreeksInfo {
    
    /** 币种 */
    private String ccy;
    
    /** delta */
    private String deltaBS;
    
    /** gamma */
    private String gammaBS;
    
    /** theta */
    private String thetaBS;
    
    /** vega */
    private String vegaBS;
    
    /** 时间戳 */
    private String ts;
}