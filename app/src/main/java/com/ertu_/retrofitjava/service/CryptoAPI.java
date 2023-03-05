package com.ertu_.retrofitjava.service;

import com.ertu_.retrofitjava.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {
    //GET, POST, UPDATE, DELETE
    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    Call<List<Model>> getData();


}
