package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置Greeks展示类型响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetGreeksInfo {
    
    /** 
     * Greeks展示类型
     * PA：币本位
     * BS：美元本位
     */
    private String greeksType;
}