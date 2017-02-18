package com.sundroid.traininfo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sundroid.traininfo.R;
import com.sundroid.traininfo.Utils.WebUrls;
import com.sundroid.traininfo.pojo.trainbetween.TrainBetweenStationPOJO;
import com.sundroid.traininfo.webservices.WebServiceBase;
import com.sundroid.traininfo.webservices.WebServicesCallBack;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TrainBetweenStationActivity extends AppCompatActivity implements WebServicesCallBack,View.OnClickListener,DatePickerDialog.OnDateSetListener{
    private final static String TRAIN_BETWEEN_STATION="train_between_station";
    private final String TAG=getClass().getSimpleName();


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_source_station)
    EditText et_source_station;
    @BindView(R.id.et_dest_station)
    EditText et_dest_station;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.btn_search)
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_between_station);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
            case R.id.btn_search:
                callAPI();
                break;
            case R.id.tv_date:
                callDateDialog();
                break;
        }
    }
    public void callDateDialog(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                TrainBetweenStationActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void callAPI(){
        if(et_source_station.getText().toString().length()>0&&et_dest_station.getText().toString().length()>0
                &&tv_date.getText().toString().length()>0) {
            String url = WebUrls.getTrainBetweenStationURL(et_source_station.getText().toString(),
                    et_dest_station.getText().toString(),tv_date.getText().toString());
            Log.d(TAG,"url:-"+url);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            new WebServiceBase(nameValuePairs, this, TRAIN_BETWEEN_STATION).execute(url);
        }
        else{
            Toast.makeText(getApplicationContext(),"Please Enter Information Correctly",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onGetMsg(String[] msg) {
        String apicall=msg[0];
        String response=msg[1];
        switch (apicall){
            case TRAIN_BETWEEN_STATION:
//                Log.d(TAG,"response:-"+response);
                parseTrainBetweenStationResponse(response);
                break;
        }
    }
    public void parseTrainBetweenStationResponse(String response){
        Gson gson=new Gson();
        TrainBetweenStationPOJO pojo=gson.fromJson(response,TrainBetweenStationPOJO.class);
        if(pojo!=null){
            try{
                if(pojo.getResponse_code().equals("200")){
                    Log.d(TAG,"TrainPOJO Between response:-"+pojo.toString());
                }else{
                    Toast.makeText(getApplicationContext(),"No Response",Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e){
                Log.d(TAG,"error:-"+e.toString());
            }
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        tv_date.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+year);
    }
}
