package com.wicklers.androidstarterseed.UserProfile;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.wicklers.androidstarterseed.utils.Webservice;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yogi on 11/11/17.
 */

@Singleton
public class UserRepository {
    @Inject
    private Webservice webservice;

    public LiveData<User> getUser(String userID) {
        final MutableLiveData<User> data = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webservice = retrofit.create(Webservice.class);
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
