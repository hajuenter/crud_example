package com.example.crud_example.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud_example.Adapter.AdapterShowData;
import com.example.crud_example.Api.EndPointApi;
import com.example.crud_example.Api.RetrofitClient;
import com.example.crud_example.Model.ModelData;
import com.example.crud_example.Model.ResponseData;
import com.example.crud_example.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<ModelData> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        rvData = findViewById(R.id.rv_data);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        tampilData();
    }

    public void tampilData() {

        //ambil dari class interface
        EndPointApi ard = RetrofitClient.konekRetrofit().create(EndPointApi.class);

        //call response dan ambil call dari interface
        Call<ResponseData> ResData = ard.showData();

        //antrikan
        ResData.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    int status = response.body().getStatus();
                    String message = response.body().getMessage();

//                    Toast.makeText(DashboardActivity.this, "Status: " + status + " | Pesan: " + message, Toast.LENGTH_SHORT).show();

                    listData = response.body().getData();
                    adData = new AdapterShowData(DashboardActivity.this, listData);
                    rvData.setLayoutManager(lmData);
                    rvData.setAdapter(adData);
                    adData.notifyDataSetChanged();
                } else {
                    Toast.makeText(DashboardActivity.this, "Response kosong atau tidak sukses", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Gagal terhubung: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}