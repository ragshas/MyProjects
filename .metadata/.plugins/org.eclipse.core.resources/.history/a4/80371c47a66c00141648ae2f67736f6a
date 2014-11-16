package com.example.partone;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GalleryImageAdapter extends BaseAdapter {

	private Context context;
	Integer[] imageIDs = { R.drawable.gallery1, R.drawable.gallery2,
			R.drawable.gallery3, R.drawable.gallery4, R.drawable.gallery5,
			R.drawable.gallery6, R.drawable.gallery7, R.drawable.gallery8 };

	public GalleryImageAdapter(Context c) {
		context = c;
	}

	@Override
	// --returns the number of images --
	public int getCount() {
		// TODO Auto-generated method stub
		return imageIDs.length;
	}

	@Override
	// returns the item --
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return imageIDs[position];
	}

	@Override
	// returns the ID of an item
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	// returns an ImageView view --
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(5, 5, 5, 5);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(imageIDs[position]);
		return imageView;
	}

}
