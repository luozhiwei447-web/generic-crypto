package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取移动持仓历史请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class GetMovePositionsHistoryRequest {
    
    /** 产品ID */
    private String instId;
    
    /** 子账户名称 */
    private String subAcct;
    
    /** 移动方向 */
    private String type;
    
    /** 请求此时间戳之前的分页内容 */
    private String before;
    
    /** 请求此时间戳之后的分页内容 */
    private String after;
    
    /** 返回结果的数量 */
    private String limit;
}