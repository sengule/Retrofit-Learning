package com.ertu_.retrofitjava.service;

import com.ertu_.retrofitjava.model.Model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {
    //GET, POST, UPDATE, DELETE
    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    Observable<List<Model>> getData();

    //Call<List<Model>> getData();
}
