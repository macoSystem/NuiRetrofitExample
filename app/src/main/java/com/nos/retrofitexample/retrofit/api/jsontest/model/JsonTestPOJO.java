package com.nos.retrofitexample.retrofit.api.jsontest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Saran on 16/5/2560.
 */

public class JsonTestPOJO {
    //Response from http://validate.jsontest.com/?json={"key":"value"}
//
//    {
//        object_or_array: "object",
//                empty: false,
//            parse_time_nanoseconds: 18964,
//            validate: true,
//            size: 1
//    }
    @SerializedName("object_or_array")
    private String objectOrArray;
    @SerializedName("empty")
    private boolean empty;
    @SerializedName("parse_time_nanoseconds")
    private long parseTimeNanoSeconds;
    @SerializedName("validate")
    private boolean validate;
    @SerializedName("size")
    private int size;


    public JsonTestPOJO() {
    }

    public String getObjectOrArray() {
        return objectOrArray;
    }

    public boolean isEmpty() {
        return empty;
    }

    public long getParseTimeNanoSeconds() {
        return parseTimeNanoSeconds;
    }

    public boolean isValidate() {
        return validate;
    }

    public int getSize() {
        return size;
    }



}
