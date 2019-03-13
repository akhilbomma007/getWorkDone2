package com.example.getworkdone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
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
