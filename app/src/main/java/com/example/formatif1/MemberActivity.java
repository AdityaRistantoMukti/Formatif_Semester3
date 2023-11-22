package com.example.formatif1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemberActivity extends AppCompatActivity {

    Button logout,kembali;
    CardView card1,card2,card3,card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        logout = findViewById(R.id.btn_logout);
        kembali = findViewById(R.id.btn_kembali);

        //        Logout menuju page login
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder konfirmasi = new AlertDialog.Builder(MemberActivity.this);
                konfirmasi.setTitle("Logout");
                konfirmasi.setMessage("Apakah anda yakin untuk logout ? ")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Intent data = new Intent(MemberActivity.this,LoginActivity.class);
                                data.putExtra("KeyLogout", "Anda telah Logout, Silahkan Login Kembali");
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

        //        Tombol Kembali
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(MemberActivity.this,MainActivity.class);
                startActivity(kembali);
            }
        });

//      Card Adit
        card2 = findViewById(R.id.card2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicit = new Intent(MemberActivity.this, AditActivity.class);
                startActivity(explicit);
            }
        });
//      Card Ashari
        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicit = new Intent(MemberActivity.this, AshariActivity.class);
                startActivity(explicit);
            }
        });
//      Card Ramsa
        card4 = findViewById(R.id.card4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicit = new Intent(MemberActivity.this, RamsaActivity.class);
                startActivity(explicit);
            }
        });
//      Card Bandhi
        card3 = findViewById(R.id.card3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicit = new Intent(MemberActivity.this, BandhiActivity.class);
                startActivity(explicit);
            }
        });
    }
}