package com.nos.retrofitexample.list;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nos.retrofitexample.R;
import com.nos.retrofitexample.retrofit.RetrofitUtils;
import com.nos.retrofitexample.retrofit.api.jsonplaceholder.JsonPlaceHolderApi;
import com.nos.retrofitexample.retrofit.api.jsonplaceholder.model.PostPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Saran on 16/5/2560.
 */

public class ListSampleActivity extends AppCompatActivity {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            refreshData();
        }


    };
    private Callback<List<PostPOJO>> mCallbackPosts = new Callback<List<PostPOJO>>() {
        @Override
        public void onResponse(Call<List<PostPOJO>> call, Response<List<PostPOJO>> response) {
            mRefreshLayout.setRefreshing(false);
            if (response.isSuccessful() && null != response.body()) {
                bindData(response.body());
            }
        }


        @Override
        public void onFailure(Call<List<PostPOJO>> call, Throwable t) {
            mRefreshLayout.setRefreshing(false);

        }
    };
    private PostsRecyclerAdapter mAdapter =  new PostsRecyclerAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        findView();
        initView();
        initRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        refreshData();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initView() {
        mRefreshLayout.setOnRefreshListener(mOnRefreshListener);
    }

    private void bindData(List<PostPOJO> datas) {
        mAdapter.replaceDatas(datas);
    }

    private void refreshData() {
        mRefreshLayout.setRefreshing(true);
        RetrofitUtils.getRetrofit(RetrofitUtils.BASE_URL_JSON_PLACE_HOLDER).create(JsonPlaceHolderApi.class).getPosts().enqueue(mCallbackPosts);
    }

    private void findView() {
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_list);
    }

}
