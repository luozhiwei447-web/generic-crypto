package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取一键还币历史请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OneClickRepayHistoryRequest {
    /**
     * 请求此时间戳之前的分页内容
     */
    private String after;
    
    /**
     * 请求此时间戳之后的分页内容
     */
    private String before;
    
    /**
     * 返回结果的数量
     */
    private String limit;
}