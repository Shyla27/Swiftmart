package com.example.swiftmartco.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.swiftmartco.utils.LoginRepo;

public class Loginviewmodel extends AndroidViewModel {

    private LoginRepo loginRepo;

    public Loginviewmodel(@NonNull Application application) {
        super(application);
        loginRepo = new LoginRepo(application);
    }
}

