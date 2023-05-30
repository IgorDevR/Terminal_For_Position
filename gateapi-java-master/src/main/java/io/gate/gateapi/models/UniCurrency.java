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
 * Currency detail
 */
public class UniCurrency {
    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_MIN_LEND_AMOUNT = "min_lend_amount";
    @SerializedName(SERIALIZED_NAME_MIN_LEND_AMOUNT)
    private String minLendAmount;

    public static final String SERIALIZED_NAME_MAX_LEND_AMOUNT = "max_lend_amount";
    @SerializedName(SERIALIZED_NAME_MAX_LEND_AMOUNT)
    private String maxLendAmount;

    public static final String SERIALIZED_NAME_MAX_RATE = "max_rate";
    @SerializedName(SERIALIZED_NAME_MAX_RATE)
    private String maxRate;

    public static final String SERIALIZED_NAME_MIN_RATE = "min_rate";
    @SerializedName(SERIALIZED_NAME_MIN_RATE)
    private String minRate;


     /**
     * Currency name
     * @return currency
    **/
    @javax.annotation.Nullable
    public String getCurrency() {
        return currency;
    }


     /**
     * Minimum lend amount
     * @return minLendAmount
    **/
    @javax.annotation.Nullable
    public String getMinLendAmount() {
        return minLendAmount;
    }


     /**
     * Maximum lend amount
     * @return maxLendAmount
    **/
    @javax.annotation.Nullable
    public String getMaxLendAmount() {
        return maxLendAmount;
    }


     /**
     * Maximum rate (Hourly)
     * @return maxRate
    **/
    @javax.annotation.Nullable
    public String getMaxRate() {
        return maxRate;
    }


     /**
     * Minimum rate (Hourly)
     * @return minRate
    **/
    @javax.annotation.Nullable
    public String getMinRate() {
        return minRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UniCurrency uniCurrency = (UniCurrency) o;
        return Objects.equals(this.currency, uniCurrency.currency) &&
                Objects.equals(this.minLendAmount, uniCurrency.minLendAmount) &&
                Objects.equals(this.maxLendAmount, uniCurrency.maxLendAmount) &&
                Objects.equals(this.maxRate, uniCurrency.maxRate) &&
                Objects.equals(this.minRate, uniCurrency.minRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, minLendAmount, maxLendAmount, maxRate, minRate);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UniCurrency {\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      minLendAmount: ").append(toIndentedString(minLendAmount)).append("\n");
        sb.append("      maxLendAmount: ").append(toIndentedString(maxLendAmount)).append("\n");
        sb.append("      maxRate: ").append(toIndentedString(maxRate)).append("\n");
        sb.append("      minRate: ").append(toIndentedString(minRate)).append("\n");
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
