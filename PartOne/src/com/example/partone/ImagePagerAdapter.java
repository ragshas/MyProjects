package com.example.partone;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagePagerAdapter extends PagerAdapter{
	
	private List<ImageView> images;
	
	public ImagePagerAdapter(List<ImageView> images) {
		this.images = images;
	}
	
	public Object instantiateItem(ViewGroup container, int position){
		ImageView imageView = images.get(position);
		container.addView(imageView);
		return imageView;
	}
	
	public void destroyItem(ViewGroup container, int position, Object object){
		container.removeView(images.get(position));
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return images.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object o) {
		// TODO Auto-generated method stub
		return view == o;
	}

}
