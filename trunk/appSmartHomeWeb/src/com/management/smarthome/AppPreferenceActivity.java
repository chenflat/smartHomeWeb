package com.management.smarthome;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;

public class AppPreferenceActivity extends PreferenceActivity {


	
	public AppPreferenceActivity() {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.prefs);

		EditTextPreference txtHostIP = (EditTextPreference) this.findPreference("PrefsWebHost");
		if (txtHostIP != null) {
			txtHostIP.setPositiveButtonText("确定");
			txtHostIP.setNegativeButtonText("取消");
		}

		EditTextPreference txtUserName = (EditTextPreference) this.findPreference("PrefsUserName");
		EditTextPreference txtPassword = (EditTextPreference) this.findPreference("PrefsPassword");

	}


	
	

}
