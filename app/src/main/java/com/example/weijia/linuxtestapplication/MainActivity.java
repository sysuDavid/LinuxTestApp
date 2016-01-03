package com.example.weijia.linuxtestapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), childActivity.class);
                startActivity(intent);

            }
        });

        Button button1 = (Button)findViewById(R.id.button_send);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                leanCloudTest();
            }
        });
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

    public void leanCloudTest() {
        AVOSCloud.initialize(getApplicationContext(), "lg1C6AKQm7Oln9lzc265Xr4L-gzGzoHsz", "jWyudCoYYfd9xIO98SU9nVHE");
        AVObject testObject = new AVObject("TestObject");
        testObject.put("key", "value");
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                Log.i("yuan", "upload data succeed");
                Toast.makeText(getApplicationContext(), "upload data succeed", Toast.LENGTH_LONG);
            }
        });
    }


}
