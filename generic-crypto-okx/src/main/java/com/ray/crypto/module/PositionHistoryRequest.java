package com.ray.crypto.module;

import com.ray.crypto.constants.InstrumentType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX持仓历史请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class PositionHistoryRequest {
    
    /** 产品类型 */
    private InstrumentType instType;
    
    /** 产品ID */
    private String instId;
    
    /** 保证金模式 */
    private String mgnMode;
    
    /** 持仓类型 */
    private String type;
    
    /** 持仓ID */
    private String posId;
    
    /** 请求此ID之前的分页内容 */
    private String after;
    
    /** 请求此ID之后的分页内容 */
    private String before;
    
    /** 返回结果的数量，最大为100，默认100条 */
    private String limit;
}