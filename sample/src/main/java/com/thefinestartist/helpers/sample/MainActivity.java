package com.thefinestartist.helpers.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.thefinestartist.Base;
import com.thefinestartist.helpers.ActivityBuilder;
import com.thefinestartist.helpers.BundleBuilder;
import com.thefinestartist.helpers.VibratorHelper;

import java.util.ArrayList;

/**
 * Created by TheFinestArtist on 1/30/16.
 */
public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                KeyboardHelper.showImmediately(editText);
//                new ActivityBuilder(SubActivity.class)
//                        .set(SubActivity.TITLE, "Hey")
//                        .start();

                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                new ActivityBuilder(SubActivity.class)
                        .set(SubActivity.TITLE, "Hey")
                        .set(SubActivity.CONTENT, 1)
                        .set("values", new int[]{1, 2, 3})
                        .set(SubActivity.ARRAY_LIST, list)
                        .start();

                Fragment1 fragment1 = new Fragment1();
                fragment1.setArguments(new BundleBuilder()
                        .set(Fragment1.NAME, "Hoy")
                        .build());

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment1);
                fragmentTransaction.commitAllowingStateLoss();
            }
        });

        Base.initialize(this);
        VibratorHelper.eee();
//        KeyboardHelper.showImmediately(editText);

//        ActivityBuilder intentBuilder = new ActivityBuilder(MainActivity.class)
//                .put("Hey", 1);
        new MainActivity();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        KeyboardHelper.showImmediately(editText);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        KeyboardHelper.showImmediately(editText);
    }
}
