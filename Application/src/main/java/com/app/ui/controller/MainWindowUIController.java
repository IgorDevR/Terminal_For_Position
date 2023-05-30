package com.app.ui.controller;


import com.app.exchangeWrapper.ExchangeServiceWrapper;
import com.app.userSettings.AppSettings;
import com.app.util.PositionUtils;
import com.app.util.logger.LogList;
import com.terminal.position.common.object.dto.binance.InitialLeverage;
import com.terminal.position.common.object.dto.binance.PositionData;
import com.terminal.position.common.object.util.enums.NamedTypeMarkets;
import com.terminal.position.common.object.util.enums.TypesExchange;
import com.terminal.position.common.object.util.enums.TypesMarketCoin;
import com.terminal.position.common.object.util.enums.TypesServer;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;


public class MainWindowUIController implements Initializable {

  @FXML
  public ListView primeLogListView;
  @FXML
  public TextField sizePartClosePosition;
  @FXML
  public TextField selectLeverageSymbolTextField;
  @FXML
  public Button btn_retrieveAllSymbolCoins;
  @FXML
  public Button btn_setNewValueLeverageForSelectSymbolCoin;
  @FXML
  public Button btn_setNewValueLeverageAllSymbolCoins;
  @FXML
  public TextField leverageValueTextField;

  @FXML
  private TextField apiKey_BINANCE_SPOT;
  @FXML
  private TextField secretKey_BINANCE_SPOT;


  @FXML
  private TextField apiKey_BINANCE_FUTURES;
  @FXML
  private TextField secretKey_BINANCE_FUTURES;


  @FXML
  private TextField apiKey_BINANCE_FUTURES_TESTNET;
  @FXML
  private TextField secretKey_BINANCE_FUTURES_TESTNET;


  @FXML
  private TextField apiKey_GATE_IO_SPOT;
  @FXML
  private TextField secretKey_GATE_IO_SPOT;


  @FXML
  private TextField apiKey_GATE_IO_FUTURES;
  @FXML
  private TextField secretKey_GATE_IO_FUTURES;

  @FXML
  private Button btn_saveOrUpdateSettings;
  @FXML
  private Button btn_getPosition;
  @FXML
  private TableView<PositionData> tableView_openPosition;
  @FXML
  private TableColumn<PositionData, Button> tbViewColumn_closeFull;
  @FXML
  public TableColumn<PositionData, Button> tbViewColumn_closePart;


  @FXML
  private TableView<InitialLeverage> coinLeverageTableView;
  @FXML
  private TableColumn<InitialLeverage, String> symbolColumn;
  @FXML
  private TableColumn<InitialLeverage, String> leverageColumn;


  @FXML
  private ComboBox<NamedTypeMarkets> selectTypeServer;
  @FXML
  private ComboBox<NamedTypeMarkets> selectTypeExchange;
  @FXML
  private ComboBox<NamedTypeMarkets> selectTypeMarketCoin;


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    AppSettings.getInstance().loadObjectFieldsFromFile();
    setTextFieldFromLoadSettings();
    setTypeExchangesTo_cBox_SelectServer();

