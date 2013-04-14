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
		DealListViewCache viewCache;

		if (convertView == null) {
			convertView = (RelativeLayout) inflater.inflate(resource, null);
			viewCache = new DealListViewCache(convertView);
			convertView.setTag(viewCache);
		} else {
			convertView = (RelativeLayout) convertView;
			viewCache = (DealListViewCache) convertView.getTag();
		}

		TextView txtDealLink = viewCache.getTextDealEffect(resource);
		txtDealLink.setText(deal.getDescription());

		ImageView GameCover = viewCache.getDealImage(resource);
		GameCover.setImageDrawable(deal.getImage());
		
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
