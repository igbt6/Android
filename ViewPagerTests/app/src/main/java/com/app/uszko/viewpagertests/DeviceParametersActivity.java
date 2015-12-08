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

import static com.app.uszko.viewpagertests.LoggerUtil.LOGE;

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
        setContentView(R.layout.activity_device_params);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "View Pager Test App made by Lukasz Uszko (lukasz.uszko@gmail.com ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setSupportActionBar(mToolbar);
        mViewPager = (ViewPager) findViewById(R.id.dev_params_viewpager);

        mPageAdapter=   new DeviceParamsPagerAdapter(getSupportFragmentManager());
        try {
            for(DeviceModel dev: ApplicationDataEngine.getInstance().getDevices()) {
                mPageAdapter.updateDevParamsList(DeviceParametersFragment.newInstance(dev.getName()));
            }

        }
        catch (Exception e){
            LOGE(LOGGER_ENABLE,TAG,"Error! ",e);
            finish();
        }
        mViewPager.setAdapter(mPageAdapter);
        mViewPager.setCurrentItem(mViewPager.getCurrentItem());
        mTabLayout = (TabLayout) findViewById(R.id.dev_params_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        //mPageAdapter.getRegisteredFragment(mViewPager.getCurrentItem()).getDevParamAdapter().updateParams(devParam);
        mPageAdapter.notifyDataSetChanged();
    }
}
