package com.example.alertdialogmultichoicedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements DialogInterface.OnClickListener {

    private String[] items = {"Samsung", "OPPO" , "Apple", "ASUS"};
    private boolean[] itemsChecked = {false, false, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog build = new AlertDialog.Builder(this)
                        .setTitle("請勾選選項?")
                        .setPositiveButton("確定",null)
                        //.setNegativeButton("取消",null)  //null:不處理按下取消鈕的事件
                        .setNegativeButton("取消",null)
                        .setMultiChoiceItems(items,itemsChecked, null)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String msg = "";
            switch (which) {
                case    DialogInterface.BUTTON_POSITIVE:
                    for(int index = 0; index < items.length; index++) {
                        if(itemsChecked[index])
                            msg += item[index] + "\n";
                    }
                    TextView output = (TextView) findViewById(R.id.lblOutput);
                    output.setText(msg);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    Toast.makeText(this,"按下取消紐" ,Toast.LENGTH_SHORT).show();
            }

    }
}