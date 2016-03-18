package com.thefinestartist.utils.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.thefinestartist.helpers.log.LogHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by TheFinestArtist on 1/30/16.
 */
public class MainActivity extends AppCompatActivity {

    LogHelper logHelper = new LogHelper(Fragment1.class).methodCount(0).showThreadInfo(true);

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
//                KeyboardUtil.showImmediately(editText);
//                new ActivityBuilder(SubActivity.class)
//                        .set(SubActivity.TITLE, "Hey")
//                        .start();

//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(1);
//                new ActivityBuilder(SubActivity.class)
//                        .set(SubActivity.TITLE, "Hey")
//                        .set(SubActivity.CONTENT, 1)
//                        .set("values", new int[]{1, 2, 3})
//                        .set(SubActivity.ARRAY_LIST, list)
//                        .start();

                Fragment1 fragment1 = new Fragment1();
                Bundle bundle = new Bundle();
                bundle.putString(Fragment1.NAME, "Name");
                fragment1.setArguments(bundle);
//
//                fragment1.setArguments(new BundleBuilder()
//                        .set(Fragment1.NAME, "Hoy")
//                        .build());
//
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment1);
                fragmentTransaction.commitAllowingStateLoss();

//                Log.e("DisplayUtil","DisplayUtil: " + DisplayUtil.getWidth());
            }
        });

//        VibratorUtil.eee();
//        KeyboardUtil.showImmediately(editText);

        logHelper.v("Hey");
        logHelper.v("Hello");
        try {
            JSONObject jsonObject = new JSONObject("{\"caller\":\"getPoiById\",\"results\":{\"indexForPhone\":0,\"indexForEmail\":\"NULL\",\"indexForHomePage\":\"NULL\",\"indexForComment\":\"NULL\",\"phone\":\"05137-930 68\",\"cleanPhone\":\"0513793068\",\"internetAccess\":\"2\",\"overnightStay\":\"2\",\"wasteDisposal\":\"2\",\"toilet\":\"2\",\"electricity\":\"2\",\"cran\":\"2\",\"slipway\":\"2\",\"camping\":\"2\",\"freshWater\":\"2\",\"fieldNamesWithValue\":[\"phone\"],\"fieldNameTranslations\":[\"Telefon\"],\"id\":\"1470\",\"name\":\"Marina Rasche Werft GmbH & Co. KG\",\"latitude\":\"52.3956107286487\",\"longitude\":\"9.56583023071289\"}}");
            logHelper.e(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        logHelper.json("{\"caller\":\"getPoiById\",\"results\":{\"indexForPhone\":0,\"indexForEmail\":\"NULL\",\"indexForHomePage\":\"NULL\",\"indexForComment\":\"NULL\",\"phone\":\"05137-930 68\",\"cleanPhone\":\"0513793068\",\"internetAccess\":\"2\",\"overnightStay\":\"2\",\"wasteDisposal\":\"2\",\"toilet\":\"2\",\"electricity\":\"2\",\"cran\":\"2\",\"slipway\":\"2\",\"camping\":\"2\",\"freshWater\":\"2\",\"fieldNamesWithValue\":[\"phone\"],\"fieldNameTranslations\":[\"Telefon\"],\"id\":\"1470\",\"name\":\"Marina Rasche Werft GmbH & Co. KG\",\"latitude\":\"52.3956107286487\",\"longitude\":\"9.56583023071289\"}}");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                logHelper.e("Hey");
            }
        });
        thread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        KeyboardUtil.showImmediately(editText);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        KeyboardUtil.showImmediately(editText);
    }
}
