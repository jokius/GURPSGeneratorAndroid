package ru.gurps.generator.android.db;

import ru.gurps.generator.android.R;
import android.content.Context;
import com.b50.migrations.MigrationsDatabaseHelper;

public class DatabaseHelper extends MigrationsDatabaseHelper {
	
	public DatabaseHelper(Context context) {
		super(context, context.getString(R.string.database_name), null, context.getResources().getInteger(
				R.integer.database_version), context.getString(R.string.package_name));
	}

}

