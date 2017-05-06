package com.example.hp.retro1;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by HP on 3/11/2017.
 */

public class PrefFragment extends PreferenceFragment {
    public void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}

