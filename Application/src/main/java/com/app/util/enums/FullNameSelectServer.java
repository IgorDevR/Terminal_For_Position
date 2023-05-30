package com.app.util.enums;


import com.terminal.position.common.object.util.enums.NamedTypeMarkets;
import java.util.HashMap;

public enum FullNameSelectServer implements NamedTypeMarkets {

  NONE("NONE"),
  BINANCE_USDM_SPOT("BINANCE_USDM_SPOT"),
  BINANCE_USDM_FUTURES("BINANCE_USDM_FUTURES"),
  BINANCE_COINM_FUTURES("BINANCE_COINM_FUTURES"),
  BINANCE_USDM_FUTURES_TESTNET("BINANCE_USDM_FUTURES_TESTNET"),
  BINANCE_COINM_FUTURES_TESTNET("BINANCE_COINM_FUTURES_TESTNET"),
  GATE_IO_USDM_SPOT("GATE_IO_USDM_SPOT"),
  GATE_IO_USDM_FUTURES("GATE_IO_USDM_FUTURES"),

  ;
  FullNameSelectServer(String name) {
  }
}
