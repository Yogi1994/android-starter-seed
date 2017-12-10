package com.wicklers.androidstarterseed;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.wicklers.androidstarterseed.ui.user.UserProfileFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserProfileFragment detailFragment = new UserProfileFragment();

        Bundle bundle = new Bundle();
        bundle.putString("uid", "1");
        detailFragment.setArguments(bundle);
    }
}
