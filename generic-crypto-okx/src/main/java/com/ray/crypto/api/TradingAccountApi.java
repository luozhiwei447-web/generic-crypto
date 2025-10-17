package com.ray.crypto.api;

import com.ray.crypto.decoder.OkxResponseDecoder;
import com.ray.crypto.interceptor.OkxFeignRequestInterceptor;
import com.ray.crypto.module.AccountRiskInfo;
import com.ray.crypto.module.AccountRiskRequest;
import com.ray.crypto.module.ActivateOptionInfo;
import com.ray.crypto.module.ActivateOptionRequest;
import com.ray.crypto.module.ApplyBillsInfo;
import com.ray.crypto.module.ApplyBillsRequest;
import com.ray.crypto.module.AccountConfigInfo;
import com.ray.crypto.module.BillsHistoricalInfo;
import com.ray.crypto.module.GetBillsHistoricalRequest;
import com.ray.crypto.module.GetLeverageRequest;
import com.ray.crypto.module.LeverageEstimatedInfo;
import com.ray.crypto.module.LeverageEstimatedRequest;
import com.ray.crypto.module.LeverageInfo;
import com.ray.crypto.module.LeverageRequest;
import com.ray.crypto.module.MaxLoanInfo;
import com.ray.crypto.module.MaxLoanRequest;
import com.ray.crypto.module.MarginBalanceInfo;
import com.ray.crypto.module.MarginBalanceRequest;
import com.ray.crypto.module.MovePositionsInfo;
import com.ray.crypto.module.MovePositionsRequest;
import com.ray.crypto.module.MaxAvailSizeInfo;
import com.ray.crypto.module.MaxAvailSizeRequest;
import com.ray.crypto.module.MaxSizeInfo;
import com.ray.crypto.module.MaxSizeRequest;
import com.ray.crypto.module.BalanceInfo;
import com.ray.crypto.module.BalanceRequest;
import com.ray.crypto.module.BillsInfo;
import com.ray.crypto.module.BillsRequest;
import com.ray.crypto.module.InstrumentInfo;
import com.ray.crypto.module.InstrumentRequest;
import com.ray.crypto.module.PositionHistoryInfo;
import com.ray.crypto.module.PositionHistoryRequest;
import com.ray.crypto.module.PositionInfo;
import com.ray.crypto.module.FeeRateInfo;
import com.ray.crypto.module.FeeRateRequest;
import com.ray.crypto.module.InterestAccruedInfo;
import com.ray.crypto.module.InterestAccruedRequest;
import com.ray.crypto.module.BorrowRepayHistoryInfo;
import com.ray.crypto.module.BorrowRepayHistoryRequest;
import com.ray.crypto.module.BorrowRepayInfo;
import com.ray.crypto.module.BorrowRepayRequest;
import com.ray.crypto.module.GreeksInfo;
import com.ray.crypto.module.GreeksRequest;
import com.ray.crypto.module.InterestRateInfo;
import com.ray.crypto.module.InterestRateRequest;
import com.ray.crypto.module.SetFeeTypeInfo;
import com.ray.crypto.module.SetFeeTypeRequest;
import com.ray.crypto.module.SetGreeksInfo;
import com.ray.crypto.module.SetGreeksRequest;
import com.ray.crypto.module.IsolatedMarginModeInfo;
import com.ray.crypto.module.IsolatedMarginModeRequest;
import com.ray.crypto.module.MaxWithdrawalInfo;
import com.ray.crypto.module.MaxWithdrawalRequest;
import com.ray.crypto.module.RiskStateInfo;
import com.ray.crypto.module.VipInterestRateInfo;
import com.ray.crypto.module.VipInterestRateRequest;
import com.ray.crypto.module.BorrowInterestLimitInfo;
import com.ray.crypto.module.BorrowInterestLimitRequest;
import com.ray.crypto.module.SetAutoEarnInfo;
import com.ray.crypto.module.SetAutoEarnRequest;
import com.ray.crypto.module.SetAutoLoanInfo;
import com.ray.crypto.module.SetAutoLoanRequest;
import com.ray.crypto.module.SetAutoRepayInfo;
import com.ray.crypto.module.SetAutoRepayRequest;
import com.ray.crypto.module.PositionBuilderInfo;
import com.ray.crypto.module.PositionBuilderRequest;
import com.ray.crypto.module.PositionBuildGraphInfo;
import com.ray.crypto.module.PositionBuildGraphRequest;
import com.ray.crypto.module.PositionModeInfo;
import com.ray.crypto.module.PositionModeRequest;
import com.ray.crypto.module.PositionRequest;
import com.ray.crypto.module.PmPositionLimitationInfo;
import com.ray.crypto.module.PmPositionLimitationRequest;
import com.ray.crypto.module.PrecheckAccountModeSwitchInfo;
import com.ray.crypto.module.PrecheckAccountModeSwitchRequest;
import com.ray.crypto.module.PresetAccountModeSwitchInfo;
import com.ray.crypto.module.PresetAccountModeSwitchRequest;
import com.ray.crypto.module.ResetMmpStatusInfo;
import com.ray.crypto.module.ResetMmpStatusRequest;
import com.ray.crypto.module.SetAccountModeInfo;
import com.ray.crypto.module.SetAccountModeRequest;
import com.ray.crypto.module.GetCollateralAssetsInfo;
import com.ray.crypto.module.GetCollateralAssetsRequest;
import com.ray.crypto.module.GetMmpConfigInfo;
import com.ray.crypto.module.GetMmpConfigRequest;
import com.ray.crypto.module.GetMovePositionsHistoryInfo;
import com.ray.crypto.module.GetMovePositionsHistoryRequest;
import com.ray.crypto.module.SetCollateralAssetsInfo;
import com.ray.crypto.module.SetCollateralAssetsRequest;
import com.ray.crypto.module.SetMmpInfo;
import com.ray.crypto.module.SetMmpRequest;
import com.ray.crypto.module.SetRiskOffsetAmountInfo;
import com.ray.crypto.module.SetRiskOffsetAmountRequest;
import com.ray.crypto.module.SetSettleCurrencyInfo;
import com.ray.crypto.module.SetSettleCurrencyRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * OKX基础信息API
 * 
 * @author ray
 * @date 2024-01-01
 */
