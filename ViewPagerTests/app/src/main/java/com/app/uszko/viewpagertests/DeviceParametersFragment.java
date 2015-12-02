package com.app.uszko.viewpagertests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by igbt6 on 03.12.2015.
 */
public class DeviceParametersFragment extends Fragment {

    private final static String TAG  = DeviceParametersFragment.class.getSimpleName();
    private final static boolean LOGGER_ENABLE = true;
    private static final String ARG_DEV_PARAM_NAME = "ARG_DEV_PARAM_NAME";

    DeviceParameterAdapter mDevParamAdapter;
    RecyclerView mRecyclerView;
    String mDevParamName;


    public static DeviceParametersFragment newInstance(String devName) {
        Bundle args = new Bundle();
        args.putString(ARG_DEV_PARAM_NAME, devName); //if you want to use
        DeviceParametersFragment fragment = new DeviceParametersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDevParamName = getArguments().getString(ARG_DEV_PARAM_NAME,"--");
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_params, container, false);
        //final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fragment_dev_param_layout);
        //frameLayout.setBackgroundColor(ContextCompat.getColor(container.getContext(),R.color.blue_background));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDevParamAdapter = new DeviceParameterAdapter(getActivity().getBaseContext());
        mRecyclerView.setAdapter( mDevParamAdapter);
    }

}
