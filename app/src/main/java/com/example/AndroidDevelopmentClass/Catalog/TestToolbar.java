package com.example.AndroidDevelopmentClass.Catalog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import static android.support.design.R.id.snackbar_text;

public class TestToolbar extends AppCompatActivity {
    private static final String ACTIVITY_NAME = "TestToolbar";
    MenuItem about;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Would you like to chat?", Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.GREEN)
                        .setDuration(Snackbar.LENGTH_LONG)
                        .setAction("Start here!", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i(ACTIVITY_NAME, "User click Start Chat");
                                Intent intent = new Intent(TestToolbar.this, MessageListActivity.class);
                                startActivityForResult(intent, 55);
                            }
                        }).show();
            }
        });


        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);


    }

    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.toolbar_menu, m);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem mi) {
        int id = mi.getItemId();

//        MenuItem about = (MenuItem) findViewById(R.id.about);
//        Assert.assertNotNull(about);
//        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        switch (id) {

            case R.id.home:
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
                Log.i(ACTIVITY_NAME, "User going back to StartActivity");
                Intent homeIntent = new Intent(TestToolbar.this, StartActivity.class);
                startActivityForResult(homeIntent, 55);

                break;

            case R.id.music:
                Toast.makeText(this, "music", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestToolbar.this);
                alertDialogBuilder.setMessage(R.string.goBackQuestion)
                        .setTitle(R.string.musicDialogTitle)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                Intent resultIntent = new Intent();
//                                resultIntent.putExtra(
//                                        getString(R.string.responseKey),
//                                        getString(R.string.responseValue));
//                                setResult(Activity.RESULT_OK, resultIntent);
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //todo: do nothing I guess!
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                break;

            case R.id.settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                Log.i(ACTIVITY_NAME, "User wants to go to login");
                Intent settingIntent = new Intent(TestToolbar.this, LoginActivity.class);
                startActivityForResult(settingIntent, 55);
                break;


            case R.id.about:
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Ver 1.0 by Amir Ardalan", Snackbar.LENGTH_LONG);
                View snkbrView = snackbar.getView();

                TextView textView = (TextView) snkbrView.findViewById(snackbar_text);
                textView.setTextSize(20);
                textView.setTextColor(Color.YELLOW);

                snackbar.setDuration(Snackbar.LENGTH_LONG).show();

                Toast.makeText(this, "For more information please visit www.github.com//ArsiaArdalan/CST2334-LAB8 repository licensed under MIT", Toast.LENGTH_LONG).show();


                break;


            case R.id.weather:
                Toast.makeText(this, "Weather app started", Toast.LENGTH_SHORT).show();
                Log.i(ACTIVITY_NAME, "Clicked weatherButton");
                Intent weatherIntent = new Intent(TestToolbar.this, WeatherForecast.class);
                startActivityForResult(weatherIntent, 555);
                break;


            case R.id.chat:
                Toast.makeText(this, "Chat started", Toast.LENGTH_SHORT).show();
                Log.i(ACTIVITY_NAME, "User click Start Chat");
                Intent chatIntent = new Intent(TestToolbar.this, MessageListActivity.class);
                startActivityForResult(chatIntent, 55);
                break;


        }

        return true;
    }

}
