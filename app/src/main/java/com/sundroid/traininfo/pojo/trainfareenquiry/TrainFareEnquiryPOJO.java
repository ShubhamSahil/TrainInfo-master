package com.sundroid.traininfo.pojo.trainfareenquiry;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunil on 16-02-2017.
 */

public class TrainFareEnquiryPOJO {
    @SerializedName("train")
    TrainPOJO train_fare_pojo;
    @SerializedName("quota")
    QuotaPOJO quota_pojo;
    @SerializedName("failure_rate")
    String failure_rate;
    @SerializedName("to")
    ToPOJO toPOJO;
    @SerializedName("response_code")
    String response_code;
    @SerializedName("fare")
    List<FarePOJO> list_fare;
    @SerializedName("from")
    FromPOJO fromPOJO;


    public TrainPOJO getTrain_fare_pojo() {
        return train_fare_pojo;
    }

    public void setTrain_fare_pojo(TrainPOJO train_fare_pojo) {
        this.train_fare_pojo = train_fare_pojo;
    }

    public QuotaPOJO getQuota_pojo() {
        return quota_pojo;
    }

    public void setQuota_pojo(QuotaPOJO quota_pojo) {
        this.quota_pojo = quota_pojo;
    }

    public String getFailure_rate() {
        return failure_rate;
    }

    public void setFailure_rate(String failure_rate) {
        this.failure_rate = failure_rate;
    }

    public ToPOJO getToPOJO() {
        return toPOJO;
    }

    public void setToPOJO(ToPOJO toPOJO) {
        this.toPOJO = toPOJO;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public List<FarePOJO> getList_fare() {
        return list_fare;
    }

    public void setList_fare(List<FarePOJO> list_fare) {
        this.list_fare = list_fare;
    }

    public FromPOJO getFromPOJO() {
        return fromPOJO;
    }

    public void setFromPOJO(FromPOJO fromPOJO) {
        this.fromPOJO = fromPOJO;
    }

    @Override
    public String toString() {
        return "TrainFareEnquiryPOJO{" +
                "train_fare_pojo=" + train_fare_pojo +
                ", quota_pojo=" + quota_pojo +
                ", failure_rate='" + failure_rate + '\'' +
                ", toPOJO=" + toPOJO +
                ", response_code='" + response_code + '\'' +
                ", list_fare=" + list_fare +
                ", fromPOJO=" + fromPOJO +
                '}';
    }
}
