/*
 * Gate API v4
 * Welcome to Gate.io API  APIv4 provides spot, margin and futures trading operations. There are public APIs to retrieve the real-time market statistics, and private APIs which needs authentication to trade on user's behalf.
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.gate.gateapi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gate.gateapi.models.PositionCloseOrder;
import java.io.IOException;

/**
 * Futures position details
 */
public class Position {
    public static final String SERIALIZED_NAME_USER = "user";
    @SerializedName(SERIALIZED_NAME_USER)
    private Long user;

    public static final String SERIALIZED_NAME_CONTRACT = "contract";
    @SerializedName(SERIALIZED_NAME_CONTRACT)
    private String contract;

    public static final String SERIALIZED_NAME_SIZE = "size";
    @SerializedName(SERIALIZED_NAME_SIZE)
    private Long size;

    public static final String SERIALIZED_NAME_LEVERAGE = "leverage";
    @SerializedName(SERIALIZED_NAME_LEVERAGE)
    private String leverage;

    public static final String SERIALIZED_NAME_RISK_LIMIT = "risk_limit";
    @SerializedName(SERIALIZED_NAME_RISK_LIMIT)
    private String riskLimit;

    public static final String SERIALIZED_NAME_LEVERAGE_MAX = "leverage_max";
    @SerializedName(SERIALIZED_NAME_LEVERAGE_MAX)
    private String leverageMax;

    public static final String SERIALIZED_NAME_MAINTENANCE_RATE = "maintenance_rate";
    @SerializedName(SERIALIZED_NAME_MAINTENANCE_RATE)
    private String maintenanceRate;

    public static final String SERIALIZED_NAME_VALUE = "value";
    @SerializedName(SERIALIZED_NAME_VALUE)
    private String value;

    public static final String SERIALIZED_NAME_MARGIN = "margin";
    @SerializedName(SERIALIZED_NAME_MARGIN)
    private String margin;

    public static final String SERIALIZED_NAME_ENTRY_PRICE = "entry_price";
    @SerializedName(SERIALIZED_NAME_ENTRY_PRICE)
    private String entryPrice;

    public static final String SERIALIZED_NAME_LIQ_PRICE = "liq_price";
    @SerializedName(SERIALIZED_NAME_LIQ_PRICE)
    private String liqPrice;

    public static final String SERIALIZED_NAME_MARK_PRICE = "mark_price";
    @SerializedName(SERIALIZED_NAME_MARK_PRICE)
    private String markPrice;

    public static final String SERIALIZED_NAME_INITIAL_MARGIN = "initial_margin";
    @SerializedName(SERIALIZED_NAME_INITIAL_MARGIN)
    private String initialMargin;

    public static final String SERIALIZED_NAME_MAINTENANCE_MARGIN = "maintenance_margin";
    @SerializedName(SERIALIZED_NAME_MAINTENANCE_MARGIN)
    private String maintenanceMargin;

    public static final String SERIALIZED_NAME_UNREALISED_PNL = "unrealised_pnl";
    @SerializedName(SERIALIZED_NAME_UNREALISED_PNL)
    private String unrealisedPnl;

    public static final String SERIALIZED_NAME_REALISED_PNL = "realised_pnl";
    @SerializedName(SERIALIZED_NAME_REALISED_PNL)
    private String realisedPnl;

    public static final String SERIALIZED_NAME_HISTORY_PNL = "history_pnl";
    @SerializedName(SERIALIZED_NAME_HISTORY_PNL)
    private String historyPnl;

    public static final String SERIALIZED_NAME_LAST_CLOSE_PNL = "last_close_pnl";
    @SerializedName(SERIALIZED_NAME_LAST_CLOSE_PNL)
    private String lastClosePnl;

    public static final String SERIALIZED_NAME_REALISED_POINT = "realised_point";
    @SerializedName(SERIALIZED_NAME_REALISED_POINT)
    private String realisedPoint;

