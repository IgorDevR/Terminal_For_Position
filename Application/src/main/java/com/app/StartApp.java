package com.app;

import com.app.ui.MainWindowsUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApp {
  public static void main(String[] args) {
    SpringApplication.run(StartApp.class, args);

    showSettingsWindow();
  }

  public static void showSettingsWindow() {

    MainWindowsUI mainWindowsUIFX = new MainWindowsUI();
    mainWindowsUIFX.run();
  }

}

