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

public class WishListAdapter extends ArrayAdapter<Game> {

	private int resource;
	private LayoutInflater inflater;
	private Context context;

	public WishListAdapter(Context ctx, int resourceId, List<Game> objects) {

		super(ctx, resourceId, objects);
		resource = resourceId;
		inflater = LayoutInflater.from(ctx);
		context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Game game = getItem(position);
		WishListViewCache viewCache;

		if (convertView == null) {
			convertView = (RelativeLayout) inflater.inflate(resource, null);
			viewCache = new WishListViewCache(convertView);
			convertView.setTag(viewCache);
		} else {
			convertView = (RelativeLayout) convertView;
			viewCache = (WishListViewCache) convertView.getTag();
		}

		TextView txtGameTitle = viewCache.getTextGameTitle(resource);
		txtGameTitle.setText(game.getTitle());

		TextView txtGameInfo = viewCache.getTextGamePrice(resource);
		txtGameInfo.setText(game.getPrice());
		
		TextView txtGameConsole = viewCache.getTextGameConsole(resource);
		txtGameConsole.setText(game.getPlatform());

		ImageView WGameCover = viewCache.getWGameCover(resource);
		WGameCover.setImageDrawable(game.getCover());
		
		/* Take the ImageView from layout and set the city's image */
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
