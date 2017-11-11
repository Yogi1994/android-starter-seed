package com.wicklers.androidstarterseed.UserProfile;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wicklers.androidstarterseed.R;

/**
 * Created by yogi on 11/11/17.
 */

public class UserProfileFragment extends Fragment {
    private static final String UID_KEY = "uid";
    private UserProfileModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of(this).get(UserProfileModel.class);
        viewModel.getUser().observe((LifecycleOwner) this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                // Update UI
            }
        });

        viewModel.init(userId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_profile, container, false);
    }
}
