package com.example.partone;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TestimonialArrayAdapter extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] body;
	private final String[] composer;

	public TestimonialArrayAdapter(Activity context, String[] body,
			String[] composer) {
		// TODO Auto-generated constructor stub
		super(context, R.layout.lv_tm, body);
		this.context = context;
		this.body = body;
		this.composer = composer;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.lv_tm, null, true);

		TextView tvBody = (TextView) rowView.findViewById(R.id.tvTmBody);
		TextView tvComposer = (TextView) rowView
				.findViewById(R.id.tvTmComposer);

		tvBody.setText(body[position]);
		tvComposer.setText(composer[position]);
		return rowView;
	}

}