    public static final String SERIALIZED_NAME_HISTORY_POINT = "history_point";
    @SerializedName(SERIALIZED_NAME_HISTORY_POINT)
    private String historyPoint;

    public static final String SERIALIZED_NAME_ADL_RANKING = "adl_ranking";
    @SerializedName(SERIALIZED_NAME_ADL_RANKING)
    private Integer adlRanking;

    public static final String SERIALIZED_NAME_PENDING_ORDERS = "pending_orders";
    @SerializedName(SERIALIZED_NAME_PENDING_ORDERS)
    private Integer pendingOrders;

    public static final String SERIALIZED_NAME_CLOSE_ORDER = "close_order";
    @SerializedName(SERIALIZED_NAME_CLOSE_ORDER)
    private PositionCloseOrder closeOrder;

    /**
     * Position mode, including:  - &#x60;single&#x60;: dual mode is not enabled- &#x60;dual_long&#x60;: long position in dual mode- &#x60;dual_short&#x60;: short position in dual mode
     */
    @JsonAdapter(ModeEnum.Adapter.class)
    public enum ModeEnum {
        SINGLE("single"),
        
        DUAL_LONG("dual_long"),
        
        DUAL_SHORT("dual_short");

        private String value;

        ModeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ModeEnum fromValue(String value) {
            for (ModeEnum b : ModeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<ModeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ModeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ModeEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return ModeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_MODE = "mode";
    @SerializedName(SERIALIZED_NAME_MODE)
    private ModeEnum mode;

    public static final String SERIALIZED_NAME_CROSS_LEVERAGE_LIMIT = "cross_leverage_limit";
    @SerializedName(SERIALIZED_NAME_CROSS_LEVERAGE_LIMIT)
    private String crossLeverageLimit;


     /**
     * User ID
     * @return user
    **/
    @javax.annotation.Nullable
    public Long getUser() {
        return user;
    }


     /**
     * Futures contract
     * @return contract
    **/
    @javax.annotation.Nullable
    public String getContract() {
        return contract;
    }


     /**
     * Position size
     * @return size
    **/
    @javax.annotation.Nullable
    public Long getSize() {
        return size;
    }


    public Position leverage(String leverage) {
        
        this.leverage = leverage;
        return this;
    }

     /**
     * Position leverage. 0 means cross margin; positive number means isolated margin
     * @return leverage
    **/
    @javax.annotation.Nullable
    public String getLeverage() {
        return leverage;
    }


    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public Position riskLimit(String riskLimit) {
        
        this.riskLimit = riskLimit;
        return this;
    }

     /**
     * Position risk limit
     * @return riskLimit
    **/
    @javax.annotation.Nullable
    public String getRiskLimit() {
        return riskLimit;
    }


    public void setRiskLimit(String riskLimit) {
        this.riskLimit = riskLimit;
    }

     /**
     * Maximum leverage under current risk limit
     * @return leverageMax
    **/
    @javax.annotation.Nullable
    public String getLeverageMax() {
        return leverageMax;
    }


     /**
     * Maintenance rate under current risk limit
     * @return maintenanceRate
    **/
    @javax.annotation.Nullable
    public String getMaintenanceRate() {
        return maintenanceRate;
    }


     /**
     * Position value calculated in settlement currency
     * @return value
    **/
    @javax.annotation.Nullable
    public String getValue() {
        return value;
    }


    public Position margin(String margin) {
        
        this.margin = margin;
        return this;
    }

     /**
     * Position margin
     * @return margin
    **/
    @javax.annotation.Nullable
    public String getMargin() {
        return margin;
    }


    public void setMargin(String margin) {
        this.margin = margin;
    }

     /**
     * Entry price
     * @return entryPrice
    **/
    @javax.annotation.Nullable
    public String getEntryPrice() {
        return entryPrice;
    }


     /**
     * Liquidation price
     * @return liqPrice
    **/
    @javax.annotation.Nullable
    public String getLiqPrice() {
        return liqPrice;
    }


     /**
     * Current mark price
     * @return markPrice
    **/
    @javax.annotation.Nullable
    public String getMarkPrice() {
        return markPrice;
    }


     /**
     * The initial margin occupied by the position, applicable to the portfolio margin account
     * @return initialMargin
    **/
    @javax.annotation.Nullable
    public String getInitialMargin() {
        return initialMargin;
    }


     /**
     * Maintenance margin required for the position, applicable to portfolio margin account
     * @return maintenanceMargin
    **/
    @javax.annotation.Nullable
    public String getMaintenanceMargin() {
        return maintenanceMargin;
    }


     /**
     * Unrealized PNL
     * @return unrealisedPnl
    **/
    @javax.annotation.Nullable
    public String getUnrealisedPnl() {
        return unrealisedPnl;
    }


     /**
     * Realized PNL
     * @return realisedPnl
    **/
    @javax.annotation.Nullable
    public String getRealisedPnl() {
        return realisedPnl;
    }


     /**
     * History realized PNL
     * @return historyPnl
    **/
    @javax.annotation.Nullable
    public String getHistoryPnl() {
        return historyPnl;
    }


     /**
     * PNL of last position close
     * @return lastClosePnl
    **/
    @javax.annotation.Nullable
    public String getLastClosePnl() {
        return lastClosePnl;
    }


     /**
     * Realized POINT PNL
     * @return realisedPoint
    **/
    @javax.annotation.Nullable
    public String getRealisedPoint() {
        return realisedPoint;
    }


     /**
     * History realized POINT PNL
     * @return historyPoint
    **/
    @javax.annotation.Nullable
    public String getHistoryPoint() {
        return historyPoint;
    }


     /**
     * Ranking of auto deleveraging, a total of 1-5 grades, &#x60;1&#x60; is the highest, &#x60;5&#x60; is the lowest, and &#x60;6&#x60; is the special case when there is no position held or in liquidation
     * @return adlRanking
    **/
    @javax.annotation.Nullable
    public Integer getAdlRanking() {
        return adlRanking;
    }


     /**
     * Current open orders
     * @return pendingOrders
    **/
    @javax.annotation.Nullable
    public Integer getPendingOrders() {
        return pendingOrders;
    }


    public Position closeOrder(PositionCloseOrder closeOrder) {
        
        this.closeOrder = closeOrder;
        return this;
    }

     /**
     * Get closeOrder
     * @return closeOrder
    **/
    @javax.annotation.Nullable
    public PositionCloseOrder getCloseOrder() {
        return closeOrder;
    }


    public void setCloseOrder(PositionCloseOrder closeOrder) {
        this.closeOrder = closeOrder;
    }

    public Position mode(ModeEnum mode) {
        
        this.mode = mode;
        return this;
    }

     /**
     * Position mode, including:  - &#x60;single&#x60;: dual mode is not enabled- &#x60;dual_long&#x60;: long position in dual mode- &#x60;dual_short&#x60;: short position in dual mode
     * @return mode
    **/
    @javax.annotation.Nullable
    public ModeEnum getMode() {
        return mode;
    }


    public void setMode(ModeEnum mode) {
        this.mode = mode;
    }

    public Position crossLeverageLimit(String crossLeverageLimit) {
        
        this.crossLeverageLimit = crossLeverageLimit;
        return this;
    }

     /**
     * Cross margin leverage(valid only when &#x60;leverage&#x60; is 0)
     * @return crossLeverageLimit
    **/
    @javax.annotation.Nullable
    public String getCrossLeverageLimit() {
        return crossLeverageLimit;
    }


    public void setCrossLeverageLimit(String crossLeverageLimit) {
        this.crossLeverageLimit = crossLeverageLimit;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return Objects.equals(this.user, position.user) &&
                Objects.equals(this.contract, position.contract) &&
                Objects.equals(this.size, position.size) &&
                Objects.equals(this.leverage, position.leverage) &&
                Objects.equals(this.riskLimit, position.riskLimit) &&
                Objects.equals(this.leverageMax, position.leverageMax) &&
                Objects.equals(this.maintenanceRate, position.maintenanceRate) &&
                Objects.equals(this.value, position.value) &&
                Objects.equals(this.margin, position.margin) &&
                Objects.equals(this.entryPrice, position.entryPrice) &&
                Objects.equals(this.liqPrice, position.liqPrice) &&
                Objects.equals(this.markPrice, position.markPrice) &&
                Objects.equals(this.initialMargin, position.initialMargin) &&
                Objects.equals(this.maintenanceMargin, position.maintenanceMargin) &&
                Objects.equals(this.unrealisedPnl, position.unrealisedPnl) &&
                Objects.equals(this.realisedPnl, position.realisedPnl) &&
                Objects.equals(this.historyPnl, position.historyPnl) &&
                Objects.equals(this.lastClosePnl, position.lastClosePnl) &&
                Objects.equals(this.realisedPoint, position.realisedPoint) &&
                Objects.equals(this.historyPoint, position.historyPoint) &&
                Objects.equals(this.adlRanking, position.adlRanking) &&
                Objects.equals(this.pendingOrders, position.pendingOrders) &&
                Objects.equals(this.closeOrder, position.closeOrder) &&
                Objects.equals(this.mode, position.mode) &&
                Objects.equals(this.crossLeverageLimit, position.crossLeverageLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, contract, size, leverage, riskLimit, leverageMax, maintenanceRate, value, margin, entryPrice, liqPrice, markPrice, initialMargin, maintenanceMargin, unrealisedPnl, realisedPnl, historyPnl, lastClosePnl, realisedPoint, historyPoint, adlRanking, pendingOrders, closeOrder, mode, crossLeverageLimit);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Position {\n");
        sb.append("      user: ").append(toIndentedString(user)).append("\n");
        sb.append("      contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("      size: ").append(toIndentedString(size)).append("\n");
        sb.append("      leverage: ").append(toIndentedString(leverage)).append("\n");
        sb.append("      riskLimit: ").append(toIndentedString(riskLimit)).append("\n");
        sb.append("      leverageMax: ").append(toIndentedString(leverageMax)).append("\n");
        sb.append("      maintenanceRate: ").append(toIndentedString(maintenanceRate)).append("\n");
        sb.append("      value: ").append(toIndentedString(value)).append("\n");
        sb.append("      margin: ").append(toIndentedString(margin)).append("\n");
        sb.append("      entryPrice: ").append(toIndentedString(entryPrice)).append("\n");
        sb.append("      liqPrice: ").append(toIndentedString(liqPrice)).append("\n");
        sb.append("      markPrice: ").append(toIndentedString(markPrice)).append("\n");
        sb.append("      initialMargin: ").append(toIndentedString(initialMargin)).append("\n");
        sb.append("      maintenanceMargin: ").append(toIndentedString(maintenanceMargin)).append("\n");
        sb.append("      unrealisedPnl: ").append(toIndentedString(unrealisedPnl)).append("\n");
        sb.append("      realisedPnl: ").append(toIndentedString(realisedPnl)).append("\n");
        sb.append("      historyPnl: ").append(toIndentedString(historyPnl)).append("\n");
        sb.append("      lastClosePnl: ").append(toIndentedString(lastClosePnl)).append("\n");
        sb.append("      realisedPoint: ").append(toIndentedString(realisedPoint)).append("\n");
        sb.append("      historyPoint: ").append(toIndentedString(historyPoint)).append("\n");
        sb.append("      adlRanking: ").append(toIndentedString(adlRanking)).append("\n");
        sb.append("      pendingOrders: ").append(toIndentedString(pendingOrders)).append("\n");
        sb.append("      closeOrder: ").append(toIndentedString(closeOrder)).append("\n");
        sb.append("      mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("      crossLeverageLimit: ").append(toIndentedString(crossLeverageLimit)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n        ");
    }

}

