package com.example.appfootball.adapters;

import java.io.InputStream;

import com.example.appfootball.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NewEventDetailsArrayAdapter extends ArrayAdapter<String> {

	private Activity context;
	private String[] newEName;
	TextView tvEName, tvDialoge;
	ImageView ivDecline;

	public NewEventDetailsArrayAdapter(Activity context, String[] newEventName) {
		// TODO Auto-generated constructor stub
		super(context, R.layout.lv_new_event, newEventName);
		this.context = context;
		this.newEName = newEventName;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = context.getLayoutInflater();
		View row = inflater.inflate(R.layout.lv_new_event, null, true);

		tvEName = (TextView) row.findViewById(R.id.tvNewEventsName);
		tvEName.setText(newEName[position]);
		tvEName.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog d = new Dialog(context);
				d.setContentView(R.layout.event_dialog_main);
				d.setTitle("Event");
				
				tvDialoge = (TextView)d.findViewById(R.id.tvEDialog);
				getText();
				
				ImageView iv = (ImageView)d.findViewById(R.id.ivEDialog);
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
				
				
//				Toast.makeText(getContext(), "Raghab", Toast.LENGTH_SHORT).show();
//				Fragment f = null;
//				f = new OpenEventDetailsFrag();
//				FragmentTransaction ft = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
//				ft.replace(R.id.container, f).addToBackStack(null).commit();
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
		return row;
	}
}
