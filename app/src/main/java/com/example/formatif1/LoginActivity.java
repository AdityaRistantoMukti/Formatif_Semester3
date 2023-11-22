package com.example.formatif1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView register;
    EditText usernameText,passwordText;
    Button login;
    private Object String;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);
        register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.loginButton){
                    String username = usernameText.getText().toString();
                    String password = passwordText.getText().toString();

                    if (username.isEmpty()){
                        usernameText.setError("Username kosong mohon di isi");
                    } else if (password.isEmpty()){
                        passwordText.setError("Password kosong mohon di isi");
                    } else if (username.length() > 15) {
                        usernameText.setError("Username tidak boleh lebih dari 15 character");
                    } else {
                        Intent main = new Intent(LoginActivity.this, MainActivity.class);
                        main.putExtra("USERNAME", username);
                        startActivityForResult(main, 2);
                    }
                } else if (v.getId() == R.id.register) {


                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Maaf register belum berfungsi"
                        ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 2){
            if (resultCode == RESULT_OK) {
                String = data.getStringExtra("KeyLogout");
                Toast.makeText(this,"Berhasil Logout",Toast.LENGTH_SHORT).show();
            }
        }
    }



}