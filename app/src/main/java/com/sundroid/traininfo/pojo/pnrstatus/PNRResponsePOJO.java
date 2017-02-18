package com.sundroid.traininfo.pojo.pnrstatus;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunil on 16-02-2017.
 */

public class PNRResponsePOJO {
    @SerializedName("failure_rate")
    String failure_rate;
    @SerializedName("reservation_upto")
    ReservationUptoPOJO reservation_upto;
    @SerializedName("class")
    String class_pnr;
    @SerializedName("passengers")
    List<PassengersPOJO> list_passengers;
    @SerializedName("from_station")
    FromStationPOJO from_station;
    @SerializedName("train_name")
    String train_name;
    @SerializedName("to_station")
    ToStationPOJO to_station;
    @SerializedName("pnr")
    String pnr;
    @SerializedName("doj")
    String doj;
    @SerializedName("error")
    String error;
    @SerializedName("train_start_date")
    TrainStartDatePOJO train_start_date;
    @SerializedName("response_code")
    String response_code;
    @SerializedName("chart_prepared")
    String chart_prepared;
    @SerializedName("boarding_point")
    BoardingPintPOJO pnboarding_pointr;
    @SerializedName("train_num")
    String train_num;
    @SerializedName("total_passengers")
    String total_passengers;

    public String getFailure_rate() {
        return failure_rate;
    }

    public void setFailure_rate(String failure_rate) {
        this.failure_rate = failure_rate;
    }

    public ReservationUptoPOJO getReservation_upto() {
        return reservation_upto;
    }

    public void setReservation_upto(ReservationUptoPOJO reservation_upto) {
        this.reservation_upto = reservation_upto;
    }

    public String getClass_pnr() {
        return class_pnr;
    }

    public void setClass_pnr(String class_pnr) {
        this.class_pnr = class_pnr;
    }

    public List<PassengersPOJO> getList_passengers() {
        return list_passengers;
    }

    public void setList_passengers(List<PassengersPOJO> list_passengers) {
        this.list_passengers = list_passengers;
    }

    public FromStationPOJO getFrom_station() {
        return from_station;
    }

    public void setFrom_station(FromStationPOJO from_station) {
        this.from_station = from_station;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public ToStationPOJO getTo_station() {
        return to_station;
    }

    public void setTo_station(ToStationPOJO to_station) {
        this.to_station = to_station;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public TrainStartDatePOJO getTrain_start_date() {
        return train_start_date;
    }

    public void setTrain_start_date(TrainStartDatePOJO train_start_date) {
        this.train_start_date = train_start_date;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getChart_prepared() {
        return chart_prepared;
    }

    public void setChart_prepared(String chart_prepared) {
        this.chart_prepared = chart_prepared;
    }

    public BoardingPintPOJO getPnboarding_pointr() {
        return pnboarding_pointr;
    }

    public void setPnboarding_pointr(BoardingPintPOJO pnboarding_pointr) {
        this.pnboarding_pointr = pnboarding_pointr;
    }

    public String getTrain_num() {
        return train_num;
    }

    public void setTrain_num(String train_num) {
        this.train_num = train_num;
    }

    public String getTotal_passengers() {
        return total_passengers;
    }

    public void setTotal_passengers(String total_passengers) {
        this.total_passengers = total_passengers;
    }

    @Override
    public String toString() {
        return "PNRResponsePOJO{" +
                "failure_rate='" + failure_rate + '\'' +
                ", reservation_upto=" + reservation_upto +
                ", class_pnr='" + class_pnr + '\'' +
                ", list_passengers=" + list_passengers +
                ", from_station=" + from_station +
                ", train_name='" + train_name + '\'' +
                ", to_station=" + to_station +
                ", pnr='" + pnr + '\'' +
                ", doj='" + doj + '\'' +
                ", error='" + error + '\'' +
                ", train_start_date=" + train_start_date +
                ", response_code='" + response_code + '\'' +
                ", chart_prepared='" + chart_prepared + '\'' +
                ", pnboarding_pointr=" + pnboarding_pointr +
                ", train_num='" + train_num + '\'' +
                ", total_passengers='" + total_passengers + '\'' +
                '}';
    }
}
