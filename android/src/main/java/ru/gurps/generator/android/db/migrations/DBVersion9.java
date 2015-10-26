package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion9 extends AbstractMigration {

    public void up() {
        execSQL("create table Culturas" +
                "(" +
                "_id integer primary key," +
                "name varchar(255) not null" +
                ");");
    }

    public void down() {
        execSQL("DROP TABLE Culturas");
    }

}

