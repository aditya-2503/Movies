package com.example.hp.retro1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HP on 3/11/2017.
 */

public class SettingsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PrefFragment())
                .commit();
    }
}
