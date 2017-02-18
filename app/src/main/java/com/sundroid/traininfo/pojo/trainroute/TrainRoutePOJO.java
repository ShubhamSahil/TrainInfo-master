package com.sundroid.traininfo.pojo.trainroute;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunil on 16-02-2017.
 */

public class TrainRoutePOJO {
    @SerializedName("response_code")
    String response_code;
    @SerializedName("TrainPOJO")
    TrainPOJO train_pojo;
    @SerializedName("route")
    List<RoutePOJO> list_route_pojo;

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

    public List<RoutePOJO> getList_route_pojo() {
        return list_route_pojo;
    }

    public void setList_route_pojo(List<RoutePOJO> list_route_pojo) {
        this.list_route_pojo = list_route_pojo;
    }

    @Override
    public String toString() {
        return "TrainRoutePOJO{" +
                "response_code='" + response_code + '\'' +
                ", train_pojo=" + train_pojo +
                ", list_route_pojo=" + list_route_pojo +
                '}';
    }
}
