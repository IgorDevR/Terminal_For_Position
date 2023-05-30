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
import java.io.IOException;

/**
 * MyFuturesTradeTimeRange
 */
public class MyFuturesTradeTimeRange {
    public static final String SERIALIZED_NAME_TRADE_ID = "trade_id";
    @SerializedName(SERIALIZED_NAME_TRADE_ID)
    private String tradeId;

    public static final String SERIALIZED_NAME_CREATE_TIME = "create_time";
    @SerializedName(SERIALIZED_NAME_CREATE_TIME)
    private Double createTime;

    public static final String SERIALIZED_NAME_CONTRACT = "contract";
    @SerializedName(SERIALIZED_NAME_CONTRACT)
    private String contract;

    public static final String SERIALIZED_NAME_ORDER_ID = "order_id";
    @SerializedName(SERIALIZED_NAME_ORDER_ID)
    private String orderId;

    public static final String SERIALIZED_NAME_SIZE = "size";
    @SerializedName(SERIALIZED_NAME_SIZE)
    private Long size;

    public static final String SERIALIZED_NAME_PRICE = "price";
    @SerializedName(SERIALIZED_NAME_PRICE)
    private String price;

    /**
     * Trade role. Available values are &#x60;taker&#x60; and &#x60;maker&#x60;
     */
    @JsonAdapter(RoleEnum.Adapter.class)
    public enum RoleEnum {
        TAKER("taker"),
        
        MAKER("maker");

        private String value;

        RoleEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RoleEnum fromValue(String value) {
            for (RoleEnum b : RoleEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<RoleEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RoleEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RoleEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return RoleEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_ROLE = "role";
    @SerializedName(SERIALIZED_NAME_ROLE)
    private RoleEnum role;

    public static final String SERIALIZED_NAME_TEXT = "text";
    @SerializedName(SERIALIZED_NAME_TEXT)
    private String text;

    public static final String SERIALIZED_NAME_FEE = "fee";
    @SerializedName(SERIALIZED_NAME_FEE)
    private String fee;

    public static final String SERIALIZED_NAME_POINT_FEE = "point_fee";
    @SerializedName(SERIALIZED_NAME_POINT_FEE)
    private String pointFee;


    public MyFuturesTradeTimeRange tradeId(String tradeId) {
        
        this.tradeId = tradeId;
        return this;
    }

     /**
     * Trade ID
     * @return tradeId
    **/
    @javax.annotation.Nullable
    public String getTradeId() {
        return tradeId;
    }


    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public MyFuturesTradeTimeRange createTime(Double createTime) {
        
        this.createTime = createTime;
        return this;
    }

     /**
     * Trading time
     * @return createTime
    **/
    @javax.annotation.Nullable
    public Double getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Double createTime) {
        this.createTime = createTime;
    }

    public MyFuturesTradeTimeRange contract(String contract) {
        
        this.contract = contract;
        return this;
    }

     /**
     * Futures contract
     * @return contract
    **/
    @javax.annotation.Nullable
    public String getContract() {
        return contract;
    }


    public void setContract(String contract) {
        this.contract = contract;
    }

    public MyFuturesTradeTimeRange orderId(String orderId) {
        
        this.orderId = orderId;
        return this;
    }

     /**
     * Order ID related
     * @return orderId
    **/
    @javax.annotation.Nullable
    public String getOrderId() {
        return orderId;
    }


    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public MyFuturesTradeTimeRange size(Long size) {
        
        this.size = size;
        return this;
    }

     /**
     * Trading size
     * @return size
    **/
    @javax.annotation.Nullable
    public Long getSize() {
        return size;
    }


    public void setSize(Long size) {
        this.size = size;
    }

    public MyFuturesTradeTimeRange price(String price) {
        
        this.price = price;
        return this;
    }

     /**
     * Trading price
     * @return price
    **/
    @javax.annotation.Nullable
    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public MyFuturesTradeTimeRange role(RoleEnum role) {
        
        this.role = role;
        return this;
    }

     /**
     * Trade role. Available values are &#x60;taker&#x60; and &#x60;maker&#x60;
     * @return role
    **/
    @javax.annotation.Nullable
    public RoleEnum getRole() {
        return role;
    }


    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public MyFuturesTradeTimeRange text(String text) {
        
        this.text = text;
        return this;
    }

     /**
     * User defined information
     * @return text
    **/
    @javax.annotation.Nullable
    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public MyFuturesTradeTimeRange fee(String fee) {
        
        this.fee = fee;
        return this;
    }

     /**
     * Fee deducted
     * @return fee
    **/
    @javax.annotation.Nullable
    public String getFee() {
        return fee;
    }


    public void setFee(String fee) {
        this.fee = fee;
    }

    public MyFuturesTradeTimeRange pointFee(String pointFee) {
        
        this.pointFee = pointFee;
        return this;
    }

     /**
     * Points used to deduct fee
     * @return pointFee
    **/
    @javax.annotation.Nullable
    public String getPointFee() {
        return pointFee;
    }


    public void setPointFee(String pointFee) {
        this.pointFee = pointFee;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyFuturesTradeTimeRange myFuturesTradeTimeRange = (MyFuturesTradeTimeRange) o;
        return Objects.equals(this.tradeId, myFuturesTradeTimeRange.tradeId) &&
                Objects.equals(this.createTime, myFuturesTradeTimeRange.createTime) &&
                Objects.equals(this.contract, myFuturesTradeTimeRange.contract) &&
                Objects.equals(this.orderId, myFuturesTradeTimeRange.orderId) &&
                Objects.equals(this.size, myFuturesTradeTimeRange.size) &&
                Objects.equals(this.price, myFuturesTradeTimeRange.price) &&
                Objects.equals(this.role, myFuturesTradeTimeRange.role) &&
                Objects.equals(this.text, myFuturesTradeTimeRange.text) &&
                Objects.equals(this.fee, myFuturesTradeTimeRange.fee) &&
                Objects.equals(this.pointFee, myFuturesTradeTimeRange.pointFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeId, createTime, contract, orderId, size, price, role, text, fee, pointFee);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MyFuturesTradeTimeRange {\n");
        sb.append("      tradeId: ").append(toIndentedString(tradeId)).append("\n");
        sb.append("      createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("      contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("      orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("      size: ").append(toIndentedString(size)).append("\n");
        sb.append("      price: ").append(toIndentedString(price)).append("\n");
        sb.append("      role: ").append(toIndentedString(role)).append("\n");
        sb.append("      text: ").append(toIndentedString(text)).append("\n");
        sb.append("      fee: ").append(toIndentedString(fee)).append("\n");
        sb.append("      pointFee: ").append(toIndentedString(pointFee)).append("\n");
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

