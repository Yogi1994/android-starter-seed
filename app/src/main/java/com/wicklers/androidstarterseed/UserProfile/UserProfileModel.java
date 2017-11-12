package com.wicklers.androidstarterseed.UserProfile;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;


/**
 * Created by yogi on 11/11/17.
 */

public class UserProfileModel extends ViewModel {
//    private User user;
    private LiveData<User> user;
    private UserRepository userRepo;
    public UserProfileModel() {

    }
    @Inject // UserRepository parameter is provided by Dagger 2
    public UserProfileModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void init(String userId) {
        if (this.user != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        userRepo = new UserRepository();
        user = userRepo.getUser(userId);
    }



//    public void init(String userId) {
//        this.userId = userId;
//    }
//    public User getUser() {
//        return user;
//    }
    public LiveData<User> getUser() {

        return this.user;
    }
}

