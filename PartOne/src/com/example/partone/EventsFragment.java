package com.example.partone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class EventsFragment extends Fragment {

	String[] eventName = { "First Event", "Second Event", "Third Event" };
	String[] eventTime = { "11-06-2014", "11-22-2014", "12-24-2014" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater
				.inflate(R.layout.events_fragment, container, false);
		ListView lv = (ListView) view.findViewById(R.id.lvEvents);
		EventsArrayAdapter eAdapter = new EventsArrayAdapter(getActivity(),
				eventName, eventTime);
		lv.setAdapter(eAdapter);

		return view;
	}
}
