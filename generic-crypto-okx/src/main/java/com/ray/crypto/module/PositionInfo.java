package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX持仓信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PositionInfo {
    
    /** 产品类型 */
    private String instType;
    
    /** 保证金模式 */
    private String mgnMode;
    
    /** 持仓ID */
    private String posId;
    
    /** 持仓方向 */
    private String posSide;
    
    /** 持仓数量 */
    private String pos;
    
    /** 基础币种持仓数量 */
    private String baseBal;
    
    /** 计价币种持仓数量 */
    private String quoteBal;
    
    /** 持仓成本价 */
    private String avgPx;
    
    /** 未实现收益 */
    private String upl;
    
    /** 未实现收益率 */
    private String uplRatio;
    
    /** 产品ID */
    private String instId;
    
    /** 杠杆倍数 */
    private String lever;
    
    /** 预估强平价 */
    private String liqPx;
    
    /** 标记价格 */
    private String markPx;
    
    /** 保证金余额 */
    private String margin;
    
    /** 保证金率 */
    private String mgnRatio;
    
    /** 维持保证金 */
    private String mmr;
    
    /** 负债额 */
    private String liab;
    
    /** 负债币种 */
    private String liabCcy;
    
    /** 利息 */
    private String interest;
    
    /** 最新成交价 */
    private String last;
    
    /** 美元价值 */
    private String notionalUsd;
    
    /** 持仓创建时间 */
    private String cTime;
    
    /** 持仓更新时间 */
    private String uTime;
}