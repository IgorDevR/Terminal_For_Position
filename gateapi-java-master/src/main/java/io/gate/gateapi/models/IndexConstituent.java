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
import java.util.ArrayList;
import java.util.List;

/**
 * IndexConstituent
 */
public class IndexConstituent {
    public static final String SERIALIZED_NAME_EXCHANGE = "exchange";
    @SerializedName(SERIALIZED_NAME_EXCHANGE)
    private String exchange;

    public static final String SERIALIZED_NAME_SYMBOLS = "symbols";
    @SerializedName(SERIALIZED_NAME_SYMBOLS)
    private List<String> symbols = null;


    public IndexConstituent exchange(String exchange) {
        
        this.exchange = exchange;
        return this;
    }

     /**
     * Exchange
     * @return exchange
    **/
    @javax.annotation.Nullable
    public String getExchange() {
        return exchange;
    }


    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public IndexConstituent symbols(List<String> symbols) {
        
        this.symbols = symbols;
        return this;
    }

    public IndexConstituent addSymbolsItem(String symbolsItem) {
        if (this.symbols == null) {
            this.symbols = new ArrayList<>();
        }
        this.symbols.add(symbolsItem);
        return this;
    }

     /**
     * Symbol list
     * @return symbols
    **/
    @javax.annotation.Nullable
    public List<String> getSymbols() {
        return symbols;
    }


    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IndexConstituent indexConstituent = (IndexConstituent) o;
        return Objects.equals(this.exchange, indexConstituent.exchange) &&
                Objects.equals(this.symbols, indexConstituent.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchange, symbols);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IndexConstituent {\n");
        sb.append("      exchange: ").append(toIndentedString(exchange)).append("\n");
        sb.append("      symbols: ").append(toIndentedString(symbols)).append("\n");
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

