package com.thefinestartist.helpers.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.thefinestartist.Base;
import com.thefinestartist.helpers.KeyboardHelper;
import com.thefinestartist.helpers.VibratorHelper;

/**
 * Created by TheFinestArtist on 1/30/16.
 */
public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                KeyboardHelper.showImmediately(editText);
            }
        });

        Base.initialize(this);
        VibratorHelper.eee();
//        KeyboardHelper.showImmediately(editText);
    }

    @Override protected void onStart() {
        super.onStart();
//        KeyboardHelper.showImmediately(editText);
    }

    @Override protected void onResume() {
        super.onResume();
//        KeyboardHelper.showImmediately(editText);
    }
}
