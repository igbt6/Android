 //Created by Łukasz Uszko (lukasz.uszko@gmail.com) 2015
 //Based on http://code.tutsplus.com/tutorials/create-a-custom-keyboard-on-android--cms-22615
 
 
 /*******************************USAGE ***************************/
 //1. Declaration:          private CustomKeyboard mHexKeyboard;
 //2. Create object:        mHexKeyboard= new CustomKeyboard(this.getActivity() , R.id.keyboardview, R.xml.hexkeyboard);
 //3. Register EditText:    mHexKeyboard.registerEditText(R.id.write_data_edit_text);
 
 //4. Add R.id.keyboardview in a layout file:
                // <android.inputmethodservice.KeyboardView
                    // android:id="@+id/keyboardview"
                    // android:layout_width="fill_parent"
                    // android:layout_height="209dp"
                    // android:layout_alignParentBottom="true"
                    // android:layout_centerHorizontal="true"
                    // android:focusable="true"
                    // android:focusableInTouchMode="true"
                    // android:visibility="visible" />
                    // <Space android:layout_width="fill_parent"
                // android:layout_height="60dp"/>
                
 // 

 
 Example of usage in WriteDataFragmet. 