package com.app.uszko.viewpagertests;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by igbt6 on 03.12.2015.
 */
public class DeviceParameterAdapter extends RecyclerView.Adapter<DeviceParameterAdapter.DeviceParameterFragmentViewHolder> {


    private final static String TAG  =  DeviceParameterAdapter.class.getSimpleName();
    private final static boolean LOG_ENABLE = true;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<DeviceModel.DeviceParameterModel> mDevParams;

    DeviceParameterAdapter (Context ctx){
        mContext= ctx;
        mDevParams= new ArrayList<>();
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    public void updateParams(DeviceModel.DeviceParameterModel devParam){
        if(!mDevParams.contains(devParam)) {
            mDevParams.add(devParam);
            notifyDataSetChanged();
        }
    }


    @Override
    public DeviceParameterAdapter.DeviceParameterFragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return (new DeviceParameterFragmentViewHolder(mLayoutInflater.inflate(R.layout.params_item,parent,false)));

    }

    @Override
    public void onBindViewHolder(DeviceParameterAdapter.DeviceParameterFragmentViewHolder holder, final int position) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.blue_primary_dark));
        holder.paramIcon.setImageResource(R.drawable.app_logo);
        holder.paramName.setBackgroundColor(ContextCompat.getColor(mContext, R.color.purple_accent));
        holder.paramName.setText(mDevParams.get(position).getName());
        holder.paramValue.setText(String.valueOf(mDevParams.get(position).getValue()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDevParams.size();
    }




    static class DeviceParameterFragmentViewHolder extends RecyclerView.ViewHolder{

        ImageView paramIcon;
        TextView  paramName;
        TextView  paramValue;

        public DeviceParameterFragmentViewHolder(View itemView) {
            super(itemView);

            paramIcon = (ImageView)itemView.findViewById(R.id.param_icon);
            paramName= (TextView)itemView.findViewById(R.id.param_name);
            paramValue= (TextView)itemView.findViewById(R.id.param_value);
        }
    }
}
