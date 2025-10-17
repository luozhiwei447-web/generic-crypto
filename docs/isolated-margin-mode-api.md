# 逐仓杠杆交易设置API使用说明

## 接口描述

逐仓杠杆交易设置接口用于配置指定产品的逐仓保证金模式，支持自动借币和自主借币两种模式。

## 接口信息

- **接口路径**: `/api/v5/account/isolated-margin-mode`
- **请求方法**: POST
- **权限要求**: 需要交易权限

## 参数说明

- `instId`: 产品ID（必填），如BTC-USDT
- `isoMode`: 逐仓保证金模式（必填）
  - `automatic`: 自动借币
  - `autonomy`: 自主借币

## 逐仓保证金模式说明

### 自动借币 (automatic)
- 系统自动根据交易需求借币
- 无需手动管理借币操作
- 适合频繁交易的用户
- 借币利率按市场实时利率计算

### 自主借币 (autonomy)
- 用户手动控制借币操作
- 需要主动借币才能进行杠杆交易
- 适合精确控制借币成本的用户
- 可以选择合适的时机借币

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 设置BTC-USDT为自动借币模式
public void setAutomaticMode() {
    IsolatedMarginModeRequest request = new IsolatedMarginModeRequest()
        .setInstId("BTC-USDT")
        .setIsoMode(IsolatedMarginMode.AUTOMATIC.getValue());
    
    List<IsolatedMarginModeInfo> result = tradingAccountApi.setIsolatedMarginMode(request);
    // 处理返回结果
}

// 设置ETH-USDT为自主借币模式
public void setAutonomyMode() {
    IsolatedMarginModeRequest request = new IsolatedMarginModeRequest()
        .setInstId("ETH-USDT")
        .setIsoMode(IsolatedMarginMode.AUTONOMY.getValue());
    
    List<IsolatedMarginModeInfo> result = tradingAccountApi.setIsolatedMarginMode(request);
    // 处理返回结果
}

// 批量设置多个产品的借币模式
public void setBatchIsolatedMarginMode() {
    // 设置BTC-USDT为自动借币
    IsolatedMarginModeRequest btcRequest = new IsolatedMarginModeRequest()
        .setInstId("BTC-USDT")
        .setIsoMode(IsolatedMarginMode.AUTOMATIC.getValue());
    tradingAccountApi.setIsolatedMarginMode(btcRequest);
    
    // 设置ETH-USDT为自主借币
    IsolatedMarginModeRequest ethRequest = new IsolatedMarginModeRequest()
        .setInstId("ETH-USDT")
        .setIsoMode(IsolatedMarginMode.AUTONOMY.getValue());
    tradingAccountApi.setIsolatedMarginMode(ethRequest);
}
```

## 返回字段说明

- `instId`: 产品ID
- `isoMode`: 设置后的逐仓保证金模式

## 注意事项

1. 设置生效后，该产品的杠杆交易将按照新的借币模式执行
2. 自动借币模式下，系统会根据交易需求自动借币和还币
3. 自主借币模式下，需要手动借币才能进行杠杆交易
4. 切换模式前建议先了解当前的借币状态和利率情况
5. 不同模式下的风险管理策略可能需要相应调整

## 应用场景

- 根据交易策略选择合适的借币模式
- 精确控制借币成本和时机
- 优化杠杆交易的资金使用效率
- 风险管理中的借币策略配置

## 相关接口

- [获取产品最大可借API](max-loan-api.md) - 查看可借额度
- [获取利率API](interest-rate-api.md) - 查看当前借币利率
- [获取计息记录API](interest-accrued-api.md) - 查看借币成本记录