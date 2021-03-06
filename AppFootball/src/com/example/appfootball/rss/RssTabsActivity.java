package com.example.appfootball.rss;

import com.example.appfootball.R;
import com.example.appfootball.R.drawable;
import com.example.appfootball.R.layout;
import com.example.appfootball.R.string;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class RssTabsActivity extends TabActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rss_tabs);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//Get the TabHost
		TabHost tabHost = getTabHost();
		
		//Art tab
		Intent artIntent = new Intent().setClass(this, RssChannelActivity.class);
		// Set Art category RSS URL
		artIntent.putExtra("rss-url", "http://www.football365.com/premier-league/rss");
		
		//The name of the art tab taken from the String resources
		String artTabName = getResources().getString(R.string.tab_art);
		TabSpec artTabSpec = tabHost.newTabSpec(artTabName).setIndicator(artTabName, getResources().getDrawable(R.drawable.rss_tab_art)).setContent(artIntent);
		
		// Add art tab to TabHost
		tabHost.addTab(artTabSpec);
		
		
		//Tech Tab
				Intent techIntent = new Intent().setClass(this, RssChannelActivity.class);
				// Set Art category RSS URL
				techIntent.putExtra("rss-url", "http://www.espn.co.uk/rss/sport/story/feeds/0.xml?sport=3;type=2");
				
				//The name of the tech tab taken from the String resources
				String techTabName = getResources().getString(R.string.tab_tech);
				TabSpec techTabSpec = tabHost.newTabSpec(techTabName).setIndicator(techTabName, getResources().getDrawable(R.drawable.rss_tab_tech)).setContent(techIntent);
				
				// Add tech tab to TabHost
				tabHost.addTab(techTabSpec);
				
				//Sports Tab
				Intent sportsIntent = new Intent().setClass(this, RssChannelActivity.class);
				// Set Art category RSS URL
				sportsIntent.putExtra("rss-url", "http://feeds.bbci.co.uk/sport/0/football/rss.xml?edition=uk");
				
				//The name of the sports tab taken from the String resources
				String sportsTabName = getResources().getString(R.string.tab_sports);
				TabSpec sportsTabSpec = tabHost.newTabSpec(sportsTabName).setIndicator(sportsTabName, getResources().getDrawable(R.drawable.rss_tab_sports)).setContent(sportsIntent);
				
				// Add tech tab to TabHost
				tabHost.addTab(sportsTabSpec);
				
				//Set current tab to technology
				tabHost.setCurrentTab(1);
	}

}
