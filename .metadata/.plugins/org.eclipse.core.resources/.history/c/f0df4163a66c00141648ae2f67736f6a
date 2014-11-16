package com.example.partone.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.partone.R;

public class SponserImageAdapter extends BaseAdapter {

	private Context context;
	Integer[] sImageIds = { R.drawable.sponser1, R.drawable.sponser2,
			R.drawable.sponser3, R.drawable.sponser4 };

	public SponserImageAdapter(Context c) {
		context = c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return sImageIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return sImageIds[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView iv;
		if (convertView == null) {
			iv = new ImageView(context);
			iv.setLayoutParams(new GridView.LayoutParams(200, 200));
			iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
			iv.setPadding(5, 5, 5, 5);
		} else {
			iv = (ImageView) convertView;
		}
		iv.setImageResource(sImageIds[position]);
		return iv;
	}

}
