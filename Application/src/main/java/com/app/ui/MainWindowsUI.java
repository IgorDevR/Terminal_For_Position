package com.app.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowsUI extends Application {
  public void run() {
    launch();
  }

  @Override
  public void start(Stage stage) throws IOException {

    Parent root = FXMLLoader.load(getClass().getResource(
        "/fxml/MainWindowUI.fxml"));
    Scene scene = new Scene(root);

    stage.setScene(scene);

    stage.setTitle("Terminal");
    stage.setWidth(700);
    stage.setHeight(700);

    stage.show();
  }
}
