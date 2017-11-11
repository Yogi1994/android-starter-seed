package com.wicklers.androidstarterseed.UserProfile;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by yogi on 11/11/17.
 */

public class UserProfileModel extends ViewModel {
    private String userId;
//    private User user;
    private LiveData<User> user;



    public void init(String userId) {
        this.userId = userId;
    }
//    public User getUser() {
//        return user;
//    }
    public LiveData<User> getUser() {
        return user;
    }
}

