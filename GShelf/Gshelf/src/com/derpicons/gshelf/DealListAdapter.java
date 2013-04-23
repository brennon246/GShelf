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
		/* Take the ImageView from layout and set the city's image */
		/*
		ImageView imageDeal = viewCache.getDealImageView(resource);
		imageDeal.setImageDrawable(deal.getImage());
		*/
		/*
		 * ImageView imageCity = (ImageView)
		 * convertView.findViewById(R.id.ImageCity); String uri = "drawable/" +
		 * city.getImage(); int imageResource =
		 * context.getResources().getIdentifier(uri, null,
		 * context.getPackageName()); Drawable image =
		 * context.getResources().getDrawable(imageResource);
		 * imageCity.setImageDrawable(image);
		 */

		return convertView;

	}
}
