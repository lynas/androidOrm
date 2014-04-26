package com.example.ormlitedemo;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MainActivity extends Activity {
	DatabaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doNoteDataStuff();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void doNoteDataStuff(){
		dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		RuntimeExceptionDao<Note, Integer> noteDao = dbHelper.getNoteRuntimeExceptionDao();
		
		/*Note note1 = new Note();
		note1.setSubject("Note Subject1");
		note1.setText("Note Text 1");
		
		Note note2 = new Note();
		note2.setSubject("Note Subject2");
		note2.setText("Note Text 2");
		
		noteDao.create(note1);
		noteDao.create(note2);*/
		
		List<Note> notes = noteDao.queryForAll();
		Log.d("demo", notes.toString());
		
		notes = noteDao.queryForEq("id", 1);
		Log.d("demo", notes.toString());
		
		Log.d("demo", "size : "+notes.size());
		
		OpenHelperManager.releaseHelper();
		
	}
	
	

}
