package com.example.task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("marvel/")
    Call<List<ModelClass>> getData();
}
