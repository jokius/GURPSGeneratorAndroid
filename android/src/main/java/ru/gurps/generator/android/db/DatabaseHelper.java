package ru.gurps.generator.android.db;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.singletons.DbSingleton;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.b50.migrations.MigrationsDatabaseHelper;

public class DatabaseHelper extends MigrationsDatabaseHelper {
	
	public DatabaseHelper(Context context) {
		super(context, context.getString(R.string.database_name), null, context.getResources().getInteger(
				R.integer.database_version), context.getString(R.string.package_name));
	}

	protected SQLiteDatabase db(){
		if (DbSingleton.getInstance().getDb() == null)
			DbSingleton.getInstance().setDb(getWritableDatabase());
		return DbSingleton.getInstance().getDb();
	}
}

