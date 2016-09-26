package com.example.wper_smile.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//SharedPreferences文件名
    private final static String SharePreferencesFileName="config";
    //键
    private final static String Key_Num="Num";//学号
    private final static String Key_Name="Name";//姓名
    private final static String Key_UserType="UserType";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取SharedPreferences实例
        preferences=getSharedPreferences(SharePreferencesFileName,MODE_PRIVATE);
        editor=preferences.edit();

        final EditText numEdt=(EditText)findViewById(R.id.num);
        final EditText nameEdt=(EditText)findViewById(R.id.name);
        final Button endData=(Button) findViewById(R.id.endData);
        Button showData=(Button)findViewById(R.id.showData);
        endData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(Key_Num,numEdt.getText().toString());
                editor.putString(Key_Name,nameEdt.getText().toString());
                editor.apply();
            }
        });
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=preferences.getString(Key_Name,null);
                String Num=preferences.getString(Key_Num,null);
                Toast.makeText(MainActivity.this, "姓名:"+Name
                        +"   学号:"+Num, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
