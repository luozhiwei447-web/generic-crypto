# 获取最大可用余额API使用说明

## 接口描述

获取最大可用余额接口用于查询指定产品在当前账户状态下的最大可用买卖余额。

## 接口信息

- **接口路径**: `/api/v5/account/max-avail-size`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `instId`: 产品ID（必填），如BTC-USDT
- `tdMode`: 交易模式（必填）
  - `cash`: 现金模式
  - `isolated`: 逐仓模式
  - `cross`: 全仓模式
- `ccy`: 保证金币种（可选），仅适用于单币种保证金模式下的全仓杂交易
- `reduceOnly`: 是否仅减仓（可选），默认false
- `unSpotOffset`: 是否不自动借币（可选），默认false
- `quickMgnType`: 是否使用快速保证金模式（可选），默认false

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询BTC-USDT现货最大可用余额
public void getMaxAvailSizeSpot() {
    MaxAvailSizeRequest request = new MaxAvailSizeRequest()
        .setInstId("BTC-USDT")
        .setTdMode(TradeMode.CASH.getValue());
    
    List<MaxAvailSizeInfo> result = tradingAccountApi.maxAvailSize(request);
    // 处理返回结果
}

// 查询BTC永续合约最大可用余额（逐仓模式）
public void getMaxAvailSizeSwapIsolated() {
    MaxAvailSizeRequest request = new MaxAvailSizeRequest()
        .setInstId("BTC-USD-SWAP")
        .setTdMode(TradeMode.ISOLATED.getValue())
        .setReduceOnly(false);
    
    List<MaxAvailSizeInfo> result = tradingAccountApi.maxAvailSize(request);
    // 处理返回结果
}

// 查询BTC永续合约最大可用余额（全仓模式，仅减仓）
public void getMaxAvailSizeSwapCrossReduceOnly() {
    MaxAvailSizeRequest request = new MaxAvailSizeRequest()
        .setInstId("BTC-USD-SWAP")
        .setTdMode(TradeMode.CROSS.getValue())
        .setCcy("USDT")
        .setReduceOnly(true);
    
    List<MaxAvailSizeInfo> result = tradingAccountApi.maxAvailSize(request);
    // 处理返回结果
}

// 查询现货最大可用余额（不自动借币）
public void getMaxAvailSizeSpotNoOffset() {
    MaxAvailSizeRequest request = new MaxAvailSizeRequest()
        .setInstId("BTC-USDT")
        .setTdMode(TradeMode.CASH.getValue())
        .setUnSpotOffset(true);
    
    List<MaxAvailSizeInfo> result = tradingAccountApi.maxAvailSize(request);
    // 处理返回结果
}
```

## 返回字段说明

- `instId`: 产品ID
- `availBuy`: 最大可买可用余额
- `availSell`: 最大可卖可用余额

## 注意事项

1. 最大可用余额会根据账户余额、持仓情况、风险度等因素动态变化
2. `reduceOnly=true`时，只能减少现有持仓，不能增加持仓
3. `unSpotOffset=true`时，现货交易不会自动借币
4. 全仓模式下可能需要指定保证金币种
5. 快速保证金模式适用于特定的交易场景