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
 * CrossMarginBalance
 */
public class CrossMarginBalance {
    public static final String SERIALIZED_NAME_AVAILABLE = "available";
    @SerializedName(SERIALIZED_NAME_AVAILABLE)
    private String available;

    public static final String SERIALIZED_NAME_FREEZE = "freeze";
    @SerializedName(SERIALIZED_NAME_FREEZE)
    private String freeze;

    public static final String SERIALIZED_NAME_BORROWED = "borrowed";
    @SerializedName(SERIALIZED_NAME_BORROWED)
    private String borrowed;

    public static final String SERIALIZED_NAME_INTEREST = "interest";
    @SerializedName(SERIALIZED_NAME_INTEREST)
    private String interest;

    public static final String SERIALIZED_NAME_NEGATIVE_LIAB = "negative_liab";
    @SerializedName(SERIALIZED_NAME_NEGATIVE_LIAB)
    private String negativeLiab;

    public static final String SERIALIZED_NAME_FUTURES_POS_LIAB = "futures_pos_liab";
    @SerializedName(SERIALIZED_NAME_FUTURES_POS_LIAB)
    private String futuresPosLiab;

    public static final String SERIALIZED_NAME_EQUITY = "equity";
    @SerializedName(SERIALIZED_NAME_EQUITY)
    private String equity;

    public static final String SERIALIZED_NAME_TOTAL_FREEZE = "total_freeze";
    @SerializedName(SERIALIZED_NAME_TOTAL_FREEZE)
    private String totalFreeze;

    public static final String SERIALIZED_NAME_TOTAL_LIAB = "total_liab";
    @SerializedName(SERIALIZED_NAME_TOTAL_LIAB)
    private String totalLiab;


    public CrossMarginBalance available(String available) {
        
        this.available = available;
        return this;
    }

     /**
     * Available amount
     * @return available
    **/
    @javax.annotation.Nullable
    public String getAvailable() {
        return available;
    }


    public void setAvailable(String available) {
        this.available = available;
    }

    public CrossMarginBalance freeze(String freeze) {
        
        this.freeze = freeze;
        return this;
    }

     /**
     * Locked amount
     * @return freeze
    **/
    @javax.annotation.Nullable
    public String getFreeze() {
        return freeze;
    }


    public void setFreeze(String freeze) {
        this.freeze = freeze;
    }

    public CrossMarginBalance borrowed(String borrowed) {
        
        this.borrowed = borrowed;
        return this;
    }

     /**
     * Borrowed amount
     * @return borrowed
    **/
    @javax.annotation.Nullable
    public String getBorrowed() {
        return borrowed;
    }


    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }

    public CrossMarginBalance interest(String interest) {
        
        this.interest = interest;
        return this;
    }

     /**
     * Unpaid interests
     * @return interest
    **/
    @javax.annotation.Nullable
    public String getInterest() {
        return interest;
    }


    public void setInterest(String interest) {
        this.interest = interest;
    }

    public CrossMarginBalance negativeLiab(String negativeLiab) {
        
        this.negativeLiab = negativeLiab;
        return this;
    }

     /**
     * Negative Liabilities. Formula:Min[available+total+unrealized_pnl,0]
     * @return negativeLiab
    **/
    @javax.annotation.Nullable
    public String getNegativeLiab() {
        return negativeLiab;
    }


    public void setNegativeLiab(String negativeLiab) {
        this.negativeLiab = negativeLiab;
    }

    public CrossMarginBalance futuresPosLiab(String futuresPosLiab) {
        
        this.futuresPosLiab = futuresPosLiab;
        return this;
    }

     /**
     * Borrowing to Open Positions in Futures
     * @return futuresPosLiab
    **/
    @javax.annotation.Nullable
    public String getFuturesPosLiab() {
        return futuresPosLiab;
    }


    public void setFuturesPosLiab(String futuresPosLiab) {
        this.futuresPosLiab = futuresPosLiab;
    }

    public CrossMarginBalance equity(String equity) {
        
        this.equity = equity;
        return this;
    }

     /**
     * Equity. Formula: available + freeze - borrowed + total + unrealized_pnl
     * @return equity
    **/
    @javax.annotation.Nullable
    public String getEquity() {
        return equity;
    }


    public void setEquity(String equity) {
        this.equity = equity;
    }

    public CrossMarginBalance totalFreeze(String totalFreeze) {
        
        this.totalFreeze = totalFreeze;
        return this;
    }

     /**
     * Total freeze. Formula: position_initial_margin + order_margin
     * @return totalFreeze
    **/
    @javax.annotation.Nullable
    public String getTotalFreeze() {
        return totalFreeze;
    }


    public void setTotalFreeze(String totalFreeze) {
        this.totalFreeze = totalFreeze;
    }

    public CrossMarginBalance totalLiab(String totalLiab) {
        
        this.totalLiab = totalLiab;
        return this;
    }

     /**
     * Total liabilities. Formula: Max[Abs[Min[quity - total_freeze,0], borrowed]] - futures_pos_liab
     * @return totalLiab
    **/
    @javax.annotation.Nullable
    public String getTotalLiab() {
        return totalLiab;
    }


    public void setTotalLiab(String totalLiab) {
        this.totalLiab = totalLiab;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CrossMarginBalance crossMarginBalance = (CrossMarginBalance) o;
        return Objects.equals(this.available, crossMarginBalance.available) &&
                Objects.equals(this.freeze, crossMarginBalance.freeze) &&
                Objects.equals(this.borrowed, crossMarginBalance.borrowed) &&
                Objects.equals(this.interest, crossMarginBalance.interest) &&
                Objects.equals(this.negativeLiab, crossMarginBalance.negativeLiab) &&
                Objects.equals(this.futuresPosLiab, crossMarginBalance.futuresPosLiab) &&
                Objects.equals(this.equity, crossMarginBalance.equity) &&
                Objects.equals(this.totalFreeze, crossMarginBalance.totalFreeze) &&
                Objects.equals(this.totalLiab, crossMarginBalance.totalLiab);
    }

    @Override
    public int hashCode() {
        return Objects.hash(available, freeze, borrowed, interest, negativeLiab, futuresPosLiab, equity, totalFreeze, totalLiab);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CrossMarginBalance {\n");
        sb.append("      available: ").append(toIndentedString(available)).append("\n");
        sb.append("      freeze: ").append(toIndentedString(freeze)).append("\n");
        sb.append("      borrowed: ").append(toIndentedString(borrowed)).append("\n");
        sb.append("      interest: ").append(toIndentedString(interest)).append("\n");
        sb.append("      negativeLiab: ").append(toIndentedString(negativeLiab)).append("\n");
        sb.append("      futuresPosLiab: ").append(toIndentedString(futuresPosLiab)).append("\n");
        sb.append("      equity: ").append(toIndentedString(equity)).append("\n");
        sb.append("      totalFreeze: ").append(toIndentedString(totalFreeze)).append("\n");
        sb.append("      totalLiab: ").append(toIndentedString(totalLiab)).append("\n");
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
