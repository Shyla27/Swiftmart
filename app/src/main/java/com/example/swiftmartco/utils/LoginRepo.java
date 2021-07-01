package com.example.swiftmartco.utils;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.swiftmartco.model.CartApiResponse;

public class LoginRepo {

    private static final String TAG = CartRepo.class.getSimpleName();
    private Application application;

    public LoginRepo(Application application)
    {
        this.application = application;
    }

    public LiveData<CartApiResponse> signinsignup(int userId)
    {
        final MutableLiveData<CartApiResponse> mutableLiveData = new MutableLiveData<>();

        return mutableLiveData;
    }
}
