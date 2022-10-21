package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    UserInfo userInfo;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInfo = (UserInfo) getIntent().getSerializableExtra("user");
        TextView textView = findViewById(R.id.tv_role);
        String[] roles = {"Administrator","Cook","Client"};
        String msg = "Welcome! You are logged in as " + roles[Integer.parseInt(userInfo.getRole())];
        textView.setText(msg);
        findViewById(R.id.btn_logoff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              confirmAlert();
            }
        });

    }
    private void confirmAlert(){
        builder = new AlertDialog.Builder(this);
        alert = builder.setTitle("tip")
                .setMessage("are you log off?")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alert.dismiss();
                    }
                })
                .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                }).create();             //创建AlertDialog对象
        alert.show();                    //显示对话框
    }
}