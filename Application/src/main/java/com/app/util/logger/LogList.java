package com.app.util.logger;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import lombok.extern.slf4j.Slf4j;

/**
 * Касс логер, добавляет новые строки в listView
 */
@Slf4j
public class LogList {
  private static final int MAX_SIZE = 2000;
  private static final ObservableList<String> logList = FXCollections.observableArrayList();

  static {
    logList.addListener((ListChangeListener<String>) change -> {
      while (change.next()) {
        if (logList.size() > MAX_SIZE) {
          logList.remove(MAX_SIZE, logList.size());
        }
      }
    });
  }

  public static ObservableList<String> getLogList() {
    return logList;
  }

  /**
   * Добавить в лог новую строку. Дублирует лог в Slf4j.
   * @param logMessage Сообщение для лога
   */
  public static void addLog(String logMessage) {
   log.info(logMessage);
    Platform.runLater(() -> {
      logList.add(0, logMessage);
    });

  }
}
