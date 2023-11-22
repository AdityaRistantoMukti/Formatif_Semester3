package com.example.formatif1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Kalkulator extends AppCompatActivity {

    public String str = "";
    String op = "";
    float i,num,numtemp;
    EditText showResult;
    Button logout,kembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        showResult = (EditText)findViewById(R.id.result_id);
        logout = findViewById(R.id.btn_logout);
        kembali = findViewById(R.id.btn_kembali);

        //        Logout menuju page login
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder konfirmasi = new AlertDialog.Builder(Kalkulator.this);
                konfirmasi.setTitle("Logout");
                konfirmasi.setMessage("Apakah anda yakin untuk logout ? ")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Intent data = new Intent(Kalkulator.this,LoginActivity.class);
                                data.putExtra("KeyLogout", "Anda telah Logout, Silahkan" +
                                        "Login Kembali");
                                setResult(Activity.RESULT_OK, data);
                                finish();
                                startActivity(data);
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
                Intent kembali = new Intent(Kalkulator.this,MainActivity.class);
                startActivity(kembali);
            }
        });
    }

    private void insert(int j) {
// TODO Auto-generated method stub
        str = str+Integer.toString(j);
        num = Integer.valueOf(str).intValue();
        showResult.setText(str);

    }
    private void calculate() {
// TODO Auto-generated method stub
        if (op == "+")
            num = numtemp + num;
        else if (op == "-")
            num = numtemp - num;
        else if (op == "/")
            num = numtemp / num;
        else if (op == "*")
            num = numtemp * num;
        showResult.setText("" + num);
    }
    private void calculateNoShow() {
// TODO Auto-generated method stub
        if(op == "+")
            num = numtemp+num;
        else if(op == "-")
            num = numtemp-num;
        else if(op == "/")
            num = numtemp/num;
        else if(op == "*")
            num = numtemp*num;
    }
    private void reset() {
// TODO Auto-generated method stub
        str ="";
        op ="q";
        num = 0;
        numtemp = 0;
        showResult.setText("");
    }
    private void perform() {
// TODO Auto-generated method stub
        str = "";
        calculateNoShow();
        numtemp = num;
    }
    public void btn0Clicked(View v){
        insert(0);
    }
    public void btn1Clicked(View v){
        insert(1);
    }
    public void btn2Clicked(View v){
        insert(2);
    }
    public void btn3Clicked(View v){
        insert(3);
    }
    public void btn4Clicked(View v){
        insert(4);
    }
    public void btn5Clicked(View v){
        insert(5);
    }
    public void btn6Clicked(View v){
        insert(6);
    }
    public void btn7Clicked(View v){
        insert(7);
    }
    public void btn8Clicked(View v){
        insert(8);
    }
    public void btn9Clicked(View v){
        insert(9);
    }
    public void btnplusClicked(View v){
        perform();

        op = "+";
        showResult.setText( "+");
    }
    public void btnminusClicked(View v){
        perform();
        op = "-";
        showResult.setText("-");
    }
    public void btndivideClicked(View v){
        perform();
        op = "/";
        showResult.setText("/");
    }
    public void btnmultiClicked(View v){
        perform();
        op = "*";
        showResult.setText("*");
    }
    public void btnequalClicked(View v){
        calculate(); }
    public void btnclearClicked(View v){
        reset();
    }
}

