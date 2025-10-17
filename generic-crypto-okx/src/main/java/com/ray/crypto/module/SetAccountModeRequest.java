package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置账户模式请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetAccountModeRequest {
    
    /** 账户模式 */
    private String acctLv;
}