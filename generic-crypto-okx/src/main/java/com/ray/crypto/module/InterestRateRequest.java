package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取用户当前杠杆借币利率请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class InterestRateRequest {
    
    /** 币种，如BTC，不填写表示查询所有币种 */
    private String ccy;
}