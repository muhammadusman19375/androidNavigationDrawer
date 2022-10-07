package com.example.mynavigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //.......... For Connecting Fragments To Main Activity...............
        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        //.......... For Connecting Fragments To Main Activity...............


        //.......... For Navigation Drawer...............
        drawerLayout=findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();
        //.......... For Navigation Drawer...............

        //.......... For Connecting Fragments To Main Activity...............
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_message);
        }
        //.......... For Connecting Fragments To Main Activity...............

    }

    //.......... For Connecting Fragments To Main Activity...............
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment()).commit();
                break;
            case R.id.nav_more_apps:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MoreAppsFragment()).commit();
                break;
            case R.id.nav_rate_it:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RateitFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //.......... For Connecting Fragments To Main Activity...............


    //.......... For Navigation Drawer...............
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //.......... For Navigation Drawer...............
}