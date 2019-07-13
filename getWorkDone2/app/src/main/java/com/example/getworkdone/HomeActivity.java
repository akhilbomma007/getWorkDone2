package com.example.getworkdone;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        navigationView = findViewById(R.id.bottom_navigation);

        final HomeFragment homeFragment = new HomeFragment();
        final NotificationFragment notificationFragment = new NotificationFragment();
        final SettingsFragment settingsFragment = new SettingsFragment();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.home) {
                    setFragment(homeFragment);
                    return true;
                }
                else if(id == R.id.notification) {
                    setFragment(notificationFragment);
                    return true;
                }
                else if(id == R.id.settings) {
                    setFragment(settingsFragment);
                    return true;
                }
                return false;
            }
        });

        navigationView.setSelectedItemId(R.id.home);
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_refresh){
            startActivity(new Intent(this,HomeActivity.class));
        }
        else if(item.getItemId()==R.id.action_about){
            Toast.makeText(this,"This is Get Work Done app",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.action_settings){
            Toast.makeText(this,"functionality not yet given",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.action_logout){
            mAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
            Toast.makeText(this,"SignOut successful",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
