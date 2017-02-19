package com.example.yq.removelog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity","日志:"+test());
    }
    //只屏蔽日志，不屏蔽其它方法
    String test(){
        Toast.makeText(this, "test方法", Toast.LENGTH_SHORT).show();
        return "log";
    }
}
