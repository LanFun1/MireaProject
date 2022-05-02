package ru.mirea.vaydich.clickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private TextView tvOut;
    private Button buttonOk;
    private Button buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOut = (TextView) findViewById(R.id.tvOut);
        buttonOk = (Button) findViewById(R.id.Ok);
        buttonCancel = (Button) findViewById(R.id.Cancel);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOut.setText("Нажата кнопка ОК");
            }
        };
        buttonOk.setOnClickListener(oclBtnOk);
    }
    public void OnMyButtonClick(View view)
    {
        // выводим сообщение
        Toast.makeText(this, "Ещё один способ!", Toast.LENGTH_SHORT).show();
    }
}