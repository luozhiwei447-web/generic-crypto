package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX账单流水信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class BillsInfo {
    
    /** 产品类型 */
    private String instType;
    
    /** 账单ID */
    private String billId;
    
    /** 账单类型 */
    private String type;
    
    /** 账单子类型 */
    private String subType;
    
    /** 时间戳 */
    private String ts;
    
    /** 余额数量 */
    private String balChg;
    
    /** 持仓数量 */
    private String posChg;
    
    /** 余额 */
    private String bal;
    
    /** 持仓 */
    private String pos;
    
    /** 币种 */
    private String ccy;
    
    /** 已实现收益 */
    private String pnl;
    
    /** 手续费 */
    private String fee;
    
    /** 保证金模式 */
    private String mgnMode;
    
    /** 产品ID */
    private String instId;
    
    /** 订单ID */
    private String ordId;
    
    /** 成交ID */
    private String execType;
    
    /** 来源 */
    private String from;
    
    /** 去向 */
    private String to;
    
    /** 备注 */
    private String notes;
}