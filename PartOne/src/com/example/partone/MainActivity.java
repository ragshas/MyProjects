package com.example.partone;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.support.v4.widget.DrawerLayout;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {
	
	

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

	}
	
	
	public void ibScheduleClick(View v) {
		Intent intent = new Intent(this, Schedule.class);
		startActivity(intent);
	}

	public void ibPlayerClick(View view) {
		Intent intent = new Intent(this, Player.class);
		startActivity(intent);
	}

	public void ibThird(View view) {
		// To do
	}
	
	public void tvAnnClick(View v){
		Intent intent = new Intent(this, Annoucement.class);
		startActivity(intent);
	}
	
	public void tvWelClick(View v){
		Intent intent = new Intent(this, WelcomeSplash.class);
		startActivity(intent);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments

		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment f = null;
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
		switch (position) {
		case 0:
			fragmentManager
					.beginTransaction()
					.replace(R.id.container,
							PlaceholderFragment.newInstance(position + 1))
					.commit();

			mTitle = getString(R.string.title_section1);
			break;
		case 1:
			f = new EventsFragment();
			fragmentManager.beginTransaction().replace(R.id.container, f).addToBackStack(null).commit();
			mTitle = getString(R.string.title_section2);
			break;
		case 2:
			f= new EventDetailsNew();
			fragmentManager.beginTransaction().replace(R.id.container, f).addToBackStack(null).commit();
			mTitle = getString(R.string.title_section3);
			break;
		case 3:
			f = new GalleryFragment();
			fragmentManager.beginTransaction().replace(R.id.container, f)
					.addToBackStack(null).commit();
			mTitle = getString(R.string.title_section4);
			break;
		case 4:
			f = new AboutUsFragment();
			fragmentManager.beginTransaction().replace(R.id.container, f)
					.addToBackStack(null).commit();
			mTitle = getString(R.string.title_section5);
			break;
		case 5:
			Intent intent = new Intent(this, Testimonial.class);
			startActivity(intent);
			mTitle = getString(R.string.title_section6);
			break;
		case 6:
			f = new SponserFragment();
			fragmentManager.beginTransaction().replace(R.id.container, f).addToBackStack(null).commit();
			mTitle = getString(R.string.title_section7);
			break;
		case 7:
			//Intent intent2 = new Intent(this, GoogleMaps.class);
			//startActivity(intent2);
			mTitle = getString(R.string.title_section8);
			break;
		case 8:
//			Intent intentWeather = new Intent(this, WeatherActivity.class);
//			startActivity(intentWeather);
			break;
			default:
				mTitle = ("OUT");
		}
	}

	public void onSectionAttached(int number) {

		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
			break;
		case 5:
			mTitle = getString(R.string.title_section5);
			break;
		case 6:
			mTitle = getString(R.string.title_section6);
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		if (mTitle.equals("HOME")) {
			// Changed
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setIcon(R.drawable.logo);
		} else {
			actionBar.setDisplayShowTitleEnabled(true);

		}
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main_activity_actions, menu);
			
			//restoreActionBar();
			//return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_search) {
			Toast.makeText(getApplication(), "Searching...", Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}