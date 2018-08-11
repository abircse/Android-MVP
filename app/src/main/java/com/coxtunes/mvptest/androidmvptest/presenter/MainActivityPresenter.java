package com.coxtunes.mvptest.androidmvptest.presenter;

import java.util.HashMap;

import com.coxtunes.mvptest.androidmvptest.MainActivity;
import com.coxtunes.mvptest.androidmvptest.interfaces.MainActivityView;
import com.coxtunes.mvptest.androidmvptest.interfaces.OnRequestComplete;
import com.coxtunes.mvptest.androidmvptest.model.InvokeApi;


public class MainActivityPresenter {
    MainActivityView view;

    public MainActivityPresenter(MainActivity view) {
        this.view = view;
    }

    public void getIpInformation() {
        view.startLoading();
        new InvokeApi(view.getAppContext(), new OnRequestComplete() {
            @Override
            public void onRequestComplete(Object infoData) {
                view.stopLoading();
                view.showIpInfo((HashMap) infoData);
            }

            @Override
            public void onRequestError(String errorMsg) {
                view.showMessage(errorMsg);
            }
        });

    }


}
