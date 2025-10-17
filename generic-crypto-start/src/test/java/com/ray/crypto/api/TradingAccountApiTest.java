package com.ray.crypto.api;

import com.ray.GenericCryptoApplication;
import com.ray.crypto.constants.InstrumentType;
import com.ray.crypto.module.ApplyBillsInfo;
import com.ray.crypto.module.ApplyBillsRequest;
import com.ray.crypto.module.AccountConfigInfo;
import com.ray.crypto.module.BillsHistoricalInfo;
import com.ray.crypto.module.GetBillsHistoricalRequest;
import com.ray.crypto.module.LeverageInfo;
import com.ray.crypto.module.LeverageRequest;
import com.ray.crypto.module.MarginBalanceInfo;
import com.ray.crypto.module.MarginBalanceRequest;
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
import com.ray.crypto.module.PositionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TradingAccountApi集成测试
 * 
 * @author ray
 * @date 2024-01-01
 */
@SpringBootTest(classes = GenericCryptoApplication.class)
@ActiveProfiles("local")
class TradingAccountApiTest {

    @Autowired
    private TradingAccountApi tradingAccountApi;

    @Test
    void testInstrumentsWithSpotType() {
        // Given
        InstrumentRequest request = new InstrumentRequest()
                .setInstType(InstrumentType.SPOT);

        // When
        List<InstrumentInfo> result = tradingAccountApi.instruments(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testBalanceWithoutCurrency() {
        // Given
        BalanceRequest request = new BalanceRequest();

        // When
        List<BalanceInfo> result = tradingAccountApi.balance(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testPositions() {
        // Given
        PositionRequest request = new PositionRequest();

        // When
        List<PositionInfo> result = tradingAccountApi.positions(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testPositionsHistory() {
        // Given
        PositionHistoryRequest request = new PositionHistoryRequest();

        // When
        List<PositionHistoryInfo> result = tradingAccountApi.positionsHistory(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testBills() {
        // Given
        BillsRequest request = new BillsRequest();

        // When
        List<BillsInfo> result = tradingAccountApi.bills(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testBillsArchive() {
        // Given
        BillsRequest request = new BillsRequest();

        // When
        List<BillsInfo> result = tradingAccountApi.billsArchive(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testApplyBillsHistorical() {
        // Given
        ApplyBillsRequest request = new ApplyBillsRequest()
                .setBegin("1609459200000")
                .setEnd("1640995200000");

        // When
        List<ApplyBillsInfo> result = tradingAccountApi.applyBillsHistorical(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testGetBillsHistorical() {
        // Given
        GetBillsHistoricalRequest request = new GetBillsHistoricalRequest()
                .setApplyId("test-apply-id");

        // When
        List<BillsHistoricalInfo> result = tradingAccountApi.getBillsHistorical(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testAccountConfig() {
        // When
        List<AccountConfigInfo> result = tradingAccountApi.accountConfig();

        // Then
        assertNotNull(result);
    }

    @Test
    void testMaxSize() {
        // Given
        MaxSizeRequest request = new MaxSizeRequest()
                .setInstId("BTC-USDT")
                .setTdMode("cash");

        // When
        List<MaxSizeInfo> result = tradingAccountApi.maxSize(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testMaxAvailSize() {
        // Given
        MaxAvailSizeRequest request = new MaxAvailSizeRequest()
                .setInstId("BTC-USDT")
                .setTdMode("cash");

        // When
        List<MaxAvailSizeInfo> result = tradingAccountApi.maxAvailSize(request);

        // Then
        assertNotNull(result);
    }

    @Test
    void testLeverageInfo() {
        // Given
        LeverageRequest request = new LeverageRequest()
                .setInstId("BTC-USDT-SWAP")
                .setMgnMode("isolated");

        // When
        List<LeverageInfo> result = tradingAccountApi.leverageInfo(request);

        // Then
        assertNotNull(result);
    }
}