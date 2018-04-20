package com.thomasbrondeau.vpgilt.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.thomasbrondeau.vpgilt.utils.Navigation;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class BaseActivity extends AppCompatActivity {
    protected Navigation mNavigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavigation = new Navigation();
    }
}
