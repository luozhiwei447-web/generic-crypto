package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX预检查账户模式切换响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PrecheckAccountModeSwitchInfo {
    
    /** 账户模式 */
    private String acctLv;
    
    /** 是否可以切换 */
    private String canSwitch;
    
    /** 原因 */
    private String reason;
}