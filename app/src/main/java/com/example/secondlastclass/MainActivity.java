package com.example.secondlastclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavController navController;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();
    }

    public void setupNavigation(){

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView= findViewById((R.id.navigation_view));
        navController= Navigation.findNavController(this,R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer((GravityCompat.START));

        }else
        {
        super.onBackPressed(); }
    }

    @Override
    public boolean onSupportNavigateUp() {

        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.nav_host_fragment),drawerLayout);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        menuItem.setCheckable(true);
        drawerLayout.closeDrawers();
        int id = menuItem.getItemId();

        switch (id)
        {
            case R.id.firstfragment:

                Toast.makeText(getApplicationContext(),"First Clicked!", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.firstfragment);

            case R.id.secondFragment:

                Toast.makeText(getApplicationContext(),"Second Clicked!", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.secondFragment);

            case R.id.thirdFragment:

                Toast.makeText(getApplicationContext(),"Third Clicked!", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.thirdFragment);
        }


        return true;
    }
}
