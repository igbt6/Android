package com.app.uszko.sqllitetestapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.app.uszko.sqllitetestapp.model.Module;
import com.app.uszko.sqllitetestapp.model.ModuleVariable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainApp mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "SqLiteTestApp created by igbt6 (lukasz.uszko@gmail.com)", Snackbar.LENGTH_LONG).show();
            }
        });

        //sets up the recycler View
        final RelativeLayout relLayout = (RelativeLayout) findViewById(R.id.module_recycler_view_frame_layout);
        relLayout.setBackgroundColor(getResources().getColor(R.color.colorLighterBlue));
        mRecyclerView = (RecyclerView) findViewById(R.id.module_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mApp= (MainApp)getApplicationContext();

        for(Module mod: generateModuleList()) { //saving all
            mApp.getDataManager().saveModule(mod);
        }
        //List<Module> allModules =mApp.getDataManager().getAllModules();

       // for(Module mod: allModules) {
       //     Log.d("++++++++++++++++++++++ ", "MODULE: "+String.valueOf(mod.getId())+" "+ mod.getName()+" "+ mod.getIconUrl());
       // }
        mRecyclerView.setAdapter(new ModuleRecyclerViewAdapter(this, mApp.getDataManager().getAllModules()));



    }

    //FOR TEST ONLY simulates data fetched from Internet/ XML/JSON ...
    private List<Module> generateModuleList(){

        List<Module> moduleList = new ArrayList<>();


        Module sensor1 = new Module(1, "SpeedSensor", "ic_speed");
        List<ModuleVariable> modVars1 = new ArrayList<>();
        modVars1.add(new ModuleVariable(15135,sensor1.getId(), "Speed_M/S", "EQ", "m/s", "ICON_URL"));
        modVars1.add(new ModuleVariable(15236,sensor1.getId(), "Speed_Km", "EQ", "KM", "ICON_URL"));
        sensor1.setModuleVariablesList(modVars1);
        moduleList.add(sensor1);

        Module sensor2 = new Module(2, "ElectricitySensor", "ic_electricity");
        List<ModuleVariable> modVars2 = new ArrayList<>();
        modVars2.add(new ModuleVariable(23411,sensor2.getId(), "Current","EQ", "A","ICON_URL"));
        modVars2.add(new ModuleVariable(26989,sensor2.getId(), "Voltage", "EQ", "V", "ICON_URL"));
        modVars2.add(new ModuleVariable(25899,sensor2.getId(), "Resistance", "EQ", "Ohm", "ICON_URL"));
        sensor2.setModuleVariablesList(modVars2);
        moduleList.add(sensor2);

        Module sensor3 = new Module(4, "EnvironmentSensor", "ic_environment");
        List<ModuleVariable> modVars3= new ArrayList<>();
        modVars3.add(new ModuleVariable(32111,sensor3.getId(), "Pressure", "EQ", "Pa", "ICON_URL"));
        sensor3.setModuleVariablesList(modVars3);
        moduleList.add(sensor3);

        return moduleList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        else if(id==R.id.action_delete_db){
            for(Module mod:mApp.getDataManager().getAllModules())
            {
                Log.i("********* ", "mModule deleted: " + String.valueOf(mod.getId()) + " " + mod.getName());
                mApp.getDataManager().deleteModule(mod.getId());
            }
            //if we have some not connected module variables
            for(ModuleVariable mVar: mApp.getDataManager().getAllModVariables())
            {
                Log.i("********* ", "mVar deleted: " + String.valueOf(mVar.getId()) + " " + mVar.getModuleId() + " " + mVar.getName() + " " + mVar.getIconUrl() + " " + mVar.getUnit());
                mApp.getDataManager().deleteModuleVariable(mVar);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
