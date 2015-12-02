package com.app.uszko.viewpagertests;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by igbt6 on 03.12.2015.
 */
public class DeviceParametersActivity extends AppCompatActivity {


    private final static String TAG  =DeviceParametersActivity.class.getSimpleName();
    private final static boolean LOGGER_ENABLE = true;
    private static String POSITION = "POSITION";
    private ViewPager mViewPager;
    private DeviceParamsPagerAdapter mPageAdapter;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "View Pager Test App made by Lukasz Uszko (lukasz.uszko@gmail.com)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        mViewPager = (ViewPager) findViewById(R.id.dev_params_viewpager);

            mPageAdapter=   new DeviceParamsPagerAdapter(getSupportFragmentManager());
            try {

                 mPageAdapter.updateDevParamsList(DeviceParametersFragment.newInstance("NAME"));
            }
            catch (Exception e){
                Toast.makeText(this, "You not connected or XML is not correct - must download a newer version from the INTERNET!", Toast.LENGTH_SHORT).show();
                finish();
            }
            mViewPager.setAdapter(mPageAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.dev_params_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mViewPager.setCurrentItem(mViewPager.getCurrentItem());
        mPageAdapter.notifyDataSetChanged();
    }


}
