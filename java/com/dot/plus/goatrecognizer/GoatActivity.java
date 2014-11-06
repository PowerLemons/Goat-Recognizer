package com.dot.plus.goatrecognizer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class GoatActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goat);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new GoatFragment())
                    .commit();
        }
    }

}
