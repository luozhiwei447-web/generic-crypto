package com.ray.crypto.module;

import com.ray.crypto.constants.InstrumentType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX交易产品请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class InstrumentRequest {
    
    /** 产品类型 */
    private InstrumentType instType;
    
    /** 交易品种，仅适用于交割/永续/期权，期权必填 */
    private String instFamily;
    
    /** 产品ID */
    private String instId;
}