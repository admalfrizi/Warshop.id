package com.example.warshop_id;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.warshop_id.ClassesHelper.SessionHelperClass;
import com.example.warshop_id.ClassesHelper.UserHelperClass;

public class LoginActivity extends AppCompatActivity {
    UserHelperClass db;
    EditText idfullname;
    EditText idPassword;
    ViewGroup progressView;
    protected boolean isProgressShowing = false;
    Button login;
     Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idfullname = findViewById(R.id.full_name);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        idPassword = findViewById(R.id.id_password);
        db = new UserHelperClass(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });

        login.setOnClickListener(view -> {
            String fullname = idfullname.getText().toString().trim();
            String password = idPassword.getText().toString().trim();
            boolean checkuserpass = db.checkUser(fullname, password);
            if(fullname.equals(checkuserpass)||password.equals(checkuserpass)){
                SessionHelperClass sessionHelperClass = new SessionHelperClass(LoginActivity.this);
                sessionHelperClass.createLoginSession(fullname,password);
                Toast.makeText(LoginActivity.this, "Login Is Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), HalamanUtama.class));
            } else {
                Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}