@ConditionalOnProperty("crypto.okx.web-url")
@FeignClient(name = "TradingAccountApi", url = "${crypto.okx.web-url}", configuration = {OkxFeignRequestInterceptor.class, OkxResponseDecoder.class})
public interface TradingAccountApi {

    /**
     * 获取交易产品基础信息
     * @param request
     * @return
     */
    @GetMapping("/api/v5/public/instruments")
    List<InstrumentInfo> instruments(@SpringQueryMap InstrumentRequest request);

    /**
     * 获取账户余额
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/balance")
    List<BalanceInfo> balance(@SpringQueryMap BalanceRequest request);

    /**
     * 获取持仓信息
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/positions")
    List<PositionInfo> positions(@SpringQueryMap PositionRequest request);

    /**
     * 获取持仓历史
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/positions-history")
    List<PositionHistoryInfo> positionsHistory(@SpringQueryMap PositionHistoryRequest request);

    /**
     * 获取账户和持仓风险
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/account-position-risk")
    List<AccountRiskInfo> accountPositionRisk(@SpringQueryMap AccountRiskRequest request);

    /**
     * 获取账单流水（近7天）
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/bills")
    List<BillsInfo> bills(@SpringQueryMap BillsRequest request);

    /**
     * 获取账单流水（近3个月）
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/bills-archive")
    List<BillsInfo> billsArchive(@SpringQueryMap BillsRequest request);

    /**
     * 申请账单流水（2021年至今）
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/apply-bills-historical")
    List<ApplyBillsInfo> applyBillsHistorical(@RequestBody ApplyBillsRequest request);

    /**
     * 获取历史账单流水（2021年至今）
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/get-bills-historical")
    List<BillsHistoricalInfo> getBillsHistorical(@SpringQueryMap GetBillsHistoricalRequest request);

    /**
     * 获取账户配置
     * @return
     */
    @GetMapping("/api/v5/account/config")
    List<AccountConfigInfo> accountConfig();

    /**
     * 设置持仓模式
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-position-mode")
    List<PositionModeInfo> setPositionMode(@RequestBody PositionModeRequest request);

    /**
     * 设置杠杆倍数
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-leverage")
    List<LeverageInfo> setLeverage(@RequestBody LeverageRequest request);

    /**
     * 获取最大订单数量
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/max-size")
    List<MaxSizeInfo> maxSize(@SpringQueryMap MaxSizeRequest request);

    /**
     * 获取最大可用余额
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/max-avail-size")
    List<MaxAvailSizeInfo> maxAvailSize(@SpringQueryMap MaxAvailSizeRequest request);

    /**
     * 增加/减少保证金
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/position/margin-balance")
    List<MarginBalanceInfo> marginBalance(@RequestBody MarginBalanceRequest request);

    /**
     * 获取杠杆倍数
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/leverage-info")
    List<LeverageInfo> getLeverage(@SpringQueryMap GetLeverageRequest request);

    /**
     * 获取杠杆预估信息
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/adjust-leverage-info")
    List<LeverageEstimatedInfo> getLeverageEstimated(@SpringQueryMap LeverageEstimatedRequest request);

    /**
     * 获取产品最大可借
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/max-loan")
    List<MaxLoanInfo> getMaxLoan(@SpringQueryMap MaxLoanRequest request);

    /**
     * 获取费率
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/trade-fee")
    List<FeeRateInfo> getTradeFee(@SpringQueryMap FeeRateRequest request);

    /**
     * 获取计息记录
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/interest-accrued")
    List<InterestAccruedInfo> getInterestAccrued(@SpringQueryMap InterestAccruedRequest request);

    /**
     * 获取利率
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/interest-rate")
    List<InterestRateInfo> getInterestRate(@SpringQueryMap InterestRateRequest request);

    /**
     * 设置手续费抵扣类型
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-fee-type")
    List<SetFeeTypeInfo> setFeeType(@RequestBody SetFeeTypeRequest request);

    /**
     * 设置Greeks展示类型
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-greeks")
    List<SetGreeksInfo> setGreeks(@RequestBody SetGreeksRequest request);

    /**
     * 逐仓杠杆交易设置
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/isolated-margin-mode")
    List<IsolatedMarginModeInfo> setIsolatedMarginMode(@RequestBody IsolatedMarginModeRequest request);

    /**
     * 获取最大可提币量
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/max-withdrawal")
    List<MaxWithdrawalInfo> getMaxWithdrawal(@SpringQueryMap MaxWithdrawalRequest request);

    /**
     * 获取账户风险状态
     * @return
     */
    @GetMapping("/api/v5/account/risk-state")
    List<RiskStateInfo> getRiskState();

