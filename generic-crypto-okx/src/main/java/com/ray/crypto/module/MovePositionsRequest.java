package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX移动持仓请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class MovePositionsRequest {
    
    /** 子账户名称 */
    private String subAcct;
    
    /** 产品ID */
    private String instId;
    
    /** 移动数量 */
    private String sz;
    
    /** 移动方向 */
    private String type;
}