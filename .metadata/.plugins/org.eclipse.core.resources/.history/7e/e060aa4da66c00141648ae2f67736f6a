package com.example.partone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ListView;

public class Player extends ActionBarActivity {

	String[] playersName = { "Player 1", "Player 2", "Player 3", "Player 4",
			"Player 5", "Player 6", "Player 7", "Player 8", "Player 9",
			"Player 10", "Player 11" };
	Integer[] playerImage = { R.drawable.player1, R.drawable.player2,
			R.drawable.player3, R.drawable.player4, R.drawable.player5,
			R.drawable.player6, R.drawable.player7, R.drawable.player8,
			R.drawable.player9, R.drawable.player10, R.drawable.player11 };
	String[] age = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_layout);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setIcon(android.R.color.transparent);

		ListView lv = (ListView) findViewById(R.id.lvPlayer);
		PlayersCustomArrayAdapter myAdapter = new PlayersCustomArrayAdapter(
				this, playersName, age, playerImage);
		lv.setAdapter(myAdapter);

	}
	

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
