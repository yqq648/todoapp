package com.example.yq.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MVPActivity extends AppCompatActivity {
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        MyModel model = new MyModel(10,10,40,40);
        view = findViewById(R.id.view);
        view.setTag(model);
    }
    class MyModel{
        int x;
        int y;
        int width;
        int heitht;

        public MyModel(int x, int y, int width, int heitht) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.heitht = heitht;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MyModel model = (MyModel) view.getTag();
        if (keyCode==KeyEvent.KEYCODE_DPAD_LEFT){
            model.x-=5;
            view.layout(model.x,model.y,
                    model.x+model.width,model.y+model.heitht);
//            view.model.x-=5;
//            view.invalidate();
            return true;
        }else if(keyCode==KeyEvent.KEYCODE_DPAD_RIGHT){
            model.x+=5;
            view.layout(model.x,model.y,
                    model.x+model.width,model.y+model.heitht);
//            view.model.x+=5;
//            view.invalidate();
        }
        return super.onKeyDown(keyCode, event);
    }
}
