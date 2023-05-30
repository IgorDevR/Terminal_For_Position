package com.app.userSettings;


import com.app.exchangeWrapper.ExchangeServiceWrapper;
import com.app.util.enums.FullNameSelectServer;
import com.app.util.logger.LogList;
import com.terminal.position.common.object.util.enums.TypesExchange;
import com.terminal.position.common.object.util.enums.TypesMarketCoin;
import com.terminal.position.common.object.util.enums.TypesServer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppSettings implements Serializable {

  private static AppSettings instance;

  private ExchangeServiceWrapper exchangeServiceWrapper;

  private ExchangeServiceManager exchangeServiceManager = new ExchangeServiceManager();

  private AppSettings() {
  }

  public static synchronized AppSettings getInstance() {
    if (instance == null) {
      instance = new AppSettings();
    }
    return instance;
  }

  private String apiKey_BINANCE_SPOT;
  private String secretKey_BINANCE_SPOT;

  private String apiKey_BINANCE_FUTURES;
  private String secretKey_BINANCE_FUTURES;

  private String apiKey_BINANCE_FUTURES_TESTNET;
  private String secretKey_BINANCE_FUTURES_TESTNET;

  public final String UM_BASE_URL = "https://fapi.binance.com";
  public final String CM_BASE_URL = "https://dapi.binance.com";
  public final String TESTNET_BASE_URL = "https://testnet.binancefuture.com";

  private String apiKey_GATE_IO_SPOT;
  private String secretKey_GATE_IO_SPOT;

  private String apiKey_GATE_IO_FUTURES;
  private String secretKey_GATE_IO_FUTURES;

  private TypesServer selectTypeServer  =TypesServer.NONE;
  private TypesExchange selectTypeExchange  = TypesExchange.NONE;
  private TypesMarketCoin selectTypeMarketCoin = TypesMarketCoin.USDM;

  private FullNameSelectServer fullNameSelectServer = FullNameSelectServer.NONE;

  public ExchangeServiceWrapper getExchangeServiceWrapper() {
    return exchangeServiceManager.createExchangeService(fullNameSelectServer);
  }
  private void setFullNameSelectServer() {
    try {
      fullNameSelectServer = FullNameSelectServer.valueOf(
          selectTypeServer + "_" + selectTypeMarketCoin + "_" + selectTypeExchange);
    } catch (Exception e) {
      LogList.addLog("Ошибка получения выбранного сервера");
    }
  }

  /**
   * Сериализовать класс в файл
   */
  public void saveObjectFieldsToFile() {
    setFullNameSelectServer();

    String filename = "userSettings.txt";
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
      oos.writeObject(this);
      LogList.addLog("Настройки сохранены в файл " + filename);
    } catch (IOException e) {
      LogList.addLog("Ошибка сохранения файла" + filename + ". " + e.getMessage());
    }
  }
  /**
   * Десериализовать класс из файла
   */
  public void loadObjectFieldsFromFile() {
    String filename = "userSettings.txt";

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
      AppSettings loadedSettings = (AppSettings) ois.readObject();
      Field[] fields = AppSettings.class.getDeclaredFields();
      for (Field field : fields) {

        if (Modifier.isStatic(field.getModifiers())) {
          continue;
        }
        String name = field.getName();
        Object o = field.get(loadedSettings);
        field.setAccessible(true);
        field.set(AppSettings.getInstance(), o);

      }
      LogList.addLog("Файл userSettings.txt найден, настройки загружены.");
    } catch (IOException | ClassNotFoundException | IllegalAccessException e) {
      LogList.addLog("Файл userSettings.txt не найден, вызвана настройка по умолчанию." + e.getMessage());
    }

  }

}