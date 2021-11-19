package com.downrush125.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edxusername , edxpassword;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edxusername = findViewById(R.id.edxusername);
        edxpassword = findViewById(R.id.edxpassword);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Patterns.EMAIL_ADDRESS.matcher(edxusername.getText().toString()).matches()){
                    Toast.makeText(MainActivity.this , "Please enter E-Mail in Proper Format" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edxusername.getText().toString().equals("admin@gmail.com") && edxpassword.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this , "Login Successfull" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this , welcome.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this , "Username or password is incorrect" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}