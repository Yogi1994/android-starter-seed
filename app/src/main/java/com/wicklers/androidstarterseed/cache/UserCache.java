package com.wicklers.androidstarterseed.cache;

import android.arch.lifecycle.LiveData;

import com.wicklers.androidstarterseed.vo.User;

import java.util.HashMap;

/**
 * Created by yogi on 14/11/17.
 */

public class UserCache {
    static HashMap<String, LiveData<User> > cached = new HashMap<String, LiveData<User> >();

    public static LiveData<User> get(String userId) {
        return cached.get(userId);
    }

    public static void put(String userId, LiveData<User> data) {
        cached.put(userId, data);
    }
}
