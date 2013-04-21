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

public class NotificationListAdapter extends ArrayAdapter<NotificationItem> {

	private int resource;
	private LayoutInflater inflater;
	private Context context;

	public NotificationListAdapter(Context ctx, int resourceId, List<NotificationItem> objects) {

		super(ctx, resourceId, objects);
		resource = resourceId;
		inflater = LayoutInflater.from(ctx);
		context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		NotificationItem not = getItem(position);
		ListViewCache viewCache;

		if (convertView == null) {
			convertView = (RelativeLayout) inflater.inflate(resource, null);
			viewCache = new ListViewCache(convertView);
			convertView.setTag(viewCache);
		} else {
			convertView = (RelativeLayout) convertView;
			viewCache = (ListViewCache) convertView.getTag();
		}

		TextView txtGameTitle = viewCache.getTextNotificationActivity(resource);
		txtGameTitle.setText(not.getActivity());

		TextView txtGameInfo = viewCache.getTextNotificationMessage(resource);
		txtGameInfo.setText(not.getMessage());

		return convertView;

	}
}
