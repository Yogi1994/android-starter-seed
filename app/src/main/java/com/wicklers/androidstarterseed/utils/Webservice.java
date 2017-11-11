package com.wicklers.androidstarterseed.utils;

import com.wicklers.androidstarterseed.UserProfile.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yogi on 11/11/17.
 */

public interface Webservice {
    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/users/{user}")
    Call<User> getUser(@Path("user") String userId);
}
