package com.sundroid.traininfo.pojo.pnrstatus;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sunil on 16-02-2017.
 */

public class TrainStartDatePOJO {
    @SerializedName("day")
    String day;
    @SerializedName("year")
    String year;
    @SerializedName("month")
    String month;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "TrainStartDatePOJO{" +
                "day='" + day + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
