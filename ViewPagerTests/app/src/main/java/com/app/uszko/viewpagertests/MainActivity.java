package com.app.uszko.viewpagertests;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DevicesAdapterBase mDevicesAdapterBase;
    private DevicesAdapter mDevicesAdapter;


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
                Snackbar.make(view, "View Pager Test App made by Lukasz Uszko (lukasz.uszko@gmail.com)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mDevicesAdapter =new DevicesAdapter(this);


        //Setup devices
        generateUpDevices();

        //setUpGridView();
        setUpGridViewWithRecyclerView();
    }

   private void setUpGridViewWithRecyclerView(){
        RecyclerView devicesRecyclerView = (RecyclerView)findViewById(R.id.devices_recycler_view);
        final int space = getApplicationContext().getResources().getDimensionPixelSize(R.dimen.spacing_nano);
        devicesRecyclerView.addItemDecoration(new OffsetDecoration(space));
        mDevicesAdapter= new DevicesAdapter(this);
        devicesRecyclerView.setAdapter(mDevicesAdapter);
        mDevicesAdapter.setOnItemClickListener(new DevicesAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(view.getContext(), "ChosenDevice: " + String.valueOf(((DeviceModel) mDevicesAdapter.getItem(position)).getName()), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DeviceParametersActivity.class);
                intent.putExtra("DEV_NAME",mDevicesAdapter.getItem(position).getName());
                startActivity(intent);
            }
        });

       for(DeviceModel dev: ApplicationDataEngine.getInstance().getDevices()) {
           mDevicesAdapter.addDevice(dev);
       }
   }


    private void setUpGridView(){
        mDevicesAdapterBase= new DevicesAdapterBase(this);
        GridView mGridview = (GridView) findViewById(R.id.all_devices_gridview);
        mGridview.setAdapter(mDevicesAdapterBase);
        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "ChosenDevice: " + String.valueOf(((DeviceModel) mDevicesAdapterBase.getItem(position)).getName()), Toast.LENGTH_SHORT).show();
            }
        });
        for(DeviceModel dev: ApplicationDataEngine.getInstance().getDevices()) {
            mDevicesAdapterBase.addDevice(dev);
        }
    }



    private void generateUpDevices(){

        //dummy data
        DeviceModel mWeatherSensor;
        DeviceModel mPositionSensor;

        ArrayList<DeviceModel.DeviceParameterModel> weatherSensorParameters = new ArrayList<>();
        weatherSensorParameters.add(new DeviceModel.DeviceParameterModel("Temperature", 21.0));
        weatherSensorParameters.add(new DeviceModel.DeviceParameterModel("Pressure", 995.0));
        weatherSensorParameters.add(new DeviceModel.DeviceParameterModel("Humidity", 91.0));
        weatherSensorParameters.add(new DeviceModel.DeviceParameterModel("Light", 333.0));
        mWeatherSensor = new DeviceModel(0,"WeatherSensor", weatherSensorParameters);

        ArrayList<DeviceModel.DeviceParameterModel> positionSensorParameters = new ArrayList<>();
        positionSensorParameters.add(new DeviceModel.DeviceParameterModel("Acceleration X", 111.0));
        positionSensorParameters.add(new DeviceModel.DeviceParameterModel("Acceleration Y", 145.0));
        positionSensorParameters.add(new DeviceModel.DeviceParameterModel("Acceleration Z", 65.0));
        mPositionSensor = new DeviceModel(0,"PositionSensor", positionSensorParameters);

        ApplicationDataEngine app = ApplicationDataEngine.getInstance();
        app.addDevice(mWeatherSensor);
        app.addDevice(mPositionSensor);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
