package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX预检查账户模式切换请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class PrecheckAccountModeSwitchRequest {
    
    /** 账户模式 */
    private String acctLv;
}