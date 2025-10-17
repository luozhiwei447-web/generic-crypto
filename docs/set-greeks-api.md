# 设置Greeks展示类型API使用说明

## 接口描述

设置Greeks展示类型接口用于配置期权Greeks值的展示方式，支持币本位和美元本位两种展示模式。

## 接口信息

- **接口路径**: `/api/v5/account/set-greeks`
- **请求方法**: POST
- **权限要求**: 需要交易权限

## 参数说明

- `greeksType`: Greeks展示类型（必填）
  - `PA`: 币本位展示
  - `BS`: 美元本位展示

## Greeks展示类型说明

### 币本位 (PA - Price Asset)
- Greeks值以标的资产（如BTC、ETH）为单位展示
- 适合习惯以币本位思考的用户
- 直观反映标的资产价格变化对期权价值的影响

### 美元本位 (BS - Black-Scholes)
- Greeks值以美元为单位展示
- 基于Black-Scholes模型计算
- 便于进行风险管理和对冲计算

## Greeks指标说明

- **Delta**: 标的资产价格变化1单位时，期权价格的变化量
- **Gamma**: 标的资产价格变化1单位时，Delta的变化量
- **Theta**: 时间流逝1天时，期权价格的变化量
- **Vega**: 隐含波动率变化1%时，期权价格的变化量

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 设置为币本位展示
public void setPaGreeksType() {
    SetGreeksRequest request = new SetGreeksRequest()
        .setGreeksType(GreeksType.PA.getValue());
    
    List<SetGreeksInfo> result = tradingAccountApi.setGreeks(request);
    // 处理返回结果
}

// 设置为美元本位展示
public void setBsGreeksType() {
    SetGreeksRequest request = new SetGreeksRequest()
        .setGreeksType(GreeksType.BS.getValue());
    
    List<SetGreeksInfo> result = tradingAccountApi.setGreeks(request);
    // 处理返回结果
}
```

## 返回字段说明

- `greeksType`: 设置后的Greeks展示类型

## 注意事项

1. 设置生效后，后续查询的Greeks值将按照新的展示类型返回
2. 不同展示类型下的Greeks值数值会有差异，但反映的风险特征相同
3. 币本位展示更适合现货交易者，美元本位展示更适合衍生品交易者
4. 设置变更立即生效，影响所有期权产品的Greeks展示
5. 该设置仅影响展示方式，不影响实际的风险计算和交易

## 应用场景

- 期权交易风险管理
- 根据交易习惯选择合适的展示方式
- 期权组合的风险分析
- 对冲策略的制定和执行

## 相关接口

- [获取Greeks信息API](greeks-api.md) - 查看当前Greeks值
- [获取账户配置API](account-config-api.md) - 查看当前Greeks展示设置