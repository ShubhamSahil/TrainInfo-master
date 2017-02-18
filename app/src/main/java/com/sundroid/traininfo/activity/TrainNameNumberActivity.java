package com.sundroid.traininfo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sundroid.traininfo.R;
import com.sundroid.traininfo.Utils.WebUrls;
import com.sundroid.traininfo.webservices.WebServiceBase;
import com.sundroid.traininfo.webservices.WebServicesCallBack;

import org.apache.http.NameValuePair;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainNameNumberActivity extends AppCompatActivity implements View.OnClickListener,WebServicesCallBack{
    private final static String TRAIN_NAME_NUMBER="train_name_number";
    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_train_name)
    EditText et_train_name;
    @BindView(R.id.btn_search)
    Button btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_name_number);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.btn_search:
                callTrainAPI();
                break;
        }
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

    public void callTrainAPI(){
        if(et_train_name.getText().toString().length()>0){
            String url = WebUrls.getTrainNameNumberURL(et_train_name.getText().toString());
            Log.d(TAG,"url:-"+url);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            new WebServiceBase(nameValuePairs, this, TRAIN_NAME_NUMBER).execute(url);
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
            case TRAIN_NAME_NUMBER:
                parseTrainResponse(response);
                break;
        }
    }
    public void parseTrainResponse(String response){
        Log.d(TAG,"response:-"+response);
    }
}