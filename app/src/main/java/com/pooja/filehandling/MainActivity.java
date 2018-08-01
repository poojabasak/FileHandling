package com.pooja.filehandling;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
EditText et;
    Button btn,btn2;
    public static final String FILE="jadu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=et.getText().toString();
                try{
                    FileOutputStream fout=openFileOutput(FILE, Context.MODE_APPEND);//two mode can be used :private-in which data will be over write and other is :append in which data will be added with previous data
                    fout.write(data.getBytes());
                    Toast.makeText(MainActivity.this,"Done..",Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Try Again..",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fin=openFileInput(FILE);
                    int x=0;
                    String data="";
                    while ((x=fin.read())!=-1)
                    {
                        data=data+Character.toString((char)x);
                    }

                    Toast.makeText(MainActivity.this,""+data,Toast.LENGTH_LONG).show();
                    //fin.read();

            }catch (Exception e)
                {
            }
            }
        });
    }
}
