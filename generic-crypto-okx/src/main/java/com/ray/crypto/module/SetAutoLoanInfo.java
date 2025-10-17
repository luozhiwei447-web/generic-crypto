package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置自动借币响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetAutoLoanInfo {
    
    /** 是否自动借币 */
    private String autoLoan;
}