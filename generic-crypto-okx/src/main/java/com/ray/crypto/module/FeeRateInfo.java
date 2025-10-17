package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX交易手续费费率信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class FeeRateInfo {
    
    /** 产品类型 */
    private String instType;
    
    /** 产品ID */
    private String instId;
    
    /** 挂单手续费费率（U本位结算） */
    private String makerU;
    
    /** 吃单手续费费率（U本位结算） */
    private String takerU;
    
    /** 挂单手续费费率（USDC结算） */
    private String makerUSDC;
    
    /** 吃单手续费费率（USDC结算） */
    private String takerUSDC;
    
    /** 交割手续费费率 */
    private String delivery;
    
    /** 行权手续费费率 */
    private String exercise;
    
    /** 产品分类 */
    private String category;
    
    /** 数据返回时间，Unix时间戳的毫秒数格式 */
    private String ts;
}