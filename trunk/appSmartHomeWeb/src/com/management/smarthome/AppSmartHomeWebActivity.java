package com.management.smarthome;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;

public class AppSmartHomeWebActivity extends Activity {

	private static final String tag = "AppSmartHomeWebActivity";
	
	private String hostUrl;
	
	private WebView webView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		SharedPreferences sprefs = PreferenceManager
				.getDefaultSharedPreferences(this.getApplicationContext());
		hostUrl = sprefs.getString("PrefsWebHost",
				"http://192.168.1.109:8180/smarthomeweb/");
		try {
			webView = (WebView) this.findViewById(R.id.webView1);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadUrl(hostUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		try {
			switch (item.getItemId()) {
			case R.id.menu_prefs:
				Intent intent = new Intent(getApplicationContext(),
						AppPreferenceActivity.class);
				startActivity(intent);
				break;
			case R.id.menu_refresh:
				if(webView!=null) {
					
					SharedPreferences sprefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
					
					hostUrl = sprefs.getString("PrefsHostUrl","");
					if(null!=hostUrl && !"".equals(hostUrl)) {
						webView.loadUrl(hostUrl);
					}
				}
				
				break;
			case R.id.menu_exit:
				// SysUtil mSysUtil= new SysUtil(AppSmartHomeWebActivity.this);
				// mSysUtil.exit();
				break;
			case R.id.menu_about:

				break;
			default:
				break;
			}
		}catch(Exception e) {
			Log.i(tag, e.getLocalizedMessage());
		}
		
		

		return true;
	}

}