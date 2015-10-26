package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;


public class DBVersion1 extends AbstractMigration {

    public void up() {
        execSQL("CREATE TABLE Features" +
                "(" +
                "_id integer primary key," +
                "advantage boolean," +
                "name varchar(255)," +
                "nameEn varchar(255)," +
                "featureType varchar(255)," +
                "cost integer," +
                "description clob," +
                "maxLevel integer," +
                "psi boolean," +
                "cybernetic boolean" +
                ");");

        try {
            String tableName = "Features";
            String columns = "_id, advantage, name, nameEn, featureType, cost, description, maxLevel," +
                    "psi, cybernetic";
            String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
            String str2 = ");";

            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("assets/csv/features.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(in));
            String[] str;

            while ((str = reader.readNext()) != null) {
                execSQL(str1 + "\"" + str[0] + "\"," + "\"" + str[1] + "\"," + "\"" + str[2]
                        + "\"," + "\"" + str[3] + "\"," + "\"" + str[4] + "\"," + "\"" + str[5]
                        + "\"," + "\"" + str[6] + "\"," + "\"" + str[7] + "\"," + "\"" + str[8]
                        + "\"," + "\"" + str[9] + "\"" + str2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void down() {
        execSQL("DROP TABLE Features");
    }

}

