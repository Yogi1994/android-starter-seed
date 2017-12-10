package com.wicklers.androidstarterseed.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import com.wicklers.androidstarterseed.App;
import com.wicklers.androidstarterseed.cache.UserCache;
import com.wicklers.androidstarterseed.api.Webservice;
import com.wicklers.androidstarterseed.db.UserDao;
import com.wicklers.androidstarterseed.vo.User;

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

    private Webservice webservice = null;

//    private UserDao userDao;

    @Inject
    public UserRepository(/*Webservice webservice , UserDao userDao*/) {
//        this.webservice = webservice;
//        this.userDao = userDao;
    }

    public LiveData<User> loadUser(String userId) {
//        LiveData<User> cached = userCache.get(userId);
//        if (cached != null) {
//            return cached;
//        }

        final MutableLiveData<User> data = new MutableLiveData<>();
//        userCache.put(userId, data);
        if(webservice == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            webservice = retrofit.create(Webservice.class);
        }
        webservice.getUser(userId).enqueue(new Callback<User>() {

            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());
            }

            public void onFailure(Call<User> call, Throwable t) {
                //TODO: failure

            }
        });
        return data;
    }
}
