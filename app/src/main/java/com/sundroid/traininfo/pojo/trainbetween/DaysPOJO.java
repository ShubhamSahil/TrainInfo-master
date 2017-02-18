package com.sundroid.traininfo.pojo.trainbetween;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sunil on 16-02-2017.
 */

public class DaysPOJO {
    @SerializedName("day-code")
    String day_code;
    @SerializedName("runs")
    String runs;

    public String getDay_code() {
        return day_code;
    }

    public void setDay_code(String day_code) {
        this.day_code = day_code;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    @Override
    public String toString() {
        return "DaysPOJO{" +
                "day_code='" + day_code + '\'' +
                ", runs='" + runs + '\'' +
                '}';
    }
}
