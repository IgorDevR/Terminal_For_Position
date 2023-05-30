package com.app.util.logger;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import io.gate.gateapi.ApiException;

public class ExceptionLog {

  /**
   * Метод добавляет в лог ошибку, если произошло исключение.
   *
   * @param e Исключение.
   */
  @SuppressWarnings("DefaultLocale")
  public static void setLogMessage(Exception e) {
    if (e instanceof BinanceClientException binanceException) {
      LogList.addLog(
          String.format("FullErrMessage: %s ErrMessage: %s ErrCode: %d HTTPStatusCode: %d",
              binanceException.getMessage(), binanceException.getErrMsg(),
              binanceException.getErrorCode(), binanceException.getHttpStatusCode()));
    } else if (e instanceof ApiException apiException) {
      LogList.addLog(String.format("FullErrMessage: %s ErrMessage: %s ErrCode: %s HTTPStatusCode: %s",
          apiException.getMessage(), apiException.getMessage(), apiException.getCode(),
          apiException.getResponseBody()));
    } else {
      LogList.addLog(String.format("FullErrMessage: %s", e.getMessage()));
    }
  }

}
