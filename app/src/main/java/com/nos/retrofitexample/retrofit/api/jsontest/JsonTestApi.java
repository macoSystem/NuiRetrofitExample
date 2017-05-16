package com.nos.retrofitexample.retrofit.api.jsontest;

import com.nos.retrofitexample.retrofit.api.jsontest.model.JsonTestPOJO;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Saran on 16/5/2560.
 */

public interface JsonTestApi {

    /*
  format(ConstanceType.HTTP_HOST + "/translations/%s.json", lang)
   */

    //http://validate.jsontest.com/?json={"key":"value"}
    @GET("?json={\"key\":\"value\"}")
    Call<JsonTestPOJO> getJson();
}
