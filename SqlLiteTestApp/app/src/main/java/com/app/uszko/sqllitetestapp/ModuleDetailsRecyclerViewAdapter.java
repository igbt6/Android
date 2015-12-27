package com.app.uszko.sqllitetestapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.uszko.sqllitetestapp.model.Module;
import com.app.uszko.sqllitetestapp.model.ModuleVariable;

import java.util.List;

/**
 * Created by igbt6 on 31.12.2015.
 */
public class ModuleDetailsRecyclerViewAdapter extends RecyclerView.Adapter<ModuleDetailsRecyclerViewAdapter.ViewHolder> {


    private List<ModuleVariable> mItems;
    private Context mContext;


    public ModuleDetailsRecyclerViewAdapter(Context context, List<ModuleVariable> items){
        mItems= items;
        mContext= context;
    }

    public ModuleDetailsRecyclerViewAdapter(Context context){
        mContext= context;
    }


    @Override
    public void onBindViewHolder(ModuleDetailsRecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.name.setText(mItems.get(position).getName());
        holder.icon.setImageResource(Util.getModuleIconPathByUrl(mContext, mItems.get(position).getIconUrl()));
        holder.value.setText("0");
        holder.unit.setText(mItems.get(position).getUnit());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context ctx= v.getContext();
                Toast.makeText(ctx, "Clicked on: "+mItems.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public ModuleDetailsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modules_details_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final CardView cv;
        public final TextView name;
        public final TextView unit;
        public final TextView value;
        public final ImageView icon;
        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            name = (TextView)itemView.findViewById(R.id.moduleDetailName);
            icon = (ImageView)itemView.findViewById(R.id.moduleDetailIcon);
            cv = (CardView)itemView.findViewById(R.id.moduleDetailCardView);
            unit = (TextView)itemView.findViewById(R.id.moduleDetailUnit);
            value = (TextView)itemView.findViewById(R.id.moduleDetailValue);
        }


    }

}
