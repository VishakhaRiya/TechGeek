package com.app.newsreaderapp;

import java.util.ArrayList;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
	
	private static final String TAG="Database";
	private static final String DATABASE_NAME="NewsReader";
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_TABLE="NewsItems";
	
	private static final String KEY_ID="CID";
	private static final String KEY_DATE="CDATE";
	private static final String KEY_LINK="CLINK";
	private static final String KEY_TIME="CTIME";
	private static final String KEY_DESCRIPTION="CDESC";
	private static final String KEY_TITLE="CTITLE";
	
	private static final String DATABASE_CREATE="create table "+ DATABASE_TABLE + " ( "+ KEY_ID + " INTEGER PRIMARY KEY  , " + KEY_TITLE + " TEXT, " + KEY_LINK +" TEXT, " 
	+ KEY_DESCRIPTION + " TEXT, " + KEY_DATE+ " INTEGER, " + KEY_TIME + " TEXT " + ");";
	
	private SQLiteDatabase newsreaderDB;
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
    @Override
	public void onCreate(SQLiteDatabase db) {
    
	// TODO Auto-generated method stub
	db.execSQL(DATABASE_CREATE);
	
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
	Log.w(TAG, "upgrading database from version "+oldVersion +"to" +newVersion+",which will destroy all old data");
	db.execSQL("DROP TABLE IF EXISTS"+ DATABASE_TABLE);
	onCreate(db);
	}
	
	public void addNews(News news)
	{
		
		SQLiteDatabase db= this.getWritableDatabase();
		ContentValues values= new ContentValues();
		//inserting values
		values.put(KEY_ID, news.getID());
		values.put(KEY_TITLE, news.getTitle());
		values.put(KEY_LINK, news.getLink());
		values.put(KEY_DESCRIPTION, news.getDescription());
		values.put(KEY_DATE, news.getDate());
		values.put(KEY_TIME, news.getTime());
		//inserting rows
		db.insert(DATABASE_TABLE, null, values);
		Log.d(TAG, "news successfully inserted");
		//db.close();
		
		
	}
	
	public ArrayList<News> getNewsItems()
	{
		
		ArrayList<News> newslist=new ArrayList<News>();
				
		String query="Select * from " + DATABASE_TABLE;
		
		Cursor cursor=this.getReadableDatabase().rawQuery(query,null);
				
		if (cursor.moveToFirst()) {
			do {
				News news = new News();
				
				news.setID(Integer.parseInt(cursor.getString(0)));
				news.setTitle(cursor.getString(1));
				news.setLink(cursor.getString(2));
				news.setDescription(cursor.getString(3));
				news.setDate(cursor.getString(4));
				news.setTime(cursor.getString(5));
			
				newslist.add(news);
			} while (cursor.moveToNext());
		}
		
		
		return newslist;
	}
	
	

}
