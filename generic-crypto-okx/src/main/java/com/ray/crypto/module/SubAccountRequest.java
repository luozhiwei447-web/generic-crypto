package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX子账户相关请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SubAccountRequest {
    
    /** 子账户名称 */
    private String subAcct;
    
    /** 是否启用 */
    private Boolean enable;
    
    /** 页码 */
    private String page;
    
    /** 每页数量 */
    private String limit;
}