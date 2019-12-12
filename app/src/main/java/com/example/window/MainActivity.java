package com.example.window;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)this.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个提示框").setTitle("提示框");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"提示框已关闭",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });
        Button button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater=getLayoutInflater();
                final View v=inflater.inflate(R.layout.login,null);
                builder.setView(v).setTitle("Login").setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText e1=(EditText)v.findViewById(R.id.editTextUserId);
                        EditText e2=(EditText)v.findViewById(R.id.editTextPwd);
                        String pwd=e2.getText().toString();
                        String id=e1.getText().toString();
                        if(id.equals("abc")&&pwd.equals("123")){
                            Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                        }
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }
}
