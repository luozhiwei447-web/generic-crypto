package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX持仓构建器图表信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PositionBuildGraphInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 持仓方向 */
    private String posSide;
    
    /** 持仓数量 */
    private String sz;
    
    /** 价格 */
    private String px;
    
    /** 未实现盈亏 */
    private String upl;
    
    /** 未实现盈亏率 */
    private String uplRatio;
}