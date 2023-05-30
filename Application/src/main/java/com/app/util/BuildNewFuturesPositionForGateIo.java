package com.app.util;

import io.gate.gateapi.models.FuturesOrder;
import io.gate.gateapi.models.FuturesOrder.AutoSizeEnum;
import io.gate.gateapi.models.FuturesOrder.TifEnum;

/**
 * Формирование новых позиций для GateIo.
 */
public class BuildNewFuturesPositionForGateIo {

  /**
   * Собрать новый закрывающий позицию ордер.
   * @param position Существующая позиция, которую нужно закрыть.
   * @param partSize Размер закрываемой позиции.
   * @return Ордер для закрытия или уменьшения позиции.
   */
  public static FuturesOrder buildCloseOrderMarket(FuturesOrder position, String partSize) {

    long size = position.getSize();

    FuturesOrder futuresOrder = new FuturesOrder();
    futuresOrder.setContract(position.getContract());
    futuresOrder.setSize(0L);
    futuresOrder.setPrice("0");

    futuresOrder.setTif(TifEnum.IOC);
    futuresOrder.setReduceOnly(true);
    futuresOrder.setClose(false);

    long closingPartSize = Long.parseLong(partSize);
    if (closingPartSize != 0) {
      closingPartSize = size > 0 ? closingPartSize * -1 : closingPartSize;
      futuresOrder.setSize(closingPartSize);
    } else {
      AutoSizeEnum autoSizeEnum = size > 0 ? AutoSizeEnum.LONG : AutoSizeEnum.SHORT;
      futuresOrder.setAutoSize(autoSizeEnum);

    }

    return futuresOrder;
  }
}
