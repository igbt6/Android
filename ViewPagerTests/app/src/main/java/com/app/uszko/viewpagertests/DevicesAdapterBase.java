package com.app.uszko.viewpagertests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by igbt6 on 29.11.2015.
 */
public class DevicesAdapterBase extends BaseAdapter {
    private final static String TAG  =  DevicesAdapterBase.class.getSimpleName();
    private final static boolean LOG_ENABLE = true;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<DeviceModel> mDevices;


    public DevicesAdapterBase(Context ctx){
        mContext= ctx;
        mDevices= new ArrayList<>();
        mInflater=LayoutInflater.from(mContext);

    }


    public void addDevice(DeviceModel dev){
        if(!mDevices.contains(dev)) {
            mDevices.add(dev);
            //notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mDevices.size();
    }

    @Override
    public Object getItem(int position) {
        return mDevices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DeviceViewHolder viewHolder;
        if(convertView==null){
            convertView= mInflater.inflate(R.layout.devices_item,null);
            viewHolder= new DeviceViewHolder();
            viewHolder.deviceIcon=(ImageView)convertView.findViewById(R.id.device_icon);
            viewHolder.deviceName=(TextView)convertView.findViewById(R.id.device_name);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (DeviceViewHolder) convertView.getTag();
        }
        viewHolder.deviceName.setText(mDevices.get(position).getName());
        viewHolder.deviceIcon.setImageResource(R.drawable.app_logo);
        return convertView;
    }


    static class DeviceViewHolder {
        ImageView deviceIcon;
        TextView deviceName;
    }

}
