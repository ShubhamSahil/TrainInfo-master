package com.sundroid.traininfo.pojo.trainnamenumber;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunil on 16-02-2017.
 */

public class TrainPOJO {
    @SerializedName("name")
    String name;
    @SerializedName("days")
    List<DaysPOJO> list_days_pojo;
    @SerializedName("number")
    String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DaysPOJO> getList_days_pojo() {
        return list_days_pojo;
    }

    public void setList_days_pojo(List<DaysPOJO> list_days_pojo) {
        this.list_days_pojo = list_days_pojo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TrainPOJO{" +
                "name='" + name + '\'' +
                ", list_days_pojo=" + list_days_pojo +
                ", number='" + number + '\'' +
                '}';
    }
}
