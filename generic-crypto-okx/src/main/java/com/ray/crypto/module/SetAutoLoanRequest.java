package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置自动借币请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetAutoLoanRequest {
    
    /** 是否自动借币 */
    private Boolean autoLoan;
}