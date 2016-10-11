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

    SharedPreferences preferences;
    //SharedPreferences.Editor是SharedPreferences的内部接口。用户使用它可以写入或修改数据
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *获取SharedPreferences实例
         * getSharedPreferences(文件名,MODE);
         * MODE_PRIVATE 只能被应用程序调用
         */
        preferences=getSharedPreferences(SharePreferencesFileName,MODE_PRIVATE);
        editor=preferences.edit();

        final EditText numEdt=(EditText)findViewById(R.id.num);
        final EditText nameEdt=(EditText)findViewById(R.id.name);

        final Button writeData=(Button) findViewById(R.id.endData);

        Button getShowData=(Button)findViewById(R.id.showData);

        writeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 写入数据、
                 * editor.putString(Key,string);
                 */

                editor.putString(Key_Num,numEdt.getText().toString());
                editor.putString(Key_Name,nameEdt.getText().toString());
                //提交数据，将数据写入SharedPreferences中
                editor.apply();
            }
        });
        getShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 获取SharedPreferences中数据
                 * XXX.getString(Key,如果没有则使用默认值);
                 */
                String Name=preferences.getString(Key_Name,null);
                String Num=preferences.getString(Key_Num,null);
                Toast.makeText(MainActivity.this, "姓名:"+Name
                        +"   学号:"+Num, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
