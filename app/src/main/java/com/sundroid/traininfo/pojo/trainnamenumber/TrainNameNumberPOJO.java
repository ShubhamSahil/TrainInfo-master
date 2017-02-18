package com.sundroid.traininfo.pojo.trainnamenumber;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sunil on 16-02-2017.
 */

public class TrainNameNumberPOJO {
    @SerializedName("response_code")
    String response_code;
    @SerializedName("train")
    TrainPOJO train_pojo;

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public TrainPOJO getTrain_pojo() {
        return train_pojo;
    }

    public void setTrain_pojo(TrainPOJO train_pojo) {
        this.train_pojo = train_pojo;
    }

    @Override
    public String toString() {
        return "TrainNameNumberPOJO{" +
                "response_code='" + response_code + '\'' +
                ", train_pojo=" + train_pojo +
                '}';
    }
}
