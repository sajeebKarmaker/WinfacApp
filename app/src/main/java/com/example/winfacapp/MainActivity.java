package com.example.winfacapp;

import static com.example.winfacapp.R.id.nav_partyBalance;
import static com.example.winfacapp.R.id.nav_paymentView;
import static com.example.winfacapp.R.id.nav_stockView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public NavigationView mainNavigationView;
    public Menu mainMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        mainNavigationView = findViewById(R.id.main_navigation);

        mainNavigationView.bringToFront();
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mainNavigationView.setNavigationItemSelectedListener(this);
        //mainNavigationView.setCheckedItem(R.id.nav_stockView);


        /* This handler is for handling all the button clicks of this activity*/
        Handler handler = new Handler();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /* The following function is used to close the NAVIGATION MENU when back button is pressed */
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    /* The following function is used to control the items of NAVIGATION MENU */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == nav_stockView) {
            Intent intent = new Intent(MainActivity.this, StockView.class);
            startActivity(intent);
        } else if (item.getItemId() == nav_partyBalance) {
            Intent intent = new Intent(MainActivity.this, PartyBalance.class);
            startActivity(intent);
        } else if (item.getItemId() == nav_paymentView) {
            Intent intent = new Intent(MainActivity.this, Payment.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(MainActivity.this, TakeOrder.class);
            startActivity(intent);
        }
        drawerLayout.closeDrawer(GravityCompat.START, false);
        return true;
    }

    /* The following function is used to control the clicks of Buttons */
    class Handler implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }


}
