package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取最大可提币量请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class MaxWithdrawalRequest {
    
    /** 币种，如BTC，不填写表示查询所有币种 */
    private String ccy;
}