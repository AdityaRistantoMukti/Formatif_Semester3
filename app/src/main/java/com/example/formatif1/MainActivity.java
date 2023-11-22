package com.example.formatif1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_username;
    Button logout;
    LinearLayout sosmed,kalkulator,website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      Inisiasi Variabel
        tv_username = findViewById(R.id.tv_username);
        logout = findViewById(R.id.btn_logout);
        sosmed = findViewById(R.id.sosmed);
        kalkulator = findViewById(R.id.kalkulator);
        website = findViewById(R.id.website);


//        GET DATA
        String usernameText = getIntent().getStringExtra("USERNAME");
        tv_username.setText(usernameText);

//        Logout menuju page login
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder konfirmasi = new AlertDialog.Builder(MainActivity.this);
                konfirmasi.setTitle("Logout");
                konfirmasi.setMessage("Apakah anda yakin untuk logout ? ")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Intent data = new Intent(MainActivity.this,LoginActivity.class);
                                data.putExtra("KeyLogout", "Anda telah Logout, Silahkan" +
                                        "Login Kembali");
                                startActivityForResult(data,Activity.RESULT_OK);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss();
                            }
                        });
                konfirmasi.show();
            }
        });


//        Sosmed
            sosmed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sosmed = new Intent(MainActivity.this, MemberActivity.class);
                    startActivity(sosmed);
                }
            });
//        Kalkulator
            kalkulator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent kalkulator = new Intent(MainActivity.this, Kalkulator.class);
                    startActivity(kalkulator);
                }
            });
//        Website
            website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent website = new Intent(Intent.ACTION_VIEW,Uri.parse("https://tugas-kelompok-pmd.ramsasabil19.repl.co/"));
                    startActivity(website);
                }
            });
    }
}