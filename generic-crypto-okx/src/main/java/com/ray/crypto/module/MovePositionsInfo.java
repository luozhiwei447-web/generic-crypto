package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX移动持仓响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MovePositionsInfo {
    
    /** 子账户名称 */
    private String subAcct;
    
    /** 产品ID */
    private String instId;
    
    /** 移动数量 */
    private String sz;
    
    /** 移动方向 */
    private String type;
    
    /** 移动结果 */
    private String result;
}