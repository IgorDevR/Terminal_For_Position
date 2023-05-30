package com.app.util.logger;

import com.app.ui.controller.MainWindowUIController;
import com.binance.connector.futures.client.exceptions.BinanceClientException;
import io.gate.gateapi.ApiException;

public class Logger {

  /**
   * Метод возвращает лог с ошибкой, если произошло исключение.
   * @param e Исключение.
   * @return Строка с текстом ошибки.
   */
  @SuppressWarnings("DefaultLocale")
  public static String getLogMessage(Exception e) {
    if (e instanceof BinanceClientException binanceException) {
      return String.format("FullErrMessage: %s ErrMessage: %s ErrCode: %d HTTPStatusCode: %d",
          binanceException.getMessage(), binanceException.getErrMsg(),
          binanceException.getErrorCode(), binanceException.getHttpStatusCode());
    } else if (e instanceof ApiException apiException) {
      return String.format("FullErrMessage: %s ErrMessage: %s ErrCode: %s HTTPStatusCode: %s",
          apiException.getMessage(), apiException.getMessage(), apiException.getCode(),
          apiException.getResponseBody());
    } else {
      return String.format("FullErrMessage: %s", e.getMessage());
    }
  }

}
