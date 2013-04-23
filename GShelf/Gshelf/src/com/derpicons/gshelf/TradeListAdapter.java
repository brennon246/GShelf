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

public class TradeListAdapter extends ArrayAdapter<Trade> {
	private int resource;
	private LayoutInflater inflater;
	private Context context;

	public TradeListAdapter(Context ctx, int resourceId, List<Trade> objects) {

		super(ctx, resourceId, objects);
		resource = resourceId;
		inflater = LayoutInflater.from(ctx);
		context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Trade trade = getItem(position);
		ListViewCache viewCache;

		if (convertView == null) {
			convertView = (RelativeLayout) inflater.inflate(resource, null);
			viewCache = new ListViewCache(convertView);
			convertView.setTag(viewCache);
		} else {
			convertView = (RelativeLayout) convertView;
			viewCache = (ListViewCache) convertView.getTag();
		}

		TextView txtGameTitle = viewCache.getTextTGameTitle(resource);
		Game game = new Network(context).getGame(trade.getGameKey());
		txtGameTitle.setText(game.getTitle());

		TextView txtGameConsole = viewCache.getTextTGameConsole(resource);
		txtGameConsole.setText(game.getPlatform());
		
		TextView txtGamePrice = viewCache.getTextTGamePrice(resource);
		txtGamePrice.setText("$" + trade.getPrice());
		
		//TextView txtTradeLocation = viewCache.getTextTradeLocation(resource);
		//txtTradeLocation.setText(trade.getLocation());

		//ImageView TGameCover = viewCache.getTGameCover(resource);
		//TGameCover.setImageDrawable(trade.gettGame().getCover());
		
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
