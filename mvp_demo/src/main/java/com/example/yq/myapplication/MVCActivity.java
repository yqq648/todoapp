package com.example.yq.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class MVCActivity extends AppCompatActivity {
    MyView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new MyView(this);
        setContentView(view);
    }

    class MyView extends View{
        public MyModel model;

        public MyView(Context context) {
            super(context);
            model = new MyModel(10,10,40,40);
        }

        public void setModel(MyModel model) {
            this.model = model;
        }

        @Override
        public void draw(Canvas canvas) {
            super.draw(canvas);
            Rect rect = new Rect(model.x,model.y,
                    model.x+model.width,model.y+model.heitht);
            canvas.drawRect(rect,new Paint());
        }
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
        if (keyCode==KeyEvent.KEYCODE_DPAD_LEFT){
            view.model.x-=5;
            view.invalidate();
            return true;
        }else if(keyCode==KeyEvent.KEYCODE_DPAD_RIGHT){
            view.model.x+=5;
            view.invalidate();
        }
        return super.onKeyDown(keyCode, event);
    }
}
