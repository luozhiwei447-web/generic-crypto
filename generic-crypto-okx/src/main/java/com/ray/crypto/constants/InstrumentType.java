package com.ray.crypto.constants;

/**
 * 产品类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum InstrumentType {
    
    /** 币币 */
    SPOT,
    
    /** 币币杠杆 */
    MARGIN,
    
    /** 永续合约 */
    SWAP,
    
    /** 交割合约 */
    FUTURES,
    
    /** 期权 */
    OPTION
}