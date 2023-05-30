package com.app.exchangeWrapper;

import com.app.util.logger.ExceptionLog;
import com.terminal.position.common.object.dto.binance.PositionData;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Класс обертка, для объединения всех сервисов
 */
public interface ExchangeServiceWrapper {

  /**
   * Получить все позиции и взять только открытые.
   *
   * @return Лист общих позиций PositionData.
   */
  public abstract List<PositionData> retrieveOpenPositions();

  /**
   * Получить все позиции и их плечи.
   *
   * @return Список символов их значения плеча.
   */
  public abstract List<?> retrieveAllLeverageCoins();

  /**
   * Установить новое значение плеча.
   *
   * @param symbol   символ. Может быть пустым, в таком случае плечо будет изменено на всех
   *                 доступных символах.
   * @param leverage новое значение плеча.
   */
  public abstract void setNewValueLeverage(List<?> symbol, int leverage);

  /**
   * Закрыть выбранную позицию
   *
   * @param positionData общая PositionData для закрытия из таблицы jTable или любого другого места
   */

  public abstract void closeSelectPosition(PositionData positionData, String partSize);

  /**
   * Получить только открытые позиции с объемом не равным 0
   *
   * @param positions Позиции любых типов от разных бирж
   * @return Список общих отрытых позиций
   */

  public abstract List<PositionData> getOnlyOpenPositionDataFromResult(List<?> positions);

  /**
   * Выполняет задачу типа Callable с обработкой исключений. Если задача выбрасывает исключение,
   * исключение регистрируется в лог, и возвращается значение по умолчанию.
   *
   * @param <T>          Тип результата, который производит задача Callable.
   * @param callable     Задача Callable, которую нужно выполнить.
   * @param defaultValue Значение по умолчанию, которое возвращается, если задача выбрасывает
   *                     исключение.
   * @return Результат, произведенный задачей Callable, или значение по умолчанию, если произошло
   * исключение.
   */
  public static <T> T executeWithExceptionHandling(Callable<T> callable, T defaultValue) {
    try {
      return callable.call();
    } catch (Exception e) {
     ExceptionLog.setLogMessage(e);
      return defaultValue;
    }

  }


}