    /**
     * 获取借币利息和限额
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/interest-limits")
    List<BorrowInterestLimitInfo> getBorrowInterestLimit(@SpringQueryMap BorrowInterestLimitRequest request);

    /**
     * 手动借币还币
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/borrow-repay")
    List<BorrowRepayInfo> borrowRepay(@RequestBody BorrowRepayRequest request);

    /**
     * 设置自动还币
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-auto-repay")
    List<SetAutoRepayInfo> setAutoRepay(@RequestBody SetAutoRepayRequest request);

    /**
     * 获取借币还币历史
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/borrow-repay-history")
    List<BorrowRepayHistoryInfo> getBorrowRepayHistory(@SpringQueryMap BorrowRepayHistoryRequest request);

    /**
     * 持仓构建器
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/position-builder")
    List<PositionBuilderInfo> positionBuilder(@RequestBody PositionBuilderRequest request);

    /**
     * 查询持仓构建器图表
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/position-builder-graph")
    List<PositionBuildGraphInfo> queryPositionBuildGraph(@SpringQueryMap PositionBuildGraphRequest request);

    /**
     * 设置现货对冲占用
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-risk-offset-amount")
    List<SetRiskOffsetAmountInfo> setRiskOffsetAmount(@RequestBody SetRiskOffsetAmountRequest request);

    /**
     * 查看账户Greeks
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/greeks")
    List<GreeksInfo> getGreeks(@SpringQueryMap GreeksRequest request);

    /**
     * 获取组合保证金模式仓位限制
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/position-tiers")
    List<PmPositionLimitationInfo> getPmPositionLimitation(@SpringQueryMap PmPositionLimitationRequest request);

    /**
     * 激活期权
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/activate-option")
    List<ActivateOptionInfo> activateOption(@RequestBody ActivateOptionRequest request);

    /**
     * 设置自动借币
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-auto-loan")
    List<SetAutoLoanInfo> setAutoLoan(@RequestBody SetAutoLoanRequest request);

    /**
     * 预设账户模式切换
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/account-level-switch-preset")
    List<PresetAccountModeSwitchInfo> presetAccountModeSwitch(@RequestBody PresetAccountModeSwitchRequest request);

    /**
     * 预检查账户模式切换
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/precheck-account-level")
    List<PrecheckAccountModeSwitchInfo> precheckAccountModeSwitch(@RequestBody PrecheckAccountModeSwitchRequest request);

    /**
     * 设置账户模式
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-account-level")
    List<SetAccountModeInfo> setAccountMode(@RequestBody SetAccountModeRequest request);

    /**
     * 设置质押币种
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-collateral-assets")
    List<SetCollateralAssetsInfo> setCollateralAssets(@RequestBody SetCollateralAssetsRequest request);

    /**
     * 获取质押币种
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/collateral-assets")
    List<GetCollateralAssetsInfo> getCollateralAssets(@SpringQueryMap GetCollateralAssetsRequest request);

    /**
     * 重置MMP状态
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/mmp-reset")
    List<ResetMmpStatusInfo> resetMmpStatus(@RequestBody ResetMmpStatusRequest request);

    /**
     * 设置MMP
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/mmp-config")
    List<SetMmpInfo> setMmp(@RequestBody SetMmpRequest request);

    /**
     * 获取MMP配置
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/mmp-config")
    List<GetMmpConfigInfo> getMmpConfig(@SpringQueryMap GetMmpConfigRequest request);

    /**
     * 移动持仓
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/move-position")
    List<MovePositionsInfo> movePositions(@RequestBody MovePositionsRequest request);

    /**
     * 获取移动持仓历史
     * @param request
     * @return
     */
    @GetMapping("/api/v5/account/move-position-history")
    List<GetMovePositionsHistoryInfo> getMovePositionsHistory(@SpringQueryMap GetMovePositionsHistoryRequest request);

    /**
     * 设置自动赚币
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-auto-earn")
    List<SetAutoEarnInfo> setAutoEarn(@RequestBody SetAutoEarnRequest request);

    /**
     * 设置结算币种
     * @param request
     * @return
     */
    @PostMapping("/api/v5/account/set-settle-currency")
    List<SetSettleCurrencyInfo> setSettleCurrency(@RequestBody SetSettleCurrencyRequest request);
}
