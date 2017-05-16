package com.nos.retrofitexample.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Saran on 16/5/2560.
 */

public class RetrofitUtils {
    public static final String BASE_URL_JSON_PLACE_HOLDER =  "http://jsonplaceholder.typicode.com/";
    public static final String BASE_URL_JSON_TEST = "http://validate.jsontest.com/";


    public static Retrofit getRetrofit(String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl);

        builder.client(new OkHttpClient());

        //For gson
        //Example. SerialzedName("userId")
        builder.addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }
}
