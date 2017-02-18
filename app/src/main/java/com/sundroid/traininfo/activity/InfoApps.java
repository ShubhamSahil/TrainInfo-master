package com.sundroid.traininfo.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Address;

import java.util.ArrayList;

/**
 * Created by emobi5 on 4/15/2016.
 */
public class InfoApps {

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getStation_code() {
        return station_code;
    }

    public void setStation_code(String station_code) {
        this.station_code = station_code;
    }

    public String getTrain_status() {
        return train_status;
    }

    public void setTrain_status(String train_status) {
        this.train_status = train_status;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getScharr_expectedarrivaltime() {
        return scharr_expectedarrivaltime;
    }

    public void setScharr_expectedarrivaltime(String scharr_expectedarrivaltime) {
        this.scharr_expectedarrivaltime = scharr_expectedarrivaltime;
    }

    public String getSchdeptime() {
        return schdeptime;
    }

    public void setSchdeptime(String schdeptime) {
        this.schdeptime = schdeptime;
    }

    public String getPlatform_no() {
        return platform_no;
    }

    public void setPlatform_no(String platform_no) {
        this.platform_no = platform_no;
    }

    public String getStation_distance() {
        return station_distance;
    }

    public void setStation_distance(String station_distance) {
        this.station_distance = station_distance;
    }

    private String station_name;
    private String station_code;
    private String train_status;
    private String day;
    private String scharr_expectedarrivaltime;
    private String schdeptime;
    private String platform_no;
    private String station_distance;

    public String getActarr_expectedarrivaltime() {
        return actarr_expectedarrivaltime;
    }

    public void setActarr_expectedarrivaltime(String actarr_expectedarrivaltime) {
        this.actarr_expectedarrivaltime = actarr_expectedarrivaltime;
    }

    private String actarr_expectedarrivaltime;


    @Override
    public String toString() {

        return "Name:-"+station_distance+",Number:-"+schdeptime;
    }
}
