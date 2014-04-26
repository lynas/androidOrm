package com.example.ormlitedemo;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
	
	private static final String DATABASE_NAME = "notes.db";
	private static final int DATABASE_VERSION = 1;
	
	private Dao<Note, Integer> noteDao = null;
	private RuntimeExceptionDao<Note, Integer> noteRuntimeDao = null;
	
	public DatabaseHelper(Context context){ 
		super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
		
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		// TODO Auto-generated method stub
		try {
			TableUtils.createTableIfNotExists(connectionSource, Note.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource oldVersion, int newVersion,
			int arg3) {
		try {
			TableUtils.dropTable(connectionSource, Note.class, true);
			onCreate(database,connectionSource);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Dao<Note, Integer> getNoteDao() throws SQLException{
		if(noteDao== null){
			noteDao = getDao(Note.class);
			return noteDao;
		}
		return noteDao;
		
			
	}
	
	
	public RuntimeExceptionDao<Note, Integer> getNoteRuntimeExceptionDao(){
		if(noteRuntimeDao == null){
			noteRuntimeDao = getRuntimeExceptionDao(Note.class);
			
		}
		return noteRuntimeDao;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
