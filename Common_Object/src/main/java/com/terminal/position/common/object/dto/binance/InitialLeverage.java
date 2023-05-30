package com.terminal.position.common.object.dto.binance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Класс, представляющий информацию об исходном плече.
 */
@Getter
@Setter
public class InitialLeverage {

  /**
   * Символ.
   */
  private String symbol;

  /**
   * Плечо.
   */
  private int leverage;
  /**
   * Конструктор с параметрами.
   *
   * @param symbol   символ
   * @param leverage плечо
   */
  @JsonIgnore
  public InitialLeverage(String symbol, int leverage) {
    this.symbol = symbol;
    this.leverage = leverage;
  }

  public InitialLeverage() {
  }

  long maxNotionalValue;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitialLeverage that = (InitialLeverage) o;
    return leverage == that.leverage && symbol.equals(that.symbol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, leverage);
  }
}
