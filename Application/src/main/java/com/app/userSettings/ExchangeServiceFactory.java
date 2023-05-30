package com.app.userSettings;

import com.app.exchangeWrapper.ExchangeServiceWrapper;
import com.app.service.BinanceUMFuturesServiceWrapper;
import com.app.service.GateIoServiceFuturesWrapper;
import com.app.util.enums.FullNameSelectServer;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import io.gate.gateapi.ApiClient;
import io.gate.gateapi.api.FuturesApi;
import io.gate.gateapi.api.SpotApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExchangeServiceFactory {
  /**
   * Создать экземпляр обертки для обмена данными с выбранным сервером.
   *
   * @param fullNameSelectServer полное имя выбранного сервера.
   * @return экземпляр ExchangeServiceWrapper для выбранного сервера.
   * @throws IllegalArgumentException если тип сервера или тип аккаунта не поддерживается.
   */
  public static ExchangeServiceWrapper createExchangeService(
      FullNameSelectServer fullNameSelectServer) {

    switch (fullNameSelectServer) {
//      case BINANCE_USDM_SPOT -> {
//        return new BinanceSpotServiceWrapper(new SpotClientImpl(AppSettings.getInstance()
//            .getApiKey_BINANCE_SPOT(), AppSettings.getInstance().getSecretKey_BINANCE_SPOT()));
//      }
      case BINANCE_USDM_FUTURES -> {
        return new BinanceUMFuturesServiceWrapper(new UMFuturesClientImpl(AppSettings.getInstance()
            .getApiKey_BINANCE_FUTURES(), AppSettings.getInstance().getSecretKey_BINANCE_FUTURES(),
            AppSettings.getInstance().getUM_BASE_URL()));
      }
//      case BINANCE_COINM_FUTURES -> {
//        return new BinanceCMFuturesServiceWrapper(new CMFuturesClientImpl(AppSettings.getInstance()
//            .getApiKey_BINANCE_FUTURES(), AppSettings.getInstance().getSecretKey_BINANCE_FUTURES(),
//            AppSettings.getInstance().getCM_BASE_URL()));
//      }
      case BINANCE_USDM_FUTURES_TESTNET -> {
        return new BinanceUMFuturesServiceWrapper(new UMFuturesClientImpl(AppSettings.getInstance()
            .getApiKey_BINANCE_FUTURES_TESTNET(),
            AppSettings.getInstance().getSecretKey_BINANCE_FUTURES_TESTNET(),
            AppSettings.getInstance().getTESTNET_BASE_URL()));
      }
//      case BINANCE_COINM_FUTURES_TESTNET -> {
//        return new BinanceCMFuturesServiceWrapper(new CMFuturesClientImpl(AppSettings.getInstance()
//            .getApiKey_BINANCE_FUTURES_TESTNET(),
//            AppSettings.getInstance().getSecretKey_BINANCE_FUTURES_TESTNET(),
//            AppSettings.getInstance().getTESTNET_BASE_URL()));
//      }
//      case GATE_IO_USDM_SPOT -> {
//        return new GateIoServiceWrapper(new SpotApi(new ApiClient(AppSettings.getInstance()
//            .getApiKey_GATE_IO_SPOT(), AppSettings.getInstance().getSecretKey_GATE_IO_SPOT())));
//      }
      case GATE_IO_USDM_FUTURES -> {
        return new GateIoServiceFuturesWrapper(
            new FuturesApi(new ApiClient(AppSettings.getInstance()
                .getApiKey_GATE_IO_FUTURES(),
                AppSettings.getInstance().getSecretKey_GATE_IO_FUTURES())));
      }
    }
    log.info(
        "не удалось выполнить создание сервиса в createExchangeService() + FullNameSelectServer = "
            + fullNameSelectServer);
    throw new IllegalArgumentException("Unsupported server type or account type");
  }
}