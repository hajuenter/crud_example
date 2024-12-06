package com.example.crud_example.Api;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetrofitClient {
    private static final String baseURL = "http://192.168.43.115/crud_example_api/api/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit() {
        if (retro == null) {

            // buat koneksi
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
