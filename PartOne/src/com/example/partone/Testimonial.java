package com.example.partone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class Testimonial extends ActionBarActivity {

	String[] body = {
			"Joined since 20011 as a 7 year old kid, I have learned many things from YC, and I would like thank all my collegeues and teachers that have helped me",
			"I love the way these boys play. Best wishes to the team." };
	String[] composer = { "Peter Jr", "Robin son" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testimonial_activity);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		ListView lv = (ListView) findViewById(R.id.lvTestimonials);

		TestimonialArrayAdapter tAdapter = new TestimonialArrayAdapter(this,
				body, composer);
		lv.setAdapter(tAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_search:

			Toast.makeText(getApplication(), "WHAT", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_compose:
			break;
		case android.R.id.home:
			this.finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
