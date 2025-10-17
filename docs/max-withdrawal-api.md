# 获取最大可提币量API使用说明

## 接口描述

获取最大可提币量接口用于查询指定币种或所有币种的最大可提币数量，包括不同模式下的提币限额。

## 接口信息

- **接口路径**: `/api/v5/account/max-withdrawal`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `ccy`: 币种（可选），如BTC，不填写表示查询所有币种

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询所有币种的最大可提币量
public void getAllMaxWithdrawal() {
    MaxWithdrawalRequest request = new MaxWithdrawalRequest();
    
    List<MaxWithdrawalInfo> result = tradingAccountApi.getMaxWithdrawal(request);
    // 处理返回结果
}

// 查询BTC的最大可提币量
public void getBtcMaxWithdrawal() {
    MaxWithdrawalRequest request = new MaxWithdrawalRequest()
        .setCcy("BTC");
    
    List<MaxWithdrawalInfo> result = tradingAccountApi.getMaxWithdrawal(request);
    // 处理返回结果
}

// 查询USDT的最大可提币量
public void getUsdtMaxWithdrawal() {
    MaxWithdrawalRequest request = new MaxWithdrawalRequest()
        .setCcy("USDT");
    
    List<MaxWithdrawalInfo> result = tradingAccountApi.getMaxWithdrawal(request);
    // 处理返回结果
}

// 查询ETH的最大可提币量
public void getEthMaxWithdrawal() {
    MaxWithdrawalRequest request = new MaxWithdrawalRequest()
        .setCcy("ETH");
    
    List<MaxWithdrawalInfo> result = tradingAccountApi.getMaxWithdrawal(request);
    // 处理返回结果
}
```

## 返回字段说明

- `ccy`: 币种
- `maxWd`: 最大可提币量
- `maxWdEx`: 最大可提币量（不借币模式）
- `spotOffsetMaxWd`: 现货对冲最大可提币量
- `spotOffsetMaxWdEx`: 现货对冲最大可提币量（不借币模式）

## 字段详细说明

### maxWd vs maxWdEx
- `maxWd`: 允许借币的情况下的最大可提币量
- `maxWdEx`: 不允许借币的情况下的最大可提币量
- 通常 `maxWd` >= `maxWdEx`

### 现货对冲模式
- `spotOffsetMaxWd`: 开启现货对冲时的最大可提币量
- `spotOffsetMaxWdEx`: 开启现货对冲且不借币时的最大可提币量
- 现货对冲可以增加可提币量，降低风险

## 注意事项

1. 最大可提币量会根据账户余额、持仓情况、风险度等因素动态变化
2. 实际提币时还需要考虑提币手续费和最小提币数量限制
3. 不同提币网络的限额可能不同
4. 借币模式下的可提币量通常更高，但需要承担借币利息
5. 现货对冲模式可以在一定程度上增加可提币量

## 应用场景

- 提币前确认可提币数量
- 资金管理和流动性规划
- 风险管理中的资金调配
- 自动化提币策略的参数设置

## 相关接口

- [获取账户余额API](balance-api.md) - 查看账户余额
- [获取利率API](interest-rate-api.md) - 了解借币成本
- [获取账户配置API](account-config-api.md) - 查看账户设置

## 风险提示

1. 提币操作不可逆，请确认提币地址正确
2. 大额提币可能触发风控审核，导致延迟
3. 借币模式下提币需要考虑利息成本
4. 市场波动可能影响实时可提币量