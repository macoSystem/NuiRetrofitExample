package com.nos.retrofitexample.simple;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nos.retrofitexample.R;
import com.nos.retrofitexample.retrofit.RetrofitUtils;
import com.nos.retrofitexample.retrofit.api.jsontest.JsonTestApi;
import com.nos.retrofitexample.retrofit.api.jsontest.model.JsonTestPOJO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Saran on 16/5/2560.
 */

public class SimpleSampleActivity extends AppCompatActivity {

    private TextView mTextViewJson;
    private ProgressDialog mProgressDialog;
    private Callback<JsonTestPOJO> mCallbackJsonTest = new Callback<JsonTestPOJO>() {
        @Override
        public void onResponse(Call<JsonTestPOJO> call, Response<JsonTestPOJO> response) {
            if (null != mProgressDialog) {
                mProgressDialog.dismiss();
            }
            if (response.isSuccessful() && null != response.body()) {
                bindData(response.body());
            }
        }

        @Override
        public void onFailure(Call<JsonTestPOJO> call, Throwable t) {
            if (null != mProgressDialog) {
                mProgressDialog.dismiss();
            }

        }
    };

    private void bindData(JsonTestPOJO body) {
        mTextViewJson.setText("JsonTestPOJO{" +
                "objectOrArray='" + body.getObjectOrArray() + '\'' +
                ", empty=" + body.isEmpty() +
                ", parseTimeNanoSeconds=" + body.getParseTimeNanoSeconds() +
                ", validate=" + body.isValidate() +
                ", size=" + body.getSize() +
                '}');
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        findView();
    }


    @Override
    protected void onStart() {
        super.onStart();
        refreshData();
    }

    private void refreshData() {
        mProgressDialog = ProgressDialog.show(this, "Simple json", "Loading...");
        RetrofitUtils.getRetrofit(RetrofitUtils.BASE_URL_JSON_TEST).create(JsonTestApi.class).getJson().enqueue(mCallbackJsonTest);
    }

    private void findView() {
        mTextViewJson = (TextView) findViewById(R.id.textview_simple_json);
    }

}
