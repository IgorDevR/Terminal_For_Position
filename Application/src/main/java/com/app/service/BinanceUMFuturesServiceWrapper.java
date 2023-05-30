package com.app.service;


import com.app.exchangeWrapper.ExchangeServiceWrapper;
import com.app.mapper.PositionMapper;
import com.app.util.BuildNewOrderForBinance;
import com.app.util.Parser;
import com.app.util.PositionUtils;
import com.app.util.logger.LogList;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.google.gson.reflect.TypeToken;
import com.terminal.position.common.object.dto.binance.BinancePositionDto;
import com.terminal.position.common.object.dto.binance.InitialLeverage;
import com.terminal.position.common.object.dto.binance.PositionData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.Getter;

/**
 * Реализация сервиса BinanceUM
 */
@Getter
public class BinanceUMFuturesServiceWrapper implements ExchangeServiceWrapper {

  private UMFuturesClientImpl client;

  public BinanceUMFuturesServiceWrapper(UMFuturesClientImpl client) {
    this.client = client;
  }

  @Override
  public List<PositionData> retrieveOpenPositions() {

    String result = ExchangeServiceWrapper.executeWithExceptionHandling(
        () -> client.account().positionInformation(new LinkedHashMap<>()), new String());
    return getOnlyOpenPositionDataFromResult(new ArrayList<>(List.of(result)));
  }


  @Override
  public List<?> retrieveAllLeverageCoins() {

    String result = ExchangeServiceWrapper.executeWithExceptionHandling(
        () -> client.account().positionInformation(new LinkedHashMap<>()), new String());

    List<InitialLeverage> namesAndLeverages = getNameAndLeverageAllCoins(
        new ArrayList<>(List.of(result)));
    return namesAndLeverages;
  }

  @Override
  public void closeSelectPosition(PositionData positionForClose, String partSize) {

    BinancePositionDto binancePositionDto = PositionMapper.positionDataToBinancePositionDto(
        positionForClose);
    LinkedHashMap<String, Object> parameterCloseOrderMarket = BuildNewOrderForBinance.GetParameterCloseOrderMarket(
        binancePositionDto, partSize);
    String result = ExchangeServiceWrapper.executeWithExceptionHandling(
        () -> client.account().newOrder(parameterCloseOrderMarket), new String());
    LogList.addLog(result);
  }

  @Override
  public void setNewValueLeverage(List<?> initialLeverages, int leverage) {

    for (InitialLeverage symbolAndLeverage : (List<InitialLeverage>) initialLeverages) {
      if (symbolAndLeverage.getLeverage() == leverage) {
        LogList.addLog(
            "Для символа: " + symbolAndLeverage.getSymbol() + ". Плече уже равно: " + leverage);
        continue;
      }
      LinkedHashMap<String, Object> symbolAndBewValueLeverage = BuildNewOrderForBinance.GetParameterForSetNewLeverageValue(
          symbolAndLeverage.getSymbol(), leverage);

      String result = ExchangeServiceWrapper.executeWithExceptionHandling(
          () -> client.account().changeInitialLeverage(symbolAndBewValueLeverage), new String());
    }
  }

  @Override
  public List<PositionData> getOnlyOpenPositionDataFromResult(List<?> result) {

    List<BinancePositionDto> binancePosDto = Parser.parseJsonToList((String) result.get(0),
        new TypeToken<List<BinancePositionDto>>() {
        });
    List<PositionData> positionData = PositionMapper.binancePositionsToPositionData(binancePosDto);
    positionData = PositionUtils.getOpenPositions(positionData);

    return positionData;
  }

  /**
   * Получить имена и плечи всех символов на сервере
   *
   * @param result Gson строка в виде листа, для парсинга и обработки
   * @return Список символ - плечо
   */
  public List<InitialLeverage> getNameAndLeverageAllCoins(List<?> result) {

    List<BinancePositionDto> binancePosDto = Parser.parseJsonToList((String) result.get(0),
        new TypeToken<List<BinancePositionDto>>() {
        });

    List<InitialLeverage> symbolAndLeverage = binancePosDto.stream()
        .map(dto -> new InitialLeverage(dto.getSymbol(), dto.getLeverage())).distinct().toList();
    return symbolAndLeverage;
  }


}
