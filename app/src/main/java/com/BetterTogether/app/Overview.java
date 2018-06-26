package com.BetterTogether.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class Overview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), new UserListFragment(), new GraphFragment());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(tabAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.bringToFront();
        tabLayout.setupWithViewPager(viewPager);
    }


}