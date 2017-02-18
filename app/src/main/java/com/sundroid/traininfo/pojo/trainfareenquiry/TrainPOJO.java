package com.sundroid.traininfo.pojo.trainfareenquiry;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sunil on 16-02-2017.
 */

public class TrainPOJO {
    @SerializedName("number")
    String number;
    @SerializedName("name")
    String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TrainPOJO{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
