package com.app.util;

import com.terminal.position.common.object.dto.binance.PositionData;
import java.util.List;
import java.util.stream.Collectors;

public class PositionUtils {

  /**
   * Получить только открыты позиции
   *
   * @param allPos Список все позиций
   * @return Список только открытых позиций
   */

  public static List<PositionData> getOpenPositions(List<PositionData> allPos) {
    if (!allPos.isEmpty()) {
      allPos = allPos.stream()
          .filter(p -> !p.getAmount().equals("0")).collect(
              Collectors.toList());
    }
    return allPos;
  }
  /**
   * Проверяет список позиций и добавляет пустую позицию, если список пуст.
   *
   * @param positionData список позиций
   */
  public static void checkAndAddEmptyPosition(List<PositionData> positionData) {
    if (positionData.size() == 0) {
      positionData.add(new PositionData("1", "открытых", "позиций", "нет", "None"));
    }
  }
}
