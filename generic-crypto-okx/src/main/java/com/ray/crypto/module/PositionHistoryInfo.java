package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX持仓历史信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PositionHistoryInfo {
    
    /** 产品类型 */
    private String instType;
    
    /** 产品ID */
    private String instId;
    
    /** 保证金模式 */
    private String mgnMode;
    
    /** 持仓类型 */
    private String type;
    
    /** 持仓方向 */
    private String direction;
    
    /** 持仓数量 */
    private String bal;
    
    /** 持仓ID */
    private String posId;
    
    /** 持仓创建时间 */
    private String cTime;
    
    /** 持仓更新时间 */
    private String uTime;
    
    /** 开仓均价 */
    private String openAvgPx;
    
    /** 平仓均价 */
    private String closeAvgPx;
    
    /** 已实现收益 */
    private String pnl;
    
    /** 已实现收益率 */
    private String pnlRatio;
    
    /** 杠杆倍数 */
    private String lever;
    
    /** 触发平仓的类型 */
    private String triggerPx;
}