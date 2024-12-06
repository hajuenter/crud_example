package com.example.crud_example.Api;

import com.example.crud_example.Model.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointApi {
    @GET("showData.php")
    Call<ResponseData> showData();
}
