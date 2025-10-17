# 设置持仓模式API使用说明

## 接口描述

设置持仓模式接口用于切换账户的持仓模式，支持单向持仓和双向持仓两种模式。

## 接口信息

- **接口路径**: `/api/v5/account/set-position-mode`
- **请求方法**: POST
- **权限要求**: 需要交易权限

## 持仓模式说明

- `net_mode`: 单向持仓模式，同一产品只能有一个方向的持仓
- `long_short_mode`: 双向持仓模式，同一产品可以同时持有多空两个方向的持仓

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 设置为单向持仓模式
public void setNetMode() {
    PositionModeRequest request = new PositionModeRequest()
        .setPosMode(PositionMode.NET_MODE.getValue());
    
    List<PositionModeInfo> result = tradingAccountApi.setPositionMode(request);
    // 处理返回结果
}

// 设置为双向持仓模式
public void setLongShortMode() {
    PositionModeRequest request = new PositionModeRequest()
        .setPosMode(PositionMode.LONG_SHORT_MODE.getValue());
    
    List<PositionModeInfo> result = tradingAccountApi.setPositionMode(request);
    // 处理返回结果
}
```

## 注意事项

1. 切换持仓模式前需要确保账户没有持仓和挂单
2. 切换持仓模式可能需要一定的处理时间
3. 建议在非交易时间进行持仓模式切换