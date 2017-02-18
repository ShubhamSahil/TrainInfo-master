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

public class PNRStatusActivity extends AppCompatActivity implements WebServicesCallBack,View.OnClickListener {
    private final static String PNR_CALL_API="pnr_call_api";
    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_click)
    Button btn_click;
    @BindView(R.id.et_pnr_text)
    EditText et_pnr_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnrstatus);
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
        if(et_pnr_text.getText().toString().length()>0) {
            String url = WebUrls.getPNRStatusURL(et_pnr_text.getText().toString());
            Log.d(TAG,"url:-"+url);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            new WebServiceBase(nameValuePairs, this, PNR_CALL_API).execute(url);
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
            case PNR_CALL_API:
                    Log.d(TAG,"response:-"+response);
                break;
        }
    }
}
