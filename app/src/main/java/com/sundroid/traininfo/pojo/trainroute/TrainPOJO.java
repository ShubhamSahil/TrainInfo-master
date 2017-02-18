package com.sundroid.traininfo.pojo.trainroute;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunil on 16-02-2017.
 */

public class TrainPOJO {
    @SerializedName("classes")
    List<ClassesPOJO> list_classes;
    @SerializedName("DaysPOJO")
    List<DaysPOJO> list_days;
    @SerializedName("name")
    String name;
    @SerializedName("number")
    String number;

    public List<ClassesPOJO> getList_classes() {
        return list_classes;
    }

    public void setList_classes(List<ClassesPOJO> list_classes) {
        this.list_classes = list_classes;
    }

    public List<DaysPOJO> getList_days() {
        return list_days;
    }

    public void setList_days(List<DaysPOJO> list_days) {
        this.list_days = list_days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "list_classes=" + list_classes +
                ", list_days=" + list_days +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
