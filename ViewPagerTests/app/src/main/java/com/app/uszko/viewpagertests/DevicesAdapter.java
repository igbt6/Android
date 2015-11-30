package com.app.uszko.viewpagertests;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igbt6 on 29.11.2015.
 */
public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DeviceViewHolder> {
    private final static String TAG  =  DevicesAdapter.class.getSimpleName();
    private final static boolean LOG_ENABLE = true;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<DeviceModel> mDevices;


    public DevicesAdapter(Context ctx){
        mContext= ctx;
        mDevices= new ArrayList<>();
        mLayoutInflater=LayoutInflater.from(mContext);

    }


    public void addDevice(DeviceModel dev){
        if(!mDevices.contains(dev)) {
            mDevices.add(dev);
            notifyDataSetChanged();
        }
    }

    public void  setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener= onItemClickListener;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeviceViewHolder(mLayoutInflater.inflate(R.layout.devices_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, final int position) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.blue_primary_dark));
        holder.deviceName.setText(mDevices.get(position).getName());
        holder.deviceName.setBackgroundColor(ContextCompat.getColor(mContext,R.color.purple_accent));
        holder.deviceIcon.setImageResource(R.drawable.app_logo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(v,position);
            }
        });
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

    public DeviceModel getItem(int position){
        return mDevices.get(position);
    }


    static class DeviceViewHolder extends RecyclerView.ViewHolder{

        final ImageView deviceIcon;
        final TextView deviceName;

        public DeviceViewHolder(View container) {
            super(container);
            deviceIcon= (ImageView)container.findViewById(R.id.device_icon);
            deviceName= (TextView)container.findViewById(R.id.device_name);
        }

    }
}
