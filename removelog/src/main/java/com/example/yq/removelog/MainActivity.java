package com.example.yq.removelog;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

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
    public void loadPatch(View view) {
        File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        Toast.makeText(this, "cunzai:"+f.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
                Environment.getExternalStorageDirectory().getAbsolutePath()
                        + "/patch_signed.apk");
    }
}