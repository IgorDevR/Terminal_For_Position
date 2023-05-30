package com.terminal.position.common.object.dto.binance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeInformationUMBinance {

  public List<String> exchangeFilters;
  public List<RateLimit> rateLimits;
  public long serverTime;
  public List<Symbol> symbols;
  public String timezone;
  public List<Asset> assets;


  @Getter
  @Setter
  public static class RateLimit {

    public String interval;
    public int intervalNum;
    public int limit;
    public String rateLimitType;
  }

  @Getter
  @Setter
  public static class Asset {

    public String asset;
    public boolean marginAvailable;
    public BigDecimal autoAssetExchange;
  }

  @Getter
  @Setter
  public static class Symbol {

    public String symbol;
    public String pair;
    public String contractType;
    public long deliveryDate;
    public long onboardDate;
    public String status;
    public String baseAsset;
    public String quoteAsset;
    public String marginAsset;
    public long pricePrecision;
    public long quantityPrecision;
    public long baseAssetPrecision;
    public long quotePrecision;
    public String underlyingType;
    public List<String> underlyingSubType;
    public long settlePlan;
    public String triggerProtect;
    public List<Filter> filters;
    public List<String> OrderType;
    public List<String> timeInForce;
  }

  @Getter
  @Setter
  public static class Filter {

    public String filterType;
    public String maxPrice;
    public String minPrice;
    public String tickSize;
    public String maxQty;
    public String minQty;
    public String stepSize;
    public long limit;
    public String multiplierUp;
    public String multiplierDown;
    public long multiplierDecimal;
  }
}