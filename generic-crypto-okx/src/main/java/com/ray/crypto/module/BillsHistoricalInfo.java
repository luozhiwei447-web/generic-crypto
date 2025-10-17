package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX历史账单流水信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class BillsHistoricalInfo {
    
    /** 申请ID */
    private String applyId;
    
    /** 申请状态 */
    private String state;
    
    /** 文件下载链接 */
    private String fileHref;
    
    /** 申请时间 */
    private String ts;
}