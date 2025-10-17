package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX借币利息和限额信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class BorrowInterestLimitInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 日利率 */
    private String rate;
    
    /** 借币限额 */
    private String loanQuota;
    
    /** 已借数量 */
    private String surplusLmt;
    
    /** 可借数量 */
    private String usedLmt;
    
    /** 借币限额等级 */
    private String loanQuotaCoef;
}