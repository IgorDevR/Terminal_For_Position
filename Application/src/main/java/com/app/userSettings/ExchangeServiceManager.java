package com.app.userSettings;

import com.app.exchangeWrapper.ExchangeServiceWrapper;
import com.app.util.enums.FullNameSelectServer;
import java.io.Serializable;

public class ExchangeServiceManager implements Serializable {
  /**
   * Создать экземпляр обертки для обмена данными с выбранным сервером.
   *
   * @param fullNameSelectServer полное имя выбранного сервера
   * @return экземпляр ExchangeServiceWrapper для выбранного сервера
   */
  public ExchangeServiceWrapper createExchangeService(FullNameSelectServer fullNameSelectServer) {
    return ExchangeServiceFactory.createExchangeService(fullNameSelectServer);
  }
}

