package com.sundroid.traininfo.pojo.trainroute;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sunil on 16-02-2017.
 */

public class RoutePOJO {
    @SerializedName("schdep")
    String schdep;
    @SerializedName("scharr")
    String scharr;
    @SerializedName("lat")
    String lat;
    @SerializedName("no")
    String no;
    @SerializedName("code")
    String code;
    @SerializedName("route")
    String route;
    @SerializedName("distance")
    String distance;
    @SerializedName("day")
    String day;
    @SerializedName("halt")
    String halt;
    @SerializedName("lng")
    String lng;
    @SerializedName("fullname")
    String fullname;
    @SerializedName("state")
    String state;

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHalt() {
        return halt;
    }

    public void setHalt(String halt) {
        this.halt = halt;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RoutePOJO{" +
                "schdep='" + schdep + '\'' +
                ", scharr='" + scharr + '\'' +
                ", lat='" + lat + '\'' +
                ", no='" + no + '\'' +
                ", code='" + code + '\'' +
                ", route='" + route + '\'' +
                ", distance='" + distance + '\'' +
                ", day='" + day + '\'' +
                ", halt='" + halt + '\'' +
                ", lng='" + lng + '\'' +
                ", fullname='" + fullname + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
