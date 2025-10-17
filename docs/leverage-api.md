# 设置杠杆倍数API使用说明

## 接口描述

设置杠杆倍数接口用于调整指定产品的杠杆倍数，支持逐仓和全仓两种保证金模式。

## 接口信息

- **接口路径**: `/api/v5/account/set-leverage`
- **请求方法**: POST
- **权限要求**: 需要交易权限

## 参数说明

- `instId`: 产品ID，如BTC-USD-SWAP
- `lever`: 杠杆倍数
- `mgnMode`: 保证金模式（isolated/cross）
- `posSide`: 持仓方向（long/short/net）
- `ccy`: 保证金币种（仅适用于跨币种保证金模式的全仓杠杆订单）

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 设置BTC永续合约10倍杠杆（逐仓模式，多头方向）
public void setLeverageIsolated() {
    LeverageRequest request = new LeverageRequest()
        .setInstId("BTC-USD-SWAP")
        .setLever("10")
        .setMgnMode(MarginMode.ISOLATED.getValue())
        .setPosSide(PositionSide.LONG.getValue());
    
    List<LeverageInfo> result = tradingAccountApi.setLeverage(request);
    // 处理返回结果
}

// 设置BTC永续合约20倍杠杆（全仓模式，净持仓）
public void setLeverageCross() {
    LeverageRequest request = new LeverageRequest()
        .setInstId("BTC-USD-SWAP")
        .setLever("20")
        .setMgnMode(MarginMode.CROSS.getValue())
        .setPosSide(PositionSide.NET.getValue());
    
    List<LeverageInfo> result = tradingAccountApi.setLeverage(request);
    // 处理返回结果
}
```

## 注意事项

1. 设置杠杆倍数前需要确保没有该产品的持仓和挂单
2. 不同产品支持的最大杠杆倍数不同
3. 逐仓模式下需要指定具体的持仓方向（long/short）
4. 全仓模式下通常使用net持仓方向