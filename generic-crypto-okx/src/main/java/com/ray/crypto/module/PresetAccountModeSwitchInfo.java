package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX预设账户模式切换响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PresetAccountModeSwitchInfo {
    
    /** 账户模式 */
    private String acctLv;
}