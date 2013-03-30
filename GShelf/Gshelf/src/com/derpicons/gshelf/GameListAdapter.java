package com.derpicons.gshelf;

import java.util.List;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameListAdapter extends ArrayAdapter<Game> {

	private int resource;
	private LayoutInflater inflater;
	private Context context;

	public GameListAdapter(Context ctx, int resourceId, List<Game> objects) {

		super(ctx, resourceId, objects);
		resource = resourceId;
		inflater = LayoutInflater.from(ctx);
		context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		/* create a new view of my layout and inflate it in the row */
		convertView = (RelativeLayout) inflater.inflate(resource, null);

		/* Extract the city's object to show */
		Game game = getItem(position);

		/* Take the TextView from layout and set the city's name */
		TextView txtTitle = (TextView) convertView.findViewById(R.id.GameTitleTextView);
		txtTitle.setText(game.getTitle());

		/* Take the TextView from layout and set the city's wiki link */
		TextView txtGameInfo = (TextView) convertView
				.findViewById(R.id.GameInfo);
		txtGameInfo.setText(game.getOverview());

		/* Take the ImageView from layout and set the city's image 
		ImageView imageCity = (ImageView) convertView
				.findViewById(R.id.ImageCity);
		String uri = "drawable/" + city.getImage();
		int imageResource = context.getResources().getIdentifier(uri, null,
				context.getPackageName());
		Drawable image = context.getResources().getDrawable(imageResource);
		imageCity.setImageDrawable(image);
		*/

		return convertView;

	}
}
