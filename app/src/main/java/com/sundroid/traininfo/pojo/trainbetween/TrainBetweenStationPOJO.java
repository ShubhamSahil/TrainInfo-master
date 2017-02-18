package com.sundroid.traininfo.pojo.trainbetween;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunil on 16-02-2017.
 */

public class TrainBetweenStationPOJO {
    @SerializedName("response_code")
    String response_code;
    @SerializedName("error")
    String error;
    @SerializedName("TrainPOJO")
    List<TrainPOJO> list_train_pojo;
    @SerializedName("total")
    String total;

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<TrainPOJO> getList_train_pojo() {
        return list_train_pojo;
    }

    public void setList_train_pojo(List<TrainPOJO> list_train_pojo) {
        this.list_train_pojo = list_train_pojo;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TrainBetweenStationPOJO{" +
                "response_code='" + response_code + '\'' +
                ", error='" + error + '\'' +
                ", list_train_pojo=" + list_train_pojo +
                ", total='" + total + '\'' +
                '}';
    }
}
