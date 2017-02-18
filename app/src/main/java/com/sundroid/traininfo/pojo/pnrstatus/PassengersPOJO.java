package com.sundroid.traininfo.pojo.pnrstatus;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sunil on 16-02-2017.
 */

public class PassengersPOJO {
    @SerializedName("coach_position")
    String coach_position;
    @SerializedName("current_status")
    String current_status;
    @SerializedName("no")
    String no;
    @SerializedName("booking_status")
    String booking_status;

    public String getCoach_position() {
        return coach_position;
    }

    public void setCoach_position(String coach_position) {
        this.coach_position = coach_position;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(String booking_status) {
        this.booking_status = booking_status;
    }

    @Override
    public String toString() {
        return "PassengersPOJO{" +
                "coach_position='" + coach_position + '\'' +
                ", current_status='" + current_status + '\'' +
                ", no='" + no + '\'' +
                ", booking_status='" + booking_status + '\'' +
                '}';
    }
}
