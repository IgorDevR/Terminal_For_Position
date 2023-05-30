//package com.app.service;
//
//import com.app.exchangeWrapper.ExchangeServiceWrapper;
//import com.binance.connector.client.impl.SpotClientImpl;
//import com.terminal.position.common.object.dto.binance.PositionData;
//import java.util.List;
//import lombok.Getter;
//
//@Getter
//public class BinanceSpotServiceWrapper implements ExchangeServiceWrapper {
//
//  private SpotClientImpl spotClientBinance;
//
//
//  public BinanceSpotServiceWrapper(SpotClientImpl spotClientBinance) {
//    this.spotClientBinance = spotClientBinance;
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
