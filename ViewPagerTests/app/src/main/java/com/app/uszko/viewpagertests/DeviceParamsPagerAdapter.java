package com.app.uszko.viewpagertests;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igbt6 on 03.12.2015.
 */
public class DeviceParamsPagerAdapter  extends FragmentStatePagerAdapter{

        private static final String[] Titles= new String[]{"Test1,Test2"};
        private SparseArray<Fragment> registeredFragments = new SparseArray<>();

        private final List<DeviceParametersFragment> mDevicesParameterFragmentList= new ArrayList<>();
        DeviceParamsPagerAdapter (FragmentManager fragmentManager){
            super(fragmentManager);
        }


        public void updateDevParamsList(DeviceParametersFragment devFragm){
            mDevicesParameterFragmentList.add(devFragm);
        }

        @Override
        public Fragment getItem(int position) {
            return mDevicesParameterFragmentList.get(position);
        }

        // Register the fragment when the item is instantiated
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            registeredFragments.put(position, fragment);
            return fragment;
        }

        // Unregister when the item is inactive
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            registeredFragments.remove(position);
            super.destroyItem(container, position, object);
        }

        // Returns the fragment for the position (if instantiated)
        public Fragment getRegisteredFragment(int position) {
            return registeredFragments.get(position);
        }

        public Fragment getCurrentFragment(int pos){
            return mDevicesParameterFragmentList.get(pos);
        }
        @Override
        public int getCount() {
            return Titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Titles[position] ;
        }
}

