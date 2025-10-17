# 持仓构建器API使用说明

## 接口描述

持仓构建器接口用于模拟计算在指定价格和数量下开仓的持仓信息，包括保证金、强平价格、盈亏等关键指标。

## 接口信息

- **接口路径**: `/api/v5/account/position-builder`
- **请求方法**: POST
- **权限要求**: 需要读取权限

## 参数说明

- `instId`: 产品ID（必填），如BTC-USD-SWAP
- `posSide`: 持仓方向（必填）
  - `long`: 多头
  - `short`: 空头
  - `net`: 净持仓
- `sz`: 持仓数量（必填）
- `px`: 委托价格（必填）

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 模拟BTC永续合约多头持仓
public void simulateBtcLongPosition() {
    PositionBuilderRequest request = new PositionBuilderRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.LONG.getValue())
        .setSz("1")
        .setPx("50000");
    
    List<PositionBuilderInfo> result = tradingAccountApi.positionBuilder(request);
    
    if (!result.isEmpty()) {
        PositionBuilderInfo info = result.get(0);
        System.out.println("产品: " + info.getInstId());
        System.out.println("持仓方向: " + info.getPosSide());
        System.out.println("持仓数量: " + info.getSz());
        System.out.println("开仓价格: " + info.getPx());
        System.out.println("所需保证金: " + info.getMargin());
        System.out.println("杠杆倍数: " + info.getLever());
        System.out.println("强平价格: " + info.getLiqPx());
        System.out.println("标记价格: " + info.getMarkPx());
        System.out.println("保证金率: " + info.getMgnRatio());
    }
}

// 模拟ETH永续合约空头持仓
public void simulateEthShortPosition() {
    PositionBuilderRequest request = new PositionBuilderRequest()
        .setInstId("ETH-USD-SWAP")
        .setPosSide(PositionSide.SHORT.getValue())
        .setSz("10")
        .setPx("3000");
    
    List<PositionBuilderInfo> result = tradingAccountApi.positionBuilder(request);
    // 处理返回结果
}

// 批量模拟不同价格的持仓情况
public void simulateMultiplePrices() {
    String[] prices = {"45000", "50000", "55000"};
    
    for (String price : prices) {
        PositionBuilderRequest request = new PositionBuilderRequest()
            .setInstId("BTC-USD-SWAP")
            .setPosSide(PositionSide.LONG.getValue())
            .setSz("1")
            .setPx(price);
        
        List<PositionBuilderInfo> result = tradingAccountApi.positionBuilder(request);
        
        if (!result.isEmpty()) {
            PositionBuilderInfo info = result.get(0);
            System.out.println("价格: " + price + 
                ", 保证金: " + info.getMargin() + 
                ", 强平价格: " + info.getLiqPx());
        }
    }
}

// 风险评估分析
public void riskAssessment() {
    PositionBuilderRequest request = new PositionBuilderRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.LONG.getValue())
        .setSz("5")
        .setPx("48000");
    
    List<PositionBuilderInfo> result = tradingAccountApi.positionBuilder(request);
    
    if (!result.isEmpty()) {
        PositionBuilderInfo info = result.get(0);
        
        double openPrice = Double.parseDouble(info.getPx());
        double liqPrice = Double.parseDouble(info.getLiqPx());
        double markPrice = Double.parseDouble(info.getMarkPx());
        double marginRatio = Double.parseDouble(info.getMgnRatio());
        
        // 计算风险指标
        double priceToLiq = Math.abs(markPrice - liqPrice) / markPrice * 100;
        double currentUpl = (markPrice - openPrice) / openPrice * 100;
        
        System.out.println("当前未实现盈亏率: " + String.format("%.2f%%", currentUpl));
        System.out.println("距离强平价格: " + String.format("%.2f%%", priceToLiq));
        System.out.println("保证金率: " + String.format("%.2f%%", marginRatio * 100));
        
        // 风险评级
        if (marginRatio < 0.1) {
            System.out.println("风险等级: 高风险");
        } else if (marginRatio < 0.2) {
            System.out.println("风险等级: 中风险");
        } else {
            System.out.println("风险等级: 低风险");
        }
    }
}

// 最优杠杆计算
public void calculateOptimalLeverage() {
    String instId = "BTC-USD-SWAP";
    String price = "50000";
    String[] sizes = {"0.1", "0.5", "1", "2", "5"};
    
    System.out.println("不同持仓数量的杠杆和风险分析:");
    
    for (String size : sizes) {
        PositionBuilderRequest request = new PositionBuilderRequest()
            .setInstId(instId)
            .setPosSide(PositionSide.LONG.getValue())
            .setSz(size)
            .setPx(price);
        
        List<PositionBuilderInfo> result = tradingAccountApi.positionBuilder(request);
        
        if (!result.isEmpty()) {
            PositionBuilderInfo info = result.get(0);
            System.out.println("数量: " + size + 
                ", 杠杆: " + info.getLever() + "x" +
                ", 保证金: " + info.getMargin() +
                ", 强平价格: " + info.getLiqPx());
        }
    }
}
```

## 返回字段说明

- `instId`: 产品ID
- `posSide`: 持仓方向
- `sz`: 持仓数量
- `px`: 委托价格
- `margin`: 所需保证金
- `lever`: 杠杆倍数
- `upl`: 未实现盈亏
- `uplRatio`: 未实现盈亏率
- `liqPx`: 强平价格
- `markPx`: 标记价格
- `mgnRatio`: 保证金率

## 应用场景

### 1. 开仓前风险评估
- 计算所需保证金
- 评估强平风险
- 分析盈亏潜力

### 2. 策略回测
- 模拟历史价格下的持仓情况
- 评估策略的风险收益比
- 优化仓位管理

### 3. 风险管理
- 计算最大可承受亏损
- 设置合理的止损位
- 评估账户风险敞口

### 4. 教育培训
- 帮助新手理解杠杆交易
- 演示不同参数的影响
- 风险意识培养

## 注意事项

1. 该接口仅用于模拟计算，不会实际开仓
2. 计算结果基于当前市场价格和账户状态
3. 实际开仓时的结果可能因市场变化而有所不同
4. 建议结合实时市场数据进行分析
5. 强平价格会根据市场波动实时调整

## 风险提示

1. **杠杆风险**: 高杠杆放大收益的同时也放大风险
2. **强平风险**: 价格不利变动可能导致强制平仓
3. **市场风险**: 市场剧烈波动可能超出预期
4. **流动性风险**: 极端市场条件下可能无法及时平仓

## 相关接口

- [获取持仓信息API](positions-api.md) - 查看实际持仓
- [获取杠杆倍数API](get-leverage-api.md) - 查看当前杠杆设置
- [获取账户风险状态API](risk-state-api.md) - 监控账户风险

## 最佳实践

1. **充分模拟**: 在实际开仓前进行充分的模拟分析
2. **风险控制**: 根据模拟结果设置合理的止损位
3. **分批建仓**: 考虑分批建仓以降低风险
4. **持续监控**: 开仓后持续监控持仓风险指标