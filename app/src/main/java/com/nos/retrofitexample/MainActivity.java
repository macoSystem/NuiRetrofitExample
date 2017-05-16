package com.nos.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nos.retrofitexample.list.ListSampleActivity;
import com.nos.retrofitexample.simple.SimpleSampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonSimple, mButtonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initView();

    }

    private void initView() {
        mButtonList.setOnClickListener(this);
        mButtonSimple.setOnClickListener(this);
    }

    private void findView() {
        mButtonSimple = (Button) findViewById(R.id.button_main_simple);
        mButtonList = (Button) findViewById(R.id.button_main_list);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == mButtonList.getId()) {
            goToListSampleActivity();
        } else if (id == mButtonSimple.getId()) {
            goToSimpleSampleActivity();
        }
    }

    private void goToSimpleSampleActivity() {
        Intent simpleSampleActivity = new Intent(this, SimpleSampleActivity.class);
        startActivity(simpleSampleActivity);
    }

    private void goToListSampleActivity(){
        Intent listSampleIntent = new Intent(this, ListSampleActivity.class);
        startActivity(listSampleIntent);
    }
}
