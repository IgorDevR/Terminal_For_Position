package com.app.mapper;


import com.terminal.position.common.object.util.enums.PositionSideEnum;
import com.terminal.position.common.object.dto.binance.BinancePositionDto;
import com.terminal.position.common.object.dto.binance.PositionData;
import io.gate.gateapi.models.FuturesOrder;
import io.gate.gateapi.models.Position;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс маппер. Конвертер позиций и ордеров.
 */
public class PositionMapper {


  /**
   * Формируем позицию BinancePositionDto из общих позиций PositionData, для BinanceFutures.
   *
   * @param position Список позиций общего вида PositionData.
   * @return Новая позиция BinancePositionDto.
   */
  public static BinancePositionDto positionDataToBinancePositionDto(PositionData position) {

    BinancePositionDto dto = new BinancePositionDto();

    dto.setSymbol(position.getSymbol());
    dto.setPositionAmt(new BigDecimal(position.getAmount()));
    dto.setEntryPrice(position.getEntryPrice());
    dto.setPositionSide(PositionSideEnum.valueOf(position.getSide()));

    return dto;
  }

  /**
   * Формируем Новый ордер из общих позиций PositionData, для GateIo.
   *
   * @param position Список позиций общего вида PositionData.
   * @return Новый ордер FuturesOrder для GateIo.
   */
  public static FuturesOrder positionDataToGateIoFuturesOrder(PositionData position) {

    long size = Long.parseLong(position.getAmount());

    FuturesOrder futuresOrder = new FuturesOrder();
    futuresOrder.setContract(position.getSymbol());
    futuresOrder.setSize(size);

    return futuresOrder;
  }

  /**
   * Формируем dto для таблицы отображения из BinancePositionDto.
   *
   * @param positions Список позиций BinanceFutures.
   * @return Список позиций общего вида PositionData.
   */
  public static List<PositionData> binancePositionsToPositionData(
      List<BinancePositionDto> positions) {

    List<PositionData> dtoList = new ArrayList<>();
    int posCnt = 1;
    for (BinancePositionDto position : positions) {
      BigDecimal positionAmt = position.getPositionAmt();
      if (positionAmt.compareTo(BigDecimal.ZERO) == 0) {
        continue;
      }
      PositionData dto = new PositionData();
      dto.setNum(String.valueOf(posCnt++));
      dto.setSymbol(position.getSymbol());
      dto.setAmount(String.valueOf(position.getPositionAmt()));
      dto.setEntryPrice(position.getEntryPrice());
      dto.setSide(position.getPositionSide().name());
      dtoList.add(dto);
    }

    return dtoList;
  }

  /**
   * Формируем dto для таблицы отображения из GateIoPositionDto.
   *
   * @param positions Список позиций GateIo.
   * @return Список позиций общего вида PositionData.
   */
  public static List<PositionData> gateIoPositionsToPositionData(
      List<Position> positions) {

    List<PositionData> dtoList = new ArrayList<>();
    int posCnt = 1;
    for (Position position : positions) {
      if (position.getSize() == 0) {
        continue;
      }
      PositionData dto = new PositionData();
      dto.setNum(String.valueOf(posCnt++));
      dto.setSymbol(position.getContract());
      dto.setAmount(String.valueOf(position.getSize()));
      dto.setEntryPrice(position.getEntryPrice());
      dto.setSide(position.getSize() > 0 ? PositionSideEnum.LONG.name()
          : PositionSideEnum.SHORT.name());
      dtoList.add(dto);
    }
    return dtoList;
  }


}
