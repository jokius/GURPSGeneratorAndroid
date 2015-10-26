package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion8 extends AbstractMigration {

    public void up() {
        execSQL("create table Characters" +
                "(" +
                "_id integer primary key," +
                "name varchar(255)," +
                "currentPoints integer default 0," +
                "maxPoints integer," +
                "st integer default 10," +
                "dx integer default 10," +
                "iq integer default 10," +
                "ht integer default 10," +
                "hp integer default 10," +
                "will integer default 10," +
                "per integer default 10," +
                "fp integer default 10," +
                "sm integer default 0," +
                "bs double default 5.0," +
                "move integer default 5," +
                "noFineManipulators boolean default false," +
                "player varchar(255)," +
                "growth integer default 0 not null," +
                "weight integer default 0 not null," +
                "age integer default 0 not null," +
                "tl integer default 0 not null," +
                "tlCost integer default 0 not null," +
                "head integer default 0 not null," +
                "torse integer default 0 not null," +
                "arm integer default 0 not null," +
                "leg integer default 0 not null," +
                "hand integer default 0 not null," +
                "foot integer default 0 not null" +
                ");");
    }

    public void down() {
        execSQL("DROP TABLE Characters");
    }

}

