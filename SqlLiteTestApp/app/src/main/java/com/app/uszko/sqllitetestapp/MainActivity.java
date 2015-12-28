package com.app.uszko.sqllitetestapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.app.uszko.sqllitetestapp.model.Module;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

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
                Snackbar.make(view, "SqLiteTestApp_created by igbt6 (lukasz.uszko@gmail.com)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //sets up the recycler View
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.module_recycler_view_frame_layout);
        frameLayout.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mRecyclerView = (RecyclerView) findViewById(R.id.module_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ModuleRecyclerViewAdapter(this, generateModuleList()));
    }

    //FOR TEST ONLY
    private List<Module> generateModuleList(){

        List<Module> moduleList = new ArrayList<>();
        moduleList.add(new Module(10, "MODULE_1", "CLOUD"));
        moduleList.add(new Module(11, "MODULE_2", "SKY"));
        moduleList.add(new Module(12, "MODULE_3", "SUN"));
        moduleList.add(new Module(13, "MODULE_4", "FIRE"));
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

        return super.onOptionsItemSelected(item);
    }
}
