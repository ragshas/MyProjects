package com.example.appfootball;

import com.example.appfootball.adapters.SponserImageAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class SponserFragment extends Fragment {
	
	Integer[] sImageIds = {R.drawable.sponser1,R.drawable.sponser2,R.drawable.sponser3, R.drawable.sponser4};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.sponser_fragment, container,
				false);
		GridView gvSponser = (GridView) view.findViewById(R.id.gvSponser);
		gvSponser.setAdapter(new SponserImageAdapter(view.getContext()));

		gvSponser.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//int idClicked = position;
				FragmentManager fm = getFragmentManager();
				Fragment fragment = null;
				fragment = new SponsersDetail();
				
				//Sending clicked info to another fragment
				Bundle args = new Bundle();
				args.putInt("clickedId", sImageIds[position]);
				fragment.setArguments(args);
				//Starting Fragment
				fm.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();


			}
		});
		return view;
	}
}
