package com.app.util;

import com.app.util.enums.OrderSideEnum;
import com.app.util.enums.TypeOrderEnum;
import com.terminal.position.common.object.dto.binance.BinancePositionDto;
import com.terminal.position.common.object.util.enums.PositionSideEnum;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс формирует ордера для бинанс.
 */
@Slf4j
public class BuildNewOrderForBinance {

  /**
   * Установить параметры.
   * @param symbol символ.
   * @param side сторона ордера.
   * @param positionSide сторона позиции.
   * @param typeOrderEnum тип ордера.
   * @param quantity количество.
   * @param price цена.
   * @return LinkedHashMap с установленными параметрами
   */
  public static LinkedHashMap<String, Object> setParam(String symbol, String side,
      String positionSide, String typeOrderEnum, String quantity,
      BigDecimal price) {

    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

    parameters.put("symbol", symbol);
    parameters.put("side", side);// order side
    parameters.put("positionSide", positionSide);
    parameters.put("type", typeOrderEnum);
//    parameters.put("timeInForce", "GTC");
    parameters.put("quantity", quantity);
    if (price.compareTo(BigDecimal.ZERO) != 0) {
      parameters.put("price", price);
    }

    return parameters;
  }
  /**
   * Получить параметры для закрытия позиции по рыночной цене.
   * @param closePos объект с информацией о закрываемой позиции.
   * @param partSize размер части позиции для закрытия (может быть нулевым).
   * @return LinkedHashMap с установленными параметрами для закрытия позиции.
   */
  public static LinkedHashMap<String, Object> GetParameterCloseOrderMarket(
      BinancePositionDto closePos, String partSize) {

    String symbol = closePos.getSymbol();
    int i = closePos.getPositionAmt().compareTo(BigDecimal.ZERO);
    OrderSideEnum orderSide = i > 0 ? OrderSideEnum.SELL : OrderSideEnum.BUY;
    PositionSideEnum positionSide = closePos.getPositionSide();
    TypeOrderEnum typeOrder = TypeOrderEnum.MARKET;
    BigDecimal price = BigDecimal.ZERO;
    BigDecimal quantity = closePos.getPositionAmt().abs();

    BigDecimal closingPartSize = new BigDecimal(partSize);
    if (closingPartSize.compareTo(BigDecimal.ZERO) != 0) {
      quantity = closingPartSize;
    }

    return setParam(symbol, orderSide.name(), positionSide.name(), typeOrder.name(),
        quantity.toString(), price);
  }

  /**
   * Получить параметры для установки нового значения маржинального плеча.
   * @param symbol символ.
   * @param leverage новое значение маржинального плеча.
   * @return LinkedHashMap с установленными параметрами для установки нового значения маржинального плеча.
   */
  public static LinkedHashMap<String, Object> GetParameterForSetNewLeverageValue(String symbol,
      int leverage) {
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    parameters.put("symbol", symbol);
    parameters.put("leverage", leverage);
    return parameters;
  }
}
