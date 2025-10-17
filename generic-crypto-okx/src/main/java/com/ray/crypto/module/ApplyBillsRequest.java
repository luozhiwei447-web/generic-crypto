package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX申请账单流水请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class ApplyBillsRequest {
    
    /** 查询的起始时间 */
    private String begin;
    
    /** 查询的结束时间 */
    private String end;
}