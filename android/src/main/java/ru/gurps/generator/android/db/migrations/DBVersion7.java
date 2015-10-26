package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;


public class DBVersion7 extends AbstractMigration {

    public void up() {
        execSQL("create table Techniques" +
                "(" +
                "_id integer auto_increment primary key not null," +
                "name varchar(255) not null," +
                "nameEn varchar(255)," +
                "complexity integer not null," +
                "defaultUse varchar(255)," +
                "demands varchar(255)," +
                "description clob" +
                ");");
        
        try {
            String tableName = "Techniques";
            String columns = "_id, name, nameEn, complexity, defaultUse, demands, description";
            String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
            String str2 = ");";

            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("assets/csv/techniques.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(in));
            String[] str;

            while ((str = reader.readNext()) != null) {
                execSQL(str1 + "\"" + str[0] + "\",\"" + str[1] + "\",\"" + str[2]
                        + "\",\"" + str[3] + "\",\"" + str[4] + "\",\"" + str[5] + "\",\""
                        + str[6] + "\"" + str2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void down() {
        execSQL("DROP TABLE Techniques");
    }

}

