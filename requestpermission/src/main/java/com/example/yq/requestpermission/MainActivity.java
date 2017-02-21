package com.example.yq.requestpermission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //一旦把这个方法混淆了， 在xml里面就不能匹配
    public void call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
        //GRANTED同意
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},100);
            return;
        }
        startActivity(callIntent);//ActivityNotFound xxx
//        getPackageManager().queryIntentActivities(callIntent,0).size()>0;
//        if (getPackageManager().通过包管理器，查看是否有此activity){
    }

    @Override//系统权限回掉方法
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode!=100){//不是拨打电话的请求
            return;
        }
        if (grantResults[0]!=PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "用户拒绝权限", Toast.LENGTH_SHORT).show();
            return;
        }
        call(null);//再次拨打电话
    }

    public void click(View view) {
        Toast.makeText(this, "xx", Toast.LENGTH_SHORT).show();
    }
}
