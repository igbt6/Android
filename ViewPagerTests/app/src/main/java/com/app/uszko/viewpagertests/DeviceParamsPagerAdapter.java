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

        private SparseArray<DeviceParametersFragment> registeredFragments = new SparseArray<>();

        private final List<DeviceParametersFragment> mDevicesParameterFragmentList;

        DeviceParamsPagerAdapter (FragmentManager fragmentManager){
            super(fragmentManager);
            mDevicesParameterFragmentList= new ArrayList<>();
        }


        public void updateDevParamsList(DeviceParametersFragment devFragm){
            if(!mDevicesParameterFragmentList.contains(devFragm)) {
                mDevicesParameterFragmentList.add(devFragm);
            }
        }

        @Override
        public DeviceParametersFragment getItem(int position) {
            return mDevicesParameterFragmentList.get(position);
        }

        // Register the fragment when the item is instantiated
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            DeviceParametersFragment fragment = (DeviceParametersFragment) super.instantiateItem(container, position);
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
        public DeviceParametersFragment getRegisteredFragment(int position) {
            return registeredFragments.get(position);
        }

        public DeviceParametersFragment getCurrentFragment(int pos){
            return mDevicesParameterFragmentList.get(pos);
        }
        @Override
        public int getCount() {
            return mDevicesParameterFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDevicesParameterFragmentList.get(position).getDevName() ;
        }
}

