//package com.app.service;
//
//import com.app.exchangeWrapper.ExchangeServiceWrapper;
//import com.terminal.position.common.object.dto.binance.PositionData;
//import io.gate.gateapi.api.SpotApi;
//import java.util.List;
//import lombok.Getter;
//
//@Getter
//public class GateIoServiceWrapper implements ExchangeServiceWrapper {
//
//  private SpotApi client;
//
//  public GateIoServiceWrapper(SpotApi client) {
//    this.client = client;
//  }
//
//  @Override
//  public List<PositionData> retrieveOpenPositions() {
//    return null;
//  }
//
//  @Override
//  public void closeSelectPosition(PositionData positionData) {
//
//  }
//
//  @Override
//  public List<PositionData> getOnlyOpenPositionDataFromResult(List<?> positions) {
//    return null;
//  }
//}
