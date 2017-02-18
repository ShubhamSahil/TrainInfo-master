package com.sundroid.traininfo.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.sundroid.traininfo.R;
import com.sundroid.traininfo.activity.InfoApps;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Emobi-Android-002 on 8/24/2016.
 */
public class Trainlive_runningAdapter extends RecyclerView.Adapter<Trainlive_runningAdapter.MyViewHolder> {
    Boolean flag = false;
    private List<InfoApps> traininfoList;
    Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, txt_depature_time, txt_status,txt_station_name,time;
        public TextView txt_day;
        public TextView platform;
        public TextView txt_act_time;
        ImageView medication, prescription;
        CircleImageView img_profile;
        Button status;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_arrival_name);
            txt_status = (TextView) view.findViewById(R.id.txt_status);
            txt_station_name = (TextView) view.findViewById(R.id.txt_station_name);
            txt_depature_time = (TextView) view.findViewById(R.id.txt_depature_time);
            txt_day = (TextView) view.findViewById(R.id.txt_day);
            platform = (TextView) view.findViewById(R.id.platform);
            txt_act_time = (TextView) view.findViewById(R.id.txt_act_time);



        }
    }


    public Trainlive_runningAdapter(List<InfoApps> moviesList, Context ctx) {
        this.traininfoList = moviesList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_traininformation_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        InfoApps movie = traininfoList.get(position);


        try{
            String time = movie.getTrain_status().split(" ")[0];
            if (time.equals("0")){
                holder.txt_status.setText("On time");
            }else {
                int t = Integer.parseInt(time);
                int hours = t / 60; //since both are ints, you get an int
                int minutes = t % 60;
                System.out.printf("%d:%02d", hours, minutes);
                String time1 = hours+"";
                if (time1.equals("0")){
                    holder.txt_status.setText(minutes + " " + "mins late");
                }
                else {
                    holder.txt_status.setText(hours + "hr." +" "+minutes + " " + "mins late");
                }}
        }
        catch (Exception e){
            e.toString();
            holder.txt_status.setText(movie.getTrain_status());
        }
        holder.title.setText(movie.getScharr_expectedarrivaltime());
        holder.txt_day.setText(movie.getDay());
        holder.platform.setText(movie.getPlatform_no());
        holder.txt_depature_time.setText(movie.getSchdeptime());
        holder.txt_station_name.setText(movie.getStation_name());
        holder.txt_act_time.setText(movie.getActarr_expectedarrivaltime());
        Typeface tf= Typeface.createFromAsset(ctx.getAssets(),"fonts/Roboto-Regular.ttf");
        holder.title.setTypeface(tf);
        holder.txt_status.setTypeface(tf);
        holder.txt_station_name.setTypeface(tf);
        holder.platform.setTypeface(tf);

    }

    @Override
    public int getItemCount() {
        return traininfoList.size();
    }
}
