package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX持仓构建器信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PositionBuilderInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 持仓方向 */
    private String posSide;
    
    /** 持仓数量 */
    private String sz;
    
    /** 委托价格 */
    private String px;
    
    /** 保证金 */
    private String margin;
    
    /** 杠杆倍数 */
    private String lever;
    
    /** 未实现盈亏 */
    private String upl;
    
    /** 未实现盈亏率 */
    private String uplRatio;
    
    /** 强平价格 */
    private String liqPx;
    
    /** 标记价格 */
    private String markPx;
    
    /** 保证金率 */
    private String mgnRatio;
}