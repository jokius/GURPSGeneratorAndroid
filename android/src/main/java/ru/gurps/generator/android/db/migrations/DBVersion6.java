package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;


public class DBVersion6 extends AbstractMigration {

    public void up() {
        execSQL("create table Spells" +
                "(" +
                "_id integer auto_increment primary key not null," +
                "school integer," +
                "name varchar(255)," +
                "nameEn varchar(255)," +
                "spellType integer," +
                "description clob," +
                "complexity integer," +
                "cost integer," +
                "maxCost integer," +
                "needTime varchar(255)," +
                "duration varchar(255)," +
                "maintainingCost varchar(255)," +
                "thing varchar(255)," +
                "createCost varchar(255)," +
                "demands varchar(255)" +
                ");");
        
        try {
            String tableName = "Spells";
            String columns = "_id, school, name, nameEn, spellType, description, complexity, " +
                    "cost, maxCost, needTime, duration, maintainingCost, thing, createCost, " +
                    "demands";
            String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
            String str2 = ");";

            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("assets/csv/spells.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(in));
            String[] str;

            while ((str = reader.readNext()) != null) {
                execSQL(str1 + "\"" + str[0] + "\",\"" + str[1] + "\",\"" + str[2]
                        + "\",\"" + str[3] + "\",\"" + str[4] + "\",\"" + str[5] + "\",\""
                        + str[6] + "\",\"" + str[7] + "\",\"" + str[8] + "\",\"" + str[9] + "\",\""
                        + str[10] + "\",\"" + str[11] + "\",\"" + str[12] + "\",\""
                        + str[13] + "\",\"" + str[14] + "\"" + str2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void down() {
        execSQL("DROP TABLE Spells");
    }

}

