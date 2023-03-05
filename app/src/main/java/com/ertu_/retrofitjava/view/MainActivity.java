package com.ertu_.retrofitjava.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ertu_.retrofitjava.R;
import com.ertu_.retrofitjava.model.Model;
import com.ertu_.retrofitjava.service.CryptoAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String BASE_URL = "https://raw.githubusercontent.com/";

    ArrayList<Model> cryptoModel;
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    private void getDataFromApi() {
        CryptoAPI cryptoAPI = retrofit.create(CryptoAPI.class);
        Call<List<Model>> call = cryptoAPI.getData();

        //enqueue() Asynchronously send the request and notify callback of its response or
        // if an error occurred talking to the server, creating the request, or processing the response.
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(response.isSuccessful()) {
                    List<Model> responseList = response.body();
                    cryptoModel = new ArrayList<>(responseList);

                    for(Model model : cryptoModel) {
                        Log.d("a", model.currency);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}