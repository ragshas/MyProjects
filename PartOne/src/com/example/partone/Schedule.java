package com.example.partone;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class Schedule extends ActionBarActivity {
	
	String[] headerTxt = {"COMMUNITY SHIELD", "YOUTH CUP"};
	String[] date = {"AUG 12 - SEP 20", "SEP 02 - MAR 13"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		

		ListView lv= (ListView)findViewById(R.id.lvSchedule);
		//lv.setAdapter(new ArrayAdapter<String>(this, R.layout.lv_schedule, R.id.tvHeader, headerTxt));*/
		
		//--Using custom array adapter --
		CustomArrayAdapter adapter = new CustomArrayAdapter(this, headerTxt, date);
		lv.setAdapter(adapter);
		
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_actions, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.action_search:
			Toast.makeText(getApplication(), "Pressed", Toast.LENGTH_LONG).show();
			return true;
		case android.R.id.home:
			this.finish();
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
		
	}
}
