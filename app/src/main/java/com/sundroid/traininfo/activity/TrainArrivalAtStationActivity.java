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

import com.sundroid.traininfo.R;
import com.sundroid.traininfo.webservices.WebServicesCallBack;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainArrivalAtStationActivity extends AppCompatActivity implements View.OnClickListener, WebServicesCallBack, TimePickerDialog.OnTimeSetListener{

    private final static String TRAIN_ARRIVAL_API="train_arrival_api";
    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_station_code)
    EditText et_station_code;
    @BindView(R.id.tv_hour)
    TextView tv_hour;
    @BindView(R.id.btn_search)
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_arrival_at_station);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tv_hour.setOnClickListener(this);
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
//        if (et_source_station.getText().toString().length() > 0 && et_destination_station.getText().toString().length() > 0
//                && et_age.getText().toString().length() > 0 && et_quota.getText().toString().length() > 0 &&
//                tv_date.getText().toString().length() > 0 && et_train_number.getText().toString().length() > 0) {
//            String url = WebUrls.getTrainFairURL(et_train_number.getText().toString(),
//                    et_source_station.getText().toString(),
//                    et_destination_station.getText().toString(),
//                    et_age.getText().toString(),
//                    et_quota.getText().toString(),
//                    tv_date.getText().toString());
//            Log.d(TAG, "url:-" + url);
//            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//            new WebServiceBase(nameValuePairs, this, TRAIN_FAIR_API).execute(url);
//        } else {
//            Toast.makeText(getApplicationContext(), "Please Enter Information Correctly", Toast.LENGTH_LONG).show();
//        }
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
//            case TRAIN_FAIR_API:
//                parseTrainFairResponse(response);
//                break;
        }
    }
    public void parseTrainFairResponse(String response){
        Log.d(TAG,"response:-"+response);
    }

    public void callDateDialog() {
//        Calendar now = Calendar.getInstance();
//        TimePickerDialog dpd = TimePickerDialog.newInstance(
//                TrainArrivalAtStationActivity.this,
//                now.get(Calendar.HOUR),
//                now.get(Calendar.MINUTE)
//        );
//        dpd.show(getFragmentManager(), "Datepickerdialog");
    }
    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        tv_hour.setText(hourOfDay+":"+minute+":"+second);
    }
}