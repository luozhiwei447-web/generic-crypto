package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX杠杆借币利率信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class InterestRateInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 日利率 */
    private String interestRate;
}