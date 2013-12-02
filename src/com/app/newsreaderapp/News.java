package com.app.newsreaderapp;

import android.util.Log;

public class News {
	private Integer ID;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	private String Title;
	private String link;
	private String Description;
	private String date;
	private String time;
	
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getLink() {
		//Log.i("$$$$$$$$$$$$$$$$$$$$$$", link);
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public News(Integer iD, String title, String link, String description,
			String date, String time) {
		super();
		ID = iD;
		Title = title;
		this.link = link;
		Description = description;
		this.date = date;
		this.time = time;
	}
	public News() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.Description;
	}

}



