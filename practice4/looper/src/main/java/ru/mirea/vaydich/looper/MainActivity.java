package ru.mirea.vaydich.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private MyLooper myLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLooper = new MyLooper();
        myLooper.start();
    }

    public void onClick(View view) {
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", "20 Student");
        msg.setData(bundle);
        String mess = (String) msg.obj;
        try {
            TimeUnit.SECONDS.sleep(5);
            if (myLooper != null) {
                myLooper.handler.sendMessage(msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}