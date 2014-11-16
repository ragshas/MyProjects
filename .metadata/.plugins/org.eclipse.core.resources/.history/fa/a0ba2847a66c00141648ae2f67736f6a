package com.example.partone;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayersCustomArrayAdapter extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] playersName;
	private final Integer[] playerImage;
	private final String[] age;

	public PlayersCustomArrayAdapter(Activity context, String[] playersName, String[] age, Integer[] playerImage) {
		super(context, R.layout.lv_players, playersName);
		this.context = context;
		this.playersName = playersName;
		this.playerImage = playerImage;
		this.age = age;
	}
	
	//Recycling
	static class ViewContainer {
		public ImageView ivPlayer;
		public TextView txtTitle;
		public TextView txtAge;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
	
		final ViewContainer viewContainer;
		View rowView = view;
	
		// if the row is displayed for the first time
		if (rowView == null) {
			Log.d("PlayerCustomArrayAdapter", "New");
			LayoutInflater inflater = context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.lv_players, null, true);
	
			// Create a view container object
	
			viewContainer = new ViewContainer();
	
			// get the reference to all the views in the row
			viewContainer.txtTitle = (TextView) rowView
					.findViewById(R.id.tvPlayerName);
			viewContainer.txtAge = (TextView) rowView
					.findViewById(R.id.tvPlayerAge);
			viewContainer.ivPlayer = (ImageView) rowView
					.findViewById(R.id.ivPlayer);
			ImageView iv = (ImageView) rowView.findViewById(R.id.ivGoProfile);
			
			iv.setOnClickListener(new View.OnClickListener() {
				String pName = viewContainer.txtTitle.getText().toString();
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(v.getContext(), PlayerProfile.class);
					intent.putExtra("name", pName);
					v.getContext().startActivity(intent);
				}
			});
			// assign the view container to the rowView
			rowView.setTag(viewContainer);
	
		} else {
			// view was previously created; can recycle
			Log.d("PlayerCustomArrayAdapter", "Recycling");
	
			viewContainer = (ViewContainer) rowView.getTag();
		}
	
		viewContainer.txtTitle.setText(playersName[position]);
		viewContainer.txtAge.setText(age[position]);
		viewContainer.ivPlayer.setImageResource(playerImage[position]);
	
		return rowView;
	}



	//	@Override
//	public View getView(int position, View view, ViewGroup parent) {
//		// --Print the index of the row to examine --
//		Log.d("CustomArrayAdapter", String.valueOf(position));
//
//		LayoutInflater inflater = context.getLayoutInflater();
//		View rowView = inflater.inflate(R.layout.lv_players, null, true);
//
//		// --get a reference to all the views on the xml layout --
//		TextView tvName = (TextView) rowView.findViewById(R.id.tvPlayerName);
//		TextView tvAge = (TextView) rowView.findViewById(R.id.tvPlayerAge);
//		ImageView ivPlayerImage = (ImageView)rowView.findViewById(R.id.ivPlayer);
//
//		tvName.setText(playersName[position]);
//		//tvAge.setText(age[position]);
//		ivPlayerImage.setImageResource(playerImage[position]);
//		return rowView;
//
//	}


}


