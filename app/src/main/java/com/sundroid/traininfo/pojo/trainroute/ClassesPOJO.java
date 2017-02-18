package com.sundroid.traininfo.pojo.trainroute;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sunil on 16-02-2017.
 */

public class ClassesPOJO {
    @SerializedName("class-code")
    String class_code;
    @SerializedName("available")
    String available;

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ClassesPOJO{" +
                "class_code='" + class_code + '\'' +
                ", available='" + available + '\'' +
                '}';
    }
}
