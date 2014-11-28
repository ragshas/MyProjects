package com.example.jsonallpractice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class JsonExample_MultipleListView extends ActionBarActivity {

	ListView listView;
	ArrayList<HashMap<String, String>> arrList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json_example__multiple_list_view);

		listView = (ListView) findViewById(R.id.listview);
		arrList = new ArrayList<HashMap<String, String>>();

		String json_str = getJsonData();

		try {
			JSONArray jArray = new JSONArray(json_str);

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = null;
				json = jArray.getJSONObject(i);

				HashMap<String, String> map1 = new HashMap<String, String>();

				// adding each child node to HashMap Key => value
				map1.put("id", json.getString("id"));
				map1.put("name", json.getString("year"));
				map1.put("url", json.getString("lastUpdated"));

				// adding Hashlist to ArrayList
				arrList.add(map1);
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (!arrList.isEmpty()) {
			ListAdapter adapter = new SimpleAdapter(this, arrList,
					R.layout.list_item, new String[] { "id", "name", "url" },
					new int[] { R.id.wid_textView, R.id.name_textView,
							R.id.url_textView });
			listView.setAdapter(adapter);
		}else {
			Toast.makeText(getApplicationContext(), "sorry", Toast.LENGTH_SHORT).show();
		}
	}
	
	private String getJsonData(){
//		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//        .detectDiskReads()
//        .detectDiskWrites()
//        .detectNetwork()   // or .detectAll() for all detectable problems
//        .penaltyLog()
//        .build());
		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectAll().penaltyLog().penaltyDialog().build());
StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
		.penaltyLog().build());
StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads().detectDiskWrites().detectNetwork() // or.detectAll()forall detectable problems
		.penaltyLog().build());
StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
		.build());
		
		
		String str = "";
		HttpResponse response;
		HttpClient myClient = new DefaultHttpClient();
		HttpPost myConnection = new HttpPost("http://www.football-data.org/soccerseasons/");
		
		try {
			response = myClient.execute(myConnection);
			str = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return str;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.json_example__multiple_list_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
