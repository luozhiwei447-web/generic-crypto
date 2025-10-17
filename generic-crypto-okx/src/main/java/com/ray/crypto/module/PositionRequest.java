package com.ray.crypto.module;

import com.ray.crypto.constants.InstrumentType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX持仓信息请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class PositionRequest {
    
    /** 产品类型 */
    private InstrumentType instType;
    
    /** 产品ID */
    private String instId;
    
    /** 持仓ID */
    private String posId;
}