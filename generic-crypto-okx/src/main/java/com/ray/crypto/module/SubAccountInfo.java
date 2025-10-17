package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX子账户信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SubAccountInfo {
    
    /** 子账户名称 */
    private String subAcct;
    
    /** 子账户UID */
    private String uid;
    
    /** 子账户标签 */
    private String label;
    
    /** 子账户类型 */
    private String type;
    
    /** 是否启用 */
    private String enable;
    
    /** 创建时间 */
    private String ts;
}