package com.example.fireapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private EditText mValueField;
    private Button mAddButton;
    private EditText mKeyValue;
    private Firebase mRootRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mValueField = (EditText) findViewById(R.id.valuefield);
        mAddButton = (Button) findViewById(R.id.addbutton);
        mKeyValue = (EditText)findViewById(R.id.keyvalue);

        mRootRef = new Firebase("https://fireapp-d0263.firebaseio.com/Users");
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value =  mValueField.getText().toString();
                String key = mKeyValue.getText().toString();

                Firebase childRef = mRootRef.child(key);
                //childRef.push().setValue(value);
                childRef.setValue(value);
            }
        });


    }
}
