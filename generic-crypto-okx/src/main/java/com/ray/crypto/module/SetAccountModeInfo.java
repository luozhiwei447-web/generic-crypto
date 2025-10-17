package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置账户模式响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetAccountModeInfo {
    
    /** 账户模式 */
    private String acctLv;
}