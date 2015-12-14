package com.app.uszko.viewpagertests;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igbt6 on 03.12.2015.
 */
public class DeviceParamsPagerAdapter  extends FragmentStatePagerAdapter{

        private SparseArray<DeviceParametersFragment> mRegisteredFragments = new SparseArray<>();

        private final List<DeviceParametersFragment> mDevicesParameterFragmentList;
        private final List<String> mDevicesNameList;

        DeviceParamsPagerAdapter (FragmentManager fragmentManager){
            super(fragmentManager);
            mDevicesParameterFragmentList= new ArrayList<>();
            mDevicesNameList =new ArrayList<>();
        }


        public void updateDevParamsList(DeviceParametersFragment devFragm, String devName){
            if(!mDevicesParameterFragmentList.contains(devFragm)&&!mDevicesNameList.contains(devName)) {
                mDevicesParameterFragmentList.add(devFragm);
                mDevicesNameList.add(devName);
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
            mRegisteredFragments.put(position, fragment);
            return fragment;
        }

        // Unregister when the item is inactive
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            mRegisteredFragments.remove(position);
            super.destroyItem(container, position, object);
        }

        // Returns the fragment for the position (if instantiated)
        public DeviceParametersFragment getCurrentFragment(int position){
            return mRegisteredFragments.get(position);
        }
        @Override
        public int getCount() {
            return mDevicesParameterFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDevicesNameList.get(position) ;
        }
}

