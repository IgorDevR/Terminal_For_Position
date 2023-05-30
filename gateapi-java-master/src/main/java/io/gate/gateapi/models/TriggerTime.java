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
 * TriggerTime
 */
public class TriggerTime {
    public static final String SERIALIZED_NAME_TRIGGER_TIME = "triggerTime";
    @SerializedName(SERIALIZED_NAME_TRIGGER_TIME)
    private Long triggerTime;


    public TriggerTime triggerTime(Long triggerTime) {
        
        this.triggerTime = triggerTime;
        return this;
    }

     /**
     * Timestamp of the end of the countdown, in milliseconds
     * @return triggerTime
    **/
    @javax.annotation.Nullable
    public Long getTriggerTime() {
        return triggerTime;
    }


    public void setTriggerTime(Long triggerTime) {
        this.triggerTime = triggerTime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TriggerTime triggerTime = (TriggerTime) o;
        return Objects.equals(this.triggerTime, triggerTime.triggerTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(triggerTime);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TriggerTime {\n");
        sb.append("      triggerTime: ").append(toIndentedString(triggerTime)).append("\n");
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

