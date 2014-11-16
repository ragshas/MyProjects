package com.example.appfootball;

import java.io.InputStream;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SponsersDetail extends Fragment {

	private int position;
	
	TextView txtSponDetails, txtSponName;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.sponsers_detail_frag, container,
				false);
		// Getting image that was clicked
		position = getArguments().getInt("clickedId");
		ImageView iv = (ImageView) view.findViewById(R.id.ivSponDetails);
		iv.setImageResource(position);

		txtSponName = (TextView) view.findViewById(R.id.tvSponName);
		txtSponDetails = (TextView) view.findViewById(R.id.tvSponDetails);
		txtSponDetails.setMovementMethod(new ScrollingMovementMethod());
		txtSponDetails.setSelected(true);
		// Call method to set the sponsor name owing to the item clicked
		getTextFromRes();
		// Set Sponsor Name
		//ReturnSponName(position);
		return view;
	}

	public void getTextFromRes() {
		// Loading text from resource / raw folder
		try {
			Resources res = getResources();
			InputStream in_s = res.openRawResource(R.raw.aboutus);

			byte[] b = new byte[in_s.available()];
			in_s.read(b);
			txtSponDetails.setText(new String(b));
		} catch (Exception e) {
			// e.printStackTrace();
			txtSponDetails.setText("Error: can't show help.");
		}

	}

}
