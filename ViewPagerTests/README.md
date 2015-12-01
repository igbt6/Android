Project is about to show you an usage of some new features available from Android 5.0 and from Support library for prevoius versions as well.
Features used like RecyclerView, CardView ViewPager, TabLayout, Toolbar make your application look more precoius and pretty. 

Idea of the app is taken from my real project where the main was following:

Idea of the application:
1. Phone is searching for available main device (scanning BLE range)
2. Once main device has been found, it starts sending data packets to the applicationabout how many and what kind of modules are supported by th device.
3. Modules were devices like WeatherSensor, MovementSensor, BatteryController etc.
4. Each of the modules contains of many data values that are continously being sent to the application.
5. Results of the values are received and updated on the screen in Real Time

Usage of android features according to the main state machine;
1. When a given module is found while scanning, it is automatically being added to GridView - based on RecyclerView
2. After clicking on the given module item on the GridView, following data values for the module are listed and shown in CardView under TabLayout and ViewPager.
3. User can switch to another module's values after swiping on the given Fragment (View pager with FragmentStatePagerAdapter)  



If you have found any issues or just have any questions, 
feel free to contact me: 

Łukasz Uszko,
lukasz.uszko@gmail.com 

Have fun and keep coding!