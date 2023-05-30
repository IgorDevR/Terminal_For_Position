package com.terminal.position.common.object.dto.binance;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.terminal.position.common.object.util.enums.PositionSideEnum;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinancePositionDto {

  private String symbol;
  private BigDecimal positionAmt;
  private String entryPrice;
  private BigDecimal markPrice;
  private BigDecimal unRealizedProfit;
  private BigDecimal liquidationPrice;
  private Integer leverage;
  private BigDecimal maxNotionalValue;
  private String marginType;
  private BigDecimal isolatedMargin;
  private Boolean isAutoAddMargin;
  private PositionSideEnum positionSide;
  private BigDecimal notional;
  private BigDecimal isolatedWallet;
  private long updateTime;


}
