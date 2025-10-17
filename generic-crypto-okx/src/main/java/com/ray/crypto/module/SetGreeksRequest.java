package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置Greeks展示类型请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetGreeksRequest {
    
    /** 
     * Greeks展示类型
     * PA：币本位
     * BS：美元本位
     */
    private String greeksType;
}