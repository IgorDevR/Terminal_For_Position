package com.terminal.position.common.object.util.enums;

import java.util.ArrayList;
import java.util.List;

public enum TypesExchange implements NamedTypeMarkets {

  NONE("NONE"),
  SPOT("SPOT"),
  FUTURES("FUTURES"),
  FUTURES_TESTNET("FUTURES_TESTNET"),

  ;

  public static List<TypesExchange> binanceTypesExchanges = new ArrayList<>(
      List.of(SPOT, FUTURES, FUTURES_TESTNET));
  public static List<TypesExchange> gateIoTypesExchanges = new ArrayList<>(
      List.of(SPOT, FUTURES));
  TypesExchange(String name) {
  }


}
