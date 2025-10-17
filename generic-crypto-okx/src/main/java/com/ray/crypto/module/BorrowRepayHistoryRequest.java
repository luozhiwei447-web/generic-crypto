package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取借币还币历史请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class BorrowRepayHistoryRequest {
    
    /** 币种，如BTC，不填写表示查询所有币种 */
    private String ccy;
    
    /** 请求此时间戳之后的分页内容，Unix时间戳的毫秒数格式 */
    private String after;
    
    /** 请求此时间戳之前的分页内容，Unix时间戳的毫秒数格式 */
    private String before;
    
    /** 返回结果的数量，最大为100，默认100条 */
    private String limit;
}