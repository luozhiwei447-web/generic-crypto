# 获取账户风险状态API使用说明

## 接口描述

获取账户风险状态接口用于查询当前账户的风险状态，包括衍生品账户和保证金账户的风险情况。

## 接口信息

- **接口路径**: `/api/v5/account/risk-state`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

该接口无需参数，直接调用即可获取当前账户的风险状态。

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 获取账户风险状态
public void getAccountRiskState() {
    List<RiskStateInfo> result = tradingAccountApi.getRiskState();
    
    for (RiskStateInfo riskState : result) {
        if ("true".equals(riskState.getAtRisk())) {
            System.out.println("账户处于风险状态，请注意风险管理！");
            // 处理风险状态逻辑
        } else {
            System.out.println("账户状态正常");
        }
    }
}

// 监控账户风险状态
public void monitorRiskState() {
    List<RiskStateInfo> result = tradingAccountApi.getRiskState();
    
    if (!result.isEmpty()) {
        RiskStateInfo riskState = result.get(0);
        
        // 检查整体风险状态
        boolean isAtRisk = "true".equals(riskState.getAtRisk());
        
        if (isAtRisk) {
            // 风险状态处理逻辑
            handleRiskState(riskState);
        }
        
        // 记录风险状态时间
        String derivativeRiskTime = riskState.getAtRiskIdx();
        String marginRiskTime = riskState.getAtRiskMgn();
        
        System.out.println("衍生品账户风险状态时间: " + derivativeRiskTime);
        System.out.println("保证金账户风险状态时间: " + marginRiskTime);
    }
}

private void handleRiskState(RiskStateInfo riskState) {
    // 风险状态处理逻辑
    // 1. 发送风险警报
    // 2. 调整持仓
    // 3. 增加保证金
    // 4. 平仓操作等
    System.out.println("执行风险控制措施...");
}
```

## 返回字段说明

- `atRisk`: 账户风险状态
  - `true`: 账户处于风险状态
  - `false`: 账户状态正常
- `atRiskIdx`: 衍生品账户风险状态时间，Unix时间戳的毫秒数格式
- `atRiskMgn`: 保证金账户风险状态时间，Unix时间戳的毫秒数格式
- `ts`: 数据返回时间，Unix时间戳的毫秒数格式

## 风险状态说明

### 风险状态触发条件
- 账户保证金率过低
- 持仓风险度过高
- 市场波动导致的风险敞口增大
- 借币比例过高

### 风险状态影响
- 可能限制开新仓
- 可能触发强制平仓
- 提币功能可能受限
- 借币功能可能受限

## 注意事项

1. 风险状态是实时计算的，建议定期查询
2. 处于风险状态时应及时采取风险控制措施
3. 不同账户类型的风险状态可能不同
4. 风险状态时间戳可以用于判断风险状态的持续时间
5. 建议结合其他风险指标综合判断账户风险

## 应用场景

- 实时风险监控
- 自动化风险管理
- 风险预警系统
- 交易策略中的风险控制
- 账户健康度评估

## 相关接口

- [获取账户和持仓风险API](account-position-risk-api.md) - 详细风险信息
- [获取账户余额API](balance-api.md) - 账户资金状况
- [获取持仓信息API](positions-api.md) - 持仓风险评估

## 风险管理建议

1. **预防措施**
   - 合理控制杠杆倍数
   - 分散投资降低风险
   - 设置止损止盈

2. **风险状态处理**
   - 及时增加保证金
   - 适当减少持仓
   - 关注市场动态

3. **监控策略**
   - 定期查询风险状态
   - 设置自动化监控
   - 建立风险预警机制