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
 * data point in every timestamp
 */
public class FuturesPremiumIndex {
    public static final String SERIALIZED_NAME_T = "t";
    @SerializedName(SERIALIZED_NAME_T)
    private Double t;

    public static final String SERIALIZED_NAME_C = "c";
    @SerializedName(SERIALIZED_NAME_C)
    private String c;

    public static final String SERIALIZED_NAME_H = "h";
    @SerializedName(SERIALIZED_NAME_H)
    private String h;

    public static final String SERIALIZED_NAME_L = "l";
    @SerializedName(SERIALIZED_NAME_L)
    private String l;

    public static final String SERIALIZED_NAME_O = "o";
    @SerializedName(SERIALIZED_NAME_O)
    private String o;


    public FuturesPremiumIndex t(Double t) {
        
        this.t = t;
        return this;
    }

     /**
     * Unix timestamp in seconds
     * @return t
    **/
    @javax.annotation.Nullable
    public Double getT() {
        return t;
    }


    public void setT(Double t) {
        this.t = t;
    }

    public FuturesPremiumIndex c(String c) {
        
        this.c = c;
        return this;
    }

     /**
     * Close price
     * @return c
    **/
    @javax.annotation.Nullable
    public String getC() {
        return c;
    }


    public void setC(String c) {
        this.c = c;
    }

    public FuturesPremiumIndex h(String h) {
        
        this.h = h;
        return this;
    }

     /**
     * Highest price
     * @return h
    **/
    @javax.annotation.Nullable
    public String getH() {
        return h;
    }


    public void setH(String h) {
        this.h = h;
    }

    public FuturesPremiumIndex l(String l) {
        
        this.l = l;
        return this;
    }

     /**
     * Lowest price&#x60;
     * @return l
    **/
    @javax.annotation.Nullable
    public String getL() {
        return l;
    }


    public void setL(String l) {
        this.l = l;
    }

    public FuturesPremiumIndex o(String o) {
        
        this.o = o;
        return this;
    }

     /**
     * Open price
     * @return o
    **/
    @javax.annotation.Nullable
    public String getO() {
        return o;
    }


    public void setO(String o) {
        this.o = o;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FuturesPremiumIndex futuresPremiumIndex = (FuturesPremiumIndex) o;
        return Objects.equals(this.t, futuresPremiumIndex.t) &&
                Objects.equals(this.c, futuresPremiumIndex.c) &&
                Objects.equals(this.h, futuresPremiumIndex.h) &&
                Objects.equals(this.l, futuresPremiumIndex.l) &&
                Objects.equals(this.o, futuresPremiumIndex.o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, c, h, l, o);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FuturesPremiumIndex {\n");
        sb.append("      t: ").append(toIndentedString(t)).append("\n");
        sb.append("      c: ").append(toIndentedString(c)).append("\n");
        sb.append("      h: ").append(toIndentedString(h)).append("\n");
        sb.append("      l: ").append(toIndentedString(l)).append("\n");
        sb.append("      o: ").append(toIndentedString(o)).append("\n");
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

