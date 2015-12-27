package com.app.uszko.sqllitetestapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.uszko.sqllitetestapp.model.Module;

import java.util.List;

/**
 * Created by igbt6 on 31.12.2015.
 */
public class ModuleRecyclerViewAdapter extends RecyclerView.Adapter<ModuleRecyclerViewAdapter.ViewHolder> {


    private List<Module> mModules;
    private Context mContext;


    public ModuleRecyclerViewAdapter(Context context,List<Module> items){
        mModules= items;
        mContext= context;
    }

    public ModuleRecyclerViewAdapter(Context context){
        mContext= context;
    }

    public void addModule(Module module){
        //check if exists already or not before
        mModules.add(module);
    }

    @Override
    public void onBindViewHolder(ModuleRecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.name.setText(mModules.get(position).getName());
        holder.icon.setImageResource(Util.getModuleIconPathByUrl(mContext, mModules.get(position).getIconUrl()));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context ctx= v.getContext();
                Toast.makeText(ctx, "Clicked on module: "+mModules.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ctx,ModuleDetailActivity.class);
                intent.putExtra(ModuleDetailActivity.MODULE_NAME,mModules.get(position).getName());
                intent.putExtra(ModuleDetailActivity.MODULE_ID,mModules.get(position).getId());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public ModuleRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modules_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mModules.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView name;
        public final ImageView icon;
        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            name = (TextView)itemView.findViewById(R.id.module_item_name);
            icon = (ImageView)itemView.findViewById(R.id.module_item_icon);
        }


    }

}
