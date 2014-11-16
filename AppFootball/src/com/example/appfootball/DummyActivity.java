package com.example.appfootball;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@SuppressWarnings("deprecation")
public class DummyActivity extends Activity {
	Integer[] imageIDs = { R.drawable.gallery1, R.drawable.gallery2,
			R.drawable.gallery3, R.drawable.gallery4, R.drawable.gallery5,
			R.drawable.gallery6, R.drawable.gallery7, R.drawable.gallery8 };
	ImageView imageSelect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_fragment);
		/*
		 * Gallery gallery = (Gallery) findViewById(R.id.gallery1); imageSelect
		 * = (ImageView) findViewById(R.id.ivGallery); gallery.setAdapter(new
		 * GalleryImageAdapter(this));
		 * 
		 * gallery.setOnItemClickListener(new OnItemClickListener() { public
		 * void onItemClick(AdapterView<?> parent, View v, int position, long
		 * id) { Toast.makeText(getApplicationContext(), "Selected" + position,
		 * Toast.LENGTH_SHORT).show();
		 * imageSelect.setImageResource(imageIDs[position]); } });
		 */
	}

}
