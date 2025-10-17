package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX最大可提币量信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MaxWithdrawalInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 最大可提币量 */
    private String maxWd;
    
    /** 最大可提币量（不借币） */
    private String maxWdEx;
    
    /** 现货对冲最大可提币量 */
    private String spotOffsetMaxWd;
    
    /** 现货对冲最大可提币量（不借币） */
    private String spotOffsetMaxWdEx;
}