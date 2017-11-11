package com.wicklers.androidstarterseed.UserProfile;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.wicklers.androidstarterseed.utils.Webservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yogi on 11/11/17.
 */

public class UserRepository {
    private Webservice webservice;

    public LiveData<User> getUser(String userID) {
        final MutableLiveData<User> data = new MutableLiveData<>();
        webservice.getUser(userID).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return data;
    }
}
