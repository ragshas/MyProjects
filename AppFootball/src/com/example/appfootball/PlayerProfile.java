package com.example.appfootball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class PlayerProfile extends ActionBarActivity {

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_profile);
		
		TextView tvName = (TextView) findViewById(R.id.tvPProfileName);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String getText = bundle.getString("name");
		
		tvName.setText(getText);
		

	}

}
