package com.example.elmclean.beeradviser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.annotation.Target;

public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);

        TextView messageView = (TextView)findViewById(R.id.message);
        messageView.setText(messageText);
    }

    // Call onSendMessage() when the button is clicked
    public void onSendMessage(View view) {
        EditText messageView = (EditText)findViewById(R.id.message2);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(this, FindBeerActivity.class);
        intent.putExtra(FindBeerActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }
}
