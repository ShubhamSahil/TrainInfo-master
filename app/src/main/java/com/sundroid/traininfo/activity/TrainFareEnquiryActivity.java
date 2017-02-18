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
import com.sundroid.traininfo.pojo.trainfareenquiry.TrainFareEnquiryPOJO;
import com.sundroid.traininfo.webservices.WebServiceBase;
import com.sundroid.traininfo.webservices.WebServicesCallBack;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainFareEnquiryActivity extends AppCompatActivity implements View.OnClickListener, WebServicesCallBack, DatePickerDialog.OnDateSetListener {
    private final String TAG = getClass().getSimpleName();
    private final static String TRAIN_FAIR_API="train_fair_api";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_train_number)
    EditText et_train_number;
    @BindView(R.id.et_source_station)
    EditText et_source_station;
    @BindView(R.id.et_destination_station)
    EditText et_destination_station;
    @BindView(R.id.et_age)
    EditText et_age;
    @BindView(R.id.et_quota)
    EditText et_quota;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.btn_search)
    Button btn_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_fare_enquiry);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tv_date.setOnClickListener(this);
        btn_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_search:
                callTrainAPI();
                break;
            case R.id.tv_date:
                callDateDialog();
                break;
        }
    }

    public void callTrainAPI() {
        if (et_source_station.getText().toString().length() > 0 && et_destination_station.getText().toString().length() > 0
                && et_age.getText().toString().length() > 0 && et_quota.getText().toString().length() > 0 &&
                tv_date.getText().toString().length() > 0 && et_train_number.getText().toString().length() > 0) {
            String url = WebUrls.getTrainFairURL(et_train_number.getText().toString(),
                    et_source_station.getText().toString(),
                    et_destination_station.getText().toString(),
                    et_age.getText().toString(),
                    et_quota.getText().toString(),
                    tv_date.getText().toString());
            Log.d(TAG, "url:-" + url);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            new WebServiceBase(nameValuePairs, this, TRAIN_FAIR_API).execute(url);
        } else {
            Toast.makeText(getApplicationContext(), "Please Enter Information Correctly", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGetMsg(String[] msg) {
        String apicall=msg[0];
        String response=msg[1];
        switch (apicall){
            case TRAIN_FAIR_API:
                parseTrainFairResponse(response);
                break;
        }
    }
    public void parseTrainFairResponse(String response){
//        Log.d(TAG,"response:-"+response);
        Gson gson=new Gson();
        TrainFareEnquiryPOJO pojo=gson.fromJson(response,TrainFareEnquiryPOJO.class);
        if(pojo!=null){
            try{
                if(pojo.getResponse_code().equals("200")){
                    Log.d(TAG,"TrainPOJO route response:-"+pojo.toString());
                }else{
                    Toast.makeText(getApplicationContext(),"No Response",Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e){
                Log.d(TAG,"error:-"+e.toString());
            }
        }
    }

    public void callDateDialog() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                TrainFareEnquiryActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        tv_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
    }
}