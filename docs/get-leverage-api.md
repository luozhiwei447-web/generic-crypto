# 获取杠杆倍数API使用说明

## 接口描述

获取杠杆倍数接口用于查询指定产品在不同保证金模式下的当前杠杆倍数设置。

## 接口信息

- **接口路径**: `/api/v5/account/leverage-info`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `instId`: 产品ID（必填），如BTC-USD-SWAP
- `mgnMode`: 保证金模式（必填）
  - `isolated`: 逐仓模式
  - `cross`: 全仓模式

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询BTC永续合约逐仓模式杠杆倍数
public void getLeverageIsolated() {
    GetLeverageRequest request = new GetLeverageRequest()
        .setInstId("BTC-USD-SWAP")
        .setMgnMode(MarginMode.ISOLATED.getValue());
    
    List<LeverageInfo> result = tradingAccountApi.getLeverage(request);
    // 处理返回结果
}

// 查询BTC永续合约全仓模式杠杆倍数
public void getLeverageCross() {
    GetLeverageRequest request = new GetLeverageRequest()
        .setInstId("BTC-USD-SWAP")
        .setMgnMode(MarginMode.CROSS.getValue());
    
    List<LeverageInfo> result = tradingAccountApi.getLeverage(request);
    // 处理返回结果
}

// 查询ETH永续合约逐仓模式杠杆倍数
public void getEthLeverage() {
    GetLeverageRequest request = new GetLeverageRequest()
        .setInstId("ETH-USD-SWAP")
        .setMgnMode(MarginMode.ISOLATED.getValue());
    
    List<LeverageInfo> result = tradingAccountApi.getLeverage(request);
    // 处理返回结果
}
```

## 返回字段说明

- `instId`: 产品ID
- `lever`: 杠杆倍数
- `mgnMode`: 保证金模式
- `posSide`: 持仓方向

## 注意事项

1. 逐仓模式下，多空两个方向可能有不同的杠杆倍数设置
2. 全仓模式下，通常只有一个杠杆倍数设置
3. 不同产品支持的最大杠杆倍数不同
4. 杠杆倍数设置会影响开仓所需的保证金和强平价格
5. 查询结果会返回当前有效的杠杆倍数配置

## 应用场景

- 交易前确认当前杠杆倍数设置
- 风险管理和仓位计算
- 交易策略中的杠杆倍数验证
- 账户配置信息的获取和展示