    handleChangeSettings();
  }

  /**
   * Установить доступные типы в комбо бокс при старте
   */
  private void setTypeExchangesTo_cBox_SelectServer() {

    selectTypeServer.getItems().setAll(TypesServer.values());
    selectTypeMarketCoin.getItems().setAll(TypesMarketCoin.values());
    selectTypeMarketCoin.setValue(TypesMarketCoin.USDM);
    setInComboBoxValue(AppSettings.getInstance().getSelectTypeServer());
  }

  /**
   * Установить значения в начальные поля после загрузки из файла при старте
   */
  private void setTextFieldFromLoadSettings() {

    Field[] fieldsApiAndSecretKeysThis = this.getClass().getDeclaredFields();
    Field[] fieldsApiAndSecretKeysConfig = AppSettings.class.getDeclaredFields();

    for (Field thisField : fieldsApiAndSecretKeysThis) {

      for (Field configField : fieldsApiAndSecretKeysConfig) {

        if (thisField.getName().equals(configField.getName())) {
          thisField.setAccessible(true);
          configField.setAccessible(true);
          try {

            if (thisField.getType() == javafx.scene.control.TextField.class) {
              String textFieldValue = (String) configField.get(AppSettings.getInstance());
              TextField textField = (TextField) thisField.get(this);
              textField.setText(textFieldValue);
            } else if (thisField.getType() == javafx.scene.control.ComboBox.class) {
              if ((configField.get(AppSettings.getInstance()) instanceof NamedTypeMarkets)) {
                NamedTypeMarkets value = (NamedTypeMarkets) configField.get(
                    AppSettings.getInstance());
                ComboBox<NamedTypeMarkets> comboBox = (ComboBox<NamedTypeMarkets>) thisField.get(
                    this);
                comboBox.getSelectionModel().select(value);
              }
            }
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
  }

  /**
   * Обработчик изменения настроек и других параметров
   */
  private void handleChangeSettings() {

    handleTextField();
    handleComboBox();
    closePositionButton();
    handlerSelectColumnInTable();
    setColumnInTable();
    listenerChangeLog();
  }

  /**
   * Обработчик нажатий на строки в tableView
   */
  private void handlerSelectColumnInTable() {
    coinLeverageTableView.getSelectionModel().selectedItemProperty()
        .addListener((obs, oldSelection, newSelection) -> {
          if (newSelection != null) {
            InitialLeverage row = coinLeverageTableView.getSelectionModel().getSelectedItem();
            LogList.addLog("Select symbol: " + row.getSymbol());
            selectLeverageSymbolTextField.setText(row.getSymbol());
          }
        });
  }

  /**
   * Получить список всех монет и их настройки плечей
   */
  private void retrieveSymbolAndLeverageAllCoins() {
    coinLeverageTableView.getItems().clear();

    ExchangeServiceWrapper exchangeServiceWrapper = AppSettings.getInstance()
        .getExchangeServiceWrapper();

    List<InitialLeverage> leverage = (List<InitialLeverage>) exchangeServiceWrapper.retrieveAllLeverageCoins();
    ObservableList<InitialLeverage> initialLeverages = FXCollections.observableArrayList(leverage);

    Platform.runLater(() -> {
      coinLeverageTableView.setItems(initialLeverages);
      coinLeverageTableView.getSortOrder().add(leverageColumn);
    });
  }

  /**
   * Обработка изменений в текстовых полях
   */
  private void handleTextField() {

//    sizePartClosePosition.setOnKeyTyped(event -> {
//      AppSettings.getInstance().setSizePartClosePosition(sizePartClosePosition.getText());
//    });
  }

  /**
   * Обработка изменений в текстовых комбо боксах
   */
  private void handleComboBox() {

    selectTypeServer.setOnAction(event -> {
      TypesServer selected = (TypesServer) selectTypeServer.getValue();
      setInComboBoxValue(selected);
      AppSettings.getInstance().setSelectTypeServer(selected);
    });
    selectTypeExchange.setOnAction(event -> {
      TypesExchange selected = (TypesExchange) selectTypeExchange.getValue();
      AppSettings.getInstance().setSelectTypeExchange(selected);
    });
    selectTypeMarketCoin.setOnAction(event -> {
      TypesMarketCoin selected = (TypesMarketCoin) selectTypeMarketCoin.getValue();
      AppSettings.getInstance().setSelectTypeMarketCoin(selected);
    });
  }

  /**
   * Установить доступные типы в комбо бокс при выборе и старте
   */
  private void setInComboBoxValue(TypesServer selected) {
    if ((selected == TypesServer.BINANCE)) {
      selectTypeExchange.getItems().setAll(TypesExchange.binanceTypesExchanges);
    } else if ((selected == TypesServer.GATE_IO)) {
      selectTypeExchange.getItems().setAll(TypesExchange.gateIoTypesExchanges);
    } else if ((selected == TypesServer.NONE)) {
      selectTypeExchange.getItems().clear();
    }
  }

  /**
   * Обработать нажатий на кнопку
   */
  @FXML
  private void handleClick(ActionEvent event) {

    if (event.getSource() == btn_saveOrUpdateSettings) {
      setConfigKeysValueField();
      AppSettings.getInstance().saveObjectFieldsToFile();
    } else if (event.getSource() == btn_getPosition) {
      runInBackground(this::retrieveAndDisplayOpenPositions);
    } else if (event.getSource() == btn_retrieveAllSymbolCoins) {
      runInBackground(this::retrieveSymbolAndLeverageAllCoins);
    } else if (event.getSource() == btn_setNewValueLeverageForSelectSymbolCoin) {
      runInBackground(() -> setNewLeverageValue(false));
    } else if (event.getSource() == btn_setNewValueLeverageAllSymbolCoins) {
      runInBackground(() -> setNewLeverageValue(true));
    }
  }

  /**
   * Установить новое значение плеча
   * @param isSetAllSymbol Замена значения у всех символов?
   */
  private void setNewLeverageValue(boolean isSetAllSymbol) {
    ExchangeServiceWrapper exchangeServiceWrapper = AppSettings.getInstance()
        .getExchangeServiceWrapper();

    List<InitialLeverage> initialLeverages = new ArrayList<>();

    if (isSetAllSymbol) {
      initialLeverages = coinLeverageTableView.getItems().stream().toList();
    } else if (selectLeverageSymbolTextField.getText().isEmpty()) {
      LogList.addLog("Для изменения плеча не выбрана монета");
      return;
    } else {
      InitialLeverage oneSymbol = coinLeverageTableView.getItems().stream()
          .filter(s -> s.getSymbol().equals(selectLeverageSymbolTextField.getText())).findFirst()
          .orElse(new InitialLeverage());
      initialLeverages.add(oneSymbol);
    }
    int leverage = Integer.parseInt(leverageValueTextField.getText());
    exchangeServiceWrapper.setNewValueLeverage(initialLeverages, leverage);
    runInBackground(this::retrieveSymbolAndLeverageAllCoins);
  }

  /**
   * Установить значение полей AppSettings, при нажатии кнопки сохранить
   */
  private void setConfigKeysValueField() {
    Field[] fieldsApiAndSecretKeysThis = this.getClass().getDeclaredFields();
    Field[] fieldsApiAndSecretKeysConfig = AppSettings.class.getDeclaredFields();

    for (Field thisField : fieldsApiAndSecretKeysThis) {

      for (Field configField : fieldsApiAndSecretKeysConfig) {

        if (thisField.getName().equals(configField.getName())) {
          thisField.setAccessible(true);
          configField.setAccessible(true);
          try {
            if (thisField.getType() == javafx.scene.control.TextField.class) {
              String textFieldValue = null;

              textFieldValue = ((TextField) thisField.get(this)).getText();
              configField.set(AppSettings.getInstance(), textFieldValue);

            } else if (thisField.getType() == javafx.scene.control.ComboBox.class) {
              ComboBox<NamedTypeMarkets> comboBox = (ComboBox<NamedTypeMarkets>) thisField.get(
                  this);
              Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
              configField.set(AppSettings.getInstance(), selectedItem);
            } else {
//              configField.set(AppSettings.getInstance(), thisField.get(this));
            }
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
  }

  /**
   * Получить список позиций и установить их в таблицу для отображения
   */
  private void retrieveAndDisplayOpenPositions() {
    tableView_openPosition.getItems().clear();
    ExchangeServiceWrapper exchangeServiceWrapper = AppSettings.getInstance()
        .getExchangeServiceWrapper();

    List<PositionData> openPositions = exchangeServiceWrapper.retrieveOpenPositions();
    PositionUtils.checkAndAddEmptyPosition(openPositions);
    ObservableList<PositionData> positionData = FXCollections.observableArrayList(openPositions);

    Platform.runLater(() -> {
      tableView_openPosition.setItems(positionData);
    });
  }

  /**
   * Запуск методов в фоновом потоке.
   */
  private void runInBackground(Runnable method) {
    Task<Void> task = new Task<Void>() {
      @Override
      protected Void call() throws Exception {
        method.run();
        return null;
      }
    };
    task.setOnSucceeded(e -> {
      // Здесь можно обновить пользовательский интерфейс после завершения задачи
    });
    new Thread(task).start();
  }

  /**
   * Обработка реакции на нажатии закрыть позицию
   */
  private void closePositionButton() {

    tbViewColumn_closeFull.setCellValueFactory(data -> {
      Button closeButton = new Button("Close");
      closeButton.setOnAction(event -> {
        // Действия при нажатии на кнопку Close
        if (data.getValue().getSide().equals("None")) {
          return;
        }

        PositionData position = data.getValue();
        ExchangeServiceWrapper exchangeServiceWrapper = AppSettings.getInstance()
            .getExchangeServiceWrapper();
        exchangeServiceWrapper.closeSelectPosition(position, "0");

        // Создаем паузу длительностью в 2 секунды
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> runInBackground(this::retrieveAndDisplayOpenPositions));
        pause.play();
      });
      return new SimpleObjectProperty<>(closeButton);
    });

    tbViewColumn_closePart.setCellValueFactory(data -> {
      Button closeButton = new Button("Close");
      closeButton.setOnAction(event -> {
        // Действия при нажатии на кнопку Close
        if (data.getValue().getSide().equals("None")
            || sizePartClosePosition.getText().equals("0") ||
            sizePartClosePosition.getText().isEmpty()) {
          return;
        }

        PositionData position = data.getValue();
        ExchangeServiceWrapper exchangeServiceWrapper = AppSettings.getInstance()
            .getExchangeServiceWrapper();
        exchangeServiceWrapper.closeSelectPosition(position, sizePartClosePosition.getText());

        // Создаем паузу длительностью в 2 секунды
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> runInBackground(this::retrieveAndDisplayOpenPositions));
        pause.play();
      });
      return new SimpleObjectProperty<>(closeButton);
    });
  }

  /**
   * Установить свойства колонок для разных таблиц
   */
  private void setColumnInTable() {

    symbolColumn.setCellValueFactory(new PropertyValueFactory<>("symbol"));
    leverageColumn.setCellValueFactory(new PropertyValueFactory<>("leverage"));
  }

  /**
   * При изменении LogList обновляем primeLogListView
   */
  private void listenerChangeLog(){
  primeLogListView.setItems(LogList.getLogList());
}

}

