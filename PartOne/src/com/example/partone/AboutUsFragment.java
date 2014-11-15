package com.example.partone;

import java.io.InputStream;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUsFragment extends Fragment implements OnClickListener {
	ImageView imagePhone, ImageEmail, ImageMap;
	TextView txtAboutUs;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.aboutus_frag, container, false);

		txtAboutUs = (TextView) view.findViewById(R.id.tvInsideSV);
		imagePhone = (ImageView) view.findViewById(R.id.ivPhone);
		ImageEmail = (ImageView) view.findViewById(R.id.ivEmail);
		ImageMap = (ImageView) view.findViewById(R.id.ivMap);

		getTextFromRes(); // Calling method to get text
		imagePhone.setOnClickListener(this);
		ImageEmail.setOnClickListener(this);
		ImageMap.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ivPhone:

			DialogFragment newFragment = CustomDialogFragment.newInstance();
			newFragment.show(getFragmentManager(), "dialog");
			break;
		case R.id.ivEmail:
			/* Create the Intent */
			final Intent emailIntent = new Intent(
					android.content.Intent.ACTION_SEND);

			/* Fill it with Data */
			emailIntent.setType("plain/text");
			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
					new String[] { "ragshas@gmail.com" });

			/* Send it off to the Activity-Chooser */
			startActivity(Intent.createChooser(emailIntent, "Send mail..."));

			break;
		case R.id.ivMap:
			double latitude = 27.694987;
			double longitude = 85.335716;
			String label = "ABC Label";
			String uriBegin = "geo:" + latitude + "," + longitude;
			String query = latitude + "," + longitude + "(" + label + ")";
			String encodedQuery = Uri.encode(query);
			String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
			Uri uri = Uri.parse(uriString);
			Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
			startActivity(intent);
		default:
			break;
		}

	}

	public void getTextFromRes() {
		// Loading text from resource / raw folder
		try {
			Resources res = getResources();
			InputStream in_s = res.openRawResource(R.raw.aboutus);

			byte[] b = new byte[in_s.available()];
			in_s.read(b);
			txtAboutUs.setText(new String(b));
		} catch (Exception e) {
			// e.printStackTrace();
			txtAboutUs.setText("Error: can't show help.");
		}

	}

}
