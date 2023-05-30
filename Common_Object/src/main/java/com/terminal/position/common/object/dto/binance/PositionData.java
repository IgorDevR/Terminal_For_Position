package com.terminal.position.common.object.dto.binance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Класс содержит общую информацию для позиций различных бирж. Используется так же для вывода на экран в jTable.
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class PositionData {

  private String num;
  private String symbol;
  private String entryPrice;
  private String amount;
  private String side;

}
