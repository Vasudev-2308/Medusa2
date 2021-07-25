package com.example.medusa1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class openingScreenActivity extends AppCompatActivity {
    public static  String name;
    EditText userName;

public void gotoMainActivity(View view){
    name=userName.getText().toString();
    Intent i=new Intent(openingScreenActivity.this,MainActivity.class);
    startActivity(i);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_screen);
        userName=findViewById(R.id.editEnterName);


    }

}
