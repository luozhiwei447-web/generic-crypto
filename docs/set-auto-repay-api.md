# 设置自动还币API使用说明

## 接口描述

设置自动还币接口用于开启或关闭自动还币功能，当开启后系统会在有足够余额时自动还币以减少利息支出。

## 接口信息

- **接口路径**: `/api/v5/account/set-auto-repay`
- **请求方法**: POST
- **权限要求**: 需要交易权限

## 参数说明

- `autoRepay`: 自动还币开关（必填）
  - `true`: 开启自动还币
  - `false`: 关闭自动还币

## 自动还币功能说明

### 开启自动还币 (autoRepay = true)
- 系统会自动监控账户余额
- 当有足够余额时自动还币
- 优先还利率较高的币种
- 减少利息支出，优化资金成本

### 关闭自动还币 (autoRepay = false)
- 需要手动进行还币操作
- 用户完全控制还币时机
- 适合有特定还币策略的用户

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 开启自动还币
public void enableAutoRepay() {
    SetAutoRepayRequest request = new SetAutoRepayRequest()
        .setAutoRepay(true);
    
    List<SetAutoRepayInfo> result = tradingAccountApi.setAutoRepay(request);
    
    if (!result.isEmpty()) {
        SetAutoRepayInfo info = result.get(0);
        if ("true".equals(info.getAutoRepay())) {
            System.out.println("自动还币功能已开启");
        }
    }
}

// 关闭自动还币
public void disableAutoRepay() {
    SetAutoRepayRequest request = new SetAutoRepayRequest()
        .setAutoRepay(false);
    
    List<SetAutoRepayInfo> result = tradingAccountApi.setAutoRepay(request);
    
    if (!result.isEmpty()) {
        SetAutoRepayInfo info = result.get(0);
        if ("false".equals(info.getAutoRepay())) {
            System.out.println("自动还币功能已关闭");
        }
    }
}

// 智能自动还币管理
public void smartAutoRepayManagement() {
    // 根据策略决定是否开启自动还币
    boolean shouldEnableAutoRepay = evaluateAutoRepayStrategy();
    
    SetAutoRepayRequest request = new SetAutoRepayRequest()
        .setAutoRepay(shouldEnableAutoRepay);
    
    List<SetAutoRepayInfo> result = tradingAccountApi.setAutoRepay(request);
    
    if (!result.isEmpty()) {
        String status = shouldEnableAutoRepay ? "开启" : "关闭";
        System.out.println("自动还币功能已" + status);
    }
}

private boolean evaluateAutoRepayStrategy() {
    // 评估策略逻辑
    // 1. 检查当前借币情况
    // 2. 分析利率水平
    // 3. 考虑交易策略需求
    // 4. 返回是否应该开启自动还币
    return true; // 示例返回值
}

// 条件性设置自动还币
public void conditionalAutoRepay() {
    try {
        // 先查询当前借币状态
        // 根据借币情况决定是否开启自动还币
        
        SetAutoRepayRequest request = new SetAutoRepayRequest()
            .setAutoRepay(true);
        
        List<SetAutoRepayInfo> result = tradingAccountApi.setAutoRepay(request);
        
        if (!result.isEmpty()) {
            System.out.println("自动还币设置成功");
        }
    } catch (Exception e) {
        System.err.println("设置自动还币失败: " + e.getMessage());
        // 处理异常情况
    }
}
```

## 返回字段说明

- `autoRepay`: 设置后的自动还币状态
  - `"true"`: 自动还币已开启
  - `"false"`: 自动还币已关闭

## 自动还币机制

### 触发条件
- 账户有足够的币种余额
- 存在对应币种的借币负债
- 自动还币功能已开启

### 还币优先级
1. 优先还利率较高的币种
2. 优先还即将到期的借币
3. 按照系统算法优化还币顺序

### 还币数量
- 系统会根据余额情况自动计算还币数量
- 保留必要的交易余额
- 避免影响正常交易

## 注意事项

1. 自动还币功能全局生效，影响所有币种
2. 开启后系统会实时监控并执行自动还币
3. 自动还币可能会影响交易策略的执行
4. 建议根据实际需求合理设置
5. 可以随时开启或关闭该功能

## 应用场景

- 长期持有策略中的成本优化
- 减少借币利息支出
- 自动化资金管理
- 风险管理中的负债控制
- 简化借币还币操作

## 相关接口

- [手动借币还币API](borrow-repay-api.md) - 手动控制借币还币
- [获取借币利息和限额API](borrow-interest-limit-api.md) - 查看借币成本
- [获取计息记录API](interest-accrued-api.md) - 查看利息支出

## 最佳实践

1. **策略考虑**
   - 评估交易策略对资金的需求
   - 考虑市场波动对资金的影响
   - 平衡成本优化和交易灵活性

2. **监控管理**
   - 定期检查自动还币效果
   - 监控利息支出变化
   - 根据需要调整设置

3. **风险控制**
   - 确保有足够的交易资金
   - 避免过度自动还币影响交易
   - 保持合理的资金缓冲

## 成本效益分析

开启自动还币的优势：
- 自动减少利息支出
- 优化资金使用效率
- 减少手动操作负担

可能的影响：
- 可能影响交易资金的灵活性
- 需要保持足够的余额用于交易
- 可能不适合高频交易策略