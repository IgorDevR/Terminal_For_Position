package com.app.service;

import com.app.exchangeWrapper.ExchangeServiceWrapper;
import com.app.mapper.PositionMapper;
import com.app.util.BuildNewFuturesPositionForGateIo;
import com.app.util.PositionUtils;
import com.app.util.logger.LogList;
import com.terminal.position.common.object.dto.binance.PositionData;
import io.gate.gateapi.api.FuturesApi;
import io.gate.gateapi.models.FuturesOrder;
import io.gate.gateapi.models.Position;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class GateIoServiceFuturesWrapper implements ExchangeServiceWrapper {

  private FuturesApi client;

  public GateIoServiceFuturesWrapper(FuturesApi client) {
    this.client = client;
  }

  @Override
  public List<PositionData> retrieveOpenPositions() {

    String settle = "usdt";
    List<Position> positions = ExchangeServiceWrapper.executeWithExceptionHandling(
        () -> client.listPositions(settle), new ArrayList<>());
    return getOnlyOpenPositionDataFromResult(positions);

  }


  @Override
  public List<?> retrieveAllLeverageCoins() {
    return null;
  }

  @Override
  public void setNewValueLeverage(List<?> symbols, int leverage) {

  }

  @Override
  public void closeSelectPosition(PositionData closePos, String partSize) {

    LogList.addLog("Start closeSelectPosition() GateIo");
    FuturesOrder futuresOrder = PositionMapper.positionDataToGateIoFuturesOrder(closePos);
    FuturesOrder closeOrderMarket = BuildNewFuturesPositionForGateIo.buildCloseOrderMarket(futuresOrder,
        partSize);

    FuturesOrder orderResponse = ExchangeServiceWrapper.executeWithExceptionHandling(
        () -> client.createFuturesOrder("usdt", closeOrderMarket), new FuturesOrder());
    if (orderResponse != null) {
      LogList.addLog(orderResponse.getStatus().name());
    }
  }


  @Override
  public List<PositionData> getOnlyOpenPositionDataFromResult(List<?> positions) {

    List<PositionData> positionData = PositionMapper.gateIoPositionsToPositionData(
        (List<Position>) positions);
    positionData = PositionUtils.getOpenPositions(positionData);
    return positionData;
  }
}
