package com.example.franck.homeworkstinkoff2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.franck.homeworkstinkoff2017.MESSAGEFIRST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.editText);
        Button btn = (Button) findViewById(R.id.button);
        Button btnImplicit = (Button) findViewById(R.id.button2);
        final Intent intent = new Intent(this, SecondActivity.class);
        receiveMessage();
        Button buttonFlag = (Button) findViewById(R.id.button3);

        buttonFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessageToEmail();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

//        receiveMessage();
    }

    public void sendMessageToEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(this.getString(R.string.set_type));
        EditText editText = (EditText) findViewById(R.id.editText);
        String mail_to = this.getString(R.string.mail_to);
        intent.putExtra(Intent.EXTRA_EMAIL, mail_to);
        intent.putExtra(Intent.EXTRA_SUBJECT, this.getString(R.string.subject));
        intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendMessage() {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
        startActivity(intent);
    }

    public void receiveMessage() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(SecondActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }
}
