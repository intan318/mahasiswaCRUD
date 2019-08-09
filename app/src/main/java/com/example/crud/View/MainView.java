package com.example.crud.View;

import com.example.crud.Base.BaseView;
import com.example.crud.Model.DatanyaItem;

import java.util.List;

public interface MainView extends BaseView {
    void getMahasiswa(List<DatanyaItem> mahasiswa);
    void insertMahasiswa
    void error(String msg);
}
