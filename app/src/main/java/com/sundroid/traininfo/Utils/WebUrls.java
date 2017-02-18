package com.sundroid.traininfo.Utils;

/**
 * Created by sunil on 11-02-2017.
 */

public class WebUrls {
    private final static String API_KEY="cq3tv2wm";
    public final static String BASE_URL="http://api.railwayapi.com";

    public static String getLiveTrainURL(String train_number,String date){
        return BASE_URL+"/live/TrainPOJO/"+train_number+"/doj/"+date+"/apikey/"+API_KEY;
    }

    public static String getPNRStatusURL(String pnr_no){
        return BASE_URL+"/pnr_status/pnr/"+pnr_no+"/apikey/"+API_KEY;
    }

    public static String getTrainRouteStatusURL(String train_no){
        return BASE_URL+"/route/TrainPOJO/"+train_no+"/apikey/"+API_KEY;
    }
    public static String getSeatAvailabilityURL(String train_no,String source_code,String destination_code,
                                                String date,String class_type,String quota){
        return BASE_URL+"/check_seat/TrainPOJO/"+train_no+"/source/"+source_code+"/dest/"+destination_code+
                "/date/"+date+"/class/"+class_type+"/quota/"+quota+"/apikey/"+API_KEY;
    }
    public static String getTrainBetweenStationURL(String source_code,String destination_code,String date){
        return BASE_URL+"/between/source/"+source_code+"/dest/"+destination_code+"/date/"+date+"/apikey/"+API_KEY;
    }

    public static String getTrainNameNumberURL(String name_num){
        return BASE_URL+"/name_number/TrainPOJO/"+name_num+"/apikey/"+API_KEY;
    }

    public static String getTrainFairURL(String train_number,String source_station_code,String destination,
                                         String age,String quota,String date){
        return BASE_URL+"/fare/train/"+train_number+"/source/"+source_station_code+"/dest/"+destination+
                "/age/"+age+"/quota/"+quota+"/doj/"+date+"/apikey/"+API_KEY;
    }
    public static String getTrainArrivalsURL(String station_code,String hours_to_search){
        return BASE_URL+"/arrivals/station/"+station_code+"/hours/"+hours_to_search+"/apikey/"+API_KEY;
    }

    public static String getCancelledTrainsURL(String date){
        return BASE_URL+"/cancelled/date/"+date+"/apikey/"+API_KEY;
    }

    public static String getRescheduledTrainsURL(String date){
        return BASE_URL+"/rescheduled/date/"+date+"/apikey/"+date;
    }
    public static String getStationNameToCodeURL(String station_name){
        return BASE_URL+"/name_to_code/station/"+station_name+"/apikey/"+API_KEY;
    }
    public static String getStationCodeToNameURL(String station_code){
        return BASE_URL+"/code_to_name/code/"+station_code+"/apikey/"+API_KEY;
    }

    public static String getStationAutoCompleteSuggestURL(String partial_station_name){
        return BASE_URL+"/suggest_station/name/"+partial_station_name+"/apikey/"+API_KEY;
    }

    public static String getTrainAutoCompleteSuggestURL(String partial_train_name){
        return BASE_URL+"/suggest_train/trains/"+partial_train_name+"/apikey/"+API_KEY;
    }

//response codes.
//    200	OK. Your request was successfully processed.
//    204	Empty response. Not able to fetch required data.
//            401	Authentication Error. You passed an unknown API Key.
//            403	Quota for the day exhausted. Applicable only for FREE users.
//            405	Account Expired. Renewal was not completed on time.

}
