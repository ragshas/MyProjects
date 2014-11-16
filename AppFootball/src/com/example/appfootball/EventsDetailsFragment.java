package com.example.appfootball;

import java.io.InputStream;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EventsDetailsFragment extends Fragment {

	TextView txtEventsName, txtEventsDetails;
	private String getValue;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = inflater.inflate(R.layout.events_details_frag, container,
				false);
		getValue = getArguments().getString("Id");
		txtEventsName = (TextView) view.findViewById(R.id.tvEventsName);
		txtEventsDetails = (TextView) view.findViewById(R.id.tvEDetails);
		txtEventsDetails.setMovementMethod(new ScrollingMovementMethod());
		getDetails();
		txtEventsName.setText(getValue);
		return view;
	}

	public void getDetails() {
		// Loading text from resource / raw folder
		try {
			Resources res = getResources();
			InputStream in_s = res.openRawResource(R.raw.aboutus);

			byte[] b = new byte[in_s.available()];
			in_s.read(b);
			txtEventsDetails.setText(new String(b));
		} catch (Exception e) {
			// e.printStackTrace();
			txtEventsDetails.setText("Error: can't show help.");
		}

	}

}
