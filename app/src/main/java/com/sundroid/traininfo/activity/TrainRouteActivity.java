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

public class TrainRouteActivity extends AppCompatActivity implements View.OnClickListener,WebServicesCallBack{
    private final static String TRAIN_ROUTE_API_CALL="pnr_call_api";
    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_click)
    Button btn_click;
    @BindView(R.id.et_train_route)
    EditText et_train_route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_route);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_click.setOnClickListener(this);
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
            case R.id.btn_click:
                callAPI();
                break;
        }
    }
    public void callAPI(){
        if(et_train_route.getText().toString().length()>0) {
            String url = WebUrls.getTrainRouteStatusURL(et_train_route.getText().toString());
            Log.d(TAG,"url:-"+url);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            new WebServiceBase(nameValuePairs, this, TRAIN_ROUTE_API_CALL).execute(url);
        }
        else{
            Toast.makeText(getApplicationContext(),"Please Enter Information Correctly",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onGetMsg(String[] msg) {
        String apicall=msg[0];
        String resposne=msg[1];
        switch (apicall){
            case TRAIN_ROUTE_API_CALL:
                Log.d(TAG,"response:-"+resposne);
                break;
        }
    }
}
