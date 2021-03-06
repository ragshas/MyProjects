package com.example.appfootball.rss;

import java.util.List;

import com.example.appfootball.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appfootball.rss.RssItem;
import com.example.appfootball.rss.ListListener;
import com.example.appfootball.rss.RssReader;


public class RssChannelActivity extends Activity{
	
	//A Reference to this Activity
	private RssChannelActivity local;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rss_channel);
		
		//Get the Rss URl that was set in the RssTabActivity
		String rssUrl = (String)getIntent().getExtras().get("rss-url");
		
		//Set reference to this activity
		local = this;
		GetRSSDataTask task = new GetRSSDataTask();
		
		//Start process Rss Task
		task.execute(rssUrl);
	}
	
	/*
	 * This class downloads and parse RSS channel feed.
	 */
	private class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem>>{

		@Override
		protected List<RssItem> doInBackground(String... urls) {
			// TODO Auto-generated method stub
			try {
				//Create Rss reader
				RssReader rssReader = new RssReader(urls[0]);
				
				//Parse RSS, get items
				return rssReader.getItems();
			} catch (Exception e) {
				// TODO: handle exception
				Log.e("RssChannelActivity", e.getMessage());
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(List<RssItem> result) {
			
			//Get a listView from the RSS Channel view
			ListView itcItems = (ListView)findViewById(R.id.rssChannelListView);
			
			//Create a list adapter
			ArrayAdapter<RssItem>adapter = new ArrayAdapter<RssItem>(local, android.R.layout.simple_list_item_1, result);
			//Set list adapter for the ListView
			itcItems.setAdapter(adapter);
			
			//Set list view item click listener
			itcItems.setOnItemClickListener(new ListListener(result, local));
			super.onPostExecute(result);
		}
		
	}

}
