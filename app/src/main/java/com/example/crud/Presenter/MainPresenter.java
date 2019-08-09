package com.example.crud.Presenter;


import androidx.appcompat.app.AlertDialog;

import com.example.crud.Base.BasePresenter;
import com.example.crud.Model.ResponseMahasiswa;
import com.example.crud.Network.Injection;
import com.example.crud.View.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainPresenter implements BasePresenter<MainView> {

    public MainPresenter(MainView mainView){
        this.mainView = mainView;
    }

    MainView mainView;

    @Override
    public void onAttach(MainView View) {
        mainView = View;
    }

    @Override
    public void onDetach(MainView View) {
        mainView = null;
    }

    //1 presenter hanya utk 1 activity

    public void getAllMahasiswa(){
        Injection.getService().getAllMahasiswa().enqueue(new Callback<ResponseMahasiswa>() {
            @Override
            public void onResponse(Call<ResponseMahasiswa> call, Response<ResponseMahasiswa> response) {
                if(response.isSuccessful()){
                    mainView.getMahasiswa(response.body().getDatanya());
                } else {
                    mainView.error("Failed to get Mahasiswa");
                }
            }

            @Override
            public void onFailure(Call<ResponseMahasiswa> call, Throwable t) {
                mainView.error("onFailure : "+t.getLocalizedMessage());
            }
        });
    }

    public void insertAllMahasiswa(String nim, String nama, String jurusan, final AlertDialog dialog){
        Injection.getService().insert(nim,nama,jurusan).enqueue(new Callback<ResponseMahasiswa>() {
            @Override
            public void onResponse(Call<ResponseMahasiswa> call, Response<ResponseMahasiswa> response) {
                if(response.isSuccessful()){
                    response.body().getPesan();
                    dialog.dismiss();
                } else {

                }

            }

            @Override
            public void onFailure(Call<ResponseMahasiswa> call, Throwable t) {
                mainView.error("onFailure : "+ t.getLocalizedMessage());

            }
        });
    }
}
