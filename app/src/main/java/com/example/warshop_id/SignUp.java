package com.example.warshop_id;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.warshop_id.ClassesHelper.UserHelperClass;

public class SignUp extends AppCompatActivity {

    EditText email_user, reg_password, full_name, repassword, phone_id;
    Button signUp;
    UserHelperClass db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        full_name = findViewById(R.id.full_name);
        phone_id = findViewById(R.id.phone);
        signUp = findViewById(R.id.sign_up);
        email_user = findViewById(R.id.email_user);
        reg_password = findViewById(R.id.reg_password);
        repassword = findViewById(R.id.repassword);
        db = new UserHelperClass(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = full_name.getText().toString();
                String password = reg_password.getText().toString();
                String email = email_user.getText().toString();
                String phone = phone_id.getText().toString();
                String repass = repassword.getText().toString();

                if (password.equals(repass)) {
                    long val = db.addUser(fullname, phone, email, password);
                    if (val > 0) {
                        Toast.makeText(SignUp.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(SignUp.this, LoginActivity.class);
                        startActivity(moveToLogin);
                    } else {
                        Toast.makeText(SignUp.this, "Registeration Error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignUp.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
