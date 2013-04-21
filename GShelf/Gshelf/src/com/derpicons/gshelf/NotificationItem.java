package com.derpicons.gshelf;

public class NotificationItem {

	private String Activity;
	private String Message;
	
	public NotificationItem(String a, String m)
	{
		Activity = a;
		Message = m;
	}
	
	public String getActivity() {
		return Activity;
	}
	public void setActivity(String activity) {
		Activity = activity;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
}
