package com.sundroid.traininfo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sundroid.traininfo.R;
import com.sundroid.traininfo.Utils.WebUrls;
import com.sundroid.traininfo.adapter.Trainlive_runningAdapter;
import com.sundroid.traininfo.webservices.WebServiceBase;
import com.sundroid.traininfo.webservices.WebServicesCallBack;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveTrainStatusActivity extends AppCompatActivity implements View.OnClickListener,
        DatePickerDialog.OnDateSetListener,WebServicesCallBack{
    private final static String LIVE_TRAIN_API_CALL="live_train_api_call";
    private final String TAG=getClass().getSimpleName();
    public  ArrayList<InfoApps> traindataarray;
    InfoApps Userdatas;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_train_number)
    EditText et_train_number;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.btn_search)
    Button btn_search;
    Trainlive_runningAdapter mAdapterbroad;
    private RecyclerView mRecyclerView;
    private LinearLayout linearlayout;
    String string_date="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_train_status);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        traindataarray=new ArrayList<InfoApps>();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        linearlayout = (LinearLayout) findViewById(R.id.linearlayout);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(LiveTrainStatusActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        tv_date.setOnClickListener(this);
        btn_search.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.tv_date:
                selectDate();
                break;
            case R.id.btn_search:
                callAPI();
                break;
        }
    }
    public void callAPI(){
        if(et_train_number.getText().toString().length()>0&&string_date.length()>0) {
            String url = WebUrls.getLiveTrainURL(et_train_number.getText().toString(), string_date);
            string_date = "";
            Log.d(TAG,"url:-"+url);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            new WebServiceBase(nameValuePairs, this, LIVE_TRAIN_API_CALL).execute(url);
        }
        else{
            Toast.makeText(getApplicationContext(),"Please Enter Information Correctly",Toast.LENGTH_LONG).show();
        }
    }
    public void selectDate(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                LiveTrainStatusActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        int month=monthOfYear+1;
        if(String.valueOf(month).length()==1){
            string_date=String.valueOf(year)+"0"+String.valueOf(month)+String.valueOf(dayOfMonth);
        }
        else{
            string_date=String.valueOf(year)+String.valueOf(month)+String.valueOf(dayOfMonth);
        }

        tv_date.setText(dayOfMonth+"/"+month+"/"+year);
    }

    @Override
    public void onGetMsg(String[] msg) {
        String apicall=msg[0];
        String response=msg[1];
        switch (apicall){
            case LIVE_TRAIN_API_CALL:
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("route");
                    for (int i =0; i<jsonArray.length();i++){
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        JSONObject jsonObject2=jsonObject1.getJSONObject("station_");
                        String station_name = jsonObject2.getString("name");
                        String  station_code=jsonObject2.getString("code");
                        String  train_status=jsonObject1.getString("status");
                        String  day=jsonObject1.getString("day");
                        String  scharr_expectedarrivaltime=jsonObject1.getString("scharr");
                        String  actarr_expectedarrivaltime=jsonObject1.getString("actarr");
                        String  actdep_expectedarrivaltime=jsonObject1.getString("actdep");
                        String  schdeptime=jsonObject1.getString("schdep");
                        String  platform_no=jsonObject1.getString("no");
                        String  station_distance=jsonObject1.getString("distance");
                        Userdatas = new InfoApps();
                        Userdatas.setStation_name(station_name+ " "+"("+station_code+")");
                        Userdatas.setStation_code(station_code);
                        Userdatas.setTrain_status(train_status);
                        Userdatas.setDay(day);
                        Userdatas.setScharr_expectedarrivaltime(scharr_expectedarrivaltime);
                        Userdatas.setSchdeptime(schdeptime);
                        Userdatas.setActarr_expectedarrivaltime(actarr_expectedarrivaltime+ " "+ "/"+actdep_expectedarrivaltime);
                        Userdatas.setPlatform_no(platform_no);
                        Userdatas.setStation_distance(station_distance);
                        traindataarray.add(Userdatas);
                        mRecyclerView.setVisibility(View.VISIBLE);
                        btn_search.setVisibility(View.GONE);
                        linearlayout.setVisibility(View.GONE);
                        mAdapterbroad = new Trainlive_runningAdapter(traindataarray, LiveTrainStatusActivity.this);
                        mRecyclerView.setAdapter(mAdapterbroad);

                    }
                }
                catch (Exception e){
                    Log.d("error",e.toString());
                }
                Log.d(TAG,"response:-"+response);
                break;
        }
    }

}
