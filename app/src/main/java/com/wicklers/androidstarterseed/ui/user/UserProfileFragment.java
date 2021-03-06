package com.wicklers.androidstarterseed.ui.user;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wicklers.androidstarterseed.R;
import com.wicklers.androidstarterseed.vo.User;

/**
 * Created by yogi on 11/11/17.
 */

public class UserProfileFragment extends Fragment {
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        String userId = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(UserProfileViewModel.class);
        viewModel.init("1");

        viewModel.getUser().observe((LifecycleOwner) getActivity(), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                // Update UI
                Toast.makeText(getActivity(), user.getName(), Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_profile, container, false);
    }
}
