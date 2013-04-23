package com.derpicons.gshelf;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DealListAdapter extends ArrayAdapter<Deal> {
	private int resource;
	private LayoutInflater inflater;
	private Context context;

	public DealListAdapter(Context ctx, int resourceId, List<Deal> objects) {

		super(ctx, resourceId, objects);
		resource = resourceId;
		inflater = LayoutInflater.from(ctx);
		context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Deal deal = getItem(position);
		ListViewCache viewCache;

		if (convertView == null) {
			convertView = (RelativeLayout) inflater.inflate(resource, null);
			viewCache = new ListViewCache(convertView);
			convertView.setTag(viewCache);
		} else {
			convertView = (RelativeLayout) convertView;
			viewCache = (ListViewCache) convertView.getTag();
		}

		TextView txtDealEffect = viewCache.getTextDealEffect(resource);
		txtDealEffect.setText(deal.getDescription());
		
		TextView txtDealSource = viewCache.getTextDealSource(resource);
		txtDealSource.setText(deal.getSource());

		return convertView;

	}
}
