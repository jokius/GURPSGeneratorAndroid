package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;


public class DBVersion3 extends AbstractMigration {

    public void up() {
        execSQL("CREATE TABLE Modifiers" +
                "(" +
                "_id integer primary key," +
                "name varchar(255) not null," +
                "nameEn varchar(255)," +
                "cost integer not null," +
                "description clob," +
                "maxLevel integer not null," +
                "combat boolean not null," +
                "improving boolean not null" +
                ");");

        try {
            String tableName = "Modifiers";
            String columns = "_id, name, nameEn, cost, description, maxLevel, combat, improving";
            String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
            String str2 = ");";

            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("assets/csv/modifiers.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(in));
            String[] str;

            while ((str = reader.readNext()) != null) {
                execSQL(str1 + "\"" + str[0] + "\"," + "\"" + str[1] + "\"," + "\"" + str[2]
                        + "\"," + "\"" + str[3] + "\"," + "\"" + str[4] + "\"," + "\"" + str[5]
                        + "\"," + "\"" + str[6] + "\"," + "\"" + str[7] + "\"" + str2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void down() {
        execSQL("DROP TABLE Modifiers");
    }

}

