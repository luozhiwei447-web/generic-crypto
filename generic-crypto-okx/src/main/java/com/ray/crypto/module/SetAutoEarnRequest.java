package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置自动赚币请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetAutoEarnRequest {
    
    /** 币种 */
    private String ccy;
    
    /** 是否开启自动赚币 */
    private Boolean autoEarn;
}