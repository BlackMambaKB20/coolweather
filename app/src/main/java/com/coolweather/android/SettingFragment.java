package com.coolweather.android;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.coolweather.android.util.PrefUtils;


public class SettingFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

//        SwitchCompat ss = (SwitchCompat) getActivity().findViewById(R.id.switch_compat);
//        ss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Logger.d("SwitchCompat " + buttonView + " changed to " + isChecked);
//            }
//        });

        final CheckBoxPreference checkboxPref = (CheckBoxPreference) getPreferenceManager()
                .findPreference(getString(R.string.automatic_positioning));

        checkboxPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Log.d("TAG", "onPreferenceChange: +++++++++++++++++++++++++++++++++++++");
                boolean checked = Boolean.valueOf(newValue.toString());
                PrefUtils.setAutomaticPositioning(checked);
                return true;
            }
        });
//        checkboxPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//
//            /**
//             * @param preference The changed Preference.
//             * @param newValue   The new value of the Preference.
//             * @return True to update the state of the Preference with the new value.
//             */
//            @Override
//            public boolean onPreferenceChange(Preference preference, Object newValue) {
//                boolean checked = Boolean.valueOf(newValue.toString());
//                PrefUtils.setAutomaticPositioning(checked);
//                return true;
//            }
//        });
    }
}