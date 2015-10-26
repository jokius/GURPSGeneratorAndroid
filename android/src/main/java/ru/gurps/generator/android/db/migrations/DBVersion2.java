package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;


public class DBVersion2 extends AbstractMigration {

    public void up() {
        execSQL("CREATE TABLE Addons" +
                "(" +
                "_id integer primary key," +
                "featureId integer," +
                "name varchar(255)," +
                "nameEn varchar(255)," +
                "cost integer," +
                "description clob," +
                "maxLevel integer," +
                "FOREIGN KEY(featureId) REFERENCES Features(id)" +
                ");");

        execSQL("CREATE INDEX feature_id_addon_index ON Addons (featureId);");

        try {
            String tableName = "Addons";
            String columns = "_id, featureId, name, nameEn, cost, description, maxLevel";
            String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
            String str2 = ");";

            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("assets/csv/addons.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(in));
            String[] str;

            while ((str = reader.readNext()) != null) {
                execSQL(str1 + "\"" + str[0] + "\"," + "\"" + str[1] + "\"," + "\"" + str[2]
                        + "\"," + "\"" + str[3] + "\"," + "\"" + str[4] + "\"," + "\"" + str[5]
                        + "\"," + "\"" + str[6] + "\"" + str2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void down() {
        execSQL("DROP TABLE Addons");
    }

}

