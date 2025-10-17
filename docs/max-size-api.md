# 获取最大订单数量API使用说明

## 接口描述

获取最大订单数量接口用于查询指定产品在当前账户状态下的最大可买卖数量。

## 接口信息

- **接口路径**: `/api/v5/account/max-size`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `instId`: 产品ID（必填），如BTC-USDT
- `tdMode`: 交易模式（必填）
  - `cash`: 现金模式
  - `isolated`: 逐仓模式
  - `cross`: 全仓模式
- `ccy`: 保证金币种（可选），仅适用于单币种保证金模式下的全仓杂交易
- `px`: 委托价格（可选），仅适用于币币交易
- `leverage`: 杠杆倍数（可选），仅适用于合约交易
- `unSpotOffset`: 是否不自动借币（可选），默认false

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询BTC-USDT现货最大可买卖数量
public void getMaxSizeSpot() {
    MaxSizeRequest request = new MaxSizeRequest()
        .setInstId("BTC-USDT")
        .setTdMode(TradeMode.CASH.getValue())
        .setPx("50000");
    
    List<MaxSizeInfo> result = tradingAccountApi.maxSize(request);
    // 处理返回结果
}

// 查询BTC永续合约最大可开仓数量（逐仓模式）
public void getMaxSizeSwapIsolated() {
    MaxSizeRequest request = new MaxSizeRequest()
        .setInstId("BTC-USD-SWAP")
        .setTdMode(TradeMode.ISOLATED.getValue())
        .setLeverage("10");
    
    List<MaxSizeInfo> result = tradingAccountApi.maxSize(request);
    // 处理返回结果
}

// 查询BTC永续合约最大可开仓数量（全仓模式）
public void getMaxSizeSwapCross() {
    MaxSizeRequest request = new MaxSizeRequest()
        .setInstId("BTC-USD-SWAP")
        .setTdMode(TradeMode.CROSS.getValue())
        .setCcy("USDT")
        .setLeverage("20");
    
    List<MaxSizeInfo> result = tradingAccountApi.maxSize(request);
    // 处理返回结果
}
```

## 返回字段说明

- `instId`: 产品ID
- `ccy`: 保证金币种
- `maxBuy`: 最大可买数量
- `maxSell`: 最大可卖数量

## 注意事项

1. 最大订单数量会根据账户余额、持仓情况、风险度等因素动态变化
2. 现货交易需要提供委托价格参数
3. 合约交易需要提供杠杆倍数参数
4. 全仓模式下可能需要指定保证金币种