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
 * LoanPatch
 */
public class LoanPatch {
    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    /**
     * Loan side. Possible values are &#x60;lend&#x60; and &#x60;borrow&#x60;. For &#x60;LoanRecord&#x60; patching, only &#x60;lend&#x60; is supported
     */
    @JsonAdapter(SideEnum.Adapter.class)
    public enum SideEnum {
        LEND("lend"),
        
        BORROW("borrow");

        private String value;

        SideEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SideEnum fromValue(String value) {
            for (SideEnum b : SideEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<SideEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SideEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SideEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return SideEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_SIDE = "side";
    @SerializedName(SERIALIZED_NAME_SIDE)
    private SideEnum side;

    public static final String SERIALIZED_NAME_AUTO_RENEW = "auto_renew";
    @SerializedName(SERIALIZED_NAME_AUTO_RENEW)
    private Boolean autoRenew;

    public static final String SERIALIZED_NAME_CURRENCY_PAIR = "currency_pair";
    @SerializedName(SERIALIZED_NAME_CURRENCY_PAIR)
    private String currencyPair;

    public static final String SERIALIZED_NAME_LOAN_ID = "loan_id";
    @SerializedName(SERIALIZED_NAME_LOAN_ID)
    private String loanId;


    public LoanPatch currency(String currency) {
        
        this.currency = currency;
        return this;
    }

     /**
     * Loan currency
     * @return currency
    **/
    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LoanPatch side(SideEnum side) {
        
        this.side = side;
        return this;
    }

     /**
     * Loan side. Possible values are &#x60;lend&#x60; and &#x60;borrow&#x60;. For &#x60;LoanRecord&#x60; patching, only &#x60;lend&#x60; is supported
     * @return side
    **/
    public SideEnum getSide() {
        return side;
    }


    public void setSide(SideEnum side) {
        this.side = side;
    }

    public LoanPatch autoRenew(Boolean autoRenew) {
        
        this.autoRenew = autoRenew;
        return this;
    }

     /**
     * Auto renew
     * @return autoRenew
    **/
    public Boolean getAutoRenew() {
        return autoRenew;
    }


    public void setAutoRenew(Boolean autoRenew) {
        this.autoRenew = autoRenew;
    }

    public LoanPatch currencyPair(String currencyPair) {
        
        this.currencyPair = currencyPair;
        return this;
    }

     /**
     * Currency pair. Required if borrowing
     * @return currencyPair
    **/
    @javax.annotation.Nullable
    public String getCurrencyPair() {
        return currencyPair;
    }


    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public LoanPatch loanId(String loanId) {
        
        this.loanId = loanId;
        return this;
    }

     /**
     * Loan ID. Required for &#x60;LoanRecord&#x60; patching
     * @return loanId
    **/
    @javax.annotation.Nullable
    public String getLoanId() {
        return loanId;
    }


    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoanPatch loanPatch = (LoanPatch) o;
        return Objects.equals(this.currency, loanPatch.currency) &&
                Objects.equals(this.side, loanPatch.side) &&
                Objects.equals(this.autoRenew, loanPatch.autoRenew) &&
                Objects.equals(this.currencyPair, loanPatch.currencyPair) &&
                Objects.equals(this.loanId, loanPatch.loanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, side, autoRenew, currencyPair, loanId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoanPatch {\n");
        sb.append("      currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("      side: ").append(toIndentedString(side)).append("\n");
        sb.append("      autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
        sb.append("      currencyPair: ").append(toIndentedString(currencyPair)).append("\n");
        sb.append("      loanId: ").append(toIndentedString(loanId)).append("\n");
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

