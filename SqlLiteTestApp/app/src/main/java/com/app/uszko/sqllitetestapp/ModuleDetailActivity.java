package com.app.uszko.sqllitetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.app.uszko.sqllitetestapp.model.Module;
import com.app.uszko.sqllitetestapp.model.ModuleVariable;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igbt6 on 31.12.2015.
 */
public class ModuleDetailActivity extends AppCompatActivity  {

    public static final String MODULE_NAME = "module_name";
    public static final String MODULE_ID = "module_id";

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_details);
        Intent intent = getIntent();
        final String moduleName = intent.getStringExtra(MODULE_NAME);
        final long moduleId = intent.getLongExtra(MODULE_ID,-1); //will be used to get data from db
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar =(CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(moduleName);
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Picasso.with(this)
                .load(R.drawable.ic_smile)
                .rotate(0)
                .into(imageView);

        //sets up recycler View
        mRecyclerView = (RecyclerView) findViewById(R.id.module_details_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ModuleDetailsRecyclerViewAdapter(this, generateModuleVariablesList()));
    }

    //FOR TEST ONLY
    private List<ModuleVariable> generateModuleVariablesList(){

        List<ModuleVariable> moduleList = new ArrayList<>();
        moduleList.add(new ModuleVariable(10, "VAR_1","EQ", "A","ICON_URL"));
        moduleList.add(new ModuleVariable(10, "VAR_2","EQ", "KM","ICON_URL"));
        moduleList.add(new ModuleVariable(10, "VAR_3","EQ", "V","ICON_URL"));
        moduleList.add(new ModuleVariable(10, "VAR_4","EQ", "%","ICON_URL"));
        moduleList.add(new ModuleVariable(10, "VAR_5","EQ", "Pa","ICON_URL"));
        moduleList.add(new ModuleVariable(10, "VAR_6","EQ", "Hz","ICON_URL"));
        moduleList.add(new ModuleVariable(10, "VAR_7","EQ", "Ohm","ICON_URL"));
        return moduleList;
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
/*
    private int getModuleIconPathByModId(Context context, int moduleId){
        String iconUri= "drawable/"+ module.getIcon();
        int iconResource= context.getResources().getIdentifier(iconUri, null, context.getPackageName());
        try{
            Drawable icon= ContextCompat.getDrawable(context, iconResource);
        }
        catch(Exception e){
            iconResource= R.drawable.app_logo;
        }
        return iconResource;
    }
    */
}
