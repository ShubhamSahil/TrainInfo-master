package com.sundroid.traininfo.pojo.trainnamenumber;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sunil on 16-02-2017.
 */

public class DaysPOJO {
    @SerializedName("runs")
    String runs;
    @SerializedName("day-code")
    String day_code;

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getDay_code() {
        return day_code;
    }

    public void setDay_code(String day_code) {
        this.day_code = day_code;
    }

    @Override
    public String toString() {
        return "DaysPOJO{" +
                "runs='" + runs + '\'' +
                ", day_code='" + day_code + '\'' +
                '}';
    }
}
