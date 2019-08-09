package com.example.crud.Base;

public interface BasePresenter <M extends BaseView> {
    void onAttach (M View);
    void onDetach (M View);

}
