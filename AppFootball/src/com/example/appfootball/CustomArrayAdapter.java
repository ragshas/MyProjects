package com.example.appfootball;

import java.io.InputStream;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String> {
	TextView tvDetails, tvDialoge;
	ImageView ivDecline;
	private final Activity context;
	private final String[] headerTxt;
	private final String[] date;

	public CustomArrayAdapter(Activity context, String[] headerTxt,
			String[] date) {
		super(context, R.layout.lv_schedule, headerTxt);
		this.context = context;
		this.headerTxt = headerTxt;
		this.date = date;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// --Print the index of the row to examine --
		Log.d("CustomArrayAdapter", String.valueOf(position));

		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.lv_schedule, null, true);

		// --get a reference to all the views on the xml layout --
		TextView tvHeader = (TextView) rowView.findViewById(R.id.tvHeader);
		TextView tvDate = (TextView) rowView.findViewById(R.id.tvDate);
		tvDetails = (TextView) rowView.findViewById(R.id.tvMoreDetails);
		tvHeader.setText(headerTxt[position]);
		tvDate.setText(date[position]);

		tvDetails.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog d = new Dialog(context);
				d.setContentView(R.layout.event_dialog_main);
				
				d.setTitle("Schedule");

				tvDialoge = (TextView) d.findViewById(R.id.tvEDialog);
				getText();

				ImageView iv = (ImageView) d.findViewById(R.id.ivEDialog);
				iv.setImageResource(R.drawable.map_pin);
				d.show();

				ivDecline = (ImageView) d.findViewById(R.id.ivEDecline);

				ivDecline.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						d.dismiss();
					}
				});
			}

			private void getText() {
				// TODO Auto-generated method stub
				try {
					Resources res = context.getResources();
					InputStream iStream = res.openRawResource(R.raw.events);

					byte[] b = new byte[iStream.available()];
					iStream.read(b);
					tvDialoge.setText(new String(b));
				} catch (Exception e) {
					// TODO: handle exception
					tvDialoge.setText("Error");
				}

			}
		});

		return rowView;

	}

}
