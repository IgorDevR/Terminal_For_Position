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
 * Spot order details
 */
public class OrderPatch {
    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private String amount;

    public static final String SERIALIZED_NAME_PRICE = "price";
    @SerializedName(SERIALIZED_NAME_PRICE)
    private String price;

    public static final String SERIALIZED_NAME_AMEND_TEXT = "amend_text";
    @SerializedName(SERIALIZED_NAME_AMEND_TEXT)
    private String amendText;


    public OrderPatch amount(String amount) {
        
        this.amount = amount;
        return this;
    }

     /**
     * New order amount. &#x60;amount&#x60; and &#x60;price&#x60; must specify one of them
     * @return amount
    **/
    @javax.annotation.Nullable
    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

    public OrderPatch price(String price) {
        
        this.price = price;
        return this;
    }

     /**
     * New order price. &#x60;amount&#x60; and &#x60;Price&#x60; must specify one of them\&quot;
     * @return price
    **/
    @javax.annotation.Nullable
    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public OrderPatch amendText(String amendText) {
        
        this.amendText = amendText;
        return this;
    }

     /**
     * Custom info during amending order
     * @return amendText
    **/
    @javax.annotation.Nullable
    public String getAmendText() {
        return amendText;
    }


    public void setAmendText(String amendText) {
        this.amendText = amendText;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderPatch orderPatch = (OrderPatch) o;
        return Objects.equals(this.amount, orderPatch.amount) &&
                Objects.equals(this.price, orderPatch.price) &&
                Objects.equals(this.amendText, orderPatch.amendText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, price, amendText);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrderPatch {\n");
        sb.append("      amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("      price: ").append(toIndentedString(price)).append("\n");
        sb.append("      amendText: ").append(toIndentedString(amendText)).append("\n");
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

