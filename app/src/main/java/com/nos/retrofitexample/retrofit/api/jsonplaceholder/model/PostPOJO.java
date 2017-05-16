package com.nos.retrofitexample.retrofit.api.jsonplaceholder.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Saran on 16/5/2560.
 */

public class PostPOJO {
    /*
    http://jsonplaceholder.typicode.com/posts
     */
//    {
//        userId: 1,
//                id: 1,
//            title: "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//            body: "quia et suscipit
//        suscipit recusandae consequuntur expedita et cum
//        reprehenderit molestiae ut ut quas totam
//        nostrum rerum est autem sunt rem eveniet architecto"
//    },

    @SerializedName("userId")
    private int userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public PostPOJO() {
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
