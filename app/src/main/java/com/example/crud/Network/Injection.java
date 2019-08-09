package com.example.crud.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.60.32/mahasiswa_server/index.php/Server/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIService getService(){

        return getRetrofit().create(APIService.class);
    }
}
