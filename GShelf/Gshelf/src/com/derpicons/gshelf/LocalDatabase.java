package com.derpicons.gshelf;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class LocalDatabase extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "LocalDb";
	private static final int SCHEMA_VERSION = 1;
	private static final String GAMES_TABLE_NAME = "Games";
	private static final String NOTIFICATIONS_TABLE_NAME = "Notifications";
	private static final String USER_TABLE_NAME = "UserId";

	// games table
	private static final String ELEMENT_TITLE = "title";
	private static final String ELEMENT_PLATFORM = "platform";
	private static final String ELEMENT_OVERVIEW = "overview";
	private static final String ELEMENT_GENRE = "genre";
	private static final String ELEMENT_DEVELOPER = "developer";
	private static final String ELEMENT_KEY = "key";
	private static final String ELEMENT_COVER = "cover";
	private static final String ELEMENT_PRICE = "price";
	private static final String ELEMENT_ISWISHLIST = "isWishList";
	private static final String ELEMENT_THRESHOLD = "threshold";
	private static final String ELEMENT_GAMEURL = "gameUrl";

	// notifications table
	private static final String ELEMENT_ACTIVITY = "activity";
	private static final String ELEMENT_MESSAGE = "message";

	// userid table
	private static final String ELEMENT_USERID = "userId";

	private Context context;

	public LocalDatabase(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);

		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE Games (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, gameUrl TEXT,"
				+ "platform TEXT, overview TEXT, genre TEXT, developer TEXT, key INTEGER not null unique, cover BLOB,"
				+ "price TEXT, isWishlist INTEGER, threshold TEXT);"
				+ " CREATE TABLE Notifications(_id INTEGER PRIMARY KEY AUTOINCREMENT, activity TEXT, message Text);"
				+ "CREATE TABLE UserId (_id INTEGER PRIMARY KEY AUTOINCREMENT, userId INTEGER);");

		// insert
		// ContentValues cv = new ContentValues();
		// cv.put("picture", imageInByte);
		// Long rawID = this.getWritableDatabase().insert(TABLE_NAME,
		// "pictures", cv);

		// read
		// Cursor cursor =
		// pictures.getWritableDatabase().rawQuery("SELECT _id, picture FROM EMPLOYEES ORDER BY picture",
		// null);
	}

	public void addGameToWishlist(Game game, float thresh) {
		ContentValues cv = new ContentValues();
		//cv.put(LocalDatabase.ELEMENT_COVER,
			//	drawableToByteArray(game.getCover()));
		cv.put(LocalDatabase.ELEMENT_DEVELOPER, game.getDeveloper());
		cv.put(LocalDatabase.ELEMENT_GAMEURL, game.getGameUrl());
		cv.put(LocalDatabase.ELEMENT_GENRE, game.getGenre());
		cv.put(LocalDatabase.ELEMENT_ISWISHLIST, 1);
		cv.put(LocalDatabase.ELEMENT_KEY, game.getKey());
		cv.put(LocalDatabase.ELEMENT_OVERVIEW, game.getOverview());
		cv.put(LocalDatabase.ELEMENT_PLATFORM, game.getPlatform());
		cv.put(LocalDatabase.ELEMENT_PRICE, game.getPrice());
		cv.put(LocalDatabase.ELEMENT_THRESHOLD, String.valueOf(thresh));
		cv.put(LocalDatabase.ELEMENT_TITLE, game.getTitle());

		getWritableDatabase().insert(LocalDatabase.GAMES_TABLE_NAME, null, cv);
	}

	public String getThreshold(int gameKey){
		int threshold = 0;
		
		String[] args = new String[1];


		
		args[0] = String.valueOf(gameKey);
	
		Cursor cursor = getReadableDatabase().rawQuery("SELECT "+LocalDatabase.ELEMENT_THRESHOLD +
				" FROM " + LocalDatabase.GAMES_TABLE_NAME +" WHERE "+ LocalDatabase.ELEMENT_KEY
				+ "=?", args);
		cursor.moveToFirst();
		return cursor.getString(cursor.getColumnIndex(LocalDatabase.ELEMENT_THRESHOLD));
	}
	
	public void updateGameInWishlist(String threshold, int gameKey){
		ContentValues cv = new ContentValues();

		cv.put(LocalDatabase.ELEMENT_THRESHOLD, threshold);
		String[] args = new String[1];

		args[0] = String.valueOf(gameKey);
		getWritableDatabase().update(GAMES_TABLE_NAME, cv, LocalDatabase.ELEMENT_KEY+"=?" , args);
	}
	
	public void addGameToLibrary(Game game) {
		ContentValues cv = new ContentValues();
		//cv.put(LocalDatabase.ELEMENT_COVER,
			//	drawableToByteArray(game.getCover()));
		cv.put(LocalDatabase.ELEMENT_DEVELOPER, game.getDeveloper());
		cv.put(LocalDatabase.ELEMENT_GAMEURL, game.getGameUrl());
		cv.put(LocalDatabase.ELEMENT_GENRE, game.getGenre());
		cv.put(LocalDatabase.ELEMENT_ISWISHLIST, 0);
		cv.put(LocalDatabase.ELEMENT_KEY, game.getKey());
		cv.put(LocalDatabase.ELEMENT_OVERVIEW, game.getOverview());
		cv.put(LocalDatabase.ELEMENT_PLATFORM, game.getPlatform());
		cv.put(LocalDatabase.ELEMENT_PRICE, game.getPrice());
	    cv.put(LocalDatabase.ELEMENT_THRESHOLD, game.getPrice());
		cv.put(LocalDatabase.ELEMENT_TITLE, game.getTitle());

		
		
		getWritableDatabase().insert(LocalDatabase.GAMES_TABLE_NAME, null, cv);
	}

	public ArrayList<Game> getGamesFromWishlist() {

		String[] args = new String[1];

		args[0] = String.valueOf(1);

		Cursor cursor = getWritableDatabase().rawQuery(
				"SELECT * FROM Games WHERE isWishList=? ORDER BY title", args);

		ArrayList<Game> games = new ArrayList<Game>();

		Game game = new Game(context);

		while (cursor.moveToNext()) {

			//game.setCover(byteArrayToDrawable(cursor.getBlob(cursor
				//	.getColumnIndex(LocalDatabase.ELEMENT_COVER))));
			
			game.setCover(null);
			game.setDeveloper(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_DEVELOPER)));
			game.setGameUrl(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_GAMEURL)));
			game.setGenre(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_GENRE)));
			game.setKey(cursor.getInt(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_KEY)));
			game.setOverview(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_OVERVIEW)));
			game.setPlatform(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_PLATFORM)));
			game.setPrice(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_PRICE)));
			game.setTitle(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_TITLE)));

			game.setPriceThreshold(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_THRESHOLD)));

			games.add(game);
			game = new Game(context);
		}

		cursor.close();
		return games;
	}

	public ArrayList<Game> getGamesFromDb(int userId) {

		Cursor cursor = this.getWritableDatabase().rawQuery(
				"SELECT * FROM Games ORDER BY title", null);

		ArrayList<Game> games = new ArrayList<Game>();

		Game game = new Game(context);

		while (cursor.moveToNext()) {

			//game.setCover(byteArrayToDrawable(cursor.getBlob(cursor
			//		.getColumnIndex(LocalDatabase.ELEMENT_COVER))));
			game.setCover(null);
			game.setDeveloper(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_DEVELOPER)));
			game.setGameUrl(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_GAMEURL)));
			game.setGenre(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_GENRE)));
			game.setKey(cursor.getInt(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_KEY)));
			game.setOverview(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_OVERVIEW)));
			game.setPlatform(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_PLATFORM)));
			game.setPrice(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_PRICE)));
			game.setTitle(cursor.getString(cursor
					.getColumnIndex(LocalDatabase.ELEMENT_TITLE)));

			games.add(game);
			game = new Game(context);
		}

		cursor.close();
		return games;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	private byte[] drawableToByteArray(Drawable d) {
		BitmapDrawable bitDw = ((BitmapDrawable) d);
		Bitmap bitmap = bitDw.getBitmap();

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		byte[] imageInByte = stream.toByteArray();

		return imageInByte;
	}

	@SuppressWarnings("deprecation")
	private BitmapDrawable byteArrayToDrawable(
			byte[] byteArrayToBeCOnvertedIntoBitMap) {
		Bitmap bitMapImage;
		bitMapImage = BitmapFactory.decodeByteArray(
				byteArrayToBeCOnvertedIntoBitMap, 0,
				byteArrayToBeCOnvertedIntoBitMap.length);

		return new BitmapDrawable(bitMapImage);
	}

}
