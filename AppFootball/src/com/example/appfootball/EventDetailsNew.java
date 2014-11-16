package com.example.appfootball;

import com.example.appfootball.adapters.NewEventDetailsArrayAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class EventDetailsNew extends Fragment {
	String[] newEventName = { "First Event", "Second Event", "Third Event" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater
				.inflate(R.layout.events_fragment, container, false);
		ListView lv = (ListView) view.findViewById(R.id.lvEvents);
		
		NewEventDetailsArrayAdapter nEAdapter = new NewEventDetailsArrayAdapter(
				getActivity(), newEventName);
		lv.setAdapter(nEAdapter);
		return view;
	}

}
