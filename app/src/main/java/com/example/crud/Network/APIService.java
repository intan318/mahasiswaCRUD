package com.example.crud.Network;

import com.example.crud.Model.ResponseMahasiswa;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @GET("getMahasiswa")
    Call<ResponseMahasiswa> getAllMahasiswa();

    @FormUrlEncoded
    @POST("insertMahasiswa")
    Call<ResponseMahasiswa> insert(@Field("nim") String nim,
                                   @Field("name") String nama,
                                   @Field("jurusan") String jurusan);

    @FormUrlEncoded
    @POST("updateMahasiswa")
    Call<ResponseMahasiswa> update (@Field("nim") String nim,
                                   @Field("name") String nama,
                                   @Field("jurusan") String jurusan);

    @FormUrlEncoded
    @POST("insertMahasiswa")
    Call<ResponseMahasiswa> delete (@Field("nim") String nim,
                                   @Field("name") String nama,
                                   @Field("jurusan") String jurusan);
}
