package com.example.ormlitedemo;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

public class DatabaseConfigUtil extends OrmLiteConfigUtil{
	
	public static final Class<?>[] classes = new Class[]{Note.class};

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt", classes);
	}

}
