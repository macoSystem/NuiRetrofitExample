package com.nos.retrofitexample.retrofit.api.jsonplaceholder;

import com.nos.retrofitexample.retrofit.api.jsonplaceholder.model.PostPOJO;
import com.nos.retrofitexample.retrofit.api.jsontest.model.JsonTestPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Saran on 16/5/2560.
 */

public interface JsonPlaceHolderApi {

//    http://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<PostPOJO>> getPosts();
}
