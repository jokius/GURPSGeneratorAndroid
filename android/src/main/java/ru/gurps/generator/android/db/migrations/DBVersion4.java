package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;


public class DBVersion4 extends AbstractMigration {

    public void up() {
        execSQL("create table Skills" +
                "(" +
                "_id integer primary key," +
                "name varchar(255) not null," +
                "nameEn varchar(255)," +
                "skillType integer not null," +
                "complexity integer not null," +
                "defaultUse varchar(255)," +
                "demands varchar(255)," +
                "description clob," +
                "modifiers clob," +
                "twoHands boolean default false," +
                "parry boolean default false," +
                "parryBonus integer default 0" +
                ");");

        try {
            String tableName = "Skills";
            String columns = "_id, name, nameEn, skillType, complexity, defaultUse, demands, " +
                    "description, modifiers, twoHands";
            String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
            String str2 = ");";

            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("assets/csv/skills.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(in));
            String[] str;

            while ((str = reader.readNext()) != null) {
                execSQL(str1 + "\"" + str[0] + "\",\"" + str[1] + "\",\"" + str[2]
                        + "\",\"" + str[3] + "\",\"" + str[4] + "\",\"" + str[5] + "\",\""
                        + str[6] + "\",\"" + str[7] + "\",\"" + str[8] + "\",\"" + str[9] + "\""
                        + str2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void down() {
        execSQL("DROP TABLE Skills");
    }

}

