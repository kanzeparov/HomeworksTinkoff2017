package com.example.franck.homeworkstinkoff2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Franck on 08.10.2017.
 */

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.franck.homeworkstinkoff2017.MESSAGESECOND";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnOk = (Button) findViewById(R.id.buttonOk);
        Button btnCancel = (Button) findViewById(R.id.buttonCancel);
        final Intent intent = new Intent(this, MainActivity.class);

        receiveMessage();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

//        receiveMessage();
    }

    public void sendMessage() {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
        startActivity(intent);
    }

    public void receiveMessage() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(message);
    }

}
