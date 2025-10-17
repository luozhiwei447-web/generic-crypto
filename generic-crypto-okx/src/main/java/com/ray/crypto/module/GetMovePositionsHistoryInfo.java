package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX获取移动持仓历史响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GetMovePositionsHistoryInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 子账户名称 */
    private String subAcct;
    
    /** 移动数量 */
    private String sz;
    
    /** 移动方向 */
    private String type;
    
    /** 移动时间 */
    private String ts;